package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;

public sealed interface Element permits Line,Shape{
	public void drawFigure(Graphics2D graphics);
	public double distance(int x,int y);
}