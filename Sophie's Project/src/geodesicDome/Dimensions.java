package geodesicDome;

import java.util.ArrayList;

public class Dimensions {

	// http://mathcircle.berkeley.edu/BMC6/ps0405/geodesic.pdf
	// above is a link which has a precise ratio between the two lengths of wood
	// needed.
	// Work in metres.

	// Triangle 1 is the equilateral triangle with base dimensions.
	// Triangle 2 is the isosceles triangle with base base and the base are
	// length hypotenuse.

	// Ratio is ratio between the two sides required to build a 2v dome.
	// Decagon Side Length =
	private final static double ratio = 0.88431;
	private static double decagonSideLength = 0.7;
	private static double rectangleSideLength = 0.7;
	private static double hypotenuse = (decagonSideLength * ratio);
	private static double base = decagonSideLength;

	public static ArrayList<Double> anglesOfIsosceles(double hypotenuse, double base) {
		double a = base;
		double b = hypotenuse;
		double c = hypotenuse;
		double ang1 = Math.acos(((b * b) + (b * b) - (a * a)) / (2 * (b * c)));
		System.out
				.println("Angle between two EQUAL length sides of the triangle is: " + Math.toDegrees(ang1) + "\u00b0");
		double ang2 = Math.acos(((c * c) + (a * a) - (b * b)) / (2 * (c * a)));
		System.out.println(
				"Angle between two UNEQUAL length sides of the triangle is: " + Math.toDegrees(ang2) + "\u00b0");
		ArrayList<Double> angles = new ArrayList<Double>();
		angles.add(ang1);
		angles.add(ang2);
		return angles;
	}

	// Works out the diameter of decagon base and prints this and the height of
	// domey.
	public static double diameter(double dSL) {
		double a = decagonSideLength;
		double A = 2 * Math.PI / 10;
		double d = Math.sqrt(2) * a / (Math.sqrt(1 - Math.cos(A)));
		System.out.println("Diameter of the decagon is: " + d + "m");
		System.out.println("Height of domey: " + (d / 2 + rectangleSideLength) + "m");
		return d;
	}

	public static void main(String[] args) {
		ArrayList<Double> aOI = anglesOfIsosceles(hypotenuse, base);
		System.out.println();
		diameter(decagonSideLength);
	}

}
