import java.util.ArrayList;

public class Register
{
    private ArrayList<Person> allPersons;

    public Register() {
        allPersons = new ArrayList<Person>();
    }

    public boolean addPerson(String name) {
        for (Person p : allPersons) {
            if(p.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }

        Person p = new Person(name);
        allPersons.add(p);
        return true;
    }
   
    public boolean printPerson(String name) {
        Person p = getPerson(name);
        
        if (p == null) {
            return false;
        }
        
        p.list();
        return true;
    }
    
    public boolean printRichest() {
        Person richestPerson = null;
        int richest = 0; 
        
        if(allPersons.isEmpty()) {
            return false;
        }
        for(Person p : allPersons) {
            if(p.total() >= richest) {
                richestPerson = p;
                richest = p.total();
            }
        }
        
        richestPerson.list();
        return true;
    }
    
    public boolean findPerson(String name) {
        for(Person p : allPersons) {
            if(name.equalsIgnoreCase (p.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public Person getPerson(String name) {
        for(Person p : allPersons) {
            if (name.equalsIgnoreCase (p.getName())) {
                return p;
            } 
        }
        return null;
    }
    
    public void crashMarket(int change) {
        for(Person p : allPersons) {
            p.setShareholdingValue(change);
        }
    }
    
    public void list() {
        for(Person p : allPersons) {
            System.out.println("----------------------------");
            p.list();
        }
    }
}
