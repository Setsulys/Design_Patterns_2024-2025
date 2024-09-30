package fr.uge.poo.paint.ex7;

sealed abstract class ShapeInRect implements Shape permits Rectangle,Ellipse  {
	int x,y,width,height;
	int centerX, centerY;
	public ShapeInRect(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.centerX = x +(width/2);
		this.centerY = y +(height/2);
	}
	
	public double distance(int x2,int y2) {
		return (centerX-x2)*(centerX-x2) + (centerY-y2)*(centerY-y2);
	}
	
	
	@Override
	public WindowSize minWindowSize() {
		return new WindowSize(width+x,height+y);
	}
	
}