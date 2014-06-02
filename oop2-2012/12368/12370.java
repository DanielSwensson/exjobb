public class AlienReport extends Alien{
	private String rep;

    public AlienReport(int date, String doctors, int id, String ALname, String des, String rep) {
    	super(date, doctors, id, ALname, des);
    	this.rep = rep;
    }

    public void updateReport(String rep2){
    	rep = rep + "\n" + rep2;
    }

    /*public getReport(){

    }*/


    public String toString(){
    	return super.toString() +	"       --- REPORT ---   \n" + rep;
    }
}