package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0) {
			return 0.0;
		} else {
			return 1.0 / Math.pow(2, n) + geometricSum(n - 1);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
	        double radiusMinimumDrawingThreshold) {
	    double bound = 5.0;
	    StdDraw.setXscale(-bound, bound);
	    StdDraw.setYscale(-bound, bound);
	    StdDraw.setPenColor(0, 0, 0);
	    StdDraw.circle(xCenter, yCenter, radius);
	    if (radius > radiusMinimumDrawingThreshold) {
	        double newRadius = radius / 2;
	        circlesUponCircles(xCenter, yCenter + radius, newRadius, radiusMinimumDrawingThreshold);
	        circlesUponCircles(xCenter, yCenter - radius, newRadius, radiusMinimumDrawingThreshold);
	        circlesUponCircles(xCenter - radius, yCenter, newRadius, radiusMinimumDrawingThreshold);
	        circlesUponCircles(xCenter + radius, yCenter, newRadius, radiusMinimumDrawingThreshold);
	    } else {
	        return;
	    }
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but in reverse order
	 */
	public static int[] toReversed(int[] array) {
	    int[] reverseArray = new int[array.length]; // Create a new array for the reversed result
	    
	    // Start the recursive process
	    reverseHelper(array, reverseArray, 0);
	    
	    return reverseArray;
	}

	/**
	 * Helper method to reverse the array recursively
	 * 
	 * @param array        the original array
	 * @param reverseArray the array that will contain the reversed elements
	 * @param index        the current index being processed
	 */
	private static void reverseHelper(int[] array, int[] reverseArray, int index) {
	    // Base case: when index reaches the length of the array, stop recursion
	    if (index == array.length) {
	        return;
	    }
	    
	    // Copy the element from the original array to the reversed array in reverse order
	    reverseArray[array.length - 1 - index] = array[index];
	    
	    // Recursively process the next element
	    reverseHelper(array, reverseArray, index + 1);
	}

	public class GCD {

	    /**
	     * This method uses recursion to compute the greatest common divisor for the two
	     * input values
	     * 
	     * @param p first operand
	     * @param q second operand
	     * @return greatest common divisor of p and q
	     */
	    public static int gcd(int p, int q) {
	        // Base case: if q divides p evenly, return q
	        if (q == 0) {
	            return p;
	        }

	        // Recursive case: compute gcd(q, p % q)
	        return gcd(q, p % q);
	    }

	    /**
	     * This method uses iteration to compute the greatest common divisor for the two
	     * input values
	     * 
	     * @param p first operand
	     * @param q second operand
	     * @return greatest common divisor of p and q
	     */
	    public static int gcdIterative(int p, int q) {
	        // Continue until q becomes 0
	        while (q != 0) {
	            int temp = q;
	            q = p % q;
	            p = temp;
	        }

	        return p; // Once q is 0, p is the gcd
	    }

	    public static void main(String[] args) {
	        // Test the recursive version
	        System.out.println("Recursive GCD of 48 and 14: " + gcd(48, 14)); // Should print 2
	        System.out.println("Recursive GCD of 27 and 36: " + gcd(27, 36)); // Should print 9

	        // Test the iterative version
	        System.out.println("Iterative GCD of 48 and 14: " + gcdIterative(48, 14)); // Should print 2
	        System.out.println("Iterative GCD of 27 and 36: " + gcdIterative(27, 36)); // Should print 9
	    }
	}

}
