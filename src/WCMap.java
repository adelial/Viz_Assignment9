//  Draws a choropleth map of countries participation in World Cup Russia 2018.
import org.gicentre.geomap.*;
import processing.core.*;
import processing.data.*;

public class WCMap {
  GeoMap geoMap;
  Table tableData;
  float dataMax;
  PApplet parent;
  int xpos, ypos, sizew, sizeh;
  
  WCMap(){
  }
  
  WCMap(PApplet p){
	  this.parent = p;
  }
  
  WCMap(int xpos, int ypos, int sizew, int sizeh) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.sizew = sizew;
    this.sizeh = sizeh;
  }
   
  // Read map data.
  public void display(int xpos, int ypos, String file_name, int sizew, int sizeh, PApplet p) {
	  this.parent = p;
	  int minColour = this.parent.color(222, 235, 247);   // Light blue
	  int maxColour = this.parent.color(49, 130, 189);    // Dark blue.
	 
	  
	  this.geoMap = new GeoMap(xpos+10, ypos+10, sizew-20, sizeh-25, p);
	  
	  if (UsingProcessing.firstInit == "A" || UsingProcessing.firstInit == "a") {
		  this.geoMap.readFile("C:\\Users\\Alma\\eclipse-workspace\\Viz_Assignment9\\src\\world");
	  }
	  else {
		  this.geoMap.readFile("C:\\Users\\Sturrock\\Documents\\SMU Data Science\\Vizualization\\Viz_Assignment9\\src\\world");
	  }
		  
	  this.tableData = parent.loadTable(file_name);  // Read data
   
    // Find largest data value so we can scale colours.
	  this.dataMax = 0;
	  for (TableRow row : tableData.rows())
	  {
		  this.dataMax = this.parent.max(this.dataMax, row.getFloat(2)); //third column
	  }
	  this.parent.fill(this.parent.color(222,242,245));
	  this.parent.noStroke();
	  this.parent.rect(xpos,ypos, sizew, sizeh);
	  this.parent.stroke(255);
	  this.parent.strokeWeight(1); 
  
    // Draw countries
	  for (int id : this.geoMap.getFeatures().keySet())
	  {
		  String countryCode = this.geoMap.getAttributeTable().findRow(this.parent.str(id),0).getString("ISO_A3");    
		  TableRow dataRow = tableData.findRow(countryCode, 0);
   
		  if (dataRow != null)       // Table row matches country code
		  {
			  float score = dataRow.getFloat(2)/dataMax;
			  this.parent.fill(parent.lerpColor(minColour, maxColour, score));
		  }
		  else                   // No data found in table.
		  {
			  this.parent.fill(this.parent.color(179,182,183));
		  }
		  this.geoMap.draw(id); // Draw country
	  }
	  // Draw title text
	  this.parent.fill(0);
	  this.parent.textAlign(PConstants.LEFT, PConstants.TOP);  
	  this.parent.text("Countries participation in World Cup Russia 2018", xpos+10, sizeh+ypos-12);
  
	  // Query the country at the mouse position to display Country name
	  int id = this.geoMap.getID(this.parent.mouseX, this.parent.mouseY);
	  if (id != -1) {
		  this.parent.fill(this.parent.color(80, 120, 120));
		  this.geoMap.draw(id);
 
		  String name = this.geoMap.getAttributeTable().findRow(parent.str(id),0).getString("NAME");    
		  this.parent.fill(0);
		  this.parent.text(name, this.parent.mouseX+5, this.parent.mouseY-5);
	  }
  	} 

}
