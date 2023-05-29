//package skeletonCodeAssgnmt2;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
* WordPanel class that inherits the JPanel component and implements the Runnable interface
*/
public class WordPanel extends JPanel implements Runnable {
		public static volatile boolean done;
		private WordRecord[] words;
		private int noWords;
		private int maxY;
      private final int fps = 25;
      private final int fallingSpeed = 3;
      static int speed;
		/**
      * Method for painting the window with words
      */
		public void paintComponent(Graphics g) {
		    int width = getWidth();
		    int height = getHeight();
		    g.clearRect(0,0,width,height);
		    g.setColor(Color.red);
		    g.fillRect(0,maxY-10,width,height);

		    g.setColor(Color.black);
		    g.setFont(new Font("Helvetica", Font.PLAIN, 26));
		   //draw the words
		   //animation must be added 
		    for (int i=0;i<noWords;i++){	    	
		    	//g.drawString(words[i].getWord(),words[i].getX(),words[i].getY());	
		    	g.drawString(words[i].getWord(),words[i].getX(),words[i].getY()+20);  //y-offset for skeleton so that you can see the words	
		    }
		   
		  }
		
		WordPanel(WordRecord[] words, int maxY) {
			this.words=words; //will this work?
			noWords = words.length;
			done=false;
			this.maxY=maxY;
			speed = 1000;		
		}
		/**
      * Overidden method of the Runnable interface for parallelizing the game
      */
		public void run() {
			//add in code to animate this
         //WordApp app = new WordApp();
         while(!done){
            try{
               Thread.sleep(speed);
               
            }
            catch(Exception e){
            
            }
            
            for(int i=0; i<words.length;i++){
               float d = (words[i].getSpeed()/fps)/fallingSpeed;
               words[i].drop((int)Math.ceil(d));
               repaint();
               
               if(words[i].dropped()){
                  WordApp a = new WordApp();
                  a.music();
                  words[i].resetWord();
                  WordApp.score.missedWord();
                  WordApp.missed.setText("Missed:"+WordApp.score.getMissed()+" ");
               }
               
            }
             if(WordApp.totalWords == WordApp.score.getTotal()){
                  done = true;
                  JFrame frame = new JFrame();
                  WordApp obj = new WordApp();
                  
                  //WordApp.startB.setEnabled(true);String message = "   Game Over!\n"+"   Total Words: "+score.getTotal()+"\n   Caught: "+score.getCaught()+"\n   Missed: "+score.getMissed()+"\n   Would You Like To Play Again?";
               //JOptionPane result= new JOptionPane();
                  String message = "   Game Over!\n"+"   Total Words: "+obj.score.getTotal()+"\n   Caught: "+obj.score.getCaught()+"\n   Missed: "+obj.score.getMissed()+"\n   Would You Like To Play Again?";
                  int result = JOptionPane.showConfirmDialog(frame, message,"Game Over",JOptionPane.YES_NO_OPTION);
                  for(int i =0;i<words.length;i++){
                        words[i].resetWord();
                  }
                  if( result == JOptionPane.YES_OPTION){
                  
                     obj.score.resetScore();
                     obj.missed.setText("Missed:"+WordApp.score.getMissed()+"    ");
                     obj.caught.setText("Caught: "+WordApp.score.getCaught()+"    ");
                     obj.scr.setText("Score:" + obj.score.getScore()+"    ");
                     obj.startB.setEnabled(true);
                     for(int i =0;i<words.length;i++){
                        words[i].resetWord();
                        repaint();
                     }
                     
                     
                  }
                  else if(result == JOptionPane.NO_OPTION){
                     System.exit(0);
                  }

              }
         }
		}

	}


