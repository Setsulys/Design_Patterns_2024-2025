package fr.uge.poo.paint.ex5;

import java.awt.Graphics2D;

public final class Ellipse extends ShapeInRect{
	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawOval(x, y, width, height);
	}
	
	@Override
	public String toString() {
		return "Ellipse[x="+x+", y="+y+", width="+width+", height="+height+"]";
	}
}