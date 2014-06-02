abstract class Pryl{

	private String prylNamn, ownerName;
	private Person owner;
	protected int value;

	public Pryl(String pN, Person o){

		prylNamn = pN;
		owner = o;

	}

	public String getPrylNamn(){

		return prylNamn;
	}

	public String getOwner(){

		ownerName = owner.getNamn();

		return ownerName;

	}

	public void setPrylNamn(String pN){

		prylNamn = pN;
	}

	public void setOwner(Person o){

		owner = o;

	}

	public abstract int getValue();




}//class