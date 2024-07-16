import java.util.Random;
import java.util.Scanner;


public class NumberGame {
class Game{
    public int computerNumber;
    public int userNumber;
    public int noOfGuesses = 0;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    Game(){
        Random rand = new Random();
        this.computerNumber = rand.nextInt(100);
    }
    void takeUserInput(){
        System.out.println("Guess the number");
        Scanner sc = new Scanner(System.in);
        userNumber = sc.nextInt();
    }
    boolean isCorrectNumber(){
        noOfGuesses++;
        if (userNumber==computerNumber){
            System.out.format("Yeee......you guessed it right, it was %d\nYou guessed it in %d attempts", computerNumber, noOfGuesses);
            return true;
        }
        else if(userNumber<computerNumber){
            System.out.println("Too low...");
        }
        else if(userNumber>computerNumber){
            System.out.println("Too high...");
        }
        return false;
    }

}
    public static void main(String[] args) {
        NumberGame ng = new NumberGame();
        Game g = ng.new Game();
        boolean b = false;
        while(!b){
        g.takeUserInput();
        b = g.isCorrectNumber();
        }
    }
}






















