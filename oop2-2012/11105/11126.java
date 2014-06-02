import java.util.ArrayList;

public class WordList {

	private ArrayList<String> wordList = new ArrayList<String>();
	private String commandType;

	public WordList(String commandType, String[] synonyms) {

		for (int i = 0; i < synonyms.length; i++){
			wordList.add(synonyms[i]);
		}
		this.commandType = commandType;


	}
	
	public WordList(String[] synonyms) {

		for (int i = 0; i < synonyms.length; i++){
			wordList.add(synonyms[i]);
		
		}
		commandType = " ";

	}
	public String returnSynonym(String word){
		for (int i = 0; i < wordList.size(); i++){
			if (word.equalsIgnoreCase(wordList.get(i)))
				return commandType;
			}
		return "";
		
	}
	
	public boolean checkIfSynonym(String word){
		for (int i = 0; i < wordList.size(); i++){
			if (word.equalsIgnoreCase(wordList.get(i)))
				return true;
			}
		return false;
		
	}
	

	public String getWord(int index) {

		String word = wordList.get(index);

		return word;
	}

	public int getSize() {

		return wordList.size();
	}
	
	

}
