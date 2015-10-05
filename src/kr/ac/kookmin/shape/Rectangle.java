package kr.ac.kookmin.shape;
	
public class Rectangle extends Shape{
	private int h;
	private int w;
	
	public Rectangle(Point center, int w, int h){
		super(center);
		this.w = w;
		this.h = h;
	}
	
	public Rectangle getBounds() {
		return this;
	}
	
	public int getHeight(){
		return h;
	}
	
	public int getWidth(){
		return w;
	}

	public void draw(Graphics g) {
		g.draw(this);
	}

	public String toString() {
		return "Rectangle";
	}
}
