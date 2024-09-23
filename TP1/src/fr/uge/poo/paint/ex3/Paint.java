package fr.uge.poo.paint.ex3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public class Paint {
	private record Line(int x,int y, int x2,int y2) implements Elements{
		
		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawLine(x, y, x2, y2);
		}
	}
	private record Rectangle(int x,int y, int x2,int y2) implements Elements{

		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawRect(x, y, x2, y2);
		}
		
	}
	private record Ellipse(int x,int y, int x2,int y2) implements Elements {

		@Override
		public void drawFigure(Graphics2D graphics) {
			graphics.drawOval(x, y, x2, y2);
		}
		
	}
	
	private interface Elements {
		public void drawFigure(Graphics2D graphics);
	}

	private static List<Elements> readFile (){
		var list =  new ArrayList<Elements>();
	    Path path = Paths.get("draw2.txt");
	    try(Stream<String> lines = Files.lines(path)) {
	      //lines.forEach(line -> System.out.println(line));
	      lines.forEach(e->  {
	  		String[] token = e.split(" ");
	  		switch(token[0]) {
	  		case "line"-> list.add(new Line(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "rectangle"-> list.add(new Rectangle(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "ellipse"-> list.add(new Ellipse(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		}
			});
	    } catch (IOException e) {
			e.getCause();
		}
	    return list;
	}
	
	private static void drawAll(Graphics2D graphics){
		var elements =readFile();
		graphics.setColor(Color.BLACK);
		elements.forEach(e->{
			e.drawFigure(graphics);
		});
	}
	
	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(Paint::drawAll);
	}
}
