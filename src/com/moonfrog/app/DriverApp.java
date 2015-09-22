package com.moonfrog.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.moonfrog.beans.Grid;
import com.moonfrog.beans.Point;

public class DriverApp {

	private Grid myGrid ;
	private int []answers = {0};
	
	public DriverApp(){
		
;	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		DriverApp app = new DriverApp();
		if(input.length == 2) {
			app.myGrid = new Grid(new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1])));
			app.play(app.myGrid,app.myGrid.getStartingPoint(), null);
		}
		else{
			System.out.print("Can't Proceed");
			return;
		}
	}
	
	public void play(Grid grid,Point currentPoint, List<Point> points){
		if(points == null)
			points = new ArrayList<Point>(2);

		if(currentPoint.equals(Point.getInvalidPoint())) {
			return;
		}
		
		if(grid.reachedEnd(currentPoint)) {
			process(points);
			return;
		}
		
		points.add(currentPoint);
		
		Point newPoint1 = grid.moveCurrentUp(currentPoint);
		
		play(grid,newPoint1, points);
		
		Point newPoint2 = grid.moveCurrentRight(currentPoint);
		
		play(grid,newPoint2, points);
		
		points.remove(points.size() - 1);
	}

	private void process(List<Point> points) {
		System.out.println(answers[4]);
		System.out.println("---====== GOT IT =========--------");
		for(Point pt : points){
			System.out.println(pt.toString());
		}
	}
	
}
