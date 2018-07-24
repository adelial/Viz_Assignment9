import processing.core.*;
import processing.data.*;

public class WCScoreBoard extends TheScoreBoard {
	
	PApplet parent;
	
	public WCScoreBoard() {

	}
	
	WCScoreBoard(PApplet p){
		this.parent = p;
	}
	
	WCScoreBoard(PApplet p, float originX, float originY, float sizeX, float sizeY, String team1, String team2, int score1, int score2){
		super(originX, originY, sizeX, sizeY, team1, team2, score1, score2);
//		this.parent.println("In WCScoreBoard Overloaded Constructor:", team1, team2, score1, score2, sizeT, sizeT2, originX, originY);
		this.parent = p;

	}
	
	public void display(){
//		this.parent.println("In WCScoreBoard.display:", team1, team2, score1, score2, sizeT, sizeT2, originX, originY);
		this.parent.fill(100,100);
		frame(this.parent, originX, originY, sizeX, sizeY); //draw Outer ScoreBoard Box
		this.parent.fill(0);
		frame(this.parent, originX+40, originY+70, sizeX/2.5f, sizeY/1.5f); //draw team 1 number box
		frame(this.parent, originX+sizeX-280, originY+70, sizeX/2.5f, sizeY/1.5f); //draw team 2 number box
		this.parent.fill(255,223,0);
		boardText(this.parent, team1, team2, score1, score2, 32, 180); //team names and scores in one line
		this.parent.fill(0);
		this.parent.textSize(18);
	}

}
