package fr.uge.poo.paint.ex9;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public final class SimpleGraphicsAdapter implements Canvas {

	private final SimpleGraphics graphics;
	private ArrayList<Consumer<Graphics2D>> toRender = new ArrayList<>();

	
	SimpleGraphicsAdapter(String name,int width,int height){
		graphics = new SimpleGraphics(name,width,height);
	}
	
	public void clear(CanvaColor color) {
		graphics.clear(toSimpleGraphicsColor(color));
	}
	
	@Override
	public void drawLine(int x, int y, int x2, int y2, CanvaColor color) {
		toRender.add(g-> g.setColor(toSimpleGraphicsColor(color)));
		toRender.add(g->g.drawLine(x,y,x2,y2));
	}
	
	@Override
	public void drawEllipse(int x,int y,int width,int height,CanvaColor color) {
		toRender.add(g-> g.setColor(toSimpleGraphicsColor(color)));
		toRender.add(g-> g.drawOval(x,y,width,height));
	}
	
	@Override
	public void waitForMouseEvents(MouseClickCallback mouseCallback) {
		graphics.waitForMouseEvents(mouseCallback::onClick);
	}
	
	@Override
	public void render() {
		clear(CanvaColor.WHITE);
		//System.out.println("+"+toRender.size());
		graphics.render(g-> toRender.forEach(e->e.accept(g)));
		//toRender.clear();
		//System.out.println("render" + toRender.size());
		
	}
	
	private Color toSimpleGraphicsColor(CanvaColor color) {
		return switch(color) {
		case BLACK -> Color.BLACK;
		case WHITE -> Color.WHITE;
		case ORANGE -> Color.ORANGE;
		default -> throw new UnsupportedOperationException();
		};
	}

	@Override
	public void clear() {
		toRender.clear();
		graphics.clear(Color.WHITE);
	}
}
