package Week1.Test4;

import java.util.*;

public class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + Math.floor(x) + ", " + Math.floor(y) + ")";
	}
}
