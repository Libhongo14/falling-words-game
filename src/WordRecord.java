//package skeletonCodeAssgnmt2;
/**
* WordRecord class for updating the counters of missed, caught and score
*/
public class WordRecord {
	private String text;
	private  int x;
	private int y;
	private int maxY;
	private boolean dropped;
	
	private int fallingSpeed;
	private static int maxWait=1500;
	private static int minWait=100;

	public static WordDictionary dict;
	

	/**
   * Default constructor
   */
	WordRecord() {
		text="";
		x=0;
		y=0;	
		maxY=300;
		dropped=false;
		fallingSpeed=(int)(Math.random() * (maxWait-minWait)+minWait); 
	}
	/**
   * Second constructor that takes in a text
   * @param text
   */
	WordRecord(String text) {
		this();
		this.text=text;
	}
	/**
   * Constructor that takes in the text, x coordinate and the maximum y coordinate
   */
	WordRecord(String text,int x, int maxY) {
		this(text);
		this.x=x;
		this.maxY=maxY;
	}
	
// all getters and setters must be synchronized
   /**
   * set method for updating the y intercept
   * @param y intercept
   */
	public synchronized  void setY(int y) {
		if (y>maxY) {
			y=maxY;
			dropped=true;
		}
		this.y=y;
	}
	/**
   * set method for updating the x intercept
   * @param x intercept
   */
	public synchronized  void setX(int x) {
		this.x=x;
	}
	/**
   * setWord method for updating the word
   *@param text
   */
	public synchronized  void setWord(String text) {
		this.text=text;
	}
   /**
   * get method for returning the word
   * @return text
   */
	public synchronized  String getWord() {
		return text;
	}
	/**
   * get method for returning the x coordinate
   * @return x
   */
	public synchronized  int getX() {
		return x;
	}	
	/**
   *get method for returning the y coordinate
   * @return y
   */
	public synchronized  int getY() {
		return y;
	}
	/**
   * get method for returning the speed
   * @return fallingSpeed
   */
	public synchronized  int getSpeed() {
		return fallingSpeed;
	}
   /**
   * set method for updating the position
   * @param x,y
   */
	public synchronized void setPos(int x, int y) {
		setY(y);
		setX(x);
	}
   /**
   * Method for reseting the y position
   */
	public synchronized void resetPos() {
		setY(0);
	}
   /**
   * Method for reseting the word
   */
	public synchronized void resetWord() {
		resetPos();
		text=dict.getNewWord();
		dropped=false;
		fallingSpeed=(int)(Math.random() * (maxWait-minWait)+minWait); 
		//System.out.println(getWord() + " falling speed = " + getSpeed());

	}
	/**
   * Method for checking whether a typed word matches one in the wordDictionary array
   * @param typedText
   * @return boolean
   */
	public synchronized boolean matchWord(String typedText) {
		//System.out.println("Matching against: "+text);
		if (typedText.equals(this.text)) {
			resetWord();
			return true;
		}
		else
			return false;
	}
	
   /**
   * Method for dropping a word
   * @param inc
   */
	public synchronized  void drop(int inc) {
		setY(y+inc);
	}
	/**
   * Method for checking whether a word is dropped
   *@return boolean
   */
	public synchronized  boolean dropped() {
		return dropped;
	}

}
