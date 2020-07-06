package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Customer extends GameObject {

	private Handler handler;
	private Stats stats;
	// private CustomerStates state;
	private float money;

	private int defaultVelX = 1;
	private int defaultVelY = 0;
	private int startingY;

	private int checkoutTime = 250;
	private int pickupTime = 100;
	private int currentWait = 0;
	private int moveWait = 0;

	private Random r = new Random();

	public Customer(int x, int y, CustomerStates state, float money, Handler handler, Stats stats) {
		super(x, y, state);
		// this.state = CustomerStates.IN_LINE;
		this.money = (float) (1.00 + r.nextFloat() * (10.00 - 1.00));
		this.handler = handler;
		this.stats = stats;

		velX = defaultVelX;
		velY = defaultVelY;
		startingY = y;
	}

	public void tick(int lastX, CustomerStates lastState) {

		//System.out.println(state + " | " + x + " | " + currentWait);
		
		x += velX;
		y += velY;

		// CHECK SPACING BETWEEN CUSTOMERS
		if (lastX - x <= 50 && (lastState == CustomerStates.REGISTER || lastState == CustomerStates.IN_LINE))
			velX = 0;
		else 
			velX = defaultVelX;
		
		// CUSTOMER ACTION HANDLER
		switch (state) {
			case IN_LINE:
				if (x >= 480 && currentWait < checkoutTime) 
					state = CustomerStates.REGISTER;
			break;
			
			case REGISTER:
				if (currentWait >= checkoutTime)
					state = CustomerStates.SWITCHING;
				currentWait++;
				velX = 0;
			break;
	
			case SWITCHING:
				velX = 0;
				velY = -1;
				if (y <= (startingY - 120))
					state = CustomerStates.PICKUP;
			break;
			
			case PICKUP:
				velX = 0;
				velY = 0;
				if (currentWait > pickupTime) currentWait = 0;
				if (y <= (startingY - 120) && currentWait >= pickupTime) {
					stats.addBalance(money);
					state = CustomerStates.LEAVING;
				}
				currentWait++;
			break;
			
			case LEAVING:
				velX = -defaultVelX;
				if (x < -30)
					state = CustomerStates.LEFT;
			break;
			
			case LEFT:
				handler.removeObject(this);
				System.out.println("removed");
			break;
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

}
