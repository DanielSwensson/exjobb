import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class HockeyKollen {
	private ArrayList<Lag> allaLag = new ArrayList<Lag>();

	private HockeyKollen() {
		System.out.println(skrivLogo());
		laddaObjekt();
		while (true) {
			System.out
					.println("1 Registrera Lag 2 Nyförvärv 3 Uppdatera 4 Lista 5 Marknadsvärden 6 Slumpa Femma 7 Statistik 8 Avsluta");
			int kommando = inläsningTal("Kommando");

			switch (kommando) {
			case 1:
				registreraLag();
				break;

			case 2:
				registreraSpelare();
				break;

			case 3:
				System.out.println(uppdateraSpelare());
				break;

			case 4:
				listaAllaSpelareOchLag();
				break;

			case 5:
				undersökMarknadsvärden();
				break;

			case 6:
				slumpaFemma();
				break;

			case 7:
				skapaStatistikTabeller();
				break;
			case 8:
				avsluta();
			}
		}
	}

	public static void main(String[] args) {
		new HockeyKollen();
	}

	public int inläsningTal(String str) {
		Scanner scan = new Scanner(System.in);
		boolean skriv = false;
		int tal = 0;
		do {
			try {
				System.out.print(str + ": ");
				tal = Integer.parseInt(scan.nextLine());
				skriv = false;
			} catch (NumberFormatException e) {
				System.out.println("Inmatningen måste vara ett tal");
				skriv = true;
			}
		} while (skriv);

		return tal;
	}

	private String inläsningSträng(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print(str + ": ");
		str = scan.nextLine();

		return str;
	}

	private ArrayList<Spelare> sortera(int vilka, int sortEfter) {
		ArrayList<Spelare> sortLista = new ArrayList<Spelare>();
		for (Lag l : allaLag)
			sortLista.addAll(l.getRooster());

		if (vilka > 1) {
			for (int i = 0; i < sortLista.size(); i++) {
				if (vilka == 2 && !(sortLista.get(i) instanceof Forward)) {
					sortLista.remove(sortLista.get(i));
					i--;
				} else if (vilka == 3 && !(sortLista.get(i) instanceof Back)) {
					sortLista.remove(sortLista.get(i));
					i--;
				} else if (vilka == 4 && !(sortLista.get(i) instanceof Målvakt)) {
					sortLista.remove(sortLista.get(i));
					i--;
				}
			}
		}

		for (int i = 0; i < sortLista.size(); i++) {
			for (int a = i + 1; a < sortLista.size(); a++) {
				if (sortEfter == 1)
					sorteraSpecifikt(sortLista, sortLista.get(a).getPoäng(),
							sortLista.get(i).getPoäng(), a, i);
				else if (sortEfter == 2)
					sorteraSpecifikt(sortLista, sortLista.get(a).getMål(),
							sortLista.get(i).getMål(), a, i);
				else if (sortEfter == 3)
					sorteraSpecifikt(sortLista, sortLista.get(a).getAssist(),
							sortLista.get(i).getAssist(), a, i);
				else if (sortEfter == 4 && vilka == 2)
					sorteraSpecifikt(sortLista,
							((Forward) sortLista.get(a)).getSkott(),
							((Forward) sortLista.get(i)).getSkott(), a, i);
				else if (sortEfter == 4 && vilka == 3)
					sorteraSpecifikt(sortLista,
							((Back) sortLista.get(a)).getPlusMinus(),
							((Back) sortLista.get(i)).getPlusMinus(), a, i);
				else if (sortEfter == 4 && vilka == 3)
					sorteraSpecifikt(sortLista,
							((Målvakt) sortLista.get(a)).getInsläpptaMål(),
							((Målvakt) sortLista.get(i)).getInsläpptaMål(), a,
							i);
				else if (sortEfter == 4 && vilka == 3)
					sorteraSpecifikt(sortLista,
							((Målvakt) sortLista.get(a)).getNollor(),
							((Målvakt) sortLista.get(i)).getNollor(), a, i);
				else if (sortEfter == 5)
					sorteraSpecifikt(sortLista, sortLista.get(a)
							.beräknaMarknadsvärde(), sortLista.get(i)
							.beräknaMarknadsvärde(), a, i);
			}
		}
		return sortLista;
	}

	private void sorteraSpecifikt(ArrayList<Spelare> spelarLista,
			int sorteraEfterA, int sorteraEfterI, int a, int i) {
		if (sorteraEfterA > sorteraEfterI) {
			Spelare temp = spelarLista.set(i, spelarLista.get(a));
			spelarLista.set(a, temp);
		}

	}

	private boolean kontrollStatVal(int kontroll, int vilka) {
		if ((vilka == 1) && (kontroll < 1 || kontroll > 3)) {
			System.out.println("Ogiltigt Kommando");
			return false;
		} else if ((vilka == 2 || vilka == 3) && (kontroll < 1 || kontroll > 4)) {
			System.out.println("Ogiltigt Kommando");
			return false;
		} else if ((vilka == 4) && (kontroll < 1 || kontroll > 5)) {
			System.out.println("Ogiltigt Kommando");
			return false;
		} else
			return true;
	}

	private String genereraFemma() {

		String forward = "", back = "", målvakt = "";
		int backar = 0, målvakter = 0, forwards = 0;
		Spelare potential;
		ArrayList<Spelare> allaSpelare = new ArrayList<Spelare>();
		for (Lag l : allaLag)
			allaSpelare.addAll(l.getRooster());
		do {
			Random rand = new Random();
			int randSpelare = rand.nextInt(allaSpelare.size());
			potential = allaSpelare.get(randSpelare);
			allaSpelare.remove(randSpelare);

			if (potential instanceof Back && backar < 2) {
				back += "\t" + potential.getNamn() + " (" + potential.getLag()
						+ ")\t";
				backar++;
			} else if (potential instanceof Forward && forwards < 3) {
				forward += potential.getNamn() + " (" + potential.getLag()
						+ ")\t";
				forwards++;
			} else if (potential instanceof Målvakt && målvakter < 1) {
				målvakt = "\t\t\t" + potential.getNamn() + " ("
						+ potential.getLag() + ")";
				målvakter++;
			}
		} while ((backar < 2) || (forwards < 3) || (målvakter < 1));
		return forward + "\n\n" + back + "\n\n" + målvakt + "\n\n";
	}

	private String skrivLogo() {
		return "\t\t   ____  __ ______ ____   __   ______ __  __\n\t\t   \\  / / // __  // __/| / /   \\  __// / / /\n\t\t   / /_/ // / / // / | |/ /    / /_  \\ \\/ /\n\t\t  / __  // / / // /  |   <    / __/   \\  /\n\t\t / / / // /_/ // /__ | |\\ \\  / /__    / / .xxx.\n\t\t/_/ /_//_____//____/ |_| \\_\\/____/   /_/  XXXXX \n\t\t _   __  ______ __    __  ______  __  __  'xxx'\n\t\t| | / / / __  // /   / /  \\  __/ / / / / ____\n\t\t| |/ / / / / // /   / /   / /   /  \\/ / /___/\n\t\t|   < / / / // /   / /   / __/ / /\\  / /\\ \\/\n\t\t| |\\ \\ /_/ // /__ / /__ / /__ / / / / /\\ \\/\n\t\t|_| \\_\\___//____//____//____//_/ /_/ /\\ \\/\n\t\t ___________________________________/__\\/\n\t\t|____|_________________________________/ \n";

	}

	private void registreraLag() {
		boolean lagRedo = true;
		Lag nyttLag = new Lag(inläsningSträng("Lagnamn"));
		for (int i = 0; i < allaLag.size(); i++) {
			if (nyttLag.getNamn().toLowerCase()
					.equals(allaLag.get(i).getNamn().toLowerCase())) {
				System.out.println("Laget finns redan");
				i = allaLag.size();
				lagRedo = false;
			}
		}
		if (lagRedo)
			allaLag.add(nyttLag);
	}

	private void registreraSpelare() {
		if (allaLag.size() == 0) {
			System.out.println("Inga lag finns registrerade ännu");
			return;
		}
		int lagIndex = inläsningLag();
		String lag = allaLag.get(lagIndex).getNamn();
		String position = inläsningPosition();
		String namn = inläsningSträng("Namn");
		int alder = inläsningTal("Ålder");
		int mål = inläsningTal("Mål");
		int assist = inläsningTal("Assist");

		if (position.toLowerCase().equals("forward")) {
			int Skott = inläsningTal("Skott");
			Forward nyForward = new Forward(namn, lag, alder, mål, assist,
					Skott);
			allaLag.get(lagIndex).nySpelare(nyForward);
		} else if (position.toLowerCase().equals("back")) {
			int plusMinus = inläsningTal("+/-");
			Back nyBack = new Back(namn, lag, alder, mål, assist, plusMinus);
			allaLag.get(lagIndex).nySpelare(nyBack);
		} else if (position.toLowerCase().equals("målvakt")) {
			int insläpptaMål = inläsningTal("Insläppta Mål");
			int nollor = inläsningTal("Hållna Nollor");
			Målvakt nyMålvakt = new Målvakt(namn, lag, alder, mål, assist,
					insläpptaMål, nollor);
			allaLag.get(lagIndex).nySpelare(nyMålvakt);
		}
	}

	private void slumpaFemma() {
		int allaForwards = 0, allaBackar = 0, allaMålvakter = 0;
		for (Lag l : allaLag) {
			allaForwards += l.räknaForwards();
			allaMålvakter += l.räknaMålvakter();
			allaBackar += l.räknaBackar();
		}
		if (allaForwards < 3 || allaBackar < 2 || allaMålvakter < 1) {
			System.out
					.println("Det finns inte tillräckligt med spelare registrerade");
			return;
		}
		System.out.print(genereraFemma());
	}

	private void skapaStatistikTabeller() {
		boolean kontroll = true;
		int sortEfter = 1;
		int vilka;
		do {
			vilka = inläsningTal("Visa statistik för (1)Alla spelare (2)Forwards (3)Backar (4)Målvakter");
			switch (vilka) {
			case 1:
				sortEfter = inläsningTal("Lista efter (1)Poäng (2)Mål (3)Assist");
				kontroll = kontrollStatVal(sortEfter, 1);
				break;
			case 2:
				sortEfter = inläsningTal("Lista efter (1)Poäng (2)Mål (3)Assist (4)Skott");
				kontroll = kontrollStatVal(sortEfter, 2);
				break;
			case 3:
				sortEfter = inläsningTal("Lista efter (1)Poäng (2)Mål (3)Assist (4)+-");
				kontroll = kontrollStatVal(sortEfter, 3);
				break;
			case 4:
				sortEfter = inläsningTal("Lista efter (1)Poäng (2)Mål (3)Assist (4)Insläppta Mål (5)Hållna Nollor");
				kontroll = kontrollStatVal(sortEfter, 4);
				break;
			default:
				System.out.println("Ogiltigt kommando");
				kontroll = false;
				break;

			}
		} while (!kontroll);
		ArrayList<Spelare> rankSort = sortera(vilka, sortEfter);
		System.out
				.println("Namn\t\t\tLag\tMål\tAssist\tPoäng\tSkott\t+/-\tIM\tSO");
		for (Spelare s : rankSort)
			System.out.println(s);
	}

	private void sparaObjekt() {
		try {
			FileOutputStream lag = new FileOutputStream("Lagfil.obj");
			ObjectOutputStream ut = new ObjectOutputStream(lag);
			for (Lag l : allaLag)
				ut.writeObject(l);
		} catch (IOException e) {
			System.out.println("Fel i Lag-sparning");
		}
		try {
			FileOutputStream spelare = new FileOutputStream("Spelarfil.obj");
			ObjectOutputStream ut2 = new ObjectOutputStream(spelare);
			for (Lag l : allaLag)
				for (Spelare s : l.getRooster())
					if (!l.getRooster().contains(s))
						ut2.writeObject(s);
		} catch (IOException e) {
			System.out.println("Fel i Spelar-sparning");
		}
	}

	private void laddaObjekt() {
		try {
			FileInputStream lag = new FileInputStream("Lagfil.obj");
			ObjectInputStream in = new ObjectInputStream(lag);
			while (lag.available() > 0) {
				Lag l = (Lag) in.readObject();
				allaLag.add(l);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Kunde inte ladda Lag");
		} catch (IOException e) {
			System.out.println("Kunde inte ladda Lag");
		} catch (ClassNotFoundException e) {
			System.out.println("Kunde inte ladda Lag");
		}

		try {
			FileInputStream spelare = new FileInputStream("Spelarfil.obj");
			ObjectInputStream in2 = new ObjectInputStream(spelare);
			while (spelare.available() > 0) {
				Spelare s = (Spelare) in2.readObject();
				for (Lag l : allaLag)
					if (s.getLag().toLowerCase()
							.equals(l.getNamn().toLowerCase()))
						l.getRooster().add(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Kunde inte ladda objekt Spelare");
		} catch (IOException e) {
			System.out.println("Kunde inte ladda objekt Spelare");
		} catch (ClassNotFoundException e) {
			System.out.println("Kunde inte ladda objekt Spelare");
		}
	}

	private String uppdateraSpelare() {
		int nollor = 0;
		int lagIndex = inläsningLag();
		String namn = inläsningSträng("Namn").toLowerCase();
		for (Spelare s : allaLag.get(lagIndex).getRooster()) {
			if (s.getNamn().toLowerCase().equals(namn)) {
				s.ändraMål(inläsningTal("Gjorda mål"));
				s.ändraAssist(inläsningTal("Gjorda assist"));
				if (s instanceof Forward)
					((Forward) s).ändraSkott(inläsningTal("Nya skott"));
				else if (s instanceof Back)
					((Back) s).ändraPlusMinus(inläsningTal("+/- förändring"));
				else if (s instanceof Målvakt) {
					nollor = ((Målvakt) s)
							.ändraNollor(inläsningTal("Hållna nollor"));
					if (nollor != 0)
						((Målvakt) s)
								.ändraInsläpptaMål(inläsningTal("Insläppta mål"));
				}
				return "Spelare Uppdaterad";
			}
		}
		return "Spelare ej registrarad i " + allaLag.get(lagIndex).getNamn();

	}

	private int inläsningLag() {
		int lagIndex = 0;
		boolean okej = true;
		String lag;
		do {
			lag = inläsningSträng("Lag");
			for (Lag l : allaLag)
				if (l.getNamn().toLowerCase().equals(lag.toLowerCase())) {
					lagIndex = allaLag.indexOf(l);
					okej = false;
				}
			if (okej) {
				System.out.print(lag + " finns inte (");
				for (Lag l : allaLag)
					System.out.print(l.getNamn() + " ");
				System.out.println("finns)");
			}
		} while (okej);
		return lagIndex;
	}

	private String inläsningPosition() {
		String position;
		boolean okej;
		do {
			position = inläsningSträng("Position");
			if (position.toLowerCase().equals("målvakt")
					|| position.toLowerCase().equals("forward")
					|| position.toLowerCase().equals("back"))
				okej = false;
			else {
				System.out.println("Ogiltig position(målvakt/back/forward)");
				okej = true;
			}
		} while (okej);
		return position;
	}

	private void avsluta() {
		sparaObjekt();
		System.out.print(skrivLogo());
		System.exit(0);
	}

	private void undersökMarknadsvärden() {
		int kommando = inläsningTal("Visa marknadsvärde för (1)alla lag (2)alla spelare i ett lag (3)de 5 högst värderade spelarna\nVal");

		switch (kommando) {
		case 1:
			for (Lag l : allaLag) {
				if (l.getNamn().length() < 8)
					System.out.println(l.getNamn() + "\t\t"
							+ l.beräknaMarknadsvärde());
				else
					System.out.println(l.getNamn() + "\t"
							+ l.beräknaMarknadsvärde());
			}
			break;
		case 2:
			String lag = null;
			int lagIndex = inläsningLag();
			for (Spelare s : allaLag.get(lagIndex).getRooster())
				lag += "\n" + s.getNamn() + "\t\t" + s.beräknaMarknadsvärde();
			System.out.println(lag);
			break;
		case 3:
			ArrayList<Spelare> dyrast = sortera(1, 5);
			for (int i = 0; i < 5; i++)
				System.out.println(dyrast.get(i).getNamn() + "\t\t"
						+ dyrast.get(i).beräknaMarknadsvärde() + "\t("
						+ dyrast.get(i).getLag() + ")");
			break;
		default:
			System.out.println("Ogiltigt val");
		}
	}

	private void listaAllaSpelareOchLag() {
		System.out
				.println("Namn\t\t\tLag\tMål\tAssist\tPoäng\tSkott\t+/-\tIM\tSO");
		for (Lag l : allaLag)
			System.out.print(l + "\n");
	}

}
