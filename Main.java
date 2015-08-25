package pong;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.*;


public class Main extends JFrame{
	int GWIDTH= 400;
	int GHEIGHT= 300;
	Dimension screenSize= new Dimension(GWIDTH, GHEIGHT);
	Image dbImage;
	Graphics dbg; 
	Ball b= new Ball(193,143);
	
	public Main() {
		// TODO Auto-generated method stub
		this.setTitle("Pong Game");
		this.setSize(screenSize);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.addKeyListener(new AL());

	}
	
	public static void main(String[] args){
		Main m= new Main();
		Thread ball= new Thread(b);
		ball.start();
		Thread p1= new Thread(b.p1);
		Thread p2= new Thread(b.p2);
		p1.start();
		p2.start();
	}
	
	public void paint(Graphics g){
		dbImage= createImage(getWidth(), getHeight());
		dbg= dbImage.getGraphics();
		draw(dbg);
		g.drawImage(dbImage,  0,  0, this);
	}
	public void draw(Graphics g){
		b.draw(g);
		b.p1.draw(g);
		b.p2.draw(g);
		repaint();
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			b.p1.keyPressed(e);
			b.p2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e){
			b.p1.keyReleased(e);
			b.p2.keyReleased(e);
		}
	}

}
