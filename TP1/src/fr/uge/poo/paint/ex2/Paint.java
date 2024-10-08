package fr.uge.poo.paint.ex2;

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
	private record Line(int x,int y, int x2,int y2) {	
	}

	private static List<Line> elements = new ArrayList<>();
	
	private static void readFile (String file){
	    Path path = Paths.get(file);
	    try(Stream<String> lines = Files.lines(path)) {
	      lines.forEach(e->  {
	  		String[] token = e.split(" ");
			elements.add(new Line(Integer.parseInt(token[1]),Integer.parseInt(token[2]),Integer.parseInt(token[3]),Integer.parseInt(token[4])));
			});
	    } catch (IOException e) {
			e.getCause();
		}
	}
	
	private static void drawAll(Graphics2D graphics){
		graphics.setColor(Color.BLACK);
		elements.forEach(e-> { graphics.drawLine(e.x, e.y, e.x2, e.y2);
		});
	}
	
	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
		readFile("draw.txt");
        area.clear(Color.WHITE);
        area.render(Paint::drawAll);
	}
}
