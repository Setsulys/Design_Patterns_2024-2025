package fr.uge.poo.paint.ex9;

import java.io.IOException;

import fr.uge.poo.paint.ex9.Canvas.CanvaColor;


public class Paint {
	public static void main(String[] args) throws IOException {
		Drawing.readFile("draw-big.txt");
		//Drawing.readFile("draw-small.txt");
		var size = Drawing.size();
		Canvas area;
		if(args.length>=1 &&args[0].equals("-legacy")) {
			area = new SimpleGraphicsAdapter("area", size.width(),size.height());
		}
		else {
			area = new CoolGraphicsAdapter("area",size.width(),size.height());
		}
		area.clear(CanvaColor.WHITE);
		Drawing.drawAll(area);
		area.waitForMouseEvents((x,y)->{
			area.clear(CanvaColor.WHITE);
			Drawing.getShortDistance(x,y);
			Drawing.drawColor(area);
		});
	}
}
