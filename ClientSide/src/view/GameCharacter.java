package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class GameCharacter {
	int x,y;
	   
	public GameCharacter(int x,int y) {
		this.x=x;
		this.y=y;
	}	
	
	public void paint(PaintEvent e,int w,int h){
		/*Display display = new Display();
		Image image = new Image(display, "resources/ski.jpg");
		GC gc = new GC(image);*/
		//Rectangle bounds = image.getBounds();
		//e.gc.drawLine(x,y,bounds.width,bounds.height);
		//e.gc.drawLine(0,bounds.height,bounds.width,0); 
		//e.gc.setBackground(new Im(image));
		e.gc.setForeground(new Color(null,255,0,0));
		e.gc.drawOval(x,y, w, h);
	   }
	}



