package geodesicDome;

import java.util.ArrayList;

public class Dimensions {

	// http://mathcircle.berkeley.edu/BMC6/ps0405/geodesic.pdf
	// above is a link which has a precise ratio between the two lengths of wood
	// needed.
	// Work in metres.

	// Triangle 1 is the equilateral triangle with base dimensions.
	// Triangle 2 is the isosceles triangle with base base and the other two
	// sides are
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

	public static double insideFiveLengthFlatPentagon() {
		double d = base / (2 * Math.sin(Math.toRadians(36)));
		// System.out.println("d = " + d);
		return d;
	}

	public static double taperAngleOfCentralBeamsInPentagon() {

		double ang1 = Math.toRadians(72);
		ThreeVector A = new ThreeVector(-base * Math.sin(ang1), base * Math.cos(ang1), 0);
		// System.out.println("A: " + A);
		double g = (base * Math.sin(Math.toRadians(54)) / (2 * Math.sin(Math.toRadians(36))));
		double d = insideFiveLengthFlatPentagon();
		double e = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(d, 2));
		// System.out.println("Hypotenuse: " + hypotenuse);
		// System.out.println("e: " + e);
		ThreeVector B = new ThreeVector(0.5 * base, g, e);
		// System.out.println("B: " + B);
		ThreeVector C = new ThreeVector(0.5 * base, (g + d), 0);
		ThreeVector O = new ThreeVector(0, 0, 0);

		// System.out.println("C: " + C);
		ThreeVector v1 = ThreeVector.subtract(A, O);
		ThreeVector v2 = ThreeVector.subtract(B, O);

		ThreeVector v3 = ThreeVector.subtract(B, A);
		ThreeVector v4 = ThreeVector.subtract(C, A);

		ThreeVector v1xv2 = ThreeVector.vectorProduct(v1, v2);
		ThreeVector v3xv4 = ThreeVector.vectorProduct(v3, v4);
		// System.out.println("v1xv2: " + v1xv2);
		// System.out.println("v3xv4: " + v3xv4);

		double angle = 0.5 * Math.toDegrees(ThreeVector.angle(v1xv2, v3xv4));

		System.out.println("Taper Angle Of Beams In Pentagon: " + angle + "\u00b0");

		return angle;
	}

	public static double taperAngleOfIsoEquil() {
		double b = base;
		double q = (b*Math.sin(Math.toRadians(54))/2)+b*Math.sin(Math.toRadians(6));
		double phi = Math.acos(b*Math.sin(Math.toRadians(54))/(2*q));
		double gamma = Math.acos(b*b*Math.cos(phi)*Math.sin(Math.toRadians(60))
				/Math.sin(Math.toRadians(72)));
		double c = hypotenuse;
		double d = insideFiveLengthFlatPentagon();
		
		ThreeVector A = new ThreeVector(0,0,0);
		ThreeVector D = new ThreeVector((-b*Math.sin(Math.toRadians(36))),(b*Math.cos(Math.toRadians(36))),0);
		ThreeVector C = new ThreeVector(((Math.sin(gamma))*Math.sin(Math.toRadians(72))),
				(b*Math.sin(Math.toRadians(18))),(b * Math.sin(Math.toRadians(60))*Math.cos(phi)));
		ThreeVector B = new ThreeVector((-c*Math.sin(gamma-phi)),(-0.5*b),Math.sqrt((c*c)-(d*d)));
		
		ThreeVector v1 = ThreeVector.subtract(B, A);
		ThreeVector v2 = ThreeVector.subtract(C, A);
		ThreeVector v3 = ThreeVector.subtract(D, A);
		
		ThreeVector v1xv2 = ThreeVector.vectorProduct(v1, v2);
		ThreeVector v2xv3 = ThreeVector.vectorProduct(v2, v3);
		
		double angle = 0.5 * Math.toDegrees(ThreeVector.angle(v1xv2, v2xv3));

		System.out.println("Taper Angle Between Iso and Equil: " + angle + "\u00b0");
		
		return angle;
	}

	public static double taperAngleBetweenIsoAndEquil() {

		double angle = 0;
		return angle;
	}

	public static void main(String[] args) {
		System.out.println("---------------------------------------------");
		System.out.println("----------------PROJECT DOMEY----------------");
		System.out.println("---------------------------------------------");
		System.out.println();
		anglesOfIsosceles(hypotenuse, base);
		System.out.println();
		diameter(decagonSideLength);
		System.out.println();
		taperAngleOfCentralBeamsInPentagon();
		taperAngleOfIsoEquil();
	}

}
