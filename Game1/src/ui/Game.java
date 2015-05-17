package ui;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import el.Sci;

public class Game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        GraphicsDevice gd = ge.getDefaultScreenDevice(); 
		GameWindow tbc = new GameWindow(gd.getDefaultConfiguration());
 
 
	        DisplayMode mode = new DisplayMode(1280, 720, 32, 60);
	        if (gd.isFullScreenSupported()) {  
	        	 try {
	 	            gd.setFullScreenWindow(tbc);
		            gd.setDisplayMode(mode);
		      }catch (IllegalArgumentException ex) {}

	        } else {  
	            System.out.println("Unsupportedfullscreen.");  
	        }  
	    
		

		tbc.setVisible(true);

	}

}
