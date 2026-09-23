/*
Gregory Blatt
CS2100

This program will play through the Dollar Game between two players.
The first player to reach 100 wins the game. If any players score
exceeds 100 their score gets reset to zero.
*/



public class DollarGame{
   public static void main(String[]args){
      //player one coins and score
      Coin nickel1 = new Coin(5);
      Coin dime1 = new Coin(10);
      Coin quarter1 = new Coin(25);
      int score1 =0;
      
      //player two coins and score
      Coin nickel2 = new Coin(5);
      Coin dime2 = new Coin(10);
      Coin quarter2 = new Coin(25);
      int score2 = 0;
      
      
      
      //playing the game
      boolean winner = false;
      int round=1;
      while(!winner){
         //Coins being processed
         score1 += processOneCoin(nickel1);
         score2 += processOneCoin(nickel2);
         
         score1 += processOneCoin(dime1);
         score2 += processOneCoin(dime2);
         
         score1 += processOneCoin(quarter1);
         score2 += processOneCoin(quarter2);
         
         //print out rounds.
         System.out.printf("Round %d:Player 1: %d, Player 2: %d\n",round,score1,score2);
         //reset a player if score is over 100
         if(score1 >100){
            System.out.println("Resetting player 1 to 0");
            score1 =0;
         }
         if(score2 >100){
            System.out.println("Resetting player 2 to 0");
            score2=0;
         }
         
         //print winner/tie.
         if(score1 ==100 && score2==100){
            System.out.println("It's a tie");
            winner = true;
         }
         else if(score1==100){
            System.out.println("Player 1 wins");
            winner = true;
         }
         else if(score2==100){
            System.out.println("Player 2 wins");
            winner = true;
         }
         
         //increment round
         round++;
      }
      
   }
   
   /**
    processOneCoin tosses the Coin and returns the Coin value
    *if* it is heads up. Otherwise, 0 is returned
    @param c the Coin object to be tossed
    @return the value of the coin if heads is up, 0 otherwise
   */
   public static int processOneCoin(Coin c){
      c.toss();
      if(c.isHeads()){
         return c.getValue();
      }
      return 0; 
   }
}