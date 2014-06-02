import java.io.*;
public class Main {
	public Main(){
	}
	public static void main(String[] args){
		String filename = "oror7050_register.fil";
		ObjectFileHelper helper = new ObjectFileHelper();
		Register register = helper.readObject(filename);
		register.run();
		helper.writeObject(filename, register);
	}

}
