import java.util.Scanner;
class main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Dog[] reg=new Dog[100];
		for (int x=0;x<reg.length;x++){
			reg[x]=new Dog("","",0,0);
		}
		int count=0;
		boolean menu=true;
		while (menu){
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
				reg[count]=new Dog(namn,ras,age,vikt);
				count+=1;
				System.out.print("\nHund '"+namn+"' registrerad.\n ");
			}	
			else if (choice==2){
				System.out.print("\nAnge minsta svanslängd: ");
				double min=sc.nextDouble();
				for (int x=0;x<reg.length;x++){
					String namn1=reg[x].retName();
					double svans1=reg[x].retTail();
					if (svans1>=min && !namn1.equals("")){
						reg[x].declare();
					}
				}
			}
			else if (choice==3){
				sc.nextLine();
				System.out.print(" \nTa bort hund: ");
				String rad=sc.nextLine();
				for (int x=0;x<reg.length;x++){
					String namn1=reg[x].retName();
					if (namn1.equalsIgnoreCase(rad)){
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
				menu=false;
			}
		}
	}
}