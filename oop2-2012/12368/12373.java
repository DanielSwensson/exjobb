public class ChiefDoctor extends Doctor{
	private String subDoc, addfield;

    public ChiefDoctor(int date, int id, String name, int docLv, String field, String subDoc) {
    	super(date, id, name, docLv);
    	addfield= getField();
    	addfield= (field + " " + addfield);
    	setField(addfield);
    	this.subDoc= subDoc;
    }

    public String toString(){
    	return super.toString() + "Teamleader over doctors: " + subDoc +"";
    }


}