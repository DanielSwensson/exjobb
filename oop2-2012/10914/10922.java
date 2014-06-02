import java.util.ArrayList;

public abstract class StockMarketHandler {
	public static void stockMarketCrash(PersonRegister persons) {
		for(Person person : persons.getAllPersons()) {
			ArrayList<Item> itemList = person.getItems();
			for(Item item : itemList) {
				if(item instanceof Share) {
					((Share) item).setPrice(0.0);
				}
			}
		}
	}
}
