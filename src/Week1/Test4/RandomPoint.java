package Week1.Test4;

import java.util.*;
import java.io.*;

public class RandomPoint {

	final static String outputFilePath = "/home/minhtq/Public/Tests/Output/output4.txt";
	public static List<Point> points = new ArrayList<>();
	public static Random rd = new Random();

	public static void genRandomPoints(Point center, double range, int number) {
		for (int i = 0; i < number; i++) {
			double r = range * Math.sqrt(rd.nextDouble());
			double t = rd.nextDouble() * 2 * Math.PI;
			Point genPoint = new Point(center.x + r * Math.cos(t), center.y + r * Math.cos(t));
			points.add(genPoint);
		}
	}

	public static void printResultToFile() {
		try {
			FileOutputStream fos = new FileOutputStream(outputFilePath);
			for (Point p : points) {
				fos.write((p.toString() + System.lineSeparator()).getBytes());
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Point A = new Point(800, 800);
		Point B = new Point(4000, 800);
		Point C = new Point(2400, 2400);

		genRandomPoints(A, 400, 8000);
		genRandomPoints(B, 500, 10000);
		genRandomPoints(C, 600, 12000);

		printResultToFile();

	}

}
