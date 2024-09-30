package fr.uge.poo.paint.ex7;

import java.awt.Graphics2D;
import java.util.function.Consumer;

import com.evilcorp.coolgraphics.CoolGraphics;
import com.evilcorp.coolgraphics.CoolGraphics.ColorPlus;
import com.evilcorp.coolgraphics.CoolGraphics.MouseCallback;

import fr.uge.poo.paint.ex7.Canvas.CanvaColor;

public final class CoolGraphicsAdapter implements Canvas{

	private final CoolGraphics graphics;
	CoolGraphicsAdapter(String name,int width,int height){
		graphics = new CoolGraphics(name,width,height);
	}
	
	@Override
	public void drawLine(int x, int y, int x2, int y2,CanvaColor color) {
		graphics.drawLine(x,y,x2,y2,toCoolGraphicsColor(color));
		
	}
	
	private ColorPlus toCoolGraphicsColor(CanvaColor color) {
		return switch(color) {
		case BLACK -> ColorPlus.BLACK;
		case WHITE -> ColorPlus.WHITE;
		case ORANGE -> ColorPlus.ORANGE;
		default -> throw new UnsupportedOperationException();
		};
	}
	
	public void drawEllipse(int x,int y,int width,int height,CanvaColor color) {
		graphics.drawEllipse(x,y,width,height,toCoolGraphicsColor(color));
	}
	
	public void drawRect(int x,int y,int width,int height,CanvaColor color) {
		drawLine(x,y,x+width,y,color);
        drawLine(x,y+height,x+width,y+height,color);
        drawLine(x,y,x,y+height,color);
        drawLine(x+width,y,x+width,y+height,color);
	}
	
	public void clear(CanvaColor color) {
		graphics.repaint(toCoolGraphicsColor(color));
	}
	
//	public void render(Consumer<Graphics2D> consumer) {
//		graphics.render(consumer);
//	}
	
	public void waitForMouseEvents(MouseCallback mouseCallBack) {
		graphics.waitForMouseEvents(mouseCallBack);
	}
	
	
	
}
