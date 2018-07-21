import processing.core.*;

public class ScoreBoard {
	float spacew, spaceh;
	int perimColor;
	int x, y;
	PApplet parent;
	  
	ScoreBoard() {  // constructor
	}
	
	ScoreBoard(PApplet p) {  // constructor
		this.parent = p;
	}
	
	ScoreBoard(float swidth, float sheight, int perimColor, PApplet p) {  // constructor
		this.spacew = swidth;
	    this.spaceh = sheight;
	    this.perimColor = perimColor;
	    this.parent = p;
	}
	  
	//method display for initial
	void display(int cordx, int cordy, int perimColor) {
		x = cordx;
	    y = cordy;
	    parent.strokeWeight(5);
	    parent.stroke(parent.color(perimColor));
	    parent.fill(parent.color(perimColor));
	    parent.rect(x, y, 320, 240,10); //spacew-spacew/10 = 420, spaceh/4*3 = 340
	    parent.rect(x+50, y+80, 80, 80);
	    parent.rect(x+185, y+80, 80,80);
	    parent.fill(16,103,14);
	    parent.textSize(32);
	    parent.text("FINAL",x+110, y+30);
	    parent.textSize(24);
	    parent.text("France", x+55, y+170);
	    parent.text("Croatia", x+180, y+170); 
	    parent.fill(0);
	    parent.textSize(44);
	    parent.text("4", x+75, y+90);   // i period team 1
	    parent.text("2", x+210, y+90);  // i period team 2
	    parent.textSize(12);

	  } // end display
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
