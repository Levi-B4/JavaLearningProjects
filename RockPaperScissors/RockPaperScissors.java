import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors{
    public static void main(String[] args) {

        int playerInput = getPlayerInput();
        int computerInput = getComputerInput();

        int winner = determineWinner(playerInput, computerInput);

        diplayWinner(winner);
    }

    //get user input
    public static int getPlayerInput(){
        Scanner s = new Scanner(System.in);

        System.out.println("Lets play Rock Paper Scissors!");
        System.out.println("\t1 = Rock\n\t2 = Paper\n\t3 = Scissors");
        System.out.println("Please select a number (1/2/3):");

        int playerChoice = s.nextInt();

        while(true){
            //Tell user their selection
            if(playerChoice == 1){
                System.out.println("\tYou chose Rock!");
                break;
            }
            else if(playerChoice == 2){
                System.out.println("\tYou chose Paper!");
                break;
            }
            else if(playerChoice == 3){
                System.out.println("\tYou chose Scissors!");
                break;
            }

            //Tell user to correct option 1 / 2 / 3
            else{
                System.out.println("Please enter a valid option (1/2/3)");
                playerChoice = s.nextInt();
            }
        }
        s.close();
        return playerChoice;
    }

    public static int getComputerInput(){
        //Genereate Computer move (random)
        Random rand = new Random();
        int computerChoice = rand.nextInt(2) + 1;

        //Tell user computer selection
        if(computerChoice == 1){
            System.out.println("\tComputer chose Rock!");
        }
        else if(computerChoice == 2){
            System.out.println("\tComputer chose Paper!");
        }
        else{
            System.out.println("\tComputer chose Scissors!");
        }

        return computerChoice;
    }

    public static int determineWinner(int playerChoice, int computerChoice){
        int winner;
        if(playerChoice == 1){
            if(computerChoice == 1){
                winner = 0;
            }
            else if(computerChoice == 2){
                winner = 2;
            }
            else{
                winner = 1;
            }
        }
        else if(playerChoice == 2){
            if(computerChoice == 1){
                winner = 1;
            }
            else if(computerChoice == 2){
                winner = 0;
            }
            else{
                winner = 2;
            }
        }
        else{
            if(computerChoice == 1){
                winner = 2;
            }
            else if(computerChoice == 2){
                winner = 1;
            }
            else{
                winner = 0;
            }
        }

        return winner;
    }

    public static void diplayWinner(int winner) {
        if(winner == 1){
            System.out.println("You Win!");
        }
        else if(winner == 2){
            System.out.println("You Lost!");
        }
        else{
            System.out.println("No one won!");
        }
    }
}