package geodesicDome;

public class ThreeVector {
		

	 	//Every ThreeVector has its own pr_x, pr_y, pr_z
	    private double pr_x, pr_y, pr_z;
	
	    //Empty constructor
	    public ThreeVector() {}
		
	    //ThreeVector constructor and set the variables to the private
	    //variables to be used by the class.
		public ThreeVector(double pu_x, double pu_y, double pu_z) {
			pr_x = pu_x;
			pr_y = pu_y;
			pr_z = pu_z;
		}
		
		//Magnitude of the vector
		public double magnitude() {
			return Math.sqrt(pr_x * pr_x + pr_y * pr_y + pr_z * pr_z);
		}
		
		//Create unit vectors, using the magnitude defined for the
		//variables entered at that instance
		public ThreeVector unitVector () {
			double uV_x = pr_x/this.magnitude();
			double uV_y = pr_y/this.magnitude();
			double uV_z = pr_z/this.magnitude();
			
			return new ThreeVector(uV_x, uV_y, uV_z);
		}
		
		//Creates a string 
		public String toString () {
			return "("+pr_x+","+pr_y+","+pr_z+")";
		}
		
		//Create a static method that returns the scalar product
		//between two vectors.
		public static double scalarProduct (ThreeVector vecA, 
				ThreeVector vecB) {
			return (vecA.pr_x*vecB.pr_x + vecA.pr_y*vecB.pr_y + 
					vecA.pr_z*vecB.pr_z);
		}
		
		//Create a static method that returns a ThreeVector of the
		//vector product between two vectors.
		public static ThreeVector vectorProduct (ThreeVector vecA, 
				ThreeVector vecB) {
			double vP_x = (vecA.pr_x * vecB.pr_y) - 
					(vecA.pr_y * vecB.pr_x);
			double vP_y = (vecA.pr_y * vecB.pr_z) - 
					(vecA.pr_z * vecB.pr_y);
			double vP_z = (vecA.pr_z * vecB.pr_x) - 
					(vecA.pr_x * vecB.pr_z);						
			return new ThreeVector (vP_x, vP_y, vP_z);
		}
		
		//Static method to add two vectors and return a ThreeVector
		public static ThreeVector add (ThreeVector vecA, 
				ThreeVector vecB) {
			return new ThreeVector (vecA.pr_x+vecB.pr_x,
					vecA.pr_y+vecB.pr_y , vecA.pr_z+vecB.pr_z);
		}
		//Static method to return the angle between two vectors as a 
		//double.
		public static double angle(ThreeVector vecA, ThreeVector vecB) {
			double sP = ThreeVector.scalarProduct(vecA,vecB);
			double magA = vecA.magnitude();
			double magB = vecA.magnitude();
			return Math.acos(sP/(magA*magB));
		}
		//Create a static method that returns the scalar product
		//between two vectors.
		public double scalarProduct(ThreeVector vec) {
			return scalarProduct(this, vec);
		}
		
		//Create a non-static method that returns a ThreeVector of the
		//vector product between two vectors.
		public ThreeVector add(ThreeVector vec) {
			return add(this, vec);
		}
		
		//Non-static method to add two vectors and return a ThreeVector
		public ThreeVector vectorProduct(ThreeVector vec) {
			return vectorProduct(this, vec);
		}
		
		//Non-static method to return the angle between two vectors as 
		//a double.
		public double angle(ThreeVector vec) {
			return angle(this, vec);
		}
		
		
}