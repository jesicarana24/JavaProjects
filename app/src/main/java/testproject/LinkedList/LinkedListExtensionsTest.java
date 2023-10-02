import java.util.Arrays;

/**
 * This class performs tests on the extensions to the LList class.
 * 
 */
public class LinkedListExtensionsTest
{
    private static LList<String> testList1 = new LList<String>();
    private static LList<String> testList2 = new LList<String>();
    private static LList<String> testList3 = new LList<String>();
    private static LList<String> testList4 = new LList<String>();
    private static LList<String> testList5 = new LList<String>();
    private static LList<String> testList6 = new LList<String>();
    private static LList<String> testList7 = new LList<String>();
    private static LList<String> testList8 = new LList<String>();
    private static LList<String> testList9 = new LList<String>();
    private static LList<String> testList10 = new LList<String>();
    private static LList<String> testList11 = new LList<String>();
    private static LList<String> testList12 = new LList<String>();
    private static LList<String> testList13 = new LList<String>();
    private static LList<String> testList14 = new LList<String>();
    private static LList<String> testList15 = new LList<String>();
    private static LList<String> testList16 = new LList<String>();
    private static LList<String> testList17 = new LList<String>();
    private static LList<String> testList18 = new LList<String>();
    private static LList<String> testList19 = new LList<String>();
    private static LList<String> testList20 = new LList<String>();


    public static void main(String args[])
    {
        
        checkReverse();
        checkCycle();
        checkAddAll();
        checkContains();
    }
        
    public static void initializeLists()
    {
        testList1.clear();
        testList1.add("Jack");
        testList1.add("Jill");
        testList1.add("John");

        testList2.clear();
        testList2.add("Jack");
        testList2.add("Jill");
        testList2.add("John");

        testList3.clear();
        testList3.add("Jill");
        testList3.add("John");
        testList3.add("Jack");
        
        testList4.clear();
        testList4.add("Jack");
        testList4.add("Jill");
        
        testList5.clear();
        testList5.add("Jack");
        testList5.add("John");
        testList5.add("Jill");
        
        testList6.clear();
        testList6.add("John");
        testList6.add("Jack");
        testList6.add("Jill");
        
        testList7.clear();
        testList7.add("A");
        testList7.add("B");
        testList7.add("C");
        testList7.add("D");
        testList7.add("E");
        testList7.add("F");
        
        testList8.clear();
        testList8.add("F");
        testList8.add("E");
        testList8.add("D");
        testList8.add("C");
        testList8.add("B");
        testList8.add("A");

        testList9.clear();
        testList9.add("A");
        testList9.add("B");
        testList9.add("C");
        testList9.add("D");
        testList9.add("E");
        testList9.add("F");
        testList9.add("G");
 
        testList10.clear();
        testList10.add("G");
        testList10.add("F");
        testList10.add("E");
        testList10.add("D");
        testList10.add("C");
        testList10.add("B");
        testList10.add("A");
        
        testList11.clear();
        testList11.add("Jill");
        testList11.add("John");
        testList11.add("Jack");
        testList11.add("Jerry");
        
        testList12.clear();
        testList12.add("Jill");
        testList12.add("Jack");
        testList12.add("John");
        testList12.add("Jerry");

        testList13.clear();
        testList13.add("Jill");
        testList13.add("Jack");
        testList13.add("Jerry");
        testList13.add("John");

        testList14.clear();
        testList15.clear();

        testList16.clear();
        testList16.add("Jill");
        testList17.clear();
        testList17.add("Jill");

        testList18.clear();
        testList18.add("A");
        testList18.add("B");
        testList18.add("C");
        testList18.add("D");

        testList19.clear();
        testList19.add("E");
        testList19.add("F");
        testList19.add("G");
        
        System.out.println();
    }

    public static void checkReverse()
    {
        initializeLists();
        
        System.out.println("TESTING REVERSE");
        
        System.out.println("List 1 is ");
        testList1.display();
        System.out.println("Reversing list one");
        testList1.reverse();
        System.out.println("List 1 is now");
        testList1.display();
        
        System.out.println("Reversing list one a second time");       
        testList1.reverse();
        if(testList1.equals(testList2))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        

        System.out.println("Reversing a list twice");
        testList1.reverse();
        testList1.reverse();
        if(testList1.equals(testList2))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        
        System.out.println("Reversing list 7 of even length");
        testList7.reverse();
        if(testList7.equals(testList8))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList7.display();
        }
        System.out.println();


