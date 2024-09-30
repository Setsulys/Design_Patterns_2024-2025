package fr.uge.poo.paint.ex7;

public sealed interface Canvas permits CoolGraphicsAdapter,SimpleGraphicsAdapter{

	enum CanvaColor{
		BLACK,
		WHITE,
		ORANGE
	}
	public void drawLine(int x,int y,int x2,int y2,CanvaColor color);
	
}
