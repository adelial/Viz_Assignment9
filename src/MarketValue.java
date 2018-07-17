/**Create Bar Chart Showing Top Ten Teams by Market Value
 * 
 */
//Processing Libraries
import processing.core.PApplet;
import processing.data.*;

//GiCentre Libraries
import org.gicentre.utils.stat.*;
//import org.gicentre.utils.colour.*;

public class MarketValue {

	BarChart barChart;

	Table mvTable;
	float[] mv = new float[10];
	String[] country = new String[10];
	PApplet parent;

	//Constructors
	MarketValue() {
		// TODO Auto-generated constructor stub
	}

	MarketValue(PApplet p) {
		this.parent = p;
	}

	public void setMV(String filename) {
		// Load CSV file into a Table object, sorted already in DESC order
		this.mvTable = parent.loadTable(filename, "header");

		for (int row=0; row < mvTable.getRowCount(); row++){
			String c = mvTable.getString(row, "Country");
			float euro = mvTable.getFloat(row, "MarketValue");
			mv[row] = euro;
			country[row] = c;
		}
	}

	public void mvDraw(){
		//Display the Market Value Bar Chart
		barChart = new BarChart(this.parent);
		
		barChart.setData(mv);
		barChart.setBarLabels(country);
		barChart.setBarColour(this.parent.color(213,43,30,200));
		barChart.setBarGap(10); 
		barChart.setValueFormat("�###");
		barChart.showValueAxis(true); 
		barChart.showCategoryAxis(true); 

		barChart.draw(600, this.parent.height/1.9f, this.parent.width/3f, this.parent.height/2.2f);
		this.parent.fill(0);
		//textFont(titleFont);
		this.parent.text("Market Value of World Cup 2018 Teams (in Millions of Euros)", this.parent.width/2.6f, this.parent.height/1.9f);
		this.parent.text("Top 10 - in Millions of Euros", this.parent.width/2.1f, this.parent.height/1.8f);
		//float textHeight = this.parent.textAscent();
	} 	

}
