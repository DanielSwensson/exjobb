public class ProjektUppgift {

	private static int valet = 0;
	
	public static void main(String[] args){
		
		Val start = new Val();
		
		while (valet!=5){
			
			valet = start.hanteraVal();
			switch(valet){
			
				case 1:{
					SkapaFil nyFil = new SkapaFil();
					nyFil.filNamn();
					nyFil.skrivText();
					nyFil.enFil();
					break;
				}
				case 2:{
					OppnaFil nyOppna = new OppnaFil();
					nyOppna.filNamn();
					nyOppna.skrivUt();
					break;
				}
				case 3:{
					Frekvens nyFrekvens = new Frekvens();
					nyFrekvens.filNamn();
					String enText = nyFrekvens.skrivUt();
					nyFrekvens.beraknaFrekvens(enText);
					break;
				}
				case 4:{
					Sprak vilketSprak = new Sprak();
					vilketSprak.filNamn();
					String enTextTill = vilketSprak.skrivUt();
					vilketSprak.beraknaFrekvens(enTextTill);
					vilketSprak.frekvensAvTotalen();
					vilketSprak.avgoraSprak();
					break;
				}
				case 5:{
					System.out.println("Tack för att du använt programmet.\nHej då!");
					System.exit(0);
					break;
				}
				default:{
					System.out.println("Ogiltigt val!");
				}
			}			
		}
	}
}
