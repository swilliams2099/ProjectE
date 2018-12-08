/*
 * The class BinarySearchTreeWithDups represents a binary search tree in which duplicate entries are allowed.

    A duplicate entry is placed in the entrys left subtree.
    The process is this:
        When adding an element, use the same process a normal binary search tree:
            if the current is smaller than the new element, go into the right subtree
            if the current is greater than the new element, go into the left subtree
        However, when you find an element that is the same as the new element:
            First, go into the left subtree.
            Then resume your normal binary search tree search.
    In this implementation, we will assume the getEntry method returns the first match it finds and the remove method removes the first match it finds. So the only modification required is the add method.

 * 
 */


import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// SW
	private void addEntryHelperNonRecursive(T newEntry) {
	/*
	 * if the current is smaller than the new element, go into the right subtree
            if the current is greater than the new element, go into the left subtree
        However, when you find an element that is the same as the new element:
            First, go into the left subtree.
            Then resume your normal binary search tree search.
	 */
		BinaryNodeInterface<T> currentNode = getRootNode();
		assert currentNode != null;
		boolean found = false;
		
		while(!found) {
			T currentEntry = currentNode.getData();
			int comparison = newEntry.compareTo(currentEntry);
			
			if (comparison == 0) { // if newEntry matches currentEntry
				// first go into left subtree
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
					// then resume normal binary search tree search ?
					// does this mean call addEntry()? Or no bc in while loop?
				} else {
					found = true;
					// setLeftChild? or setData?
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				}
				
			} else if (comparison < 0) { // if newEntry is smaller than currentNode
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				}
				
			} else { // if newEntry is larger than currentNode
				
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				} else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
				
			}
		}
	
	}

	// SW
	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNodeInterface<T> currentNode = getRootNode();
		
		// consider a loop!
		
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE!! YOU CAN ALSO CREATE A PRIVATE HELPER.
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNodeInterface<T> rootNode = getRootNode();
		
		// consider a helper method!
		
		return count;
	}
		
	// YOUR CODE HERE! MUST BE USE A STACK!! 
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNodeInterface<T> rootNode = getRootNode();
		Stack<BinaryNodeInterface<T>> nodeStack = new Stack<BinaryNodeInterface<T>>();
		nodeStack.push(rootNode);

		// consider a loop based on the stack!
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n).
	public int countUniqueValues() {
		return 0;
	}
	
	public int getLeftHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	


}