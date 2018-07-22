import processing.core.PApplet;
import processing.data.*;

//Base Class for ScoreBoard Creation
public class TheScoreBoard {
	PApplet parent;

	float originX, originY, sizeX, sizeY;

	TheScoreBoard() {
		// TODO Auto-generated constructor stub
	}

	TheScoreBoard(PApplet p) {
		this.parent = p;
	}
	
	TheScoreBoard(float originX, float originY, float sizeX, float sizeY){
		this.originX = originX;
		this.originY = originY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void frame(PApplet p, float originX, float originY, float sizeX, float sizeY) {
		this.parent = p;
		this.parent.rect(originX, originY, sizeX, sizeY);
	}

}
