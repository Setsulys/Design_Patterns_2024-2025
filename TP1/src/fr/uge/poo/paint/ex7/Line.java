package fr.uge.poo.paint.ex7;

import java.awt.Graphics2D;

public record Line(int x,int y, int x2,int y2) implements Shape{
	
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawLine(x, y, x2, y2);
	}
	
	public double distance(int x3,int y3) {
		int centerX = (x2+x)/2;
		int centerY = (y2+y)/2;
		return (centerX-x3)*(centerX-x3) + (centerY-y3)*(centerY-y3);
	}

	@Override
	public WindowSize minWindowSize() {
		return new WindowSize(x2+x,y2+y);
	}
	
}