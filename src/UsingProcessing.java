//Credit To:
//https://study.com/academy/lesson/java-global-variable-declaration-examples.html
//https://www.tutorialspoint.com/eclipse/eclipse_create_java_class.htm

import processing.core.*;
import processing.data.*;

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
	ScoreBoard sboard;
	PImage img1, img2;
	
	//Static Variable Used to Toggle between A and G to switch folder paths
	public static String firstInit = "A";
	public static PImage textImg;
	
	public static void main(String[] args) { 
		PApplet.main(new String[] {"UsingProcessing"} );
	}
	
	public void settings(){
		size(1650,1000);
    }

    public void setup(){
    	
    	fill(120,50,240);
    	PlayersAgeFR = new AgesGraph(this);
    	PlayersAgeCT = new AgesGraph(this);
    	map1 = new WCMap(this);
    	buildTable = new DataTable(this);
    	goalGraph = new GoalScoredGraph(this);
    	marketValue = new MarketValue(this);
    	tree = new Tree(this);
    	sboard = new ScoreBoard(this);

    	if (firstInit == "A" || firstInit == "a") {
    		PlayersAgeFR.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\FranceAges.csv",15);
    		PlayersAgeCT.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\CroatiaAges.csv",15);
    		table1 = loadTable("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    		goalGraph.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\GoalDistribution.csv");
    		marketValue.setMV("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\FIFA18_MVteam.csv");
    	}
    	else {
    		PlayersAgeFR.loadData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\SquadsGroupAge.csv",20);
    		table1 = loadTable("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    		goalGraph.loadData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\GoalDistribution.csv");    	
    		marketValue.setMV("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\FIFA18_MVteam.csv");
    	}
    	
    	
    	
    	
    	img1 = loadImage("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\longfifa.jpg");
    	img2 = loadImage("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\fifa2018.jpg");
    	
    //	marketValue.mvDraw();
    //	tree.drawTreeMap();
    	    
    }

    public void draw(){
    	image(img2,0,0);
    	if (firstInit == "A" || firstInit == "a") {
    		map1.display(960, 55, "C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\Country_rounds.csv", 670, 300, this);
    	}
    	else {
    		map1.display(860, 55, "C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\Country_rounds.csv", 760, 400, this);
    	}
    	image(img1, width/2-img1.width/2,1);
    	sboard.display(40, 65,color(199,200,200));
    	PlayersAgeFR.displayAll(20,620, this, this.color(187,1,4,70), this.color(43,139,222), "France and Croatia Payers Age",500);
    	//buildTable.drawTable(805,240, table1, false);    	
    	PlayersAgeCT.displayAll(20,800, this, this.color(187,1,4,70), this.color(43,139,222),"",500);
    	//goalGraph.createPlot();
      
    }
}
