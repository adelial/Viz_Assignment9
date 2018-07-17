// Build a circle graph 
// this is used for players age graph


import grafica.*;
import processing.core.*;
import processing.data.*;

public class GoalScoredGraph {
	  Table goalTable;
	  GPlot plot;
	  GPointsArray points;
	  float[] pointSizes;
	  PApplet parent;

	  GoalScoredGraph() {
	  }
	  
	  GoalScoredGraph(PApplet p) {
		  this.parent = p;
	  }
	 
	  void loadData(String filename) {
		  this.goalTable = parent.loadTable(filename, "header");  
		  // Save the data in one GPointsArray and calculate the point sizes
		  points = new GPointsArray();
		  pointSizes = new float[goalTable.getRowCount()];
	      
		  for (int row = 0; row < goalTable.getRowCount(); row++) {
			  float time = goalTable.getFloat(row, "Time");
			  float goals = goalTable.getFloat(row, "Goals");
			  String goalsT = goalTable.getString(row, "Goals");
			  float gSize = goalTable.getFloat(row, "Goals");
			  points.add(time, goals, goalsT);
			  pointSizes[row] = gSize*1.1f;
		  }
	  }
	  
	  // Create the plot
	  void createPlot() {
	    plot = new GPlot(this.parent, 10f, this.parent.height/2f, this.parent.width/3f, this.parent.height/1.5f);
	    plot.setDim(500, 350);
	    plot.setTitleText("When Were Goals Scored?");
	    plot.getXAxis().setAxisLabelText("Game Time (minutes)");
	    plot.getYAxis().setAxisLabelText("Goals Scored");
	    plot.setPoints(points);
	    plot.setPointSizes(pointSizes);
	    plot.activatePointLabels();
	    plot.activatePanning(PConstants.RIGHT);
	    plot.activateZooming(1.3f, PConstants.CENTER, PConstants.CENTER);
	
	    plot.beginDraw();
	    plot.drawBox();
	    plot.drawXAxis();
	    plot.drawYAxis();
	    plot.drawTitle();
	    plot.drawGridLines(GPlot.BOTH);
	    plot.drawPoints();
	    plot.drawLabels();
	    plot.endDraw();
	  }  


}
