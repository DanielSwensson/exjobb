import java.util.ArrayList;
import java.util.Scanner;

public class Huvudprogram {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Album> allaAlbums = new ArrayList<Album>();
	ArrayList<Tidning> allaTidningar = new ArrayList<Tidning>();
	ArrayList<Betyg> allaBetyg = new ArrayList<Betyg>();
	final int ANTAL_MENYALTERNATIV = 8;
	
	private void läggTillTidningar(){ 
		allaTidningar.add(new Tidning("SvD", 6));
		allaTidningar.add(new Tidning("Aftonbladet", 5));
		allaTidningar.add(new Tidning("DN", 5));	
		allaTidningar.add(new Tidning("Sonic", 10));	
	}

	private void läggTillAlbum(){ 

		Album nyttAlbum;
		Tidning tidn;
		
		nyttAlbum = new Album("Young Hunger", "Chad Valley", 2012);
		allaAlbums.add(nyttAlbum);
		tidn = hittaTidningMedNamn("SVD");				
		allaBetyg.add(new KritikerBetyg(4, nyttAlbum, tidn));

		
		nyttAlbum = new Album("Traveling Alone", "Tift Merritt", 2012);
		allaAlbums.add(nyttAlbum);
		tidn = hittaTidningMedNamn("DN");				
		allaBetyg.add(new KritikerBetyg(4, nyttAlbum, tidn));
		
		nyttAlbum = new Album("channel ORANGE", "Frank Ocean", 2012);
		allaAlbums.add(nyttAlbum);
		tidn = hittaTidningMedNamn("DN");				
		allaBetyg.add(new KritikerBetyg(1, nyttAlbum, tidn));
		
		nyttAlbum = new Album("1987", "Fibes, Oh Fibes!", 2009);
		allaAlbums.add(nyttAlbum);
		tidn = hittaTidningMedNamn("Sonic");				
		allaBetyg.add(new KritikerBetyg(8, nyttAlbum, tidn));
		
		nyttAlbum = new Album("Och Stora Havet", "Jakob Hellman", 2010);
		allaAlbums.add(nyttAlbum);
		allaBetyg.add(new MittBetyg(8, nyttAlbum));
		
	}

	
	private int readInt (String fråga){
		for(;;){
			try{
				System.out.print(fråga);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}
	
	
	private String readString(String fråga){ 
		System.out.print(fråga);
		String str=keyboard.nextLine();
		return str;
	}
	
	
	private int väljMenyAlternativ(){
		int valtAlternativ;
		
		System.out.print("\nSkriv\n1 för att mata in ett nytt album"+ 
				"\n2 för mata in ett nytt eget betyg av albumet (1-100)"+
				"\n3 för mata in ett nytt kritikerbetyg av albumet"+
				"\n4 för att visa alla album"+ 
				"\n5 för att visa alla betyg"+ 
				"\n6 för att visa tillgängliga tidningar"+ 
				"\n7 för att visa betyg i fallande ordning"+
				"\n8 för att avsluta programmet\n");
			
		for(;;){
			valtAlternativ = readInt("Välj ett alternativ:");
			if (valtAlternativ>ANTAL_MENYALTERNATIV || valtAlternativ<1){				
				System.out.println("Skriv ett alternativ mellan 1 och " + ANTAL_MENYALTERNATIV);
			} else return valtAlternativ;	
		}		
	}
	
	
	private void mataInNyttAlbum(){ 
		String nyttAlbum = readString("Albumets namn: ");
		String nyArtist = readString("Artistens namn: ");
		int nyttÅr = readInt("Albumets utgivningsår (YYYY): ");
		Album alb = hittaAlbumMedNamn(nyttAlbum);
		if (alb != null){
			System.out.println("Det albumet finns redan");
		} else {
			Album ny = new Album(nyttAlbum, nyArtist, nyttÅr);
			allaAlbums.add(ny);
		} 
	}
	
	private Album hittaAlbumMedNamn(String albumnamn){
		for (Album alb : allaAlbums){
			if(alb.getAlbumNamn().equalsIgnoreCase(albumnamn)){
				return alb;
			}	
		} 
		return null; 
	}
	
	private Album hittaAlbumMedIdNr(int idNr){
		for (Album alb : allaAlbums){
			if(alb.getIdNr() == idNr){
				return alb;
			}	
		} 
		return null; 
	}
	
	private Tidning hittaTidningMedNamn(String tidningsnamn){
		for (Tidning t : allaTidningar){
			if(t.getTidningsNamn() .equalsIgnoreCase(tidningsnamn))
			{
				return t;

			} 	
		}
		return null;
	}

	private void mataInNyttBetyg(String typAvBetyg){ 
		int idNr = readInt("Skriv in albumets idNummer: ");
		int nyttBetyg = readInt("Skriv in betyg på albumet: ");
		Album alb = hittaAlbumMedIdNr(idNr);
			
		 
		if (alb != null)
		{			
			if(typAvBetyg == "KritikerBetyg")
			{
				String tidningsnamn = readString("Skriv in namnet på kritikerns tidning: ");
				
				Tidning tidn = hittaTidningMedNamn(tidningsnamn);				

				if (tidn != null){
					allaBetyg.add(new KritikerBetyg(nyttBetyg, alb, tidn));
				}else 	{
					System.out.print("Tidning med det namnet fanns ej i registret");
				}				
			}
			else {
				allaBetyg.add(new MittBetyg(nyttBetyg, alb)); 
			}
		}
		else {
				System.out.print("Album med det namnet fanns ej i registret");
			} 				
	}


	private void visaArraylistBetyg(ArrayList<Betyg> betygAttVisa){
		String utskrift;
		Betyg b;
		for (int index=0; index<betygAttVisa.size(); index++){
			b = betygAttVisa.get(index);
			utskrift = "Album: " + b.getAlbum().getAlbumNamn() + " Betyg: " + b.visaBetyg() + "   " ;
			if (b instanceof KritikerBetyg)
			{
				utskrift +=((KritikerBetyg) b).getTidning().getTidningsNamn()+ "s betyg: "  + b.visaOriginalBetyg() + " av " + ((KritikerBetyg) b).getTidning().getMaxBetyg();
			}
			else
			{	
				utskrift += " av 100";
			}
				
			System.out.println(utskrift);			
		}
	}

	private void visaBästaBetyg(){ 
		ArrayList<Betyg> sorteradeBetyg = new ArrayList<Betyg>();
		Boolean found = false;
		
		sorteradeBetyg.add(allaBetyg.get(0));
		for (int index=1; index<allaBetyg.size(); index++){
			for (int sortindex=0; sortindex<sorteradeBetyg.size(); sortindex++){
				if (allaBetyg.get(index).visaBetyg()>sorteradeBetyg.get(sortindex).visaBetyg())
				{
					sorteradeBetyg.add(sortindex, allaBetyg.get(index));
					found = true;
					break;
				}
			}
			if (!found) sorteradeBetyg.add(sorteradeBetyg.size(), allaBetyg.get(index));
			found = false;
		}
		visaArraylistBetyg(sorteradeBetyg);

	}

	
	private void visaAllaTidningar(){
		for (int index=0; index<allaTidningar.size(); index++){
			System.out.println("Tidning: " + allaTidningar.get(index).getTidningsNamn() + 
				" Maxbetyg: " + allaTidningar.get(index).getMaxBetyg());			
		}
	}
	
	private void visaAllaAlbum(){
		for (int index=0; index<allaAlbums.size(); index++){
			System.out.println("IdNummer: " + allaAlbums.get(index).getIdNr() + " Albumnamn: " + allaAlbums.get(index).getAlbumNamn() + " Artist: " + allaAlbums.get(index).getArtistNamn());			
		}
	}

	public static void main(String[] args) {
		Huvudprogram hp = new Huvudprogram();
		hp.läggTillTidningar();
		hp.läggTillAlbum();
		for(;;){							
					switch (hp.väljMenyAlternativ()) {
					case 1: hp.mataInNyttAlbum();	break;
					case 2:	hp.mataInNyttBetyg("MittBetyg"); break;
					case 3: hp.mataInNyttBetyg("KritikerBetyg"); break;
					case 4: hp.visaAllaAlbum(); break;
					case 5: hp.visaArraylistBetyg(hp.allaBetyg); break;
					case 6: hp.visaAllaTidningar(); break;
					case 7: hp.visaBästaBetyg(); break;
					case 8: System.exit(0);
					default: System.out.println("Felaktigt kommando");
					}		
		}
	}
}

