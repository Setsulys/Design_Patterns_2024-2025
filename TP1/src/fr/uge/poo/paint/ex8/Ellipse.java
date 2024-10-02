package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvaColor;

public final class Ellipse extends ShapeInRect{
	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawFigure(Canvas canva, CanvaColor color) {
		canva.drawEllipse(x, y, width, height,color);
	}
	
	@Override
	public String toString() {
		return "Ellipse[x="+x+", y="+y+", width="+width+", height="+height+"]";
	}

}