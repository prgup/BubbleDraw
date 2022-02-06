import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BubblePanel extends JPanel {
	
	ArrayList <Bubble> bubbleList;
	int initialSize = 30;
	Timer timer;
	int latency = 33;
	
	public BubblePanel() {
		timer = new Timer(latency, new BubbleListener() );
		bubbleList = new ArrayList<>();
		setBackground(Color.BLACK);
		//testBubbles();
		addMouseListener( new BubbleListener() );
		addMouseMotionListener( new BubbleListener() );
		addMouseWheelListener( new BubbleListener() );
		timer.start();
		}
	
	public void paintComponent(Graphics canvas) {
		super.paintComponent(canvas);
		for(Bubble b : bubbleList) {
			b.draw(canvas);
			}
		}
	
//	public void testBubbles() {
//		for(int n = 0; n < 200; n++) {
//		int x = rand.nextInt(600);
//		int y = rand.nextInt(400);
//		int size = rand.nextInt(50);
//		bubbleList.add( new Bubble(x, y, size) );
//		}
//		repaint();
//		}
	
	private class BubbleListener extends MouseAdapter implements ActionListener{
		public void mousePressed(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(), e.getY(), initialSize));
			repaint();
			}
		public void mouseDragged(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(), e.getY(), initialSize));
			repaint();
			}
		public void mouseWheelMoved(MouseWheelEvent e) {
			initialSize += e.getUnitsToScroll();
			}
		public void actionPerformed(ActionEvent e) {
			for (Bubble b : bubbleList)
				b.update();
			repaint();
		}
	}

}
