abstract class Valuable{



	protected String name;

	public Valuable(String name){

		this.name = name;

	}


	abstract int getValue();


	public  String toString(){

		return name + " " + getValue();

	}

}

