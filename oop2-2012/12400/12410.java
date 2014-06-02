abstract class Prylar{
	private String namn;

	abstract public int getVarde();

	public String getNamn(){
		return namn;}


	public Prylar (String namn){
		this.namn=namn;}

	public String toString(){
		return namn;
	}
}