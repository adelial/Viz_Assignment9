import processing.core.*;
import processing.data.*;

public class AgesGraph {
	Bubble[] bubbles;
	Table dataTable;
	float posx,posy;
	/*int backColor = color(#B5E5B5);
	int circleColor = color(#9396F7); */
	int backColor, circleColor;
	PApplet parent;

	AgesGraph(){
	
	}
	
	AgesGraph(PApplet p){	
		parent = p;
		
	}
	  
	AgesGraph(float posx, float posy, Table dataTable, int backColor, int circleColor, PApplet p){
		
	    this.posx = posx;
	    this.posy = posy;
	    this.dataTable = dataTable;
	    this.backColor = backColor;
	    this.circleColor = circleColor;
	    parent = p;
	}

	public void loadData(String filename) {
	    // Load CSV file into a Table object, sorted already in DESC order
	    this.dataTable = parent.loadTable(filename, "header");
	 
	    // The size of the array of Bubble objects is determined by the total number of rows in the CSV
	    this.bubbles = new Bubble[dataTable.getRowCount()]; 

	    // You can access iterate over all the rows in a table
	   
	    for (int i = 0; i < dataTable.getRowCount(); i++) {
	    	TableRow row = dataTable.getRow(i);
	      // d number of players with a specific Age
	    	int d = row.getInt(1);
	    	String n = row.getString(0);
	    	 
	      // Make a Bubble object out of the data read
	      this.bubbles[i] = new Bubble(d, n);
	    }
	}
	
	public void displayAll(int px, int py, PApplet p, int c1, int c2) {
		int xval, yval, initx;
		parent = p;
		xval = px;
		yval = py;
		initx = xval;
		this.backColor = parent.color(c1);
		this.circleColor = parent.color(c2);
		
		parent.fill(parent.color(this.backColor));
	    parent.rect (xval,yval-50, parent.width-60,150); 
	    xval = xval+this.bubbles[0].diameter/2 +60;
	    yval = yval+this.bubbles[0].diameter/2 +10;
	    for (int i = 0; i < this.bubbles.length; i++) {
	      this.bubbles[i].display(xval, yval, circleColor, parent);
	      if (i < this.bubbles.length-1) {
	        xval = xval+ this.bubbles[i].diameter/2 + this.bubbles[i+1].diameter/2;
	      }
	    }
	    parent.textAlign(parent.CENTER, parent.CENTER);
	    parent.fill(0);
	    parent.text(dataTable.getColumnTitle(0),initx+20,yval+55); 
	    	    
	    parent.textSize(14);
	    parent.text("Player ages in the World Cup 2018", parent.width/2, yval-80);
	}
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}	
		
}
