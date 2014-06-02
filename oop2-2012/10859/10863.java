package pr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SaveLoad {
    private String savePath;//

    // konstruktorn
    SaveLoad(String savePath) {
	this.savePath = savePath;
    }

    public void Save(ArrayList<Person> perrsonArray) {
	try {

	    OutputStream fil = new FileOutputStream(savePath);
	    OutputStream buffert = new BufferedOutputStream(fil);
	    ObjectOutput output = new ObjectOutputStream(buffert);
	    try {
		output.writeObject(perrsonArray);
		System.out.println("Sparat!");
	    } finally {
		output.close();
	    }
	} catch (IOException e) {
	    System.out.println(e);
	}
    }

    public ArrayList<Person> Load() {
	ArrayList<Person> aterskapadeArray = null;
	try {
	    InputStream fil = new FileInputStream(savePath);
	    InputStream buffert = new BufferedInputStream(fil);
	    ObjectInput input = new ObjectInputStream(buffert);
	    try {
		aterskapadeArray = (ArrayList<Person>) input.readObject();
		System.out.println("Laddat!");
	    } finally {
		input.close();
	    }
	} catch (ClassNotFoundException e) {
	} catch (IOException e) {
	}
	return aterskapadeArray;
    }

}
