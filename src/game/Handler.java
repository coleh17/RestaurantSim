package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		int lastX = 1000;
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick(lastX);
			System.out.println(object.size());
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
			if (this.object.get(i).getState() == CustomerStates.IN_LINE)
				customerCount++;
		}
		if (customerCount < 6)
			this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}