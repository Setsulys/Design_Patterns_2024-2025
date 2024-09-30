package fr.uge.poo.paint.ex7;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.function.Consumer;
import fr.uge.poo.simplegraphics.SimpleGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics.MouseCallback;

public final class SimpleGraphicsAdapter implements Canvas {

	private final SimpleGraphics graphics;
	SimpleGraphicsAdapter(String name,int width,int height){
		graphics = new SimpleGraphics(name,width,height);
	}
	
	public void clear(CanvaColor color) {
		graphics.clear(toSimpleGraphicsColor(color));
	}
	
	public void render(Consumer<Graphics2D> consumer) {
		graphics.render(consumer);
	}
	
	public void waitForMouseEvents(MouseCallback mouseCallBack) {
		graphics.waitForMouseEvents(mouseCallBack);
	}

	@Override
	public void drawLine(int x, int y, int x2, int y2, CanvaColor color) {
		// TODO Auto-generated method stub
//		setColor(toSimpleGraphicsColor(color));
//		Graphics2D.drawLine(x,y,x2,y2);
	}
	
	private Color toSimpleGraphicsColor(CanvaColor color) {
		return switch(color) {
		case BLACK -> Color.BLACK;
		case WHITE -> Color.WHITE;
		case ORANGE -> Color.ORANGE;
		default -> throw new UnsupportedOperationException();
		};
	}
}
