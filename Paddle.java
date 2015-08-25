package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle implements Runnable{
	int x, y, yDirection, id;
	Rectangle paddle;
	
	public Paddle(int x, int y, int id){
		this.x= x;
		this.y= y;
		this.id= id;
		paddle= new Rectangle(x, y, 10, 50);
		
	}
	
	public void keyPressed(KeyEvent e){
		switch(id){
		default:
			System.out.println("Please Enter valid ID in paddle constructor");
			break;
			
		case 1:
			if(e.getKeyCode() == e.VK_W){
				
			}
			if(e.getKeyCode() == e.VK_S){
						
					}
			break;
		case 2:
			if(e.getKeyCode() == e.VK_UP){
				
			}
			if(e.getKeyCode() == e.VK_DOWN){
				
			}
			break;
		}
	}
	public void setYDirection(int ydir){
		yDirection= ydir;
	}
	
	public void move(){
		paddle.y += yDirection;
		if(paddle.y <= 15){
			paddle.y= 15;
		}
		if(paddle.y >= 250){
			paddle.y = 250;
		}
	}
	public void draw(Graphics g){
		switch (id){
			default:
				System.out.println("Please enter valid ID in Paddle");
				break;
			case 1:
				g.setColor(Color.cyan);
				g.fillRect(paddle.x,  paddle.y,  paddle.width, paddle.height);
				break;
			case 2:
				g.setColor(Color.PINK);
				g.fillRect(paddle.x,  paddle.y,  paddle.width, paddle.height);
				break;
				
				
				
		}
	}
	public void run(){
		try{
			while(true){
				move();
				Thread.sleep(7);
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
