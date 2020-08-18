package Week1.Test4;

import java.util.HashSet;
import java.util.Set;

public class Point {
	double x;
	double y;
	int id = 1;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Point && ((Point) obj).x == this.x && ((Point) obj).y == this.y);
	}

	public String toString() {
		return "(" + (int) x + ", " + (int) y + ")";
	}
}
