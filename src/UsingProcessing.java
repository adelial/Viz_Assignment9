//Credit To:
//https://study.com/academy/lesson/java-global-variable-declaration-examples.html
//https://www.tutorialspoint.com/eclipse/eclipse_create_java_class.htm

import processing.core.*;
import processing.data.*;

public class UsingProcessing extends PApplet {

	//Class Declarations
	AgesGraph PlayersAge;
	WCMap map1;
	DataTable buildTable;
	Table table1;
	GoalScoredGraph goalGraph;
	MarketValue marketValue;
	Tree tree;

	//Static Variable Used to Toggle between A and G to switch folder paths
	public static String firstInit = "G";
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"UsingProcessing"} );
	}
	
	public void settings(){
		size(1650,1000);
    }

    public void setup(){
    	fill(120,50,240);
    	PlayersAge = new AgesGraph(this);
    	map1 = new WCMap(this);
    	buildTable = new DataTable(this);
    	goalGraph = new GoalScoredGraph(this);
    	marketValue = new MarketValue(this);
    	tree = new Tree(this);

    	if (firstInit == "A" || firstInit == "a") {
    		PlayersAge.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv");
    		table1 = loadTable("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    		goalGraph.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\GoalDistribution.csv");
    		marketValue.setMV("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\FIFA18_MVteam.csv");
    	}
    	else {
    		PlayersAge.loadData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\SquadsGroupAge.csv");
    		table1 = loadTable("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    		goalGraph.loadData("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\GoalDistribution.csv");    	
    		marketValue.setMV("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\FIFA18_MVteam.csv");
    	}
    	
    	//PlayersAge.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv");
    	PlayersAge.displayAll(790,120, this, this.color(187,1,4,70), this.color(43,139,222));
    	//table1 = loadTable("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    	buildTable.drawTable(805,240, table1, false);    	
    	
    	marketValue.mvDraw();
    	tree.drawTreeMap();
    	    
    }

    public void draw(){
    	if (firstInit == "A" || firstInit == "a") {
    		map1.display(10, 10, "C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\Country_rounds.csv", 760, 400, this);
    	}
    	else {
    		map1.display(10, 10, "C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\data\\Country_rounds.csv", 760, 400, this);
    	}
    	
    	goalGraph.createPlot();
      
    }
}
