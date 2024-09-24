package fr.uge.poo.paint.ex5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import fr.uge.poo.simplegraphics.SimpleGraphics;

public class Paint {
	
	private record CenterPoint(int x,int y) {}
	
	private record Line(int x,int y, int x2,int y2) implements Element{
		
		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawLine(x, y, x2, y2);
		}

		@Override
		public CenterPoint getCenterPoint() {
			var xCenter = (x2+x)/2;
			var yCenter = (y2+y)/2;
			return new CenterPoint(xCenter,yCenter);
		}
	}
	private record Rectangle(int x,int y, int x2,int y2) implements Element{

		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawRect(x, y, x2, y2);
		}

		@Override
		public CenterPoint getCenterPoint() {
			var xCenter = x2+(x/2);
			var yCenter = y2-(y/2);
			return new CenterPoint(xCenter,yCenter);
		}
	}
	private record Ellipse(int x,int y, int x2,int y2) implements Element{

		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawOval(x, y, x2, y2);
		}
		
		@Override
		public CenterPoint getCenterPoint() {
			var xCenter = x2+(x/2);
			var yCenter = y2-(y/2);
			return new CenterPoint(xCenter,yCenter);
		}
	}
	
	private interface Element{
		public void drawFigure(Graphics2D graphics);
		public CenterPoint getCenterPoint();
	}
	
	private static int distance(int x1,int x2,int y1,int y2) {
		return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
	}
	
	private static Element nearest = null;
	
	private static void getShortDistance(int x,int y) {
		nearest = elements.stream().min(Comparator.comparingInt(e->{			
			var ex=e.getCenterPoint().x;
			var ey =e.getCenterPoint().y;
			return distance(ex,x,ey,y);
			})).orElse(null);
	}
	
	private static List<Element> elements = new ArrayList<>();

	private static void readFile (){
	    Path path = Paths.get("draw2.txt");
	    try(Stream<String> lines = Files.lines(path)) {
	      lines.forEach(e->  {
	  		String[] token = e.split(" ");
	  		switch(token[0]) {
	  		case "line"-> elements.add(new Line(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "rectangle"-> elements.add(new Rectangle(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "ellipse"-> elements.add(new Ellipse(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		}
			});
	    } catch (IOException e) {
			e.getCause();
		}
	}
	
	private static void drawAll(Graphics2D graphics){
		graphics.setColor(Color.BLACK);
		elements.forEach(e->{
			e.drawFigure(graphics);
		});
	}
	
	private static void drawColor(Graphics2D graphics) {
		graphics.setColor(Color.ORANGE);
		nearest.drawFigure(graphics);
	}
	
	private static void drawdrawColor(SimpleGraphics area) {
		area.waitForMouseEvents((x,y)-> {
			getShortDistance(x, y);
			area.render(Paint::drawColor);
			});
	}
	
	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
		readFile();
        area.clear(Color.WHITE);
        area.render(Paint::drawAll);
        drawdrawColor(area);
	}
}
