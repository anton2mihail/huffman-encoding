
/**
 * The Class EncodingData.
 * 
 * @author Toni Lachmaniucu Date: April 2 2018
 */
public class EncodingData {

	/** The symbol. */
	private char symbol;

	/** The encoding. */
	private String encoding;

	/**
	 * Instantiates a new encoding data object.
	 *
	 * @param symbol
	 *            the symbol of the character
	 * @param encoding
	 *            the encoding of the character
	 */
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;
		this.encoding = encoding;
	}

	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol.
	 *
	 * @param symbol
	 *            the new symbol
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Gets the encoding.
	 *
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets the encoding.
	 *
	 * @param encoding
	 *            the new encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/*
	 * @param obj checks to see if the symbols of the two objects are the same
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		EncodingData other = (EncodingData) obj;
		if (this.symbol != other.symbol)
			return false;
		return true;

	}

	/*
	 * Generates a string representaion of the encoding data object including the
	 * symbol and the encoding
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Symbol:" + this.symbol + " ," + "Encoding:" + this.encoding;
	}

}
