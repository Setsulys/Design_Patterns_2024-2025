package fr.uge.poo.paint.ex9;

import fr.uge.poo.paint.ex9.Canvas.CanvaColor;

public sealed interface Shape permits Line,ShapeInRect{
	public void drawFigure(Canvas canva,CanvaColor color);
	public double distance(int x,int y);
	
	public WindowSize minWindowSize();
}