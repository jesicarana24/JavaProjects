import java.util.Arrays;
public class Homework4 {
    public static void main(String[] args) {
        LinkedBag<Integer> myBag = new LinkedBag<>();
        LinkedBag<Integer> yourBag = new LinkedBag<>();
        int[] tests1 = {35, 23, 45, -30, 23};
        for (int i = 0; i < tests1.length; i++) {
            myBag.add(tests1[i]);
        }
        int[] tests2 = {32, 23};
        for (int i = 0; i < tests2.length; i++) {
            yourBag.add(tests2[i]);
        }
//test add(entry)
        System.out.println("My bag: " + myBag);
        System.out.println("Your bag: " + yourBag);
        assert myBag.toString().equals("[23, -30, 45, 23, 35]");
//test recursive getFrequencyOf(entry)
        System.out.println("Frequency of 23 in my bag: "+myBag.getFrequencyOf(23));
        assert myBag.getFrequencyOf(23) == 2;
        System.out.println("Frequency of 23 in your bag: "+yourBag.getFrequencyOf(23));
        assert yourBag.getFrequencyOf(23) == 1;
        System.out.println("Frequency of 45 in my bag: "+myBag.getFrequencyOf(45));
        assert myBag.getFrequencyOf(45) == 1;
        System.out.println("Frequency of 45 in your bag: "+yourBag.getFrequencyOf(45));
        assert yourBag.getFrequencyOf(45) == 0;
//test recursive getCurrentSize(entry)
        System.out.println("Size of my bag: " + myBag.getCurrentSize());
        assert myBag.getCurrentSize() == 5;
        System.out.println("removing a number from the bag");
        Integer item = myBag.remove();
        System.out.println("My bag: " + myBag);
        System.out.println("Size of my bag: " + myBag.getCurrentSize());
        assert myBag.getCurrentSize() == 4;
        System.out.println("Clearing your bag... " );
        yourBag.clear();
        System.out.println("Your bag: " + yourBag);
        System.out.println("Size of your bag: " + yourBag.getCurrentSize());
        assert yourBag.getCurrentSize() == 0;
    } // end main
}
