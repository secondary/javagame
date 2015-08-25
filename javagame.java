package javagame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class javagame extends JFrame{
	int x,y;
	private Image dbImage;
	private Graphics dbg;
	Font font= new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	Image face;
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode= e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				if(x<=0){
					x=0;
				}else{
					x=x-20;
				}
				
			}
			if(keyCode == e.VK_RIGHT){
				if(x>=480){
					x=480;
				}else{
					x=x+20;
				}
							
						}
			if(keyCode == e.VK_UP){
				if(y<=20){
					y=20;
				}else{
					y=y-20;
				}
			}
			if(keyCode == e.VK_DOWN){
				if(y>=480){
					y=480;
				}else{
					y=y+20;
				}
				
			}
		}
		public void keyRelease(KeyEvent e){
			
		}
	}
	public javagame(){
		//load images
		ImageIcon i= new ImageIcon("C:/Users/Administrator/Downloads/icon1.png");
		face= i.getImage();
		//game properties
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x=150;
		y=150;
		setBackground(Color.BLUE);
	}
	public void paint(Graphics g){
		dbImage= createImage(getWidth(), getHeight());
		dbg= dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
		//g.drawString("Hello Java", 75,100);\
		//g.setFont(font);
		g.setColor(Color.MAGENTA);
		//g.drawString("Hello World!", 50, 50);
		//g.setColor(Color.cyan);
		//g.fillOval(x,y,15,15);
		g.drawImage(face,  x,  y,  this);
		repaint();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new javagame();
	}

}
