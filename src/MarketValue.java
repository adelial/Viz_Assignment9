/**Create Bar Chart Showing Top Ten Teams by Market Value
 * 
 */
//Processing Libraries
//GiCentre Libraries
//import org.gicentre.utils.colour.*;
import org.gicentre.utils.stat.BarChart;

import processing.core.PApplet;
import processing.data.Table;

public class MarketValue {

	BarChart barChart;

	Table mvTable;
	float[] mv = new float[2];
	String[] country = new String[2];
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
		barChart.setValueFormat("€###");
		barChart.showValueAxis(true); 
		barChart.showCategoryAxis(true); 

		barChart.draw(550, this.parent.height/1.9f, this.parent.width/3.1f, this.parent.height/2.2f);
		this.parent.fill(0);
		//textFont(titleFont);
		this.parent.textSize(18);
		this.parent.text("Market Value (in Millions of Euros)", this.parent.width/2.0f, this.parent.height/1.9f);
		this.parent.text("France vs Croatia", this.parent.width/2.0f, this.parent.height/1.85f);
	} 	

}

