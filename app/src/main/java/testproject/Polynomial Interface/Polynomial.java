/*
me and Sree chityala worked together on this homework. we finished the assignment together
which is why you might see similarities in code :)
*/
import java.util.Iterator;
public class Polynomial implements PolynomialInterface
{
	private SortedListInterface<Term> myTerms;  // Terms of polynomial in ascending
												// order by exponents of x
	private int myDegree; // Polynomial's degree (highest exponent among terms)

	public Polynomial() {
		//CODE TO BE COMPLETED IN LAB
		myDegree = 0;
		myTerms = new LinkedSortedList<>();
	}  // end default constructor

	public int getDegree() 	{
		//CODE TO BE COMPLETED IN LAB
		return myDegree;
	}  // end getDegree

	public double getCoefficient(int power) throws IllegalArgumentException
	{
		if (power < 0) throw new IllegalArgumentException("Exponent cannot be negative");
		Iterator<Term> iterator = myTerms.getIterator();
		while (iterator.hasNext()){
			Term term = iterator.next();
			if (term.getExponent() == power){
				return term.getCoefficient();
			}
		}
		//CODE TO BE COMPLETED IN LAB
		return 0;
	}  // end getCoefficient

	public void addTerm(double newCoefficient, int power) throws IllegalArgumentException	{
		//CODE TO BE COMPLETED IN LAB
		if (power < 0) throw new IllegalArgumentException("Exponent cannot be negative");
		Term term = new Term(newCoefficient, power);
		myTerms.add(term);
		if (myDegree < power)
			myDegree = power;
		
	} // end addTerm


	public Polynomial add(Polynomial polyTwo) {
		//CODE TO BE COMPLETED FOR HOMEWORK
		//Re-do solution provided during lab to use iterators
		Polynomial sum = new Polynomial();
		Iterator<Term> iter1 = myTerms.getIterator();
		Iterator<Term> iter2 = polyTwo.myTerms.getIterator();
		int max = Math.max(this.myDegree, polyTwo.myDegree);
		for (int i = 0; i <= max; i++) {
			double a = this.getCoefficient(i);
			double b = polyTwo.getCoefficient(i);
			sum.addTerm(a + b, i);
		}
		return sum;
	}
		private Polynomial negate(){
		Polynomial temp = new Polynomial();
		Iterator<Term> iter = myTerms.getIterator();
		while(iter.hasNext()) {
				int power = (int) iter.next().getExponent();
				temp.addTerm((getCoefficient(power) * -1), power);
		}
			return temp;
		}
	public Polynomial subtract(Polynomial polyTwo)
	{

		Polynomial result = new Polynomial();
		polyTwo = polyTwo.negate();
		result = this.add(polyTwo);

		return result;

	}  // end subtract

	@Override
	public double evaluate(double value) {
		double result = 0;
		Iterator<Term> iter = myTerms.getIterator();
		while(iter.hasNext()){
			int getexponent = iter.next().getExponent()  ;
			if(getexponent > 0 ){
				result += getCoefficient(getexponent) * Math.pow(value,getexponent);
			}else{
				result = result + getCoefficient(getexponent);
			}
		}

		return result;

		//return 0;
	}

	public void clear()
	{
		myTerms.clear();  
		myDegree = 0;
	}  // end clear

	public String toString()
	{
		String polyString = "";
		int degree = getDegree();
		int listLength = myTerms.getLength();
		for (int position = 1; position <= listLength; position++)
		{
			Term nextTerm = myTerms.getEntry(position);
			if (position == 1)
				polyString += nextTerm.toString().startsWith(" +") ? nextTerm.toString().substring(3): nextTerm.toString();
			else
				polyString = polyString + nextTerm.toString();
		}  // end for

		return polyString;

	}  // end toString
}  // end Polynomial
