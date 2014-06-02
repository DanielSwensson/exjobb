import java.awt.TextArea;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Registry
{
	private ArrayList<Person> persons = new ArrayList<Person>();
	
	public Registry()
	{
		loadData();

		boolean quit = false;
		while(!quit)
		{
			
			String command = menu();
			if(command == null)
				command = "9";
			
			switch(command.toLowerCase())
			{
				case "1":
				case "skapa person":
					registerPerson();
					break;
				case "2":
				case "skapa pryl":
					createItem();
					break;
				case "3":
				case "visa alla":
					showAll();
					break;
				case "4":
				case "visa rikaste":
					showRichestPerson();
					break;
				case "5":
				case "visa viss person":
					showPerson();
					break;
				case "6":
				case "börskrash":
					stockCrash();
					break;
				case "7":
				case "ta bort person":
					removePerson();
					break;
				case "8":
				case "ta bort pryl":
					removePersonItem();
					break;
				case "9":
				case "avsluta":
					quit = true;
					showMessage("Avslutar", "");
					break;
				default:
					showMessage("Felaktigt kommando", "Error!");
			}
		}
		saveData();
	}
	private void removePerson()
	{
		if(!persons.isEmpty())
		{
			try
			{
				Person removePerson = getPerson("Vilken person ska tas bort");
				persons.remove(removePerson);
				showMessage("Personen " + removePerson.getName() + " bortagen", "");
			}
			catch(IllegalArgumentException e)
			{
				showMessage("Avbryter", "");
			}
		}
		else
		{
			showMessage("Finns inga personer", "");
		}
		
	}
	private void removePersonItem()
	{
		if(!persons.isEmpty())
		{
			try
			{
				Person person = getPerson("Vilken person");
				ArrayList<Item> items = person.getAllItems();
				if(!items.isEmpty())
				{
					String text = person.getName() + " har följande prylar: \n\n" + 
													 person.getAllItemsInfo(true);
					
	
					boolean error = false;
					do
					{
						try
						{
							String input = JOptionPane.showInputDialog(null, new TextArea(text), "", 1);
							error = false;
							if(input == null)
							{
								showMessage("Avbryter", "");
							}
							else
							{
								items.remove(Integer.parseInt(input) - 1);
							}
						}
						catch(IndexOutOfBoundsException e)
						{
							error = true;
							showMessage("Skriv in ett tal som motsvarar en av siffrorna!", "Error!");
						}
						catch(NumberFormatException e)
						{
							error = true;
							showMessage("Skriv in ett nummer!", "Error!");
						}
						
					}
					while(error);
				}
				else
				{
					showMessage("Personen har inga saker att ta bort", "Error!");
				}
			}
			catch(IllegalArgumentException e)
			{
				showMessage("Avbryter", "");
			}
		}
		else
		{
			showMessage("Finns inga personer", "");
		}
		
	}
	private void stockCrash()
	{
		for(Person p : persons)
		{
			ArrayList<Item> items = p.getAllItems();
			for(Item i : items)
			{
				if(i instanceof Stock)
				{
					i.setBaseValue(0);
				}
			}
		}
		showMessage("Börskrash genomförd", "");
		
	}
	private void createItem()
	{
		if(persons.isEmpty())
		{
			showMessage("Det finns inga personer", "Error!");
		}
		else
		{
			try
			{
				Person p = getPerson("Vilken person äger prylen:");
				boolean error = false;
				do
				{
					error = false;
					String item = getString("Vilken sorts pryl (Smycke/Aktie/Apparat):");
					switch(item.toLowerCase())
					{
						case "smycke":
							createJewelery(p);
							break;
						case "aktie":
							createStock(p);
							break;
						case "apparat":
							createApparatus(p);
							break;
						default:
							showMessage("Felaktigt val", "Error!");
							error = true;
							break;
					}
				}
				while(error);
			}
			catch(IllegalArgumentException e)
			{
				showMessage("Abvryter", "");
			}
			
		}
	}
	private void createJewelery(Person p)
	{
		try
		{
			String name = getString("Vilken sorts smycke:");
			
			String material = "";
			do
			{
				material = getString("Är smycket av guld (Ja/Nej):");
				if(!material.equalsIgnoreCase("ja") && !material.equalsIgnoreCase("nej"))
				{
					showMessage("Skriv ja eller nej", "Error!");
				}
			}
			while(!material.equalsIgnoreCase("ja") && !material.equalsIgnoreCase("nej"));
			int stones = getInt("Antal ädelstenar:");
			
			boolean m = material.toLowerCase().equals("ja") ? true : false;
			p.addItem(new Jewelery(name, m, stones));
			showMessage("Smycket skapades", "");
		}
		catch(IllegalArgumentException e)
		{
			showMessage("Avbryter", "");
		}
		
	}
	private void createStock(Person p)
	{
		try
		{
			String name = getString("Namnet på akiten:");
			int value = getInt("Värdet på aktien:");
			int amount = getInt("Antal aktier:");
			
			p.addItem(new Stock(name, value, amount));
			showMessage("Aktien skapades", "");
		}
		catch(IllegalArgumentException e)
		{
			showMessage("Avbryter", "");
		}
	}
	private void createApparatus(Person p)
	{
		try
		{
			String name = getString("Vad för apparat:");
			int value = getInt("Värdet på appraten:");
			int amount = 0;
			do
			{
				amount = getInt("Hur mycket slitage (10(inget) - 1(mycket)):");
				if(amount > 10 || amount < 1)
				{
					showMessage("Skriv ett tal inom spannet", "Error!");
				}
			}
			while(amount > 10 || amount < 1);
			
			p.addItem(new Apparatus(name, value, amount));
			showMessage("Apparaten skapades", "");
		}
		catch(IllegalArgumentException e)
		{
			showMessage("Avbryter", "");
		}
	}
	private boolean personExist(String name)
	{
		Person person = null;
		for(Person p : persons)
		{
			if(name.equals(p.getName()))
			{
				person = p;
				break;
			}
		}
		return person != null ? true : false;
	}
	private Person getPerson(String promt)
	{
		Person person = null;
		do
		{
			String name = getString(promt);
			for(Person p : persons)
			{
				if(name.equals(p.getName()))
				{
					person = p;
					break;
				}
			}
			if(person == null)
			{
				showMessage("Ingen person med det namnet", "Error!");
			}
		}
		while(person == null);
		
		return person;
	}
	private void registerPerson()
	{
		try
		{
			boolean error = false;
			do
			{
				String name = getString("Namn: ");
				error = personExist(name);
				
				if(error)
				{
					showMessage("En person med samma namn finns redan", "Error!");
				}
				else
				{
					Person p = new Person(name);
					persons.add(p);
					showMessage("Personen "+ name + " skapades","");
				}
			}
			while(error);
			
		}
		catch(IllegalArgumentException e)
		{
			showMessage("Avbryter", "");
		}
		
	}
	private void showAll()
	{
		String text = "";
		for(Person p : persons)
		{
			text += p.getName() + "\t\t" + p.getTotalValue() + "\n";
		}
		JOptionPane.showMessageDialog(null, new TextArea("I registret finns: \n\n" + text), "Alla personer", 1);
	}
	private void showMessage(String message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, 1);
	}
	private String menu()
	{
		return JOptionPane.showInputDialog(null, "1.Skapa person\n" +
												 "2.Skapa pryl\n" +
												 "3.Visa alla\n" +
												 "4.Visa rikaste\n" +
												 "5.Visa viss person\n" +
												 "6.Börskrash\n" +
												 "7.Ta bort person\n" +
												 "8.Ta bort pryl\n" +
												 "9.Avsluta", "Meny", 1);
	}
	private void showRichestPerson()
	{
		if(!persons.isEmpty())
		{
			Person richest = null;
			for(Person p : persons)
			{
				Person temp = p;
				if(richest == null)
				{
					richest = temp;
				}
				else if(richest.getTotalValue() < temp.getTotalValue())
				{
					richest = temp;
				}
			}
			String text = "Rikast är " + richest.getName() + " som sammanlagt äger " + richest.getTotalValue() + "\n\n" +
						  richest.getAllItemsInfo(false);
			JOptionPane.showMessageDialog(null, new TextArea(text), "", 1);
		}
		else
		{
			showMessage("Finns inga personer", "");
		}
	}
	private void showPerson()
	{
		if(!persons.isEmpty())
		{
			try
			{
				Person p = getPerson("Vilken person:");
				String text = "Personen " + p.getName() + " som sammanlagt äger " + p.getTotalValue() + "\n\n" +
														  p.getAllItemsInfo(false);
				JOptionPane.showMessageDialog(null, new TextArea(text), "", 1);
			}
			catch(IllegalArgumentException e)
			{
				showMessage("Avbryter", "");
			}
		}
		else
		{
			showMessage("Finns inga personer", "");
		}
	}
	private String getString(String promt) throws IllegalArgumentException
	{
		String s = "";
		do
		{
			s = JOptionPane.showInputDialog(null, promt, "", 1);
			if(s == null)
			{
				throw new IllegalArgumentException("avbröt");
			}
			if(s.trim().equals(""))
			{
				showMessage("Du måste skriva in något!", "Error!");
			}
		}
		while(s.trim().equals(""));
		System.out.println(promt + "" + s);
		
		return s;
	}
	private int getInt(String promt) throws IllegalArgumentException
	{
		boolean error = false;
		int v = 0;
		do
		{
			try
			{
				error = false;
				String s = JOptionPane.showInputDialog(null, promt, "", 1);
				if(s == null)
				{
					throw new IllegalArgumentException("avbröt");
				}
				v = Integer.parseInt(s);
				if(v < 0)
				{
					error = true;
					showMessage("Talet måste vara positivt", "Error!");
				}
			}
			catch(NumberFormatException e)
			{
				showMessage("Skriv in ett nummer", "Error!");
				error = true;
			}
		}
		while(error);
		
		System.out.println(promt + "" + v);
		return v;
	}
	private void saveData()
	{
		try
		{
			FileOutputStream fil = new FileOutputStream("RegistryData.obj");
			ObjectOutputStream out = new ObjectOutputStream(fil);
			out.writeObject(persons);
			out.close();
		}
		catch (IOException e)
		{
			
		}
	}
	@SuppressWarnings("unchecked")
	private void loadData()
	{
		try
		{
			FileInputStream fil = new FileInputStream("RegistryData.obj");
			ObjectInputStream in = new ObjectInputStream(fil);
			persons = (ArrayList<Person>) in.readObject();
			in.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Registry r = new Registry();
	}
}