        System.out.println("Reversing list 9 of odd length");
        testList9.reverse();
        if(testList9.equals(testList10))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList10.display();
        }
        System.out.println();


        System.out.println("Reversing a list of length 0");
        testList14.reverse();
        if(testList15.equals(testList14))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList14.display();
        }
        System.out.println(); 
        
        
        System.out.println("Reversing a list of length 1");
        testList16.reverse();
        if(testList17.equals(testList16))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList16.display();
        }
        System.out.println();
    }


    public static void checkCycle()
    {
        int counter = 0 ;

        initializeLists();
        
        System.out.println("TESTING CYCLE");

        System.out.println("Cycling list 1 once");
        testList1.cycle();

        if(testList1.equals(testList3))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        
        System.out.println("Cycling list 3 three times");
        testList3.cycle();
        testList3.cycle();
        testList3.cycle();
        if(testList1.equals(testList3))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList3.display();
        }
        System.out.println();
        
        
        System.out.println("Cycle a list of length 0");
        testList14.reverse();
        if(testList15.equals(testList14))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on cycle)");
            testList14.display();
        }
        System.out.println(); 
        
        
        System.out.println("Cylce a list of length 1");
        testList16.reverse();
        if(testList17.equals(testList16))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on cycle)");
            testList16.display();
        }
        System.out.println();
    }

    public static void checkAddAll() {

        initializeLists();

        System.out.println("TESTING ADDALL");

        String[] items = {"E", "F"};
        System.out.println("Adding " + Arrays.toString(items) + " to list 18 ");
        testList18.addAll(items);

        if (testList18.equals(testList7))
            System.out.println("    Passed test");
        else {
            System.out.println("*** Failed test (bad list result)");
            testList18.display();
        }



        System.out.println("Removing last 2 items of list 18 and adding them at the beginning of list 20 ");
        testList20.add(1,testList18.remove(testList18.getLength()));
        testList20.add(1,testList18.remove( testList18.getLength()));
        System.out.println("Adding 'G' to the end of list 20");
        testList20.add("G");

        if (testList20.equals(testList19))
            System.out.println("    Passed test");
        else {
            System.out.println("*** Failed test (bad list result)");
            testList20.display();
        }

        items = testList19.toArray(new String[testList19.getLength()]);
        System.out.println("Adding " + Arrays.toString(items) + " to list 18 ");
        testList18.addAll(items);


        if (testList18.equals(testList9))
            System.out.println("    Passed test");
        else {
            System.out.println("*** Failed test (bad list result)");
            testList18.display();
        }

        System.out.println("Clearing list 20");
        testList20.clear();
        if (testList20.getLength() == 0) {
            System.out.println("    Passed test");
        }
        else {
            System.out.println("*** Failed test (bad list result)");
            testList20.display();
        }
        System.out.println("Adding content of list 1 to list 20");
        items = testList1.toArray(new String[testList1.getLength()]);
        testList20.addAll(items);

        if (testList20.equals(testList1))
            System.out.println("    Passed test");
        else {
            System.out.println("*** Failed test (bad list result)");
            testList20.display();
        }
        System.out.println();
    }
    public static void checkContains() {

        initializeLists();

        System.out.println("TESTING CONTAINS");

        System.out.println("List 1 is ");
        testList1.display();
        System.out.println("Checking if list 1 contains 'Jack'");
        boolean flag = testList1.contains("Jack");
        if(flag)
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();


        System.out.println("List 4 is ");
        testList4.display();
        System.out.println("Checking if list 4 contains 'Jack'");
        flag = testList4.contains("Jack");
        if(flag)
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList4.display();
        }
        System.out.println();

        System.out.println("Clearing list 4");
        testList4.clear();
        System.out.println("Checking if list 4 contains 'Jack'");
        flag = testList4.contains("Jack");
        if(!flag)
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList4.display();
        }
        System.out.println();

        System.out.println("Adding 'Jill' to list 4");
        testList4.add("Jill");
        System.out.println("Checking if list 4 contains 'Jack'");
        flag = testList4.contains("Jack");
        if(!flag)
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList4.display();
        }

        System.out.println();
        System.out.println("Adding 'Jack' twice to list 4" );
        testList4.add("Jack");
        testList4.add("Jack");
        

        System.out.println("Checking if list 4 contains 'Jack'");
        flag = testList4.contains("Jack");
        if(flag)
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList4.display();
        }

    }



}
