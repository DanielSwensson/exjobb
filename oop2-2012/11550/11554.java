import java.io.*;
import java.util.ArrayList;

public class FileHandler {
	
	//Writing record to file
	public void saveToFile(String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(AddTo.all);
		}
		catch (IOException e) {
			System.exit(1);
		}
	}
	
	//Loading record from file
	public void getFromFile(String fileName) {
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			AddTo.all = (ArrayList<Person>)in.readObject();
		}
		
		catch (FileNotFoundException e) {
		}
		
		catch (IOException e) {
		}
		
		catch (ClassNotFoundException e) {
			System.exit(3);	
		}
	}
	
}
