import processing.core.PApplet;
import processing.data.*;

//Base Class for ScoreBoard Creation
public class TheScoreBoard {
	PApplet parent;

	float originX, originY, sizeX, sizeY, sizeT, sizeT2;
	String team1, team2; 
	int score1, score2;

	TheScoreBoard() {
		// TODO Auto-generated constructor stub
	}

	TheScoreBoard(PApplet p) {
		this.parent = p;
	}
	
	TheScoreBoard(float originX, float originY, float sizeX, float sizeY, String team1, String team2, int score1, int score2){
		this.originX = originX;
		this.originY = originY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.team1 = team1;
		this.team2 = team2;
		this.score1 = score1;
		this.score2 = score2;
	}
	
	public void frame(PApplet p, float originX, float originY, float sizeX, float sizeY) {
		this.parent = p;
		this.parent.rect(originX, originY, sizeX, sizeY);
	}
	
	public void boardText(PApplet p, String team1, String team2, int score1, int score2, float sizeT, float sizeT2) {
//		this.parent.println("In TheScoreBoard.boardText:", team1, team2, score1, score2, sizeT, sizeT2, originX, originY);
		this.parent = p;
		this.parent.textSize(sizeT);
		this.parent.text(team1, originX+150, originY+45);
		this.parent.text(team2, originX+sizeX-170, originY+45);
		this.parent.textSize(sizeT2);
		this.parent.text(score1, originX+160, originY+180);
		this.parent.text(score2, originX+sizeX-160, originY+180);
	}

}
