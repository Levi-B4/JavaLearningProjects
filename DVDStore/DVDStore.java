import java.util.Scanner;

public class DVDStore{
    //instantiate store
    static int numOfDVDs = 10;
    static double cashAmount = 100;

    public static void main(String[] args){
        int menuSelection;
        Scanner scanner = new Scanner(System.in);

        //run store loop until user selects exit
        do{
            menuSelection = displayMenu(scanner);
            //do user selected option
            processMenuSelection(menuSelection, scanner);
        }while(menuSelection != 9);
        scanner.close(); 
    }

    private static int displayMenu(Scanner sc) {
        System.out.println("Welcome to DVDs R Us. Please choose from the options below:\n" +
                "1 - Buy DVDs\n" +
                "2 - Sell DVDs\n" +
                "3 - Check how many DVDs we have in stock\n" +
                "4 - Check how much cash we have\n" +
                "9 - Exit the program\n" +
                "Enter Option:");
        int userInput = 0;
        //verify user input
        while(true){
            if(sc.hasNextInt()){
                userInput = sc.nextInt();
                if(userInput >= 1 && userInput <= 4 || userInput == 9)
                    break;
            }
            else{
                sc.next();
            };
            System.out.println("Please enter a valid number (1,2,3,4,9)");
        }
        return userInput;
    }

    private static void processMenuSelection(int selection, Scanner sc) {
        switch (selection) {
            case 1:
                BuyDVD(sc);
                getInventory(numOfDVDs, cashAmount);
                break;

            case 2:
                SellDVD(sc);
                getInventory(numOfDVDs, cashAmount);
                break;

            case 3:
                getNumberOfDVDs(numOfDVDs);
                break;

            case 4:
                getCashOnHand(cashAmount);
                break;

            default:
                System.out.println("Thank you for shopping with us! Please return soon!");
                break;
        }
    }

    private static void BuyDVD(Scanner sc) {
        System.out.println("How many DVDs do you want to buy?");
        int numberToBuy = 0;
        //verify user input
        while(true){
            if(sc.hasNextInt()){
                numberToBuy = sc.nextInt();
                break;
            }
            else{
                sc.next();
            }
            System.out.println("Please enter a number of DVDs to buy.");
        }
        if(numberToBuy * 9 <= cashAmount){
            numOfDVDs += numberToBuy;
            cashAmount -= numberToBuy * 9;
        }else{
            System.out.println("You do not have enough money for this transaction");
        }
    }
    
    private static void SellDVD(Scanner sc) {
        System.out.println("How many DVDs do you want to sell?");
        int numberToSell = 0;
        //verify user input
        while(true){
            if(sc.hasNextInt()){
                numberToSell = sc.nextInt();
                break;
            }
            else{
                sc.next();
            }
            System.out.println("Please enter a number of DVDs to sell.");
        }
        if(numberToSell <= numOfDVDs){
            numOfDVDs -= numberToSell;
            cashAmount += numberToSell * 10;
        }else{
            System.out.println("You do not have enough DVDs for this transaction");
        }
    }
    
    private static void getInventory(int DVDCount, double cashCount){
        getNumberOfDVDs(DVDCount);
        getCashOnHand(cashCount);
    }

    private static void getNumberOfDVDs(int DVDCount) {
        System.out.printf("Number of DVDs: %d\n", DVDCount);
    }

    private static void getCashOnHand(double CashCount) {
        System.out.printf("Cash available: $%.2f\n", CashCount);
    }
}