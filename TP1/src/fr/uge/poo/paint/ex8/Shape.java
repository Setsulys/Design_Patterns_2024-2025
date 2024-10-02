package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvaColor;

public sealed interface Shape permits Line,ShapeInRect{
	public void drawFigure(Canvas canva,CanvaColor color);
	public double distance(int x,int y);
	
	public WindowSize minWindowSize();
}