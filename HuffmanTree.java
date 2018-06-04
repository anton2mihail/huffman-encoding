import java.util.Iterator;

/**
 * The Class HuffmanTree.
 * 
 * @author Toni Lachmaniucu Date: April 2 2018
 * @param <T>
 *            the generic type
 */
public class HuffmanTree<T> extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree> {

	/**
	 * Instantiates a new empty huffman tree.
	 */
	public HuffmanTree() {
		super();
	}

	/**
	 * Instantiates a new huffman tree with a root node.
	 *
	 * @param element
	 *            the root node
	 */
	public HuffmanTree(HuffmanPair element) {
		super(element);

	}

	/**
	 * Instantiates a new huffman tree.
	 *
	 * @param element
	 *            the element the root node
	 * @param leftSubtree
	 *            the left subtree to connect
	 * @param rightSubtree
	 *            the right subtree to connect
	 */
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
		super(element);
		BinaryTreeNode<HuffmanPair> rt = super.getRoot();
		rt.setLeft(leftSubtree.getRoot());
		rt.setRight(rightSubtree.getRoot());
	}

	/**
	 * Instantiates a new huffman tree from an ordered list of huffman pairs.
	 *
	 * @param pairsList
	 *            the list of huffman pairs
	 */
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {
		super();
		ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
		for (HuffmanPair pair : pairsList) {
			HuffmanTree treeTemp = new HuffmanTree(pair);
			buildList.add(treeTemp);
		}
		while (buildList.size() > 1) {
			HuffmanTree left = (HuffmanTree) buildList.removeFirst();
			BinaryTreeNode<HuffmanPair> leftRoot = left.getRoot();
			HuffmanPair leftPair = leftRoot.getElement();
			HuffmanTree right = (HuffmanTree) buildList.removeFirst();
			BinaryTreeNode<HuffmanPair> rightRoot = right.getRoot();
			HuffmanPair rightPair = rightRoot.getElement();

			HuffmanPair newPair = new HuffmanPair('*', (leftPair.getFrequency() + rightPair.getFrequency()));
			HuffmanTree newTree = new HuffmanTree(newPair, left, right);
			buildList.add(newTree);
		}
		super.setRoot(buildList.first().getRoot());
		return;
	}

	/*
	 * Compares self and a given other huffman tree based on the frequency of the
	 * root element
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(HuffmanTree otherTree) {
		// TODO Auto-generated method stub
		if (this.getRoot().getElement().getFrequency() > ((HuffmanPair) otherTree.getRoot().getElement())
				.getFrequency()) {
			return 1;
		} else if (this.getRoot().getElement().getFrequency() < ((HuffmanPair) otherTree.getRoot().getElement())
				.getFrequency()) {
			return -1;
		}
		return 0;

	}

	/*
	 * Returns a string representation of the Huffman Tree object based on the
	 * preorder binary tree traversal algorithm.
	 * 
	 * @see LinkedBinaryTree#toString()
	 */
	public String toString() {
		Iterator<HuffmanPair> iter = this.iteratorPreOrder();
		String preorderStringRep = "";
		while (iter.hasNext()) {
			HuffmanPair temp = iter.next();
			preorderStringRep += temp.toString() + ",";
		}
		return preorderStringRep;
	}

}
