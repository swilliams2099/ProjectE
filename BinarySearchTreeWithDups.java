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

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {

	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or
		// delete it!
		int count = 0;
		BinaryNodeInterface<T> currentNode = getRootNode();

		// consider a loop!

		return count;
	}


	public int countGreaterRecursive(T target) {
		int count = 0;
		BinaryNodeInterface<T> rootNode = getRootNode();
		if (rootNode.getData().compareTo(target) > 0) {
			count = 1 + countGreaterRecursiveHelper(target, rootNode);
		} else {
			count = countGreaterRecursiveHelper(target, rootNode);
		}

		return count;
	}

	private int countGreaterRecursiveHelper(T target, BinaryNodeInterface<T> newRoot) {
		int helperCount = 0;
		if (!newRoot.hasLeftChild() && !newRoot.hasRightChild()) { // base case for recursion
			if (newRoot.getData().compareTo(target) > 0) {
				helperCount++;
			}
		}

		if (newRoot.hasLeftChild()) {
			if (newRoot.getLeftChild().getData().compareTo(target) > 0) { // recursive call on left child if it exists
				helperCount = 1 + countGreaterRecursiveHelper(target, newRoot.getLeftChild());
			} else {
				helperCount = countGreaterRecursiveHelper(target, newRoot.getLeftChild());
			}
		}

		if (newRoot.hasRightChild()) {
			if (newRoot.getLeftChild().getData().compareTo(target) > 0) { // recursive call on right child if it exists
				helperCount = 1 + countGreaterRecursiveHelper(target, newRoot.getRightChild());
			} else {
				helperCount = countGreaterRecursiveHelper(target, newRoot.getRightChild());
			}
		}

		return helperCount;
	}


	public int countGreaterWithStack(T target) {
		int count = 0;
		BinaryNodeInterface<T> rootNode = this.getRootNode();
		Stack<BinaryNodeInterface<T>> nodeStack = new Stack<BinaryNodeInterface<T>>();
		nodeStack.push(rootNode);

		while (!nodeStack.isEmpty()) {
			BinaryNodeInterface<T> currentNode = nodeStack.pop();

			if (currentNode.getData().compareTo(target) > 0) {
				count++;

			}

			if (currentNode.getLeftChild() != null) {
				nodeStack.push(currentNode.getLeftChild());
			}

			if (currentNode.getRightChild() != null) {
				nodeStack.push(currentNode.getRightChild());

			}
		}
		
		return count;
	}

	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n).
	public int countUniqueValues() {
		return 0;
	}

	public int getLeftHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if (rootNode == null) {
			return 0;
		} else if (!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if (rootNode == null) {
			return 0;
		} else if (!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}

}