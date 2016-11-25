package checkerssolitaire;

import java.util.LinkedList;

import javax.swing.JFrame;

import framework.*;

public class CheckersSolitaire implements Puzzle
{
	char[][] matrix = new char[7][7];

	
	public CheckersSolitaire()
	{
		for (int i = 0; i< 7; i++)
		{
			for (int j = 0; j< 7; j++)
			{
				matrix[i][j] = '0';
			}
		}
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				matrix[i][j] = '1';
			}
			for(int j = 5; j < 7; j++)
			{
				matrix[i][j] = '1';
			}
		}
		for(int i = 5; i < 7; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				matrix[i][j] = '1';
			}
			for(int j = 5; j < 7; j++)
			{
				matrix[i][j] = '1';
			}
		}
	}


	public void initialPosition()
	{
		Configurations.addAll();
		
		LinkedList l = (LinkedList) Configurations.theConfigs.get(2);
		for (Object o : l)
		{
			CheckerNode vNode = (CheckerNode) o;
	    	placeChecker(vNode.getX(), vNode.getY());
	    }
	}
	
	private void placeChecker(int pos_x, int pos_y)
	{
		matrix[pos_x][pos_y] = 'C';
	}
	private boolean hasChecker(int pos_x, int pos_y)
	{
		return matrix[pos_x][pos_y] == 'C';
	}


	public boolean isGoal()
	{
		boolean count = false;
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				if(matrix[x][y] == 'C')
				{
					if(count == false)
					{
						count = true;
					}
					else
					{
						return false;
					}
				}
			}
		}
		if(count == true)
		{
			//One in Middle is the only solutions
			if(matrix[3][3] == 'C')
			{
				return true;
			}//*/
			/*//Any one left is a solution
			return true;
			//*/
		}
		return false;
	}
	private LinkedList transform()
	{
		LinkedList theList = new LinkedList();
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				if(matrix[x][y] == 'C')
				{
					CheckerNode cNode = new CheckerNode(x, y);
					theList.add(cNode);
				}
			}
		}
		return theList;
	}
	
	public void drawSolution(LinkedList theList)
	{
		JFrame frame = new JFrame("CheckersSolitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        for (Object o : theList)
        {
        	CheckersSolitaire puzzle = (CheckersSolitaire) o;
        	CheckersSolitairePanel checkerssolitairepanel = new CheckersSolitairePanel(puzzle.transform());
        	frame.getContentPane().add(checkerssolitairepanel);
        	frame.show();
        	        			
        	// an idle loop that delays the display of a position; makes moves visible
        	long t0,t1;
        	     
        	t0=System.currentTimeMillis();
        	     
        	do
        	{
        		t1=System.currentTimeMillis();
            } while (t1-t0<500);
        	        
        }
	}
	
	public LinkedList legalMoves(Node node)
	{
		LinkedList theSet = new LinkedList();
		for (int x=0; x<7; x++)
		{
			for (int y=0; y<7; y++)
			{
				if(matrix[x][y] == 'C')
				{
					if(x-2 >= 0 && matrix[x-2][y] == '0' && matrix[x-1][y] == 'C')
					{
						Move theMove = new Move(x, y, Direction.left);
						CheckersSolitaire position = move(theMove);
						theSet.add(position);
					}
					if(y-2 >= 0 && matrix[x][y-2] == '0' && matrix[x][y-1] == 'C')
					{
						Move theMove = new Move(x, y, Direction.up);
						CheckersSolitaire position = move(theMove);
						theSet.add(position);
					}
					if(x+2 < 7 && matrix[x+2][y] == '0' && matrix[x+1][y] == 'C')
					{
						Move theMove = new Move(x, y, Direction.right);
						CheckersSolitaire position = move(theMove);
						theSet.add(position);
					}
					if(y+2 < 7 && matrix[x][y+2] == '0' && matrix[x][y+1] == 'C')
					{
						Move theMove = new Move(x, y, Direction.down);
						CheckersSolitaire position = move(theMove);
						theSet.add(position);
					}
				}
			}
		}
		return theSet;
	}
	private CheckersSolitaire move(Move theMove)
	{
		CheckersSolitaire NewValue = this.clone();
		if(theMove.direction == Direction.left)
		{
			NewValue.matrix[theMove.pos_x][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x-1][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x-2][theMove.pos_y] = 'C';
		}
		else if(theMove.direction == Direction.right)
		{
			NewValue.matrix[theMove.pos_x][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x+1][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x+2][theMove.pos_y] = 'C';
		}
		else if(theMove.direction == Direction.up)
		{
			NewValue.matrix[theMove.pos_x][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x][theMove.pos_y-1] = '0';
			NewValue.matrix[theMove.pos_x][theMove.pos_y-2] = 'C';
		}
		else if(theMove.direction == Direction.down)
		{
			NewValue.matrix[theMove.pos_x][theMove.pos_y] = '0';
			NewValue.matrix[theMove.pos_x][theMove.pos_y+1] = '0';
			NewValue.matrix[theMove.pos_x][theMove.pos_y+2] = 'C';
		}
		return NewValue;
	}
	public CheckersSolitaire clone()
	{
		CheckersSolitaire NewValue = new CheckersSolitaire();
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				NewValue.matrix[x][y] = matrix[x][y];
			}
		}
		return NewValue;
	}
	public boolean equals(Object o)
	{
		CheckersSolitaire NewValue = (CheckersSolitaire) o;
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				if(NewValue.matrix[x][y] != matrix[x][y])
				{
					return false;
				}
			}
		}
		return true;
	}
	public int hashCode()
	{
		int code = 0;
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				code += matrix[x][y];
			}
		}
		return code;
	}
	enum Direction
	{
		left, right, up, down
	}
	class Move
	{
		int pos_x;
		int pos_y;
		Direction direction;
		
		Move(int pos_x, int pos_y, Direction direction)
		{
			this.pos_x = pos_x;
			this.pos_y = pos_y;
			this.direction = direction;
		}
		
	}
}