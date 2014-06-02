import java.util.*;

public class Register{
  
  private static Scanner in = new Scanner(System.in);
  private static ArrayList<Person> personList = new ArrayList<Person>(); //Personlistan
  
  public static void main(String[] args){
    
    String choice = ""; //Används till menyns switch
    
    while(true){ 
      choice = questionText("Värdesaksregister - Meny \n" +
                            "1. Skapa person \n" +
                            "2. Lägg till ägodel \n" +
                            "3. Visa alla \n" +
                            "4. Visa rikaste \n" +
                            "5. Visa specifik person \n" +
                            "6. Börskrasch \n" +
                            "7. Avsluta \n");
      
      switch(choice){
        case "1": //Lägg till person
          
          addPerson();
          
          break;
          
        case "2": //Lägg till ägodel
          
          addProperty();
          
          break;
          
        case "3": //Visa alla personer
          
          System.out.println(getAllPersons());
          
          break;
          
        case "4": //Visa rikaste person
          
          System.out.println(getRichest());
          
          break;
          
        case "5": //Visa enskild person
          
          String name = questionText("Ange vilken person du vill visa: ");
          System.out.println(getPerson(name));
          
          break;
          
        case "6": //Börskrasch
          
          stockCrash();
          
          break;
          
        case "7": //Avsluta
          System.exit(0);
          break;
          
        default:
          System.out.println("Du angav fel kommando, försök igen");
          
      }//Swtitchen
    }//Whilen
  }//Metoden
  
  //Lägger till en person med önskat namn
  public static void addPerson(){  
    String name = questionText("Ange namn på personen du vill skapa: ");
    
    //Om personen redan existerar får man veta det
    if(contains(name)){
      System.out.println("Personen existerar redan."); 
    }
    //Om användaren inte anger något namn anropas en annan konstruktor
    else if(name.isEmpty()){
      personList.add(new Person());
      System.out.println(getLast());
    }
    //Annars lägggs personen till
    else{    
      personList.add(new Person(name));
      System.out.println(getLast());
    }
  }
  
  //Menyn för inläsning av ägodelar
  public static void addProperty(){
    //Om det inte finns några personer kan man inte lägga till ägodelar till personer
    if(personList.isEmpty()){
      System.out.println("Det finns inga personer i listan ännu. Lägg till några! \n");
    }
    //Om det finns personer kan man lägga till ägodelar till dem
    else{
      System.out.println("Till vilken person ska ägodelen tillhöra? (Ange namn)");      
      String name = in.nextLine();
      
      //Om användaren anger ett namn som finns flyter allt på och hoppar ur loopen ovan
      //Likaså loppar menyn om användaren skriver in fel alternativ i menyn
      if(contains(name)){
       
        boolean validInput;
        do{//Så att användaren inte ska behöva gå igenom vilken person ägodelen ska tillhöra igen om fel inmatning
          validInput = true;
          
          String choice = questionText("Vad vill du lägga till för ägodel? \n" +
                                       "1. Pryl/Device \n" +
                                       "2. Smycke/Jewelry \n" +
                                       "3. Aktie/Stock \n ");
          
          switch(choice){
            case "1": //Lägger till en pryl
              
              addDevice(name);
              
              break;
              
            case "2": //Lägger till ett smycke
              
              addJewelry(name);
              
              break;
              
            case "3": //Lägger till en aktie
              
              addStock(name);
              
              break;
              
            default:
              
              validInput = false;
              System.out.println("Du angav fel kommando, försök igen ");
              
          }//Switchen
        }while(!validInput);
      }
      //Om angiven person inte hittas användaren försöka igen
      else{
        System.out.println(personNotFound());
      }
    }
  }
  
  //Skickar en pryl till en person som sedan lägger in den i sin ArrayList
  public static void addDevice(String name){    
    String device = questionText("Vad är det för typ av pryl (ange typ, märke, etc.)");  
    int price = questionInt("Vad kostade den? (Ange summa, endast siffror)");    
    int wear = questionInt("På en skala från 1 - 10, hur sliten är den? (Ange i siffor)");
    
    personList.get(getPosition(name)).addProperty(new Device(device, price, wear));
  }
  
