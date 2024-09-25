package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;


public final class Rectangle extends Shape{
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	
	}
	
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawRect(x, y, width, height);
	}
	
	@Override
	public String toString() {
		return "Rectangle[x="+x+", y="+y+", width="+width+", height="+height+"]";
	}
}
