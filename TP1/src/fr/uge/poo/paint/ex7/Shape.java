package fr.uge.poo.paint.ex7;

import java.awt.Graphics2D;

public sealed interface Shape permits Line,ShapeInRect{
	public void drawFigure(Graphics2D graphics);
	public double distance(int x,int y);
	
	public WindowSize minWindowSize();
}