package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable{
	
	
	
	int x, y, xDirection, yDirection;
	Paddle p1 = new Paddle(15, 140, 1);
	Paddle p2 = new Paddle(370, 140, 2);
	int p1Score, p2Score;
	
	Rectangle ball;
	
	public Ball(int x, int y){
		p1Score= p2Score= 0;
		this.x= x;
		this.y= y;
		
		//Set ball moving randmoly
		Random r= new Random();
		int rDir= r.nextInt(2);
		if(rDir ==0){
			rDir--;
		}
		setXDirection(rDir);
		int yrDir= r.nextInt(2);
		if(yrDir == 0){
			yrDir--;
		}
		setYDirection(yrDir);
			
		ball = new Rectangle(this.x, this.y, 15, 15);
	}
	
	private void setYDirection(int yrDir) {
		// TODO Auto-generated method stub
		
	}

	public void setXDirection(int xdir){
		xDirection= xdir;
	}
	public void setyDirection(int ydir){
		yDirection= ydir;
	}
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}
	
	public void move(){
		ball.x=x+ xDirection;
		ball.y=y+ yDirection;
		if(ball.x <= 0){
			setXDirection(+1);
			p2Score++;
			
		}
		if(ball.x >= 385){
			setXDirection(-1);
			p1Score++;
		}
		if(ball.y <=0){
			setYDirection(+1);
		}
		if(ball.y>= 285){
			setYDirection(-1);
		}
	}
	public void run(){
		try{
			while(true){
				move();
				Thread.sleep(4);
			}
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	
}
