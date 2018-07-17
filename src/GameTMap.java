// Tree Map
import org.gicentre.treemappa.*;      // For treemappa classes
import org.gicentre.utils.colour.*;   // Colours needed by treemappa.

import processing.core.*;
import processing.data.*;

public class GameTMap {
	PTreeMappa pTreeMappa;
	TreeMapPanel tmPanel;
	PApplet parent;
	
	GameTMap(){
	}
	
	GameTMap(PApplet p){
	}
	
	public void buildGraph() {
		pTreeMappa = new PTreeMappa(this);  // Create an empty treemap.    
		pTreeMappa.readData("play.csv");    // Load the data and build the treemap. 
		TreeMapPanel tmPanel = pTreeMappa.getTreeMapPanel();
		this.tmPanel.setMutation(0.4);
		this.tmPanel.setLeafMaxTextSize(18);
		this.tmPanel.showStatistics();
		this.tmPanel.updateImage();
		this.tmPanel.updateLayout();
		this.pTreeMappa.createImage();
		this.tmPanel.writeImage("gameTMap.png");
		
		this.parent.text("How is World Cup Game Time Allocated?", 400, 530);
		this.parent.gTreeMap = loadImage("gameTMap.png");
		this.parent.gTreeMap.resize(880, 440);
		this.parent.image(gTreeMap, 60, 540);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
