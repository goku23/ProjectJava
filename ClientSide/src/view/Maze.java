package view;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Maze extends Canvas{
	
	int[][] mazeBoard;
	GameCharacter c;
	Timer timer;
	TimerTask task;
	
	public Maze( Composite parent, int style, final int[][] mazeBoard){
		super(parent, style);
		this.mazeBoard = mazeBoard;
		
		setBackground(new Color(null, 255, 255, 255));
				
		c = new GameCharacter(10, 10);
		
		addPaintListener(new PaintListener(){

			public void paintControl(PaintEvent e) {
				e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));

				   int width=getSize().x;
				   int height=getSize().y;

				   int w=width/mazeBoard[0].length;
				   int h=height/mazeBoard.length;

				   for(int i=0;i<mazeBoard.length;i++)
				      for(int j=0;j<mazeBoard[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeBoard[i][j]!=0)
				             e.gc.fillRectangle(x,y,w,h);
				        	  //e.gc.drawRectangle(x, y, w, h);
				      }
				   c.paint(e, w, h);
				   
				}
		});
		
		addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				stop();
			}
		});
	}
	
	
	public void start() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						Random r = new Random();
						c.x +=- 5+r.nextInt(11);
						c.y +=- 5+r.nextInt(11);
						redraw();
						
					}
				});
				/*Random r = new Random();
				c.x +=- 5+r.nextInt(11);
				c.y +=- 5+r.nextInt(11);
				redraw();*/
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, 500);
	}
	
	public void stop() {
		if(task!=null)
			task.cancel();
		if(timer!=null)
			timer.cancel();
	}
}
				
				
			


				
		
