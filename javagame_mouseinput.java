package javagame_mouseinput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class javagame_mouseinput extends JFrame {

	int GWIDTH= 400;
	int GHEIGHT= 300;
	int x,y;
	private Image dbImage;
	private Graphics dbg;
	boolean mouseOnScreen;
	
	public javagame_mouseinput(){
		setSize(GWIDTH, GHEIGHT);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(new Mouse());
		x= 15;
		y= 15;
	}
	
	public class Mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			int xCoord= e.getX();
			int yCoord= e.getY();
			x= xCoord -1;
			y= yCoord -1;
		}
		public void mouseReleased(MouseEvent e){
			
		}
		public void mouseEntered(MouseEvent e){
			mouseOnScreen= true;
		}
		public void mouseExited(MouseEvent e){
			mouseOnScreen= false;
		}
	}
	
	public void paint(Graphics g){
		dbImage= createImage(getWidth(), getHeight());
		dbg= dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	public void paintComponent(Graphics g){
		g.fillOval(x, y, 15, 15);
		g.setColor(Color.blue);
		if(mouseOnScreen){
			g.drawString("Coord: ("+x+","+y+")", 150, 150);
		}
		repaint();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javagame_mouseinput main= new javagame_mouseinput();
	}
	
	
	

}
