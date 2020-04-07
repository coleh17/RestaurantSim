package game;

import java.awt.Color;
import java.awt.Graphics;

public class Shack {
	
	private int x;
	private int y;
	private int width;
	private int height;

	public Shack(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(224, 132, 11));
		g.fillRect(x, y, width, height);
	}

}
