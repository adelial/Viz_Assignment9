//Draw TreeMap Showing Average Time Breakout per Game
////http://www.staff.city.ac.uk/~jwo/treemappa/software/userguide.html
////https://www.gicentre.net/treemappa/using/

import processing.core.PApplet;
import processing.core.PImage;
import org.gicentre.treemappa.*;
import org.gicentre.utils.colour.*;

public class Tree {

	PTreeMappa pTreeMappa;
	PApplet parent;

	Tree() {

	}

	Tree(PApplet p) {
		this.parent = p;
	}
	
	public void drawTreeMap() {
		
		//Generate Tree Map
		pTreeMappa = new PTreeMappa(this.parent);  // Create an empty treemap.  
		
		pTreeMappa.readData(UsingProcessing.localPath+"match.csv");  
				
		TreeMapPanel tmPanel = pTreeMappa.getTreeMapPanel();
		tmPanel.setColourTable(ColourTable.readFile(this.parent.createInput("match.ctb")));
		tmPanel.setMutation(0.4f);
		tmPanel.setLeafMaxTextSize(36);
		tmPanel.showStatistics();
		tmPanel.setLayouts("orderedSquarified");
		tmPanel.setBorders(20); //border around level 0 nodes
		tmPanel.setBorder(1,0); //no border around leaf nodes (level 1)
		tmPanel.setLeafTextColour(this.parent.color(255));
		tmPanel.setAllowVerticalLabels(false);
		tmPanel.updateImage();
		tmPanel.updateLayout();
		pTreeMappa.createImage();
		
		tmPanel.writeImage(UsingProcessing.localPath+"matchTMap.png");
		
	}
	
    public void display() {
    	//Display Tree Map
    	PImage gTreeMap;
    	this.parent.textSize(18);
    	this.parent.text("Match Summary Statistics - France (Blue) vs Croatia (Red)", 1350, 490);
		gTreeMap = this.parent.loadImage(UsingProcessing.localPath+"matchTMap.png");
		gTreeMap.resize(560, 480);
		this.parent.image(gTreeMap, 1070, 500);
    	
    }

}