  //Skickar ett smycke till en person som sedan lägger in den i sin ArrayList
  public static void addJewelry(String name){    
    String jewelry = questionText("Vad är det för smycke (ange typ, märke, etc.)");   
    int material = questionInt("Smycket består av guld 1 \nSmycket består av silver 2");
    boolean gold = false;
    if(material == 1){
      gold = true;
    }
    int gems = questionInt("Hur många ädelstenar har smycket?");
    
    personList.get(getPosition(name)).addProperty(new Jewelry(jewelry, gold, gems));
  }
  
  //Skickar en aktie till en person som sedan lägger in den i sin ArrayList
  public static void addStock(String name){    
    String stock = questionText("Vad är det för företag aktien finns i?");
    int value = questionInt("Vad var aktiens värde? (Ange summa, endast siffror)");
    int quantity = questionInt("Hur många aktier?");
    
    personList.get(getPosition(name)).addProperty(new Stock(stock, value, quantity));
  }
  
  //Returnerar en persons position i ArrayListen
  public static int getPosition(String name){    
    for(int i=0; i<personList.size(); i++){
      if(personList.get(i).getName().equalsIgnoreCase(name)){
        return i;        
      }     
    }
    return 0;
  }
  
  //Returnerar namnet på den personen som är sist i personList listan
  public static String getLast(){
    return personList.get(personList.size()-1).getName() + " har lagts till i registret. \n"; 
  }
  
  //Returnerar den rikaste personen
  public static String getRichest(){
    if(!personList.isEmpty()){
      int richest = 0; //Antar att personen på plats 0 är rikast
      for(int i=1; i<personList.size(); i++){
        if(personList.get(richest).getTotalValue() < personList.get(i).getTotalValue()){
          //Om någon är rikare än personen på plats 0 blir den personen rikast så länge ingen annan är rikare än denne
          richest = i;
        }
      }
      return "Rikaste personen: " + getPerson(personList.get(richest).getName());
    }
    else{
      return "Det finns inga personer i registret ännu. \n";
    }
  }
  
  
  //Returnerar toStringen till en person användaren anger om personen är skapad
  public static String getPerson(String name){   
    if(contains(name)){    
      return personList.get(getPosition(name)) + "\n";
    }
    else{
      return personNotFound();
    }
  }
  
  //Returnerar alla personer samt deras totala värde av ägodelar
  public static String getAllPersons(){
    if(!personList.isEmpty()){
      String all = "";
      for(int i=0; i<personList.size(); i++){
        //Lägger in alla personer och deras totala värden av ägodelar
        all += personList.get(i).getName() + "   " + personList.get(i).getTotalValue() + "\n";
      }
      return all;
    }
    else{
      return "Det finns inga personer i registret ännu. \n";  
    }
  }
  
  //Om personen finns i registret returneras true, bra för att se om personen i fråga redan existerar
  public static boolean contains(String name){ 
    for(int i=0; i<personList.size(); i++){
      if(personList.get(i).getName().equalsIgnoreCase(name)){
        return true; //Om personen finns returneras true, annars false
      }     
    }
    return false;
  }
  
  //Läser in en int från användaren enligt angiven fråga och ser om det är en int, om det är en returnerar den den,
  //annars blir fortsätter den fråga efter en int tills den får en
  public static int questionInt(String question){
    System.out.println(question);
    while(true){
      try{
        int i = in.nextInt();
        in.nextLine();
        return i;
      }
      catch(InputMismatchException e){
        System.out.println("Endast siffror: ");
        in.nextLine(); //Städar upp scannern
      }
    }
  }
  
  //Ställer en fråga som skickas som argument och läser in svaret från användaren samt returnerar det
  public static String questionText(String question){
    System.out.println(question);
    return in.nextLine();
  }
  
  //Anropar på personens stockCrash som i sin tur anropar Stocks crash som nollställer nuvarande aktiers values
  public static void stockCrash(){
    for(int i=0; i<personList.size(); i++){
      personList.get(i).stockCrash(); 
    }
  }
  
  //Felmeddelande om sökt person inte hittas
  public static String personNotFound(){
    return "Personen ej funnen. \n";
  }
  
}