//Draw TreeMap Showing Average Time Breakout per Game
import processing.core.PApplet;
import processing.core.PImage;
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
		
		//if (UsingProcessing.firstInit == "A" || UsingProcessing.firstInit == "a") {
			pTreeMappa.readData(UsingProcessing.localPath+"play.csv");  
		/*}
		else {
			pTreeMappa.readData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\play.csv");
		}*/
		
		TreeMapPanel tmPanel = pTreeMappa.getTreeMapPanel();
		tmPanel.setMutation(0.4f);
		tmPanel.setLeafMaxTextSize(36);
		tmPanel.showStatistics();
		tmPanel.updateImage();
		tmPanel.updateLayout();
		pTreeMappa.createImage();
		
		//if (UsingProcessing.firstInit == "A" || UsingProcessing.firstInit == "a") {
			tmPanel.writeImage(UsingProcessing.localPath+"gameTMap.png");
		/*}
		else {
			tmPanel.writeImage("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\gameTMap.png"); 
		}
		 */
		
		//Display Tree Map
		//if (UsingProcessing.firstInit == "A" || UsingProcessing.firstInit == "a") {
			gTreeMap = this.parent.loadImage(UsingProcessing.localPath+"gameTMap.png");
		/*}
		else {
			gTreeMap = this.parent.loadImage("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\gameTMap.png");
		}
		*/
		//gTreeMap = this.parent.loadImage("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\gameTMap.png");
		gTreeMap.resize(490, 480);
		this.parent.image(gTreeMap, 1150, 500);
	}

}
