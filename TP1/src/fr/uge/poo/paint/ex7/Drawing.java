package fr.uge.poo.paint.ex7;

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

import fr.uge.poo.paint.ex7.Canvas.CanvaColor;

public class Drawing {
	private static Shape nearest = null;
	private static List<Shape> elements = new ArrayList<>();

	public static void readFile (String file){
	    Path path = Paths.get(file);
	    try(Stream<String> lines = Files.lines(path)) {
	      lines.forEach(e->  {
	  		String[] token = e.split(" ");
	  		switch(token[0]) {
	  		case "line"-> elements.add(new Line(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "rectangle"-> elements.add(new Rectangle(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		case "ellipse"-> elements.add(new Ellipse(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
	  		default -> throw new UnsupportedOperationException();
	  		}
			});
	    } catch (IOException e) {
			e.getCause();
		}
	}
	
	public static void getShortDistance(int x,int y) {
		nearest = elements.stream().min(Comparator.comparingDouble(e->{			
			return e.distance(x,y);
			})).orElse(null);
	}
	
	public static void drawAll(Canvas canva){
		elements.forEach(e->{
			e.drawFigure(canva,CanvaColor.BLACK);
		});
	}
	public static void drawColor(Canvas canva) {
		drawAll(canva);
		nearest.drawFigure(canva,CanvaColor.ORANGE);
	}
	
	public static WindowSize size() {
		return elements.stream().map(Shape::minWindowSize).reduce(new WindowSize(500,500),WindowSize::union);
	}
}
