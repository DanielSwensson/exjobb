public class Alien {
	private int id, date;
	private String ALname, des, doctors;

    public Alien(int date, String doctors, int id, String ALname, String des) {
    	this.id= id;
    	this.doctors= doctors;
    	this.date= date;
    	this.ALname= ALname;
    	this.des= des;
    }


    public String getListinfo(){
    	return  "" + id + " Alien idenfication" + " || Date: " + date + " || Alien name: " + ALname + "";
    }

    public int getID(){
    	return id;
    }

	public String getDocs(){
    	return doctors;
    }
    public int getDate(){
		return date;
	}

	public String getName(){
		return ALname;
	}

	public String getDes(){
		return des;
	}

    public String toString(){
    	return "Date: " + date + "\nDoctors assigned to specimen: " + doctors + "\nAlien idenfication number: " + id + "\nAlien name: " + ALname + "\nAlien description: \n" + des + "\n";
    }


}