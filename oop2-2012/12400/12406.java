import java.util.*;

class Personer{
	private String namn;
	public ArrayList<Prylar> allaPrylar=new ArrayList<Prylar>();


	public int getSumma(){
		int summan=0;
		for(Prylar s:allaPrylar){

			summan+=s.getVarde();
		}
		return summan;
	}

	public String getNamn(){
		return namn;}

	public String getAllaPrylar(){
		String returnstring = "";
		for (Prylar s:allaPrylar) {
			returnstring+=s.getNamn()+ "\t" +s.getVarde() +"\n";}
		return returnstring;

	}
	public Personer(String namn){
		this.namn=namn;}




}

