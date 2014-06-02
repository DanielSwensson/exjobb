public class Link extends BoardComponent {
	private int value;
	private int rowNumber;
	private int columnNumber;
	
	public Link(int value, int rowNumber, int columnNumber){
		this.value = value;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
	}
	public int getRowNumber(){
		return rowNumber;
	}
	public int getColumnNumber(){
		return columnNumber;
	}
	public void setValue(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		return " " + getValue() + " ";
	}
}
