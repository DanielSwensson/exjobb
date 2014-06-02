public class AutopsyDoctor extends Doctor{
	private String addfield;
	private int autop;

    public AutopsyDoctor(int date, int id, String name, int docLv, String field, int autop) {
    	super(date, id, name, docLv);
    	addfield= getField();
    	addfield= (field + " " + addfield);
    	setField(addfield);
    	this.autop= autop;
    }

    public String toString(){
    	return super.toString() + "Number of successful autopsies: " + autop +"";
    }


}