public class Doctor {
	private int id, date, docLv;
	private String name, field="Doctor";

    public Doctor(int date, int id, String name, int docLv){
    	this.date=date;
    	this.id= id;
    	this.name= name;
    	this.docLv= docLv;
    }

	public String getField(){
		return field;
	}

	public void setField(String field){
		this.field= field;
	}

	public String getName(){
		return name;
	}

    public String getListinfo(){
    	return  " D-" + id + " Idenfication number" + " || Date of employment: " + date + " || Name: " + name + "";
    }

    public int getID(){
    	return id;
    }

    public int getDocLv(){
    	return docLv;
    }


    public int PayEq(){
    	return 500*docLv*docLv;
    }

    public String toString(){
    	return "Date of employment: " + date + "\nIdenfication number: " + "D-" + id + "\nName: " + name + "\nField: " + field + "\nDoctor authorization level: " + docLv + "\nSalary: " + PayEq() + "$\n" ;
    }
}
