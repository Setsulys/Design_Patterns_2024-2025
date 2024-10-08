package fr.uge.poo.paint.ex9;

public record WindowSize(int width, int height) {
	
	public static WindowSize union(WindowSize first,WindowSize  second) {
		var w = first.width() > second.width()? first.width():second.width();
		var h = first.height() > second.height()? first.height():second.height();
		return new WindowSize(w,h);
	}
	
}