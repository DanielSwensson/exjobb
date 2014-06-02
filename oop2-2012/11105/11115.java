
public class Key extends Item {

	private String description;
	private final int KEYID;
	
	public Key(String description, int keyId){
		super("key");
		this.KEYID = keyId;
		this.description = description;
	}
	
	public int getKeyId(){
		return KEYID;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String toString(){
		return getName() + " - " + description;
	}
	
}
