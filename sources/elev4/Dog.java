class Dog{
	private String name;
	private String breed;
	private int age;
	private double weight;
	private double tail;
	Dog (String name, String breed, int age, double weight) 
		{
		this.name=name;
		this.breed=breed;
		this.age=age;
		this.weight=weight;
		if (breed.equalsIgnoreCase("tax")){
			this.tail=3.7;
			}
		else {
			this.tail=age*weight/10;
			}
		}
	void clear(){
		name="";
		breed="";
		age=0;
		weight=0;
		tail=0;
		}
	public void declare(){
		System.out.print(" \nNamn: "+name+" \nRas: "+breed+" \n≈lder: "+age+" \nVikt: "+weight+" \nSvansl‰ngd: "+tail+" \n");
		}
	public String retName(){
		return name;
		}
	public double retTail(){
		return tail;
		}
}	