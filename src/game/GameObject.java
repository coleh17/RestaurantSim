package game;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y;
	protected CustomerStates state;
	protected int velX, velY;
	
	public GameObject(int x, int y, CustomerStates state) {
		this.x = x;
		this.y = y;
		this.state = state;
	}
	
	public abstract void tick(int lastX, CustomerStates lastState);
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setState(CustomerStates state) {
		this.state = state;
	}
	public CustomerStates getState() {
		System.out.println(" -- " + state);
		return state;
	}
	
	
}
