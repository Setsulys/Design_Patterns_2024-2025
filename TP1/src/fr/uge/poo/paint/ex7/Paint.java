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
import fr.uge.poo.simplegraphics.SimpleGraphics;

public class Paint {

	
	
	public static void main(String[] args) throws IOException {
		//Drawing.readFile("draw-big.txt");
		Drawing.readFile("draw-small.txt");
		var size = Drawing.size();
		SimpleGraphics area = new SimpleGraphics("area", size.width()>500? size.width():500, size.height()>500? size.height():500);
		
        area.clear(Color.WHITE);
        area.render(Drawing::drawAll);
		area.waitForMouseEvents((x,y)-> {
			area.clear(Color.WHITE);
			Drawing.getShortDistance(x,y);
			area.render(Drawing::drawColor);
		});
	}
}
