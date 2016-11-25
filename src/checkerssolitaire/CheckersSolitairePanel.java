package checkerssolitaire;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.util.LinkedList;

class CheckersSolitairePanel extends JPanel
{
  
	LinkedList CheckerPlacement;
	int X_Offset;
	int Y_Offset;
	int SpaceWidth;
	int SpaceHeight;
	
	CheckersSolitairePanel(LinkedList l)
	{
		CheckerPlacement = l;
		X_Offset = 65;
		Y_Offset = 65;
		SpaceWidth = 50;
		SpaceHeight = 50;
	}
	private void drawChecker(int pos_x, int pos_y, Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(pos_x * SpaceWidth + X_Offset, pos_y * SpaceHeight + Y_Offset, SpaceWidth, SpaceHeight);		  
	}
	private void drawSpace(int pos_x, int pos_y, Graphics g)
	{
		g.setColor(Color.GRAY);
		g.drawOval(pos_x * SpaceWidth + X_Offset, pos_y * SpaceHeight + Y_Offset, SpaceWidth, SpaceHeight);	
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 2; i < 5; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				drawSpace(i, j, g);
			}
		}
		for(int j = 2; j < 5; j++)
		{
			for(int i = 0; i < 7; i++)
			{
				drawSpace(i, j, g);
			}
		}
		for (Object o : CheckerPlacement)
		{
			checkerssolitaire.CheckerNode cNode = (checkerssolitaire.CheckerNode) o;
	    	drawChecker(cNode.getX(), cNode.getY(), g);
	    }
	}
}