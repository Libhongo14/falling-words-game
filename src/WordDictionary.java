//package skeletonCodeAssgnmt2;
/**
* WordDictionary class for generating the dictionary of words that will be used by the game
* There is a built in dictionary of word for in case the file is not found
*/
public class WordDictionary {
	int size;
	static String [] theDict= {"litchi","banana","apple","mango","pear","orange","strawberry",
		"cherry","lemon","apricot","peach","guava","grape","kiwi","quince","plum","prune",
		"cranberry","blueberry","rhubarb","fruit","grapefruit","kumquat","tomato","berry",
		"boysenberry","loquat","avocado"}; //default dictionary
	/**
   * Constructor taking in an array
   * @param temporary array
   */
	WordDictionary(String [] tmp) {
		size = tmp.length;
		theDict = new String[size];
		for (int i=0;i<size;i++) {
			theDict[i] = tmp[i];
		}
		
	}
	/**
   * No argument constructor
   */
	WordDictionary() {
		size=theDict.length;
		
	}
	/**
   * Method for getting a new word
   * @return word of type String
   */
	public synchronized String getNewWord() {
		int wdPos= (int)(Math.random() * size);
		return theDict[wdPos];
	}
}
