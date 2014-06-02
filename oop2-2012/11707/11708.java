import java.util.Scanner;
import java.util.ArrayList;

public class Inlupp2X {
	
	public static void main(String[] args){
		
		Scanner keyboard=new Scanner(System.in);
		ArrayList <Book>         allBooks   = new ArrayList<Book>        ();
		ArrayList <MusicRecords> allRecords = new ArrayList<MusicRecords>();
		
			
			for(;;){
				System.out.println("Antal medier: "+(allBooks.size()+allRecords.size()) );
				System.out.println("1. L�mna ut medie"                                  );
				System.out.println("2. �terl�mna medie"                                 );
				System.out.println("3. L�gg till ny bok"                                );
				System.out.println("4. L�gg till CD"                                    );
				System.out.println("5. Visa medier"                                     );
				System.out.println("6. Ta bort medie"                                   ); 
				System.out.println("7. �ndra skick f�r CD"                              ); 
				System.out.println("8. B�cker utan l�nm�jlighet"                        ); 
				System.out.print  ("9. Avsluta "        
						
						);
				String action=keyboard.nextLine();
				
				switch(action){
//-----------------------------------------------------------------------------------
				case "1":{
					
					for(;;){
						
						System.out.print("Bok eller CD: "); String answere=keyboard.nextLine();
						
						if(answere.equalsIgnoreCase("bok")){
						
							System.out.println("Tillg�ngliga b�cker:");
							for(int i=0;i<allBooks.size();i++){
							
								allBooks.get(i).getAvailability();
							
								if(allBooks.get(i).getAvailability()==true){
									System.out.println(allBooks.get(i).printArrayList());
								}
							
							}
						
							System.out.print("Ange bokens namn: ");
							String borrowBook=keyboard.nextLine();
						
							boolean bookFound=false;
							for(int i=0; i<allBooks.size(); i++){
							
								if(borrowBook.equalsIgnoreCase(allBooks.get(i).getTitle())){  
									bookFound=true;
								
									if(allBooks.get(i).getStatus().equalsIgnoreCase("Tillg�nglig") && allBooks.get(i).getPossibleToLend().equalsIgnoreCase("ja")){
										allBooks.get(i).Status="Otillg�nglig";
										System.out.println("Boken �r nu utl�nad");
										System.out.println();
									
									}else System.err.println("Bok kan ej l�nas");
								}
							}
							if(!bookFound) System.out.println("Boken existerar ej i system"); 
							keyboard.nextLine();
							break;
					  
						} //if "bok"
						if(answere.equalsIgnoreCase("CD")){
							
							System.out.println("Tillg�ngliga CDs: ");
							
							for(int i=0 ;i<allRecords.size();i++){
								if(allRecords.get(i).getAvailability()==true){
								System.out.println(allRecords.get(i).printArrayList());
								}
							}
							
							System.out.print("Ange skivans namn: "); String occupyRecord=keyboard.nextLine(); 
							
							boolean recordFound=false;
							for(int i=0;i<allRecords.size();i++){
								
								if(occupyRecord.equalsIgnoreCase(allRecords.get(i).Title)){
									
									recordFound=true;
									if(allRecords.get(i).Occupied.equalsIgnoreCase("nej")){
										allRecords.get(i).Occupied="Ja";
										System.out.println("CDn �r nu bokad"); //keyboard.nextLine();
										System.out.println();
										

									}
									else System.err.println("CDn �r upptagen");
									
								}
								
							} 
							if(!recordFound) System.err.println("CD finns ej i system");
							keyboard.nextLine();
							
							break;
						} //if "cd"
						
					} //for
					

					break;
				} //case
//-----------------------------------------------------------------------------------
				case "2":{
					System.out.println("�terl�mna medie. Ange bok eller CD: ");
					String answere=keyboard.nextLine();
					
						if(answere.equalsIgnoreCase("bok")){
							for(int i=0;i<allBooks.size();i++){
						
								if(allBooks.get(i).getStatus().equalsIgnoreCase("Otillg�nglig")){
									System.out.println(i+1+". "+allBooks.get(i).printArrayList());
								}
							}
					
							System.out.print("Ange bokens namn: ");
							String returnBook=keyboard.nextLine();
							for(int i=0;i<allBooks.size();i++){
						
								if(allBooks.get(i).getTitle().equalsIgnoreCase(returnBook) && allBooks.get(i).getStatus().equalsIgnoreCase("Otillg�nglig")){
									allBooks.get(i).Status="Tillg�nglig";
									System.out.println("Boken �r nu inl�mnad");
									System.out.println();
								}
							}
						} //if "bok"
						if(answere.equalsIgnoreCase("CD")){
							
							System.out.print("Ange CD titel: ");
							String returnRecord=keyboard.nextLine();
							for(int i=0;i<allRecords.size();i++){
								
								if(allRecords.get(i).getTitle().equalsIgnoreCase(returnRecord) && allRecords.get(i).Occupied.equalsIgnoreCase("ja")){
									allRecords.get(i).Occupied="Nej";
									System.out.println("CDn �r ej l�ngre upptagen");
									System.out.println();
								}
							}
						}
					

					break;
				}
//-----------------------------------------------------------------------------------
				case "3":{
					
					for(;;){
						
						System.out.print("Namn: ");
						String Title=keyboard.nextLine();
						System.out.print("F�rfattare: ");
						String Creator=keyboard.nextLine();
						System.out.print("Genre: ");
						String Genre=keyboard.nextLine();
						System.out.print("Utgivnings�r: ");
						String ReleaseYear=keyboard.nextLine();
						System.out.print("M�jlighet f�r utl�ning (Ja/Nej): ");
						String PossibleToLend=keyboard.nextLine();
					
						Book newBook= new Book(ReleaseYear, PossibleToLend, Title, Creator, Genre);
						allBooks.add(newBook);
						
						
						System.out.print("L�gg till ytterligare bok: Ja/Nej: ");
						String answere=keyboard.nextLine();
						if(answere.equalsIgnoreCase("nej")) break; 
					}
					break;
				}
//------------------------------------------------------------------------------------
				case "4":
				{
					for(;;){
						System.out.print("Titel: ");
						String Title=keyboard.nextLine();
						System.out.print("Artist: ");
						String Creator=keyboard.nextLine();
						System.out.print("Genre: ");
						String Genre=keyboard.nextLine();
						System.out.print("Speltid (timmar): ");
						String Playtime=keyboard.nextLine();
						System.out.print("Skick (Repig/Orepig): ");
						String Condition=keyboard.nextLine();
						
						MusicRecords newMusicRecord= new MusicRecords(Playtime, Condition, Title, Creator, Genre);
						allRecords.add(newMusicRecord);
						
						System.out.print("L�gg till ytterligare CD: Ja/Nej: ");
						String answere=keyboard.nextLine();
						if(answere.equalsIgnoreCase("nej")) break;
						
					}
				 
				
					break;
				}
//------------------------------------------------------------------------------------
				case "5":
				{
					System.out.println();
					System.out.print("Visa medier. Ange bok eller CD: ");
					String answere=keyboard.nextLine();
					
					if(answere.equalsIgnoreCase("bok")){
						for(int i=0;i<allBooks.size();i++){
						
							System.out.println( (i+1) +". "+allBooks.get(i).printArrayList() ); 
							
						}
					}
					if(answere.equalsIgnoreCase("CD")){
						for(int i=0;i<allRecords.size();i++){
							System.out.println( (i+1) +". "+ allRecords.get(i).printArrayList()); 
						}
					}
					
						break;	
				}
				
//------------------------------------------------------------------------------------
				case "6":{
					System.out.print("Ta bort medie. Ange bok eller CD: ");
					String answere=keyboard.nextLine();
					System.out.println();

						if(answere.equalsIgnoreCase("bok")){
							boolean bookFound=false;
							for(int i=0;i<allBooks.size();i++){
								System.out.println(allBooks.get(i).printArrayList());
								
							}
							System.out.print("Vilken bok ska bort ur register: "); String deleteBook=keyboard.nextLine();
							for(int i=0;i<allBooks.size();i++){
								if(allBooks.get(i).getTitle().equalsIgnoreCase(deleteBook)){
									bookFound=true;
									allBooks.remove(i);
									System.out.println("Boken �r raderad");
								}
							keyboard.nextLine();
							if(bookFound==false) System.err.println("Fel namn");
						}
					}
						if(answere.equalsIgnoreCase("CD")){
							
							System.out.print("Vilken CD ska bort ur register: ");
							String deleteRecord=keyboard.nextLine();
							
							boolean recordFound=false;
							for(int i=0;i<allRecords.size();i++){
								if(allRecords.get(i).getTitle().equalsIgnoreCase(deleteRecord)){
									allRecords.remove(i);
									System.out.println("CDn �r nu raderad");
								}
							}
							if(!recordFound) System.err.println("Fel namn");
						}
					break;
				}
//------------------------------------------------------------------------------------
				case "7":{
						System.out.println();
						System.out.print("�ndra skick f�r CD. Ange namn: ");
						String answere=keyboard.nextLine();
						
						boolean recordFound=false;
							for(int i=0;i<allRecords.size();i++){
								if(allRecords.get(i).Title.equalsIgnoreCase(answere)){
									recordFound=true;
									
									System.out.println(allRecords.get(i).printArrayList());
									
									System.out.print("Har skicket p� album "+allRecords.get(i).Title+" f�rs�mrats? Ja/Nej");
									String newCondition=keyboard.nextLine();
										if(newCondition.equalsIgnoreCase("ja")){
											allRecords.get(i).Condition="Repig";
										}
								
								}
							}
							if(recordFound==false) System.out.println("CDn existerar ej i system");
					
					break;
				}
//-----------------------------------------------------------------------------------
				case "8":{
					System.out.println("B�cker i system som ej kan l�nas");
					
					for(int i=0;i<allBooks.size();i++){
						if(allBooks.get(i).getAvailability()==false){
							System.out.println(allBooks.get(i).printArrayList());
						}
					}
					
					
					break;
				}
//------------------------------------------------------------------------------------
				case "9":{
						System.out.println("Avslutar program");
						System.exit(0);
				}
//------------------------------------------------------------------------------------	
					default:{
						System.err.println("Fel kommando");
						System.out.println();
						
						break;
					}
				
				} //switch
				
		}// for-loop 
		
		
	} //main

} // klass inlupp2
