/**
 An interface for the ADT polynomial. Each polynomial has
 integer coefficients and non-negative exponents.

 @author Frank M. Carrano
 @version 5.0
 */
public interface PolynomialInterface
{
    /** Gets the degree of this polynomial.
     @returns  The degree of the polynomial. */
    public int getDegree();

    /** Retrieves the coefficient of a particular term in this polynomial.
     @param power  The integer exponent of the desired term.
     @returns  The coefficient of the specified term, 0 of a non-negative power is not present.
     @throws IllegalArgumentException when power is negative*/
    public double getCoefficient(int power) throws IllegalArgumentException;

    /** Add a term with a given coefficient and power
     * @param newCoefficient a double value
     * @param power  The integer exponent of the desired term.
     * @throws IllegalArgumentException when power is negative*/
    public void addTerm(double newCoefficient, int power) throws IllegalArgumentException;

    /** Adds a given polynomial to this polynomial.
     @param polyTwo  A second polynomial.
     @return  A new polynomial that is the sum; the original
     polynomials are unchanged. */
    public Polynomial add(Polynomial polyTwo);

    /** Subtracts a given polynomial from this polynomial.
     @param polyTwo  A second polynomial.
     @return  A new polynomial that is the difference; the original
     polynomials are unchanged. */
    public Polynomial subtract(Polynomial polyTwo);

    /**return evaluation of hte polynomial at the given value
     * @param value
     * @return
     */

    public double evaluate(double value);

    /** Sets this polynomial to the empty polynomial. */
    public void clear();

    /** @return a string representation of this polynomial. */
    public String toString();


}  // end PolynomialInterface
