package kr.ac.kookmin.shape;

public abstract class Shape {
	protected Point center;
	
	protected Shape(Point center){
		this.center = center;
	}
	
	public Point getCenter(){
		return this.center;
	}
	
	abstract public Rectangle getBounds();
	
	abstract public void draw(Graphics g);
}
