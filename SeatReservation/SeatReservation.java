import java.net.DatagramSocketImplFactory;
import java.util.Scanner;

import javax.swing.RowSorter;

public class SeatReservation{
    public static void main(String[] args){
        //Seats
        String[] rowASeats = new String[]{"1A", "2A", "3A"};
        String[] rowBSeats = new String[]{"1B", "2B", "3B"};

        //Seat Prices
        double[] rowAPrices = new double[]{99.99, 110.99, 99.99};
        double[] rowBPrices = new double[]{75.99, 85.99, 75.99};
    
        double total = 0;

        display(rowASeats, rowBSeats, rowAPrices, rowBPrices);
        
        //get user reservation count
        System.out.println("How many seats do you want to reserve?");
        int numSeats = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            if(sc.hasNextInt()){
                numSeats = sc.nextInt();
                break;
            } else{
                sc.nextLine();
                System.out.println("Please enter an integer for how many seats to reserve.");
            }
        }

        //Reserve user's seats
        double reservationCost = 0;
        for(int i = 0; i < numSeats; i++){
            String row = getRow(sc);
            if(row == "A"){
                reservationCost = makeReservation(rowASeats, rowAPrices);
            } else if(row == "B"){
                reservationCost = makeReservation(rowBSeats, rowBPrices);
            }
            total += reservationCost;
            System.out.printf("Current Total Cost: $%.2f", total);
        }

        printReceipt();

        sc.close();
    }

    private static void display(String[] rowASeats, String[] rowBSeats, 
                                double[] rowAPrices, double[] rowBPrices) {
        System.out.println("Welcome to our event! Here's our seating chart with prices:\nSteating Chart");

        //Create display borders
        String displayEdge = "";
        String displayRowSeperator = "";
        int displayWidth = 32;
        displayWidth -= (displayWidth - 2) % rowASeats.length; //adjust width down so that outputs are evenly spaced
        for(int i = 0; i < displayWidth; i ++){
            displayEdge += "=";
            displayRowSeperator += "=";
        }


        System.out.println(displayEdge);
        printRowSeats(rowASeats, displayWidth);
        printRowPrices(rowAPrices, displayWidth);
        System.out.println(displayRowSeperator);
        printRowSeats(rowASeats, displayWidth);
        printRowPrices(rowAPrices, displayWidth);
        System.out.println(displayEdge);
    }

    public static void printRowSeats(String[] rowSeats, int displayWidth){
        String output = "";
        output += "|";
        for (String seat : rowSeats) {
            output += String.format("%-" + (displayWidth / rowSeats.length) + "s", seat);
        }
        output += "|";
        
        System.out.println(output);
    }
    
    public static void printRowPrices(double[] rowPrices, int displayWidth){
        String output = "";
        output += "|";
        for (double price : rowPrices) {
            output += String.format("$%-" + ((displayWidth / rowPrices.length) - 1) + ".2f", price);
        }
        output += "|";
        
        System.out.println(output);
    }

    private static String getRow(Scanner scan) {
        String row = "";
        System.out.println("Would you like row A or Row B");
        while(true){
            row = scan.nextLine();
            if(row.toLowerCase() == "a" || row.toLowerCase() == "b"){
                return row.toUpperCase();
            }
            System.out.println("Please enter your desired row (A, B)");
        }
    }
    
    private static double makeReservation(String[] rowASeats, double[] rowAPrices) {
        return 0;
    }

    private static void printReceipt() {
    }


}