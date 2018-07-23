// Age Graph class used to draw a bubble graph with the provided data in a csv file
import processing.core.PApplet;
import processing.core.PConstants;
import processing.data.Table;
import processing.data.TableRow;

public class AgesGraph {
	Bubble[] bubbles;
	Table dataTable;
	float posx,posy;
	int backColor, circleColor;
	int factor;
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

	// Create an array of bubble based on the data provided in filename, factor parameter is used to determine the size of the bubbles
	public void loadData(String filename, int factor) {
	    // Load CSV file into a Table object, sorted already in DESC order
	    this.dataTable = parent.loadTable(filename, "header");
	 
	    // The size of the array of Bubble objects is determined by the total number of rows in the CSV
	    this.bubbles = new Bubble[dataTable.getRowCount()]; 

	    // You can access iterate over all the rows in a table
	    for (int i = 0; i < dataTable.getRowCount(); i++) {
	    	TableRow row = dataTable.getRow(i);
	      // d number of players with a specific Age  multiply by the factor.
	    	int d = row.getInt(1)*factor;
	    	String n = row.getString(0);
	    	 
	      // Make a Bubble object out of the data read
	      this.bubbles[i] = new Bubble(d, n, factor);
	    }
	} //loadData
	
	// With the use of the bubble created in loadData it will display all the bubbles
	public void displayAll(int px, int py, PApplet p, int c1, int c2, String title,int swidth) {
		int xval, yval, initx;
		parent = p;
		xval = px;
		yval = py;
		initx = xval;
		this.backColor = parent.color(c1);
		this.circleColor = parent.color(c2);
		
		parent.fill(parent.color(this.backColor));
		parent.noStroke();
	    parent.rect (xval,yval-50, swidth,150); 
	    xval = xval+this.bubbles[0].diameter/2 +60;
	    yval = yval+this.bubbles[0].diameter/2 +10;
	    for (int i = 0; i < this.bubbles.length; i++) {
	      this.bubbles[i].display(xval, yval, circleColor, parent, 15);
	      if (i < this.bubbles.length-1) {
	        xval = xval+ this.bubbles[i].diameter/2 + this.bubbles[i+1].diameter/2+5;
	      }
	    }
	    parent.textAlign(PConstants.CENTER, PConstants.CENTER);
	    parent.fill(0);
	    parent.text(dataTable.getColumnTitle(0),initx+20,yval+55); 
	    	    
	    parent.textSize(16);
	    parent.text(title, swidth/2, yval-80);
	    parent.textSize(12);
	} //displayAll
} //class
