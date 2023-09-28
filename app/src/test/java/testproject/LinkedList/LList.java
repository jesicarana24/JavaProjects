class LList<T> implements ListInterface<T> {

    private Node firstNode;  // Reference to first node of chain
    private int numberOfEntries;

    public LList() {
        initializeDataFields();
    } // end default constructor

    public void clear() 
    {
        initializeDataFields();

    } // end clear
    
    // Initialize the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else // Add to end of nonempty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add

    public void add(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1) // Case 1
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else // Case 2: List is not empty
            { // and givenPosition > 1
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        } else {
             throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    } // end add

    public T remove(int givenPosition) {
        T result = null; // Teturn value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if (givenPosition == 1) // Case 1: remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            } else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);  // Remove entry
            } // end if
            numberOfEntries--;              // Update count
            return result;
        } 
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

    } // end remove


    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return  getNodeAt(givenPosition).getData();
        } else 
             throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry
    public T replace(int givenPosition,T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    } // end replace

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) // Or getLength() == 0
        {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        } // end if
        return result;
    } // end isEmpty

    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while
        return result;
    } // end toArray

    public T[] toArray(T[] result){
        if (result.length != numberOfEntries) throw new ArrayIndexOutOfBoundsException();
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while
        return result;
    }

    // Return a reference to the node at a given position.
    // Precondition: List is not empty;
    //              1 <= givenPostion <= numberOfEntries
    private Node getNodeAt(int givenPosition) {
        assert (firstNode != null)
                && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        // Traverse the chain to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        assert currentNode != null;
        return currentNode;
    } // end getNodeAt

    private class Node {

        public Object previous;
        private T data; // entry in bag
        private Node next; // link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node

    /** Build a string representation of the list.
     *
     * @return A string showing the state of the list.
     */
    public String toString() {
        String result = "{ ";
        Node currentNode = firstNode;
        while (currentNode != null) {

            result = result + "<" + currentNode.data + "> ";
            currentNode = currentNode.next;

        }
        result = result + "}";

        return result;
    }

    /** Display the list with indices one to a line
     *  This will correctly display an infinite list,
     *  whereas the toString() method will never return.
     * 
     */
    public void display() {
        int index = 1;
        Node currentNode = firstNode;

        while (currentNode != null) {
            System.out.println(index + ":" + currentNode.getData());

            currentNode = currentNode.getNextNode();
            index++;
        }

    } // end display

    
   /** Check to see if two lists are the same.  
    * @param aList Another linked list to check this list against.
    * @return True if all the items in this list and the other list are equals.
    */
    public boolean equals(LList<T> aList) {
        boolean isEqual = false; // result of comparison of lists

        Node currOne = firstNode;
        Node currTwo = aList.firstNode;
        int counter;

        if (numberOfEntries == aList.numberOfEntries) {
            // Lists have equal lengths, so traverse both and compare items as you go:
            // (NOTE: loop is skipped if lists are empty)

            while ((currOne != null) && (currOne.getData()).equals(currTwo.getData())) {
                currOne = currOne.getNextNode();
                currTwo = currTwo.getNextNode();
            } // end while

            // If we made it to the end, the lists are equal
            isEqual = (currOne == null);
        }

        return isEqual;
    } // end equals

    
        
    /*********************************************************************
     * 
     * METHODS TO BE COMPLETED
     * 
     ***********************************************************************/
     

    /** Reverse the order of items in a list.
     */
    public void reverse() {
        Node previous = null;
        Node current = firstNode;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        firstNode = previous;

     }

    /** Cycle the first item to the end of the list.
     */
    public void cycle(){
        Node newnode = firstNode;
        firstNode = getNodeAt(2);
        numberOfEntries--;
        Node lastNode = getNodeAt(numberOfEntries);
        numberOfEntries++;
        lastNode.next = newnode;
        newnode.previous = lastNode;
        newnode.next = null;
        lastNode.setNextNode(newnode);

        // CODE TO BE COMPLETED
    }

   /** Add an array of tiems to the end of the list.  
    * @param items an array of objects.
    */

    public void addAll(T[] items){
        if(firstNode == null){
            Node firstNode2 = new Node(items[0]);
            firstNode = firstNode2;
            numberOfEntries++;
            int sizeofarray = items.length;
            for(int i = 1 ; i < sizeofarray; i ++) {
                T data = items[i];
                Node lastNode = getNodeAt(numberOfEntries);
                numberOfEntries++;
                Node newNode = new Node(data);
                lastNode.next = newNode;
                newNode.previous = lastNode;
                newNode.next = null;
                lastNode.setNextNode(newNode);
            }
        }
        else if(firstNode!= null) {
            int sizeofarray = items.length;
            for (int i = 0; i < sizeofarray; i++) {
                T data = items[i];
                Node lastNode = getNodeAt(numberOfEntries);
                numberOfEntries++;
                Node newNode = new Node(data);
                lastNode.next = newNode;
                newNode.previous = lastNode;
                newNode.next = null;
                lastNode.setNextNode(newNode);
            }
            //CODE TO BE COMPLETED
        }
     }


    public boolean contains(T anEntry)     {
        return contains(anEntry, firstNode);
    } // end contains
    
    /** Recursive method that checks whether a list contains an object.  
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    private boolean contains(T anEntry, Node startNode) {
        boolean variable = false;
        if(getLength()>0 && startNode!= null) {
            if (startNode.getData() == anEntry) {
                variable = true;
                return variable;


            } else {
                return contains(anEntry, startNode.next);

            }
        }else{
            return variable;
        }
        //CODE TO BE COMPLETED
    } // end contains

}
