package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		int lastX = 1000;
		CustomerStates lastState = CustomerStates.IN_LINE;
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			//System.out.println(lastState);
			tempObject.tick(lastX, lastState);
			lastX = tempObject.getX();
			lastState = tempObject.getState();
			//System.out.println("------ " + lastState);
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		int customerCount = 0;
		for (int i = 0; i < this.object.size(); i++) {
			if (this.object.get(i).getState() == CustomerStates.IN_LINE || this.object.get(i).getState() == CustomerStates.REGISTER)
				customerCount++;
		}
		if (customerCount < 4)
			this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}