import java.util.*;

public class Register{
  
  private static Scanner in = new Scanner(System.in);
  private static ArrayList<Person> personList = new ArrayList<Person>(); //Personlistan
  
  public static void main(String[] args){
    
    String choice = ""; //Anv�nds till menyns switch
    
    while(true){ 
      choice = questionText("V�rdesaksregister - Meny \n" +
                            "1. Skapa person \n" +
                            "2. L�gg till �godel \n" +
                            "3. Visa alla \n" +
                            "4. Visa rikaste \n" +
                            "5. Visa specifik person \n" +
                            "6. B�rskrasch \n" +
                            "7. Avsluta \n");
      
      switch(choice){
        case "1": //L�gg till person
          
          addPerson();
          
          break;
          
        case "2": //L�gg till �godel
          
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
          
        case "6": //B�rskrasch
          
          stockCrash();
          
          break;
          
        case "7": //Avsluta
          System.exit(0);
          break;
          
        default:
          System.out.println("Du angav fel kommando, f�rs�k igen");
          
      }//Swtitchen
    }//Whilen
  }//Metoden
  
  //L�gger till en person med �nskat namn
  public static void addPerson(){  
    String name = questionText("Ange namn p� personen du vill skapa: ");
    
    //Om personen redan existerar f�r man veta det
    if(contains(name)){
      System.out.println("Personen existerar redan."); 
    }
    //Om anv�ndaren inte anger n�got namn anropas en annan konstruktor
    else if(name.isEmpty()){
      personList.add(new Person());
      System.out.println(getLast());
    }
    //Annars l�gggs personen till
    else{    
      personList.add(new Person(name));
      System.out.println(getLast());
    }
  }
  
  //Menyn f�r inl�sning av �godelar
  public static void addProperty(){
    //Om det inte finns n�gra personer kan man inte l�gga till �godelar till personer
    if(personList.isEmpty()){
      System.out.println("Det finns inga personer i listan �nnu. L�gg till n�gra! \n");
    }
    //Om det finns personer kan man l�gga till �godelar till dem
    else{
      System.out.println("Till vilken person ska �godelen tillh�ra? (Ange namn)");      
      String name = in.nextLine();
      
      //Om anv�ndaren anger ett namn som finns flyter allt p� och hoppar ur loopen ovan
      //Likas� loppar menyn om anv�ndaren skriver in fel alternativ i menyn
      if(contains(name)){
       
        boolean validInput;
        do{//S� att anv�ndaren inte ska beh�va g� igenom vilken person �godelen ska tillh�ra igen om fel inmatning
          validInput = true;
          
          String choice = questionText("Vad vill du l�gga till f�r �godel? \n" +
                                       "1. Pryl/Device \n" +
                                       "2. Smycke/Jewelry \n" +
                                       "3. Aktie/Stock \n ");
          
          switch(choice){
            case "1": //L�gger till en pryl
              
              addDevice(name);
              
              break;
              
            case "2": //L�gger till ett smycke
              
              addJewelry(name);
              
              break;
              
            case "3": //L�gger till en aktie
              
              addStock(name);
              
              break;
              
            default:
              
              validInput = false;
              System.out.println("Du angav fel kommando, f�rs�k igen ");
              
          }//Switchen
        }while(!validInput);
      }
      //Om angiven person inte hittas anv�ndaren f�rs�ka igen
      else{
        System.out.println(personNotFound());
      }
    }
  }
  
  //Skickar en pryl till en person som sedan l�gger in den i sin ArrayList
  public static void addDevice(String name){    
    String device = questionText("Vad �r det f�r typ av pryl (ange typ, m�rke, etc.)");  
    int price = questionInt("Vad kostade den? (Ange summa, endast siffror)");    
    int wear = questionInt("P� en skala fr�n 1 - 10, hur sliten �r den? (Ange i siffor)");
    
    personList.get(getPosition(name)).addProperty(new Device(device, price, wear));
  }
  
  //Skickar ett smycke till en person som sedan l�gger in den i sin ArrayList
  public static void addJewelry(String name){    
    String jewelry = questionText("Vad �r det f�r smycke (ange typ, m�rke, etc.)");   
    int material = questionInt("Smycket best�r av guld 1 \nSmycket best�r av silver 2");
    boolean gold = false;
    if(material == 1){
      gold = true;
    }
    int gems = questionInt("Hur m�nga �delstenar har smycket?");
    
    personList.get(getPosition(name)).addProperty(new Jewelry(jewelry, gold, gems));
  }
  
  //Skickar en aktie till en person som sedan l�gger in den i sin ArrayList
  public static void addStock(String name){    
    String stock = questionText("Vad �r det f�r f�retag aktien finns i?");
    int value = questionInt("Vad var aktiens v�rde? (Ange summa, endast siffror)");
    int quantity = questionInt("Hur m�nga aktier?");
    
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
  
  //Returnerar namnet p� den personen som �r sist i personList listan
  public static String getLast(){
    return personList.get(personList.size()-1).getName() + " har lagts till i registret. \n"; 
  }
  
  //Returnerar den rikaste personen
  public static String getRichest(){
    if(!personList.isEmpty()){
      int richest = 0; //Antar att personen p� plats 0 �r rikast
      for(int i=1; i<personList.size(); i++){
        if(personList.get(richest).getTotalValue() < personList.get(i).getTotalValue()){
          //Om n�gon �r rikare �n personen p� plats 0 blir den personen rikast s� l�nge ingen annan �r rikare �n denne
          richest = i;
        }
      }
      return "Rikaste personen: " + getPerson(personList.get(richest).getName());
    }
    else{
      return "Det finns inga personer i registret �nnu. \n";
    }
  }
  
  
  //Returnerar toStringen till en person anv�ndaren anger om personen �r skapad
  public static String getPerson(String name){   
    if(contains(name)){    
      return personList.get(getPosition(name)) + "\n";
    }
    else{
      return personNotFound();
    }
  }
  
  //Returnerar alla personer samt deras totala v�rde av �godelar
  public static String getAllPersons(){
    if(!personList.isEmpty()){
      String all = "";
      for(int i=0; i<personList.size(); i++){
        //L�gger in alla personer och deras totala v�rden av �godelar
        all += personList.get(i).getName() + "   " + personList.get(i).getTotalValue() + "\n";
      }
      return all;
    }
    else{
      return "Det finns inga personer i registret �nnu. \n";  
    }
  }
  
  //Om personen finns i registret returneras true, bra f�r att se om personen i fr�ga redan existerar
  public static boolean contains(String name){ 
    for(int i=0; i<personList.size(); i++){
      if(personList.get(i).getName().equalsIgnoreCase(name)){
        return true; //Om personen finns returneras true, annars false
      }     
    }
    return false;
  }
  
  //L�ser in en int fr�n anv�ndaren enligt angiven fr�ga och ser om det �r en int, om det �r en returnerar den den,
  //annars blir forts�tter den fr�ga efter en int tills den f�r en
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
        in.nextLine(); //St�dar upp scannern
      }
    }
  }
  
  //St�ller en fr�ga som skickas som argument och l�ser in svaret fr�n anv�ndaren samt returnerar det
  public static String questionText(String question){
    System.out.println(question);
    return in.nextLine();
  }
  
  //Anropar p� personens stockCrash som i sin tur anropar Stocks crash som nollst�ller nuvarande aktiers values
  public static void stockCrash(){
    for(int i=0; i<personList.size(); i++){
      personList.get(i).stockCrash(); 
    }
  }
  
  //Felmeddelande om s�kt person inte hittas
  public static String personNotFound(){
    return "Personen ej funnen. \n";
  }
  
}