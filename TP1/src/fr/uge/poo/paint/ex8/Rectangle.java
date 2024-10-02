package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvaColor;

public final class Rectangle extends ShapeInRect{
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	
	}
	
	@Override
	public void drawFigure(Canvas canva,CanvaColor color) {
		canva.drawRect(x, y, width, height,color);
	}
	
	@Override
	public String toString() {
		return "Rectangle[x="+x+", y="+y+", width="+width+", height="+height+"]";
	}
}
