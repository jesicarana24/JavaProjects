import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


public final class LinkedBag<T> {
    private @Nullable Node firstNode; // Reference to the first node
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) 
    {
        // Add to the beginning of the chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make the new node reference the rest of the chain
        firstNode = newNode;      // New node is at the beginning of the chain
        numberOfEntries++;

        return true;
    } 

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
        }

        return result;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Gets the number of entries currently in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return getCurrentSizeRecursive(firstNode);
    }

    private int getCurrentSizeRecursive(@Nullable Node currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            return 1 + getCurrentSizeRecursive(currentNode.next);
        }
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry if the removal was successful or null.
     */
    public @Nullable T remove() {
        @Nullable T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove the first node from the chain
            numberOfEntries--;
        }

        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(@NonNull T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null && firstNode != null) {
            nodeN.data = firstNode.data; // Replace located entry with entry in the first node
            firstNode = firstNode.next; // Remove the first node
            numberOfEntries--;
            result = true;
        }

        return result;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        return getFrequencyOther(anEntry, firstNode);
    }

    private int getFrequencyOther(T anEntry, @Nullable Node currentNode) {
        if (currentNode == null) {
            return 0; // The list is empty, so the entry is not found
        }

        if (anEntry == null) {
            // Do something when anEntry is null
        } else {
            // Check if anEntry is not null before calling equals
            if (anEntry.equals(currentNode.data)) {
                return 1 + getFrequencyOther(anEntry, currentNode.next);
            }
        }
        // Goes to the next node
        return getFrequencyOther(anEntry, currentNode.next);
    }

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
            if (anEntry != null && anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
    
        return found;
    }

    /**
     * Locates a given entry within this bag.
     * Returns a reference to the node containing the entry if located,
     * or null otherwise.
     *
     * @param anEntry The entry to locate.
     * @return The node containing the entry or null if not found.
     */
    private @Nullable Node getReferenceTo(@NonNull T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
    
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
    
        return currentNode;
    }

    private class Node {
        private T data; // Entry in the bag
        private @Nullable Node next; // Link to the next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, @Nullable Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

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
