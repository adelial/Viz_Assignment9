//Draw TreeMap Showing Average Time Breakout per Game
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.*;

import org.gicentre.treemappa.*;

public class Tree {

	PTreeMappa pTreeMappa;
	PApplet parent;

	Tree() {

	}

	Tree(PApplet p) {
		this.parent = p;
	}
	
	public void drawTreeMap() {
		
		PImage gTreeMap;
		//Generate Tree Map
		pTreeMappa = new PTreeMappa(this.parent);  // Create an empty treemap.    
		pTreeMappa.readData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\play.csv");  
		TreeMapPanel tmPanel = pTreeMappa.getTreeMapPanel();
		tmPanel.setMutation(0.4f);
		tmPanel.setLeafMaxTextSize(18);
		tmPanel.showStatistics();
		tmPanel.updateImage();
		tmPanel.updateLayout();
		pTreeMappa.createImage();
		tmPanel.writeImage("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\gameTMap.png");  
		
		//Display Tree Map
		gTreeMap = this.parent.loadImage("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\gameTMap.png");
		gTreeMap.resize(470, 470);
		this.parent.image(gTreeMap, 1150, 500);
	}

}
