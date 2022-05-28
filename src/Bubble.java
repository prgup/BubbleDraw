import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;


public class Bubble {
	
	private int x;
	private int y;
	private int size;
	private Color color;
	private int xspeed, yspeed;
	private final int MAX_SPEED = 5;
	Random rand = new Random();
	
	public Bubble () {};
	
	public Bubble (int newX, int newY, int newSize) {
		x = newX;
		y = newY;
		size = newSize;
		color = new Color( rand.nextInt(256),
				rand.nextInt(256),
				rand.nextInt(256),
				rand.nextInt(256)
				);
//		while (Math.abs(xspeed)<1)
			xspeed = rand.nextInt( MAX_SPEED * 2 + 1) - MAX_SPEED;
//		while (Math.abs(yspeed)<1)
			yspeed = rand.nextInt( MAX_SPEED * 2 + 1) - MAX_SPEED;
		
	}

	
	public void draw(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillOval(x - size/2, y - size/2, size, size);
	}
	
	public void update(int newWidth, int newHeight ) {
		x += xspeed;
		y += yspeed;
		if (((x - size/2) <= 0) || ((x + size/2) >= newWidth)) {
			xspeed = -xspeed;
//			yspeed += -yspeed/2;
		}
		if ((y - size/2 <= 0) || (y + size/2 >= newHeight)) {
			yspeed = -yspeed;
//			xspeed += -xspeed/2;
		}
		
		}
	
	public ArrayList<Bubble> testBubbles() {
		ArrayList <Bubble> testBubbleList = new ArrayList <>();
		for(int n = 0; n < 200; n++) {
		int x = rand.nextInt(600);
		int y = rand.nextInt(400);
		int size = rand.nextInt(5,70);
		testBubbleList.add( new Bubble(x, y, size) );
		}
		return testBubbleList;
//		repaint();
		}

}
