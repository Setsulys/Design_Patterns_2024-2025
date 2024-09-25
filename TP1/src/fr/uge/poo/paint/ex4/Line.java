package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;

public record Line(int x,int y, int x2,int y2) implements Element{
	
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawLine(x, y, x2, y2);
	}
	
	
	
	public double distance(int x2,int y2) {
		int centerX = (x2+x)/2;
		int centerY = (y2+y)/2;
		return (centerX-x2)*(centerX-x2) + (centerY-y2)*(centerY-y2);
	}
}