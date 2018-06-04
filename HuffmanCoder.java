
/**
 * The Class HuffmanCoder.
 * 
 * @author Toni Lachmaniucu Date: April 2 2018
 */
public class HuffmanCoder {

	/** The huffmantree containing the characters and their frequencies. */
	private HuffmanTree<HuffmanPair> huffTree;

	/** The encoding list containing the encoding data symbol/code pairs. */
	private ArrayUnorderedList<EncodingData> encodingList;

	/**
	 * Instantiates a new huffman coder object.
	 *
	 * @param pairsList
	 *            the list of huffman pairs (symbols and frequencies)
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList) {
		huffTree = new HuffmanTree<HuffmanPair>(pairsList);
		encodingList = new ArrayUnorderedList<EncodingData>();

		buildEncodingList(huffTree.getRoot(), "");

	}

	/**
	 * Decodes the given code into a character.
	 *
	 * @param code
	 *            the code
	 * @return the char
	 */
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> node = huffTree.getRoot();
		int i = 0;
		while (!node.isLeaf() && i < code.length()) {
			if (code.charAt(i) == '0') {
				node = node.getLeft();
			} else if (code.charAt(i) == '1') {
				node = node.getRight();
			}
			i++;
		}
		if (node.isLeaf() && i == code.length()) {
			return node.getElement().getCharacter();
		}
		return (char) 0;

	}

	/**
	 * Encode.
	 *
	 * @param c
	 *            the character to encode
	 * @return the encoding of the character
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	public String encode(char c) throws ElementNotFoundException {
		for (EncodingData data : encodingList) {
			if (data.getSymbol() == c) {
				return data.getEncoding();
			}
		}
		throw new ElementNotFoundException("That character is not in the current encoding list!");

	}

	/*
	 * Returns a string representation of the huffman coder object based on the
	 * toString of the ArrayUnorderedList class.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return encodingList.toString();

	}

	/**
	 * Builds the encoding list.
	 *
	 * @param node
	 *            the current node
	 * @param encoding
	 *            the encoding for that node object.
	 */
	private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding) {
		if (node.isLeaf()) {
			EncodingData dat = new EncodingData(node.getElement().getCharacter(), encoding);
			encodingList.addToFront(dat);
		} else {
			buildEncodingList(node.getLeft(), encoding + 0);
			buildEncodingList(node.getRight(), encoding + 1);
		}

	}

}
