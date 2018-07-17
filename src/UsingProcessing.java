import processing.core.*;
import processing.data.*;

public class UsingProcessing extends PApplet {

	AgesGraph PlayersAge;
	WCMap map1;
	DataTable buildTable;
	Table table1;
	GoalScoredGraph goalGraph;
	
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
    	
    	   	
    	PlayersAge.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv");
    	PlayersAge.displayAll(790,120, this, this.color(187,1,4,70), this.color(43,139,222));
    	table1 = loadTable("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv", "header");
    	buildTable.drawTable(805,240, table1, false);    	
    	
    	goalGraph.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\GoalDistribution.csv");
        //goalGraph.createPlot();
      
    }

    public void draw(){
    	map1.display(10, 10, "C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\Country_rounds.csv", 760, 400, this);
    	goalGraph.createPlot();
      
    }
}
