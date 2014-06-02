public class Barbarmyra extends KrigarMyra {
	public Barbarmyra(String na, String kö, int li, int man, int niv,
			int erfarenhe, int maxMan, int maxli, int fySkada, int maSkada,
			Huvudprogrammet inProgram) {
		super(na, kö, li, man, niv, erfarenhe, maxMan, maxli, fySkada, maSkada,
				inProgram);
		this.program = inProgram;
	}

	int fLiv = 30;
	public void attack(Karaktar myrre) {
		Fiende f = new Fiende("Larven", 30, 7);
		int mLiv;
		int mMana;
		int mNivå;
		int mExp;
		int mFySkada;
		int fiendeSkada;
		mLiv = myrre.getLiv();
		mMana = myrre.getMana();
		mNivå = myrre.getNivå();
		mExp = myrre.getErfarenhet();
		mFySkada = myrre.getFysiskSkada();
		fiendeSkada = f.getfSkada();
		// om man har 2 eller mer mana och fienden lever så gör man skada och
		// mana dras.
		if (mMana >= 5 && fLiv > 0) {
			fLiv = (fLiv - mFySkada);
			mMana = mMana - 5;
			myrre.setMana(mMana);
			// om fienden har liv kvar efter att man gjorde skada så skrivs det
			// ut hur mkt skada man gjorde och fienden attackerar tillbaka.
			if (fLiv > 0) {
				System.out.println("Du gjorde " + mFySkada
						+ " fysisk skada till fienden!\nDen har nu " + fLiv
						+ " liv kvar!");

				mLiv = mLiv - fiendeSkada;
				// om fienden tar myrans hp till 0 eller lägre så dör man,
				// annars sätts det nya livet till myra
				if (mLiv <= 0) {
					System.out.println("Du dog, bättre lycka nästa gång!");
					System.exit(0);
				}
				myrre.setLiv(mLiv);
				System.out.println("Fienden gjorde " + fiendeSkada
						+ " skada till dig!\nDu har nu " + mLiv + " liv och "
						+ mMana + " mana kvar!");
			}
			// om fienden inte har liv kvar så får man exp
			else {
				System.out
						.println("Du besegrade fienden! Du fick 10 erfarenhetspoäng!\n ");
				myrre.setLiv(mLiv);
				fLiv = 30;
				myrre.setExp(mExp + 10);
				mExp = mExp + 10;
				if (mExp == 30) {
					mNivå++;
					myrre.setNivå(mNivå);
					System.out
							.println("Gratulerar, du gick upp en nivå! Du är nu nivå "
									+ mNivå + "\n ");
					mExp = 0;
					myrre.setExp(0);
					// om exp = 30 går man upp i lvl och exp sätts till 0 igen

					// om man inte går upp i lvl så sätts expn
				} else {
					myrre.setExp(mExp);
				}

			}
		} else {
			System.out
					.println("Du har inte tillräckligt mycket mana för att använda den här attacken!");
		}
	}

	int bLiv = 200;

	public void bossAttack(Karaktar myrre) {
		Fiende f = new Fiende("Henrik Möller", 200, 16);
		int mLiv;
		int mMana;
		int mNivå;
		int mExp;
		int mFySkada;
		int fiendeSkada;
		mLiv = myrre.getLiv();
		mMana = myrre.getMana();
		mNivå = myrre.getNivå();
		mExp = myrre.getErfarenhet();
		mFySkada = myrre.getFysiskSkada();
		fiendeSkada = f.getfSkada();
		// om man har 2 eller mer mana och fienden lever så gör man skada och
		// mana dras.
		if (mMana >= 3 && bLiv > 0) {
			bLiv = (bLiv - mFySkada);
			mMana = mMana - 3;
			myrre.setMana(mMana);
			// om fienden har liv kvar efter att man gjorde skada så skrivs det
			// ut hur mkt skada man gjorde och fienden attackerar tillbaka.
			if (bLiv > 0) {
				System.out.println("Du gjorde " + mFySkada
						+ " fysisk skada till Henrik Möller!\nHan har nu "
						+ bLiv + " liv kvar!");

				mLiv = mLiv - fiendeSkada;
				// om fienden tar myrans hp till 0 eller lägre så dör man,
				// annars sätts det nya livet till myra
				if (mLiv <= 0) {
					System.out.println("Du dog, bättre lycka nästa gång!");
					System.exit(0);
				}
				myrre.setLiv(mLiv);
				System.out.println("Myrsloken gjorde " + fiendeSkada
						+ " skada till dig!\nDu har nu " + mLiv + " liv och "
						+ mMana + " mana kvar!");
			}
			// om fienden inte har liv kvar så får man exp
			else {
				System.out
						.println("Du besegrade bossen! Du fick 999 erfarenhetspoäng!\n ");
				System.out
						.println("Du tog dig tillbaka till Ante-stacken oskadd! Dina medmyror i stacken välkommnar dig som en hjälte!");
				System.exit(0);
				myrre.setLiv(mLiv);
				bLiv = 200;
				myrre.setExp(mExp + 10);
				mExp = mExp + 10;
				if (mExp >= 30) {
					mNivå++;
					myrre.setNivå(mNivå);
					System.out
							.println("Gratulerar, du gick upp en nivå! Du är nu nivå "
									+ mNivå + "\n ");
					mExp = 0;
					myrre.setExp(0);
					// om exp = 30 går man upp i lvl och exp sätts till 0 igen

					// om man inte går upp i lvl så sätts expn
				} else {
					myrre.setExp(mExp);
				}

			}
		} else {
			System.out
					.println("Du har inte tillräckligt mycket mana för att använda den här attacken!");
		}
	}
}