package fr.uge.poo.paint.ex4;

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
	

	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
		Drawing.readFile("draw2.txt");
        area.clear(Color.WHITE);
        area.render(Drawing::drawAll);
        area.waitForMouseEvents((x,y)-> System.out.println(Drawing.getShortDistance(x, y)));
	}
}
