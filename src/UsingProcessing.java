//********************************************//
// MSDS 6390 - Visualization of Information   // 
// Assignment 9 - Object Oriented Project     //
// Names:  Alma Lopez and George Sturrock     //
//********************************************//

//Credit To:
//https://study.com/academy/lesson/java-global-variable-declaration-examples.html
//https://www.tutorialspoint.com/eclipse/eclipse_create_java_class.htm
//https://processing.org/tutorials/eclipse/ 

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
//import src.WCScoreBoard;

public class UsingProcessing extends PApplet {

	//Class Declarations 
	AgesGraph PlayersAgeFR;
	AgesGraph PlayersAgeCT;
	WCMap map1;
	DataTable buildTable;
	Table table1;
	GoalScoredGraph goalGraph;
	MarketValue marketValue;
	Tree tree;
	WCScoreBoard wcBoard;

	PImage img1, img2;
	
	//Static Variable Used to Toggle between A and G folder paths
	//public static String localPath = "C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\";
	public static String localPath = "C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\";
	
	public static PImage textImg;
	
	public static void main(String[] args) { 
		PApplet.main(new String[] {"UsingProcessing"} );
	}
	
	public void settings(){
		size(1650,1000);   // Size of the window
    }

    public void setup(){
    	
    	fill(120,50,240);
    	// Creation of objects 
    	PlayersAgeFR = new AgesGraph(this);
    	PlayersAgeCT = new AgesGraph(this);
    	map1 = new WCMap(this);
    	buildTable = new DataTable(this);
    	goalGraph = new GoalScoredGraph(this);
    	marketValue = new MarketValue(this);
    	tree = new Tree(this);
    	wcBoard = new WCScoreBoard(this, 20f, 60f, 600f, 400f, "France", "Croatia", 4, 2);
    	
    	// load data for the different graphs
   		PlayersAgeFR.loadData(localPath+"FranceAges.csv",15);
   		PlayersAgeCT.loadData(localPath+"CroatiaAges.csv",15);
   		goalGraph.loadData(localPath+"GoalDistribution.csv");
   		marketValue.setMV(localPath+"FIFA18_MVteam.csv");
   		
   		//load images
    	img1 = loadImage(localPath+"longfifa.jpg");
    	img2 = loadImage(localPath+"fifa2018.jpg");
    	  	    	    
    } //setup

    public void draw(){
    	image(img2,0,0);
    	// WC european map
   		map1.display(890, 60, localPath+"Country_rounds.csv", 700, 400, this);
    	image(img1, width/2-img1.width/2,1);
    	//Players age bubble graph
    	PlayersAgeFR.displayAll(20,620, this, this.color(187,1,4,70), this.color(43,139,222), "France Players Age",500);	
    	PlayersAgeCT.displayAll(20,820, this, this.color(187,1,4,70), this.color(43,139,222),"Croatia Players Age",500);
    	//Market value graph
    	marketValue.mvDraw();
    	//Treemap
    	tree.display();
    	//WC board
    	wcBoard.display();    
    } // draw
} // class
