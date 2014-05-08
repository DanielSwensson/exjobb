import java.util.Scanner;
class test{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Dog[] reg=new Dog[100];
		for (int x=0;x<reg.length;x++){
			reg[x]=new Dog("","",0,0);
			}
		int count=0;
		int menu=1;
		while (menu==1){
			for (int x=0;x<reg.length;x++){
				if (reg[x].equals("")){
					count=x;
					}
				}
			System.out.print(" \n1 - Registrera hund\n2 - Lista hundar\n3 - Ta bort hund\n4 - Avsluta program\nVal: ");
			int choice=sc.nextInt();
			if (choice==1){
				sc.nextLine();
				System.out.print(" \nNamn: ");
				String namn=sc.nextLine();
				System.out.print("Ras: ");
				String ras=sc.nextLine();
				System.out.print("Ålder: ");
				int age=sc.nextInt();

				System.out.print("Vikt: ");
				double vikt=sc.nextDouble();
				reg[count]=new Dog(namn.toUpperCase(),ras.toUpperCase(),age,vikt);
				count+=1;
				System.out.print("\nHund '"+namn+"' registrerad.\n ");
			}	
			else if (choice==2){
				System.out.print("\nAnge minsta svanslängd: ");
				double min=sc.nextDouble();
				for (int x=0;x<reg.length;x++){
					if (reg[x].name!="" && reg[x].tail>=min){
						reg[x].declare();
						}
				}
			}
			else if (choice==3){
				sc.nextLine();
				System.out.print(" \nTa bort hund: ");
				String rad=sc.nextLine();
				rad=rad.toUpperCase();
				for (int x=0;x<reg.length;x++){
					if (reg[x].name.equals(rad)){
						reg[x].clear();
						System.out.print("Hund "+rad+" raderad.\n ");
						break;
						}
					else if(x==reg.length-1){
						System.out.print("Hund med det namnet finns ej i registret.\n ");
						}
						}					
			}
			else if (choice==4){
				menu=0;
			}
			}
	}
}