/**
   A class of polynomial terms.
   
   @author Frank M. Carrano
   @author Joseph Erickson
   @version 5.0
 */
public class Term implements Comparable<Term>
{
	private double coefficient;
	private int exponent;

	/** A constructor for initializing a Term with
		a given coefficient and exponent value.
		@param coefficientValue  The initial coefficient of the term.
		@param exponentOfX       The initial exponent of the term. */
	public Term(double coefficientValue, int exponentOfX)
	{
		coefficient = coefficientValue;
		exponent = exponentOfX;
	} // end constructor

	/** Sets the coefficient of the term to the given value.
		@param coefficientValue  The new coefficient of the term. */
	public void setCoefficient(double coefficientValue)
	{
		coefficient = coefficientValue;
	} // end setCoefficient

	/** Sets the exponent of the term to the given value.
		@param exponentOfX  The new exponent of the term. */
	public void setExponent(int exponentOfX)
	{
		exponent = exponentOfX;
	} // end setExponent

	/** Gets the coefficient of the term.
		@return  The term's coefficient. */
	public double getCoefficient()
	{
		return coefficient;
	} // end getCoefficient

	/** Gets the exponent of the term.
		@return  The term's exponent. */
	public int getExponent()
	{
		return exponent;
	} // end getExponent

	public int compareTo(Term other)
	{
		int result;

		if (this.exponent == other.exponent)
			result = 0;
		else if (this.exponent < other.exponent)
			result = -1;
		else
			result = 1;

		return result;
	} // end compareTo

	public String toString()
	{
		String result = "";

		if ((coefficient > 1) && (exponent != 0))
			result = result + " + " + coefficient + "x^" + exponent;
		else if ((coefficient > 1) && (exponent == 0))
			result = result + " + " + coefficient;
		else if ((coefficient == 1) && (exponent != 0))
			result = result + " + " + "x^" + exponent;
		else if ((coefficient == 1) && (exponent == 0))
			result = result + " + " + coefficient;

		else if ((coefficient < -1) && (exponent != 0))
			result = result + " - " + Math.abs(coefficient) + "x^" + exponent;
		else if ((coefficient < -1) && (exponent == 0))
			result = result + " - " + Math.abs(coefficient);
		else if ((coefficient == -1) && (exponent != 0))
			result = result + " - " + "x^" + exponent;
		else if ((coefficient == -1) && (exponent == 0))
			result = result + " - " + Math.abs(coefficient);

		return result;
	} // end toString
} // end Term
