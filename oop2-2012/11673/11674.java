public class Aktie extends Pryl {
	/**
	 * @uml.property  name="amountOfPosts"
	 */
	private int amountOfPosts;
	/**
	 * @uml.property  name="pricePerPost"
	 */
	private int pricePerPost;

	public Aktie(String name, int pricePerPost, int amountOfPosts){
		super (name);
		this.amountOfPosts = amountOfPosts;
		this.pricePerPost = pricePerPost;
	}
	
	public int changePriceToZero() {
		return pricePerPost = 0;
	}
	public double getValue() {
		return amountOfPosts*pricePerPost;
	}
	public String toString(){
		return super.getName() + "   " + getValue();
	}
	public double totalValue(){
		return getValue();
	}
}