package framework;

import java.lang.Thread.State;
import java.util.*;

class PuzzleSolver implements Runnable
{
	public void run()
	{
		ConcurrentPuzzleSolver.search();
	}
}

public class ConcurrentPuzzleSolver
{
	static private Puzzle puzzle;
	static private final HashSet seen = new HashSet();
	static private final LinkedList next = new LinkedList();
	static private LinkedList result = null;

	public ConcurrentPuzzleSolver(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	
	public LinkedList solve()
	{
		puzzle.initialPosition();
		startsearch(new Node(puzzle, null));
		if(result == null)
		{
			Thread A = new Thread(new PuzzleSolver());
			Thread B = new Thread(new PuzzleSolver());
			A.start();
			B.start();
			while(result == null)
			{
				if(A.getState() == State.TERMINATED)
				{
					A = new Thread(new PuzzleSolver());
					A.start();
				}
				if(B.getState() == State.TERMINATED)
				{
					B = new Thread(new PuzzleSolver());
					B.start();
				}
			}
			return result;
		}
		else
		{
			return result;
		}
	}

	synchronized static private void addNextNode(Node node)
	{
		if(!seen.contains(node.pos))
		{
			next.push(node);
			seen.add(node.pos);
		}
	}
	synchronized static private Node getNextNode()
	{
		if(next.size() == 0)
		{
			return null;
		}
		else
		{
			Node result = (Node)next.pop();
			return result;
		}
	}
	static public void search()
	{
		Node node = getNextNode();
		if(node != null)
		{
			if (node.pos.isGoal())
			{ 
				result = node.asPositionList();
			}
			else
			{
				for (Object o : node.pos.legalMoves(node))
				{ 
					Puzzle puzzle = (Puzzle) o;
					addNextNode(new Node(puzzle, node));
				}
			}
		}
	}
	private void startsearch(Node node)
	{
		if (node.pos.isGoal())
		{ 
			result = node.asPositionList();
		}
		for (Object o : node.pos.legalMoves(node))
		{ 
			Puzzle puzzle = (Puzzle) o;
			addNextNode(new Node(puzzle, node));
		}
	}
}