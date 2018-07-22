import processing.core.*;
import processing.data.*;

public class WCScoreBoard extends TheScoreBoard {
	
	PApplet parent;
	
	String team1, team2;
	int score1, score2;
	
	//from Super Class TheScoreBoard
	//float originX, originY, sizeX, sizeY;

	public WCScoreBoard() {

	}
	
	WCScoreBoard(PApplet p){
		this.parent = p;
	}
	
	WCScoreBoard(PApplet p, float originX, float originY, float sizeX, float sizeY, String team1, String team2, int score1, int score2){
		super(originX, originY, sizeX, sizeY);
		
		this.parent = p;
		
		this.parent.println("In WCScoreBoard Constructor", originX, originY, sizeX, sizeY);
		
		this.team1 = team1;
		this.team2 = team2;
		this.score1 = score1;
		this.score2 = score2;
	}
	
	public void display(){
		
		this.parent.fill(100,100);
		frame(this.parent, originX, originY, sizeX, sizeY); //draw Outer ScoreBoard Box
		this.parent.fill(0);
		frame(this.parent, originX+40, originY+70, sizeX/2.5f, sizeY/1.5f); //draw team 1 number box
		frame(this.parent, originX+sizeX-280, originY+70, sizeX/2.5f, sizeY/1.5f); //draw team 2 number box
		this.parent.fill(255,223,0);
		this.parent.textSize(32);
		this.parent.text(team1, originX+150, originY+45);
		this.parent.text(team2, originX+sizeX-170, originY+45);
		this.parent.textSize(180);
		this.parent.text(score1, originX+160, originY+180);
		this.parent.text(score2, originX+sizeX-160, originY+180);
		this.parent.fill(0);
		this.parent.textSize(18);
	}

}
