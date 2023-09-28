
public class Driver 
{
	public static void main(String args[])  
	{
		Polynomial myPoly = new Polynomial();
		Polynomial yourPoly = new Polynomial();

		// Create 2x^5 - 4x^3 + x - 16
		myPoly.addTerm(2, 5);
		myPoly.addTerm(-4, 3);
		myPoly.addTerm(1, 1);
		myPoly.addTerm(-16, 0);

		System.out.print("The polynomial" + myPoly);
		System.out.println(" is of degree " + myPoly.getDegree());
		assert myPoly.getDegree() ==5;
		System.out.println("Tests Passed: 1");

		System.out.print("The coefficient of its x^3 term is ");
		System.out.println(myPoly.getCoefficient(3));
		assert myPoly.getCoefficient(3) ==-4;
		System.out.println("Tests Passed: 2");

		// x^6 - x
		yourPoly.addTerm(1, 6);
		yourPoly.addTerm(-1, 0);

		System.out.print("The polynomial" + yourPoly);
		System.out.println(" is of degree " + yourPoly.getDegree());
		assert yourPoly.getDegree() == 6;
		System.out.println("Tests Passed: 3");

		System.out.print("The coefficient of its x^3 term is ");
		System.out.println(yourPoly.getCoefficient(3));
		assert yourPoly.getCoefficient(3) == 0;
		System.out.println("Tests Passed: 4");

		// Test add
		Polynomial sum = myPoly.add(yourPoly);
		System.out.println("The sum of " + myPoly);
		System.out.println("and " + yourPoly);
		System.out.println("is " + sum);
		assert sum.toString().equals(" - 17.0 + x^1 - 4.0x^3 + 2.0x^5 + x^6");
		System.out.println("Tests Passed: 5");
		System.out.println();


		sum = yourPoly.add(myPoly);
		System.out.println("The sum of" + yourPoly);
		System.out.println("and " + myPoly);
		System.out.println("is " + sum);
		assert sum.toString().equals(" - 17.0 + x^1 - 4.0x^3 + 2.0x^5 + x^6");
		System.out.println("Tests Passed: 6");
		System.out.println();

		// Create 3x^5 + 4x^4 + 4x^3 - 5x^2 + 2x + 5
		myPoly.clear();
		myPoly.addTerm(3, 5);
		myPoly.addTerm(4, 4);
		myPoly.addTerm(4, 3);
		myPoly.addTerm(-5, 2);
		myPoly.addTerm(2, 1);
		myPoly.addTerm(5, 0);
		assert myPoly.toString().equals("5.0 + 2.0x^1 - 5.0x^2 + 4.0x^3 + 4.0x^4 + 3.0x^5");
		System.out.println("Tests Passed: 7");
		System.out.println();

		// Create 3x^8+ 2x^7 + x^5 - x^4 + 4x^3 - 5x^2 + 2
		yourPoly.clear();
		yourPoly.addTerm(2, 7);
		yourPoly.addTerm(1, 5);
		yourPoly.addTerm(-1, 4);
		yourPoly.addTerm(4, 3);
		yourPoly.addTerm(-5, 2);
		yourPoly.addTerm(2, 0);
		yourPoly.addTerm(3, 8);
		assert yourPoly.toString().equals("2.0 - 5.0x^2 + 4.0x^3 - x^4 + x^5 + 2.0x^7 + 3.0x^8");
		System.out.println("Tests Passed: 8");
		System.out.println();

		sum = yourPoly.add(myPoly);
		System.out.println("The sum of " + myPoly);
		System.out.println("and " + yourPoly);
		System.out.println("is " + sum);
		assert sum.toString().equals("7.0 + 2.0x^1 - 10.0x^2 + 8.0x^3 + 3.0x^4 + 4.0x^5 + 2.0x^7 + 3.0x^8");
		System.out.println("Tests Passed: 9");
		System.out.println();

		// Test subtract
		Polynomial difference = myPoly.subtract(yourPoly);
		System.out.println("The difference of " + myPoly);
		System.out.println("and " + yourPoly);
		System.out.println("is " + difference);
		assert difference.toString().equals("3.0 + 2.0x^1 + 5.0x^4 + 2.0x^5 - 2.0x^7 - 3.0x^8");
		System.out.println("Tests Passed: 10");
		System.out.println();

 		//p0(x) = 0.0
		Polynomial p0 = new Polynomial();
		System.out.println("p0(x) = " + p0);
		assert p0.getDegree() == 0;
		assert p0.getCoefficient(0) == 0;
		assert p0.getCoefficient(5) == 0;
		assert p0.toString().equals(new Polynomial().toString());
		System.out.println("Tests Passed: 14 ");
		//p1(x) = 2.5x^3 - 5.3x + 3.0

		Polynomial p1 = new Polynomial();
		p1.addTerm(2.5,3);
		p1.addTerm(-5.3, 1);
		p1.addTerm(3.0, 0);
		System.out.println("p1(x) = " + p1);
		assert p1.toString().equals("3.0 - 5.3x^1 + 2.5x^3");
		System.out.println("p1(0) = "+ p1.evaluate(0));
		assert p1.getDegree() == 3;
		assert p1.getCoefficient(0) == 3.0;
		assert p1.getCoefficient(2) == 0.0;

		assert Math.abs(p1.evaluate(0) - 3.0) < 0.00001;
		System.out.println("Tests passed: 19");
		//p2(x) = x^4 + 2.1x^3 + 0.5x - 8.7
		//cfs = new double[]{1, 2.1, 0, 0.5, -8.7};
		Polynomial p2 = new Polynomial();
		p2.addTerm(1,4);
		p2.addTerm(2.1, 3);
		p2.addTerm(0.5, 1);
		p2.addTerm(-8.7, 0);
		System.out.println("p2(x) = " + p2);
		assert p2.getDegree() == 4;
		System.out.println("p2(1) = "+ p2.evaluate(1));
		assert p2.evaluate(1) == -5.1;
		//assert p1.compareTo(p2) == -1;
		System.out.println("-Tests passed: 21");
		//p3(x) = 7.2x^5
		Polynomial p3 = new Polynomial();
		p3.addTerm(7.2,5);
		System.out.println("p3(x) = " + p3);
		assert p3.getDegree() == 5;
		assert p3.getCoefficient(5) == 7.2;
		assert p3.evaluate(2) == 230.4;
		//assert p3.compareTo(p2) == 1;
		System.out.println("-Tests passed: 24");
		Polynomial addResult =(Polynomial) p1.add(p2);
		System.out.println("p1(x) + p2(x) = "+addResult);
		assert addResult.getDegree() == 4;
		assert Math.abs(addResult.getCoefficient(0) - -5.7) <= 0.0001;

		try{
			Polynomial p4 = new Polynomial() ;
			p4.addTerm(3.4, -3);
			System.out.println(p4.getCoefficient(-3));
			assert false; //power cannot be negative
		}
		catch (Exception e){
			//as expected
			assert true;
		}


		System.out.println("Tests passed: 27");
		Polynomial subtractResult = (Polynomial) p2.subtract(p1);
		System.out.println("p2(x) - p1(x) = " +p2.subtract(p1));
		assert subtractResult.getDegree() == 4;
		assert Math.abs(subtractResult.getCoefficient(1) - 5.8) <= 0.0001;
		assert Math.abs(subtractResult.getCoefficient(3) - -0.4) <= 0.0001;
		System.out.println("Tests passed: 30");
		Polynomial p4 = new Polynomial();
		p1.addTerm(1,0);
		p1.addTerm(2,2);
	/*	Polynomial multResult = (Polynomial) p1.multiply(p4);
		System.out.println("p1(x) * p4(x) = " +multResult);
		assert multResult.getDegree() == 6;
		assert Math.abs(multResult.getCoefficient(2) - -10.6) <= 0.0001;
		assert Math.abs(multResult.getCoefficient(0) ) <= 0.0001;
		assert Math.abs(multResult.getCoefficient(6) - 2.5) <= 0.0001;
		assert Math.abs(p1.evaluate(2) * p4.evaluate(2) - multResult.evaluate(2))
				<= 0.0001;
		assert p1.equals(new Polynomial(new double[]{2.5, 0, -5.3, 3.0}));
		System.out.println("Tests passed: 29");*/


		System.out.println("Done.");
	}  // end main
}  // end Driver

/*
 The polynomial - 16 + x^1 - 4x^3 + 2x^5 is of degree 5
 The coefficient of its x^3 term is -4
 
 The polynomial - 1 + x^6 is of degree 6
 The coefficient of its x^3 term is 0
 
 The sum of - 16 + x^1 - 4x^3 + 2x^5
 and - 1 + x^6
 is - 17 + x^1 - 4x^3 + 2x^5 + x^6
 
 The sum of - 1 + x^6
 and - 16 + x^1 - 4x^3 + 2x^5
 is - 17 + x^1 - 4x^3 + 2x^5 + x^6
 
 The sum of + 5 + 2x^1 - 5x^2 + 4x^3 + 4x^4 + 3x^5
 and + 2 - 5x^2 + 4x^3 - x^4 + x^5 + 2x^7
 is  + 7 + 2x^1 - 10x^2 + 8x^3 + 3x^4 + 4x^5 + 2x^7
 
 The difference of + 5 + 2x^1 - 5x^2 + 4x^3 + 4x^4 + 3x^5
 and + 2 - 5x^2 + 4x^3 - x^4 + x^5 + 2x^7
 is  + 3 + 2x^1 + 5x^4 + 2x^5 - 2x^7
 
 Done.

 */
