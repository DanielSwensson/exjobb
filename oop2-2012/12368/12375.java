public class MarsianDoctor extends Doctor{
	private String subDoc, addfield;

    public MarsianDoctor(int date, int id, String name, int docLv, String field) {
    	super(date, id, name, docLv);
    	addfield= getField();
    	addfield= (field + " " + addfield);
    	setField(addfield);
    }

    public int PayEq(){
    	return 500*getDocLv()*getDocLv() + 700;
    }

    public String toString(){
    	return super.toString() + "";
    }


}