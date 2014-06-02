import java.util.ArrayList;

public class Test {
// Test klass som inte funkar :/
	
	public static void main(String[] args) {
		ArrayList<Smycke>AllaSmycken= new ArrayList<Smycke>();
		ArrayList<Apparat>AllaApparater= new ArrayList<Apparat>();
		ArrayList<Aktie>AllaAktier= new ArrayList<Aktie>();
//		ArrayList<Pryl>AllaPrylar = new ArrayList<Pryl>();
		
		System.out.println("arraylist skapad");
		
		for(int y=0;y<4;y++){
			AllaSmycken.add(new Smycke());
			AllaApparater.add(new Apparat());
			AllaAktier.add(new Aktie());
//			AllaPrylar.add(new Pryl());
		}
		System.out.println("added");
		
		for(int x = 0;x<AllaAktier.size();x++){
			System.out.println(AllaSmycken.get(x));
			System.out.println(AllaApparater.get(x));
			System.out.println(AllaAktier.get(x));
//			System.out.println(AllaPrylar.get(x));
		}
		System.out.println("finished");
		

	}

}
