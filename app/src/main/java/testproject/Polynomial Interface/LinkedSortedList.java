
import java.util.Iterator;

public class LinkedSortedList<T extends Comparable<? super T>> implements SortedListInterface<T>, Iterable<T>
{
   private @Initialized @NonNull Node firstNode;       // Reference to first node of chain
   private int numberOfEntries;
   
   public LinkedSortedList()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end default constructor
   
   public void add(T newEntry)
   {
      Node newNode = new Node(newEntry);
      Node nodeBefore = getNodeBefore(newEntry);
      
      if (isEmpty() || (nodeBefore == null))
      {
         // Add at beginning
         newNode.setNextNode(firstNode);
         firstNode = newNode;
      }
      else
      {
         // Add after nodeBefore
         Node nodeAfter = nodeBefore.getNextNode();
         newNode.setNextNode(nodeAfter);
         nodeBefore.setNextNode(newNode);
      } // end if
      
      numberOfEntries++;
   } // end add

   public boolean remove(T anEntry)
   {
      boolean found = false;
      
      if (numberOfEntries > 0)
      {
         Node nodeToRemove;
         Node nodeBefore = getNodeBefore(anEntry);
         
         if (nodeBefore == null)
            nodeToRemove = firstNode;
         else
            nodeToRemove = nodeBefore.getNextNode();
         
         if ((nodeToRemove != null) && anEntry.equals(nodeToRemove.getData()) )
         {
            found = true;
            
            if (nodeBefore == null)
               firstNode = nodeToRemove.getNextNode();
            else
            {
               Node nodeAfter = nodeToRemove.getNextNode();
               nodeBefore.setNextNode(nodeAfter);
            } // end if
            
            numberOfEntries--;
         } // end if
      } // end if
      
      return found;
   } // end remove

   public int getPosition(T anEntry)
   {
      int position = 1;
      Node currentNode = firstNode;

      while ( (currentNode != null) && ( anEntry.compareTo(currentNode.getData()) > 0) )
      {
         currentNode = currentNode.getNextNode();
         position++;
      } // end while

      if ( (currentNode == null) || anEntry.compareTo(currentNode.getData()) != 0)
         position = -position;

      return position;
   } // end getPosition

   // List operations
   public T getEntry(int givenPosition)
   {
      @Nullable T result = null;                          // Result to return
      
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         result = getNodeAt(givenPosition).getData();
      } // end if
      
      return result;
   } // end getEntry
   
   public T remove(int givenPosition)
   {
      @Nullable T result = null;                           // Return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()

         if (givenPosition == 1)                 // Case 1: remove first entry
         {
            result = firstNode.getData();        // Save entry to be removed
            firstNode = firstNode.getNextNode();
         }
         else                                    // Case 2: givenPosition > 1
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);   // Disconnect the node to be removed
            result = nodeToRemove.getData();     // Save entry to be removed
         } // end if

         numberOfEntries--;
      } // end if

      return result;                             // Return removed entry, or
                                                 // null if operation fails
   } // end remove

   public final void clear() 
   {
      @Initialized @NonNull firstNode = null;
      numberOfEntries = 0;
   } // end clear

   public boolean contains(T anEntry)
   {
		return getPosition(anEntry) > 0;
   } // end contains

   public int getLength()
   {
      return numberOfEntries;
   } // end getLength

   public boolean isEmpty()
   {
      boolean result;
         
      if (numberOfEntries == 0) // Or getLength() == 0
      {
         // Assertion: firstNode == null
         result = true;
      }
      else
      {
         // Assertion: firstNode != null
         result = false;
      } // end if
         
      return result;
   } // end isEmpty

   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Comparable[numberOfEntries]; // Warning: unchecked cast

	  int index = 0;
     Node currentNode = firstNode;
	  while ((index < numberOfEntries) && (currentNode != null))
	  { 
	     result[index] = currentNode.getData();
	     currentNode = currentNode.getNextNode();
        index++; 
	  } // end while
     
     return result;
   } // end toArray

   @Override
   public Iterator<T> getIterator() {
      return iterator();
   }

   // Finds the node that is before the node that should or does
   // contain a given entry.
   // Returns either a reference to the node that is before the node
   // that contains--or should contain--anEntry, or null if no prior node exists
   // (that is, if anEntry is or belongs at the beginning of the list).
   private Node getNodeBefore(T anEntry)
   {
      Node currentNode = firstNode;
      @Initialized @NonNull Node nodeBefore = null;
      
      while ( (currentNode != null) &&
             (anEntry.compareTo(currentNode.getData()) > 0) )
      {
         nodeBefore = currentNode;
         currentNode = currentNode.getNextNode();
      } // end while
      
      return nodeBefore;
   } // end getNodeBefore
   
   private Node getNodeAt(int givenPosition)
   {
      // Assertion: !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries)
      Node currentNode = firstNode;

      // Traverse the list to locate the desired node
      for (int counter = 1; counter < givenPosition; counter++)
         currentNode = currentNode.getNextNode();

      // Assertion: currentNode != null
      return currentNode;
   } // end getNodeAt

   @Override
   public Iterator<T> iterator() {
      return new SortedListIterator<>();
   }

   private class SortedListIterator<T>  implements Iterator<T> {
      private Node iterNode;

      //initializes iterNode to beginning of the list
      public SortedListIterator() {
         iterNode = firstNode;

         //COMPLETE THIS FOR HOMEWORK
      }

      @Override
      //return true if there are nodes in the list
      public boolean hasNext() {
         if (iterNode != null) {
            return true;
         } else {
            return false;
         }
      }


      @Override
      //return the data of the node that iterNode refers to
      //move the node forward
      public T next() {
         int zero = 0 ;
         if (iterNode != null) {
            T getdata = (T) iterNode.data;
            iterNode = iterNode.getNextNode();
            //COMPLETE THIS FOR HOMEWORK
            return getdata; //getNodeBefore(iterNode);
         } else {
            return null;
         }
      }
   }
   private class Node
   {
      private T     data;  // Entry in list
      private Node   next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
   } // end Node
} // end LinkedSortedList
