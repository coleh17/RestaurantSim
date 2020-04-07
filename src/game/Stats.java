package game;

import java.awt.Graphics;
import java.text.DecimalFormat;

public class Stats {
	
	private float balance;
	
	public Stats(float balance) {
		this.balance = balance;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		DecimalFormat df = new DecimalFormat("#.##");
		g.drawString("Balance: " + df.format(balance), 10, 20);
	}
	
	public float getBalance() {
		return balance;
	}

	public void addBalance(float amount) {
		balance = balance + amount;
	}
}
