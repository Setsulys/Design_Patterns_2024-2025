package fr.uge.poo.paint.ex4;

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
	private record Elements(String Type,int x,int y, int x2,int y2) {
		
	}

	private static List<Paint.Elements> readFile (){
		var list =  new ArrayList<Elements>();
	    Path path = Paths.get("draw2.txt");
	    try(Stream<String> lines = Files.lines(path)) {
	      //lines.forEach(line -> System.out.println(line));
	      lines.forEach(e->  {
	  		String[] token = e.split(" ");
			list.add(new Elements(token[0],Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
			});
	    } catch (IOException e) {
			e.getCause();
		}
	    return list;
	}
	
	private static void drawAll(Graphics2D graphics){
		var elements =readFile();
		graphics.setColor(Color.BLACK);
		elements.forEach(e-> { 
			//System.out.println(e.Type);
			switch(e.Type) {
			case "line"->	graphics.drawLine(e.x, e.y, e.x2, e.y2);
			case "rectangle"->	graphics.drawRect(e.x, e.y, e.x2, e.y2);
			case "ellipse"-> graphics.drawOval(e.x, e.y, e.x2, e.y2);
			default-> throw new IllegalArgumentException();
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(Paint::drawAll);
	}
}
