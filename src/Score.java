//package skeletonCodeAssgnmt2;
/**
* Class for generating the score of the game
*/
public class Score {
	private int missedWords;
	private int caughtWords;
	private int gameScore;
	/**
   * Default constructor
   */
	public Score() {
		missedWords=0;
		caughtWords=0;
		gameScore=0;
	}
		
	// all getters and setters must be synchronized
	/**
   * Method for returning missed words
   * @return int missed words
   */
	public int getMissed() {
		return missedWords;
	}
   /**
   * Method for returning caught words
   * @return int caught words
   */
	public int getCaught() {
		return caughtWords;
	}
	/**
   * Method for returning total words
   * @return int total words
   */
	public int getTotal() {
		return (missedWords+caughtWords);
	}
   /**
   * Method for returning the game score
   * @return int gameScore
   */
	public int getScore() {
		return gameScore;
	}
	/**
   * Method for incrementing missed words counter
   */
	public void missedWord() {
		missedWords++;
	}
   /**
   * Method for incrementing caught words counter
   */
	public void caughtWord(int length) {
		caughtWords++;
		gameScore+=length;
	}
   /**
   * Method for reseting the score(all counters)
   */
	public void resetScore() {
		caughtWords=0;
		missedWords=0;
		gameScore=0;
	}
}
