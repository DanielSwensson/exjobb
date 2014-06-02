import java.io.*;
public class ObjectFileHelper{
	public void writeObject(String filename, Object o){
		try{
			FileOutputStream fil = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fil);
			out.writeObject(o);
		}
		catch (IOException e){
			System.exit(1);
		}
	}
	public Register readObject(String filename){
		Register o = null;;
		try{
			FileInputStream fil = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fil);
			o = (Register)in.readObject();
		}
		catch(FileNotFoundException e) {
			System.out.println("No data file found. Creating new register.");
			o =  new Register();
		}

		catch(IOException e){
			System.out.println("IOException");
			System.exit(2);
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
			System.exit(3);
		}
		return o;
	}
}
