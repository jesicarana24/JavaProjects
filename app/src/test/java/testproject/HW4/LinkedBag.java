public final class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry)         // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode;      // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while

        return result;
    } // end toArray

    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {

        return numberOfEntries == 0;
    } // end isEmpty

    /**
     * Gets the number of entries currently in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
      return getCurrentSize2(this.firstNode) ;
    } // end getCur
    // rentSize
    //WRITE A PRIVATE RECURSIVE METHOD THAT RETURNS THE TOTAL NUMBER
    //OF NODES (size of the bag)
    private int getCurrentSize2(Node current2Node){

        if (current2Node!= null){
            return  1 + getCurrentSize2(current2Node.next);
        }else{
            return 0 ;
        }

    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        } // end if

        return result;
    } // end remove

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null) {
            nodeN.data = firstNode.data; // Replace located entry with entry in first node
                    firstNode = firstNode.next;  // Remove first node
            numberOfEntries--;
            result = true;
        } // end if

        return result;
    } // end remove

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while (!isEmpty())
            remove();
    } // end clear

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        return getfrequencyother(anEntry, firstNode);
        // end getFrequencyOf
    }

    private int getfrequencyother(T anEntry,Node currentNode ){
        //Node currentNode2 = new Node(anEntry);
        if((currentNode == null)){
            return 0;
        }
        if (anEntry.equals(currentNode.data)){
            return 1 + getfrequencyother(anEntry,currentNode.next);
        }
       else{
            return getfrequencyother(anEntry, currentNode.next);
        }
    }

    //WRITE A PRIVATE RECURSIVE METHOD THAT RETURNS TEH FREQUENCY OF
    //AN ENTRY

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while

        return found;
    } // end contains

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while

        return currentNode;
    } // end getReferenceTo

    private class Node {
        private T data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

    public String toString() {
        T[] result = toArray();
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < result.length; i++) {
            res.append(result[i]);
            if (i != result.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
//question 1 and 2
 /**  By using the definition of Big Oh, show that n2 + 17n + 1 is O(n2).
        We have to find a positive real number c and a positive integer N such that f(n) ≤ c g(n) for all n ≥ N, where
  f (n)= n^2 +17n +1 and g(n) =n2 .Choose c = 5 and N = 1. We must show that n^2 + 17 n + 1 ≤ 5n2 if n ≥ 1 or
  equivalently show that n2 + 12n + 1 ≤ 0 if n ≥ 1. But since n ≥ 1, n2 ≥ 1, which means that n2+17n+1 is O(n2)

  Slide 9 in the lecture notes shows the relative magnitudes of common growth-rate functions. Indicate where the growth-rate function n2logn belongs in that ordering.
  This is the table ordering
  1 < (log(log n) < log n < log2 n < n < n log n  < n2  <  n3  <  2n < n!
  If we were to add n2logn i would think that we would add it at
  1 < (log(log n) < log n < log2 n < n < n log n <n2logn  < n2  <  n3  <  2n < n!
*/