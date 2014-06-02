

import java.util.*;
public class AssetManager {

private ArrayList<Client> clients = new ArrayList<Client>();
private Scanner scan = new Scanner(System.in);

public static void main(String[] args) {
AssetManager managementCompany =new AssetManager();
System.out.println("Välkommen till vårt depåsystem;");
for(;;){
int choice = managementCompany.readInt("Vad vill du göra? \n 1. Arbeta med kunderna? \n 2. Arbeta med kundernas värdepapper \n 3. Uppdatera marknadsräntan \n 4. Avsluta\n");
switch (choice){
case 1: managementCompany.workWithClients();break;
case 2: managementCompany.workWithClientsAssets();break;
case 3: BlockofAssets.setMarketInterestRate();System.out.println("Marknadsräntan uppdaterad "+BlockofAssets.getMarketInterestRate()); break;
case 4: System.out.println("Tack för idag.");System.exit(0);
default: System.out.println("Felaktigt kommando");
}

}

}

private void workWithClients (){
boolean getOn = true;
do {
int choice = readInt("Vad vill du göra? \n 1. Lägg till kund \n 2. Ta bort kund \n 3. Skriva ut information om alla kunderna \n 4. Namnge den rikaste av kunderna. \n 5. Annan arbetsuppgift");
switch(choice){
case 1: addClient();break;
case 2: removeClient();break;
case 3: System.out.println(printAllClients());break;
case 4: nameRichest(); break;
case 5: getOn = false; break;
default: System.out.println("Felaktigt kommando!");

}
}while(getOn == true);
}

private void workWithClientsAssets(){
boolean getOn = true;
do{
int choice = readInt("Vad vill du göra? \n 1. Lägg till värdepapper till kunds befintliga värdepapper? \n 2. Ta bort värdepapper från kunds befintliga värdepapper? \n 3.Arbeta med andra arbetsuppgifter?");
switch(choice){
case 1: addAsset(); break;
case 2: removeAsset();break;
case 3: getOn = false;break;
default : System.out.println("Felaktigt kommando");
}
}while (getOn == true);
}

private void addClient (){
String name = readString("Kundens namn: ");
Client cc = searchClient(name);
if (cc!=null)
System.out.println("Den kundens finns redan");
else{
String askedLegalForm = readString("Vilken juridisk form har kunden?");
Client addedClient = new Client(name,askedLegalForm);
clients.add(addedClient);
}
}

private void removeClient(){
String noLongerClient = readString("Vad heter kunden som ska tas bort?");
Client rc = searchClient(noLongerClient);
if (rc==null)
System.out.println("Någon kund med det namnet finns inte!");
else {
clients.remove(rc);
System.out.println("Kunden borttagen");
}
}

private void nameRichest(){

double netWorthOfRichest = 0;
String nameOfRichest = "Ingen";

for (Client maybeRichest : clients){

	double conditionAmount = maybeRichest.getTotalWealth();
	
	if(conditionAmount>netWorthOfRichest){
		netWorthOfRichest = conditionAmount;
		nameOfRichest = maybeRichest.getName();
	}// if-satsen

}//for-loopen


System.out.println(nameOfRichest + " är rikast!");

}// metoden


private Client searchClient (String name){
for(Client searched : clients)

if (searched.getName().equalsIgnoreCase(name))
return searched;
return null;

}

private String printAllClients(){
String printAllClients = clients.toString();
return printAllClients;
}


private void addAsset(){
Client richer = searchClient(readString("Vad heter kunden du vill lägga till värdepapper till?"));

if (richer == null)
System.out.println("Det finns inte någon sådan kund!");

else{

boolean getOn= true;

do {
int whichToAdd = readInt("Vilken typ av värdepapper vill du lägga till? \n 1: Aktiepost \n 2:Obligationspost \n 3:Optionspost \n 4:Kundens alla värdepapper är registrerade.");
switch(whichToAdd){
case 1: richer.Assets.add(addShares()); break;
case 2: richer.Assets.add(addBonds()); break;
case 3:richer.Assets.add(addOptions()); break;
case 4 :getOn = false;break;
default: System.out.println("Felaktigt kommando!");
}
}while (getOn == true);
}
}

private void removeAsset(){
Client poorer = searchClient(readString("Vad heter kunden du vill ta bort värdepapper från?"));

if(poorer == null)
System.out.println("Det finns inte någon sådan kund!");

String assetToRemove = readString("Vilket värdepapper vill du ta bort från kunden?");

for(int x =0; x< poorer.Assets.size();x++)

if (poorer.Assets.get(x).getName().equalsIgnoreCase(assetToRemove)){
poorer.Assets.remove(x);
System.out.println("Värdepappret borttaget");
}
else{
System.out.println("Det finns inget sådant värdepapper!");
}
}


private BlockOfShares addShares(){
String name1 = readString("Vad heter aktieslaget?");
int numberOfShares1 = readInt("Hur många aktier ingår i posten?");
double dividend1 = readDouble("Vilken utdelning betalar aktien?");
BlockOfShares AdditionalShares = new BlockOfShares(name1,numberOfShares1,dividend1);

return AdditionalShares;
}

private BlockOfBonds addBonds(){
String name = readString("Vad heter obligationerna?");
double faceValue = readDouble("Vad är obligationens nominella belopp?");
int yearsToMaturity = readInt("Hur många år återstår av obligations löptid?");
double nominalInterestRate = ((readDouble("Vad är obligationens nominella ränta i %?")/100));
int numberOfBonds = readInt("Hur många obligationer ingår i posten?");
BlockOfBonds additionalBonds = new BlockOfBonds(name, faceValue, yearsToMaturity, nominalInterestRate, numberOfBonds);
return additionalBonds;
}
private BlockOfOptions addOptions (){
String name = readString("Vad heter optionerna?");
int numberOfOptions = readInt("Hur många optioner ingår i posten?");
int daysLeftToSettlement = readInt("Hur många dagar återstår till avräkning?");
BlockOfOptions additionalOptions = new BlockOfOptions(name, numberOfOptions, daysLeftToSettlement);
return additionalOptions;
}

 

private int readInt(String question){
for(;;){
try{
System.out.println(question);
int x = Integer.parseInt(scan.nextLine());
return x;
}
catch (NumberFormatException e){
System.out.println("Fel - skall vara numeriskt heltalsvärde");
}
}
}

private String readString(String question){
System.out.println(question);
String answer = scan.nextLine();
return answer;
}

private double readDouble(String question){
for(;;){
try{
System.out.println(question);
double x = Double.parseDouble(scan.nextLine());
return x;
}
catch (NumberFormatException e){
System.out.println("Fel skall vara ett numeriskt värde med decimaler och decimalpunkt!");
}

}
}
}

 

 
