package nico.spaceinvaders.models;

import nico.spaceinvaders.WindowManager;
import nico.spaceinvaders.gamelogic.ProjectilesManager;

public class RedShip extends Model {

	public static final byte SIZE_X = 18;
	public static final byte SIZE_Y = 8;

	//Determine how fast and in what direction it's moving
	private int motion;
	
	public RedShip() {
		super("red_ship", -SIZE_X * WindowManager.ZOOM, 3 * WindowManager.ZOOM, SIZE_X * WindowManager.ZOOM, SIZE_Y * WindowManager.ZOOM);
		this.motion = 0;
	}
	
	public void setMotion(int motion) {
		//Set the UFO's motion for it to start moving
		this.motion = motion;
		
		//Also moves the UFO to the left or to the right of the screen
		if(motion > 0)
			super.model.x = -SIZE_X * WindowManager.ZOOM;
		else
			super.model.x = WindowManager.WIDTH;
	}
	
	public void move() {
		//Move the UFO
		super.model.x += this.motion * WindowManager.ZOOM;
	}
	
	public boolean checkCollision(ProjectilesManager projectilesManager) {
		//Check if UFO was hit
		if(projectilesManager.checkCollision(this)) {
			super.model.x = -SIZE_X * WindowManager.ZOOM;
			return true;
		}
		return false;
	}
}
