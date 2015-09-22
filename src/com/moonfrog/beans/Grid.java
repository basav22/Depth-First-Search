package com.moonfrog.beans;

public class Grid {

	private Point startingPoint, endPoint;
	
	public Grid(Point point) {
		startingPoint = new Point(1D, 1D);
		endPoint = point;
	}
	
	public Point getStartingPoint() {
		return startingPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean reachedEnd(Point currentPoint) {
		return currentPoint.equals(endPoint);
	}
	
	public boolean inRange(Point currentPoint) {
		boolean toReturn = false;
		if(currentPoint.getX() <= endPoint.getX() 
				&& currentPoint.getY() <= endPoint.getY())
			toReturn = true;
		
		return toReturn;
	}
 	
	public Point moveCurrentUp(Point currentPoint){
		Point toReturn = new Point(currentPoint.getX(), currentPoint.getY() + 1);
		
		if(!inRange(toReturn)) {
			toReturn = Point.getInvalidPoint();
		}
		return toReturn;
	}
	
	public Point moveCurrentRight(Point currentPoint) {
		Point toReturn = null;
		if(!currentPoint.equals(Point.getInvalidPoint())) {
			toReturn = new Point(currentPoint.getX() + 1, currentPoint.getY());
			if(! inRange(toReturn))
				toReturn = Point.getInvalidPoint();
		}
		else {
			toReturn = Point.getInvalidPoint();
		}
		return toReturn;
	}
	
}
