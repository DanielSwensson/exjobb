public class Sprak extends Frekvens{
	
	public static final int ANTAL_SPRAK = 4;
	public static final double[][] SPRAK_FREKVENSER = new double[][] //tabell med bokstavsförekomst i språken engelska, franska, svenska, tyska.
		       {{8.27,1.48,2.94,4.03,11.78,2.22,1.72,6.77, //engelska
		         7.39,0.12,0.81,3.76,2.85,6.71,7.79,1.54,
		         0.05,5.95,6.69,9.07,2.66,1.13,2.14,0.19,
		         1.89,0.03},
		        {7.97,1.40,3.55,3.79,16.89,1.02,1.00,0.75, //franska
		         7.08,0.38,0.04,5.51,2.82,8.11,5.19,2.78,
		         1.01,6.69,8.35,7.22,6.09,1.35,0.02,0.54,
		         0.30,0.15},
		        {9.50,1.11,1.53,5.30,8.94,1.74,3.57,3.94,  //svenska
		         3.98,0.89,3.26,4.93,3.41,8.46,5.01,1.77,
		         0.00,6.73,5.56,9.20,1.94,2.42,0.00,0.05,
		         0.45,0.00},
		        {5.12,1.95,3.57,5.07,16.87,1.35,3.00,5.79, //tyska
		         8.63,0.19,1.14,3.68,3.12,10.64,1.74,0.42,
		         0.01,6.30,6.99,5.19,3.92,0.77,1.79,0.01,
		         0.69,1.24}};
	 
	public double[] frekvensAvTotal = new double[ANTAL_BOKSTAVER]; //frekvens av varje bokstav som andelar av hela texten.

	Sprak(){
		frekvensAvTotal = new double[ANTAL_BOKSTAVER];
		setTotaltBokstaver(0);
	}
	public void filNamn(){
		System.out.println("Ange en fil för att avgöra vilket språk texten är skriven på");
		setFilNamn(userInput.nextLine());
	}
	public void beraknaFrekvens(String enText){
	
		String strang = enText;
		 if (enText!=""){
			 for (int i=0; i<ANTAL_BOKSTAVER; i++){
				 frekvens[i] = 0;
			 }
		 }
		        for (int i=0; i< strang.length(); i++){
		        	int index;
		            if (strang.charAt(i)>='a' && strang.charAt(i)<='z'){
		            	index = strang.charAt(i) - 'a';
		                frekvens[index]++;
		                setTotaltBokstaver(getTotaltBokstaver() + 1);
		            }

		            else if (strang.charAt(i)>='A' && strang.charAt(i)<='Z'){
		            	index = strang.charAt(i) - 'A';
		                frekvens[index]++;
		                setTotaltBokstaver(getTotaltBokstaver() + 1);
		            }
		        }
		 }
	
	public void frekvensAvTotalen(){
		
		for (int bokstav = 0; bokstav<ANTAL_BOKSTAVER; bokstav++)
        frekvensAvTotal[bokstav] = ((double) frekvens[bokstav] / getTotaltBokstaver()) * 100;
	}
	
	public void avgoraSprak(){
		String[] spraknamn = new String[]{"Engelska ","Franska ", "Svenska ","Tyska "};
    
		double[] summa = new double[ANTAL_SPRAK];
		double skillnad, minstavarde,kvadratskillnad=0.0;
		String namn = "";
		
		System.out.println("Kvadratsummorna för respektive språk räknas ut\n" +
							"och ju lägre kvadratsumma desto större är\n" +
							"sannolikheten att detta är textens språk.\n");
		for(int spraket=0;spraket<ANTAL_SPRAK; spraket++){

			for (int i=0; i<ANTAL_BOKSTAVER; i++)
			{
				skillnad=frekvensAvTotal[i]- SPRAK_FREKVENSER[spraket][i];
				kvadratskillnad= kvadratskillnad + skillnad*skillnad; //kvadratskillnad
			}
			
			System.out.println(spraknamn[spraket] + " har kvadratsumman: " + kvadratskillnad);
			summa[spraket] = kvadratskillnad;
			kvadratskillnad = 0;
		}

		minstavarde = summa[0];
		namn = spraknamn[0];

		for(int i = 1; i<ANTAL_SPRAK; i++)
		{
			if(summa[i] < minstavarde){
				minstavarde = summa[i];
				namn = spraknamn[i];}
          
        
		}
		System.out.println("\nTexten är troligtvis skriven på " + namn + "\n");
	}
    




}
