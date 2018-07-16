import processing.core.*;
import org.gicentre.geomap.*; 

public class UsingProcessing extends PApplet {

	AgesGraph PlayersAge;
	
	WCMap map1;

	
	public static void main(String[] args) {
		PApplet.main(new String[] {"UsingProcessing"} );
	}
	public void settings(){
		size(1000,1000);

    }

    public void setup(){
    	fill(120,50,240);
    	PlayersAge = new AgesGraph(this);
    	map1 = new WCMap(this);
    	//ball = new Bubble(this);
    	PlayersAge.loadData("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\SquadsGroupAge.csv");
    	PlayersAge.displayAll(40,100, this, 200, 255);
    	map1.display(20, 460, "C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\data\\Country_rounds.csv", 960, 400, this);
    }

    public void draw(){
    	//PlayersAge.displayAll(40,100, this, 200, 255);
    }
}
