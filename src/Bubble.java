import processing.core.*;

public class Bubble {
	float x, y;
	int diameter=30;
	int factor=1;
	String name;
	int circleColor;
	boolean over = false;
	PApplet parent;
	  
	Bubble(PApplet p){
		parent = p;
	}

	Bubble(int diameter, String name, int factor) {
		this.diameter = diameter;
	    this.name = name;
	    this.factor = factor;
	}
	 
	Bubble(int diameter, String name, int circleColor) {
	    this.diameter = diameter;
	    this.name = name;
	    this.circleColor = circleColor;
	}
	
	Bubble(int diameter, String name, int circleColor, PApplet p) {
	    this.diameter = diameter;
	    this.name = name;
	    this.circleColor = circleColor;
	    parent = p;
	}
	  
	// Display the Bubble
	public void display(int xpos, int ypos, int circleColor, PApplet p, int factor) {
		this.parent = p;
		parent.stroke(0);
	    parent.strokeWeight(2);
	    parent.noFill();
	    x = xpos;
	    y = ypos;
	    
	    parent.fill(parent.color(circleColor));
	    parent.noStroke();
	    parent.ellipse(x, y, diameter, diameter);
	    int num = 0;
	    if (this.diameter > 10) {
	    	parent.fill(0);
	    	parent.textAlign(PConstants.CENTER, PConstants.CENTER);
	    	num = this.diameter/factor;
	    	parent.text(num,x,y);
	    	parent.text(this.name,x,y+55);
	    }
	}

}