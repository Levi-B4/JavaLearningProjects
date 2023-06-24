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
            if(row.equals("A")){
                reservationCost = makeReservation(rowASeats, rowAPrices, row, sc);
            } else{
                reservationCost = makeReservation(rowBSeats, rowBPrices, row, sc);
            }
            total += reservationCost;
            System.out.printf("Current Total Cost: $%.2f\n", total);
            System.out.println("-------");
        }

        printReceipt(numSeats, total);

        sc.close();
    }

    public static void display(String[] rowASeats, String[] rowBSeats, 
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

    public static String getRow(Scanner scan) {
        System.out.println("Would you like row A or Row B");
        String row = scan.nextLine();
        while(true){
            if(row.toUpperCase().equals("A") || row.toUpperCase().equals("B")){
                break;
            }
            System.out.println("Please enter your desired row (A, B)");
            row = scan.nextLine();
        }
        return row.toUpperCase();
    }
    
    public static double makeReservation(String[] rowSeats, double[] rowPrices, String row, Scanner scan) {
        printRowSeats(rowSeats, 32);
        printRowPrices(rowPrices, 32);

        //get seat selection
        System.out.println("Which seat would you like? (1, 2, 3)");
        String seatNumString = "";
        while(true){
            seatNumString = scan.nextLine();
            if((seatNumString.equals("1")) || (seatNumString.equals("2")) || (seatNumString.equals("3"))) break;
            System.out.println("Please enter a valid seat number (1, 2, 3)");
        }
        int seatNum = Integer.parseInt(seatNumString);
        double seatCost = rowPrices[seatNum - 1];
        System.out.printf("You chose seat %s\n", seatNum);
        System.out.printf("The price of the seat is: $%.2f\n", seatCost);

        System.out.println("Updated Row Chart:");
        updateSeatingChart(rowSeats, seatNum);

        printRowSeats(rowSeats, 32);
        printRowPrices(rowPrices, 32);

        return seatCost;
    }

    public static void updateSeatingChart(String[] rowSeats, int seatNum){
        rowSeats[seatNum - 1] = "X";
    }

    public static void printReceipt(int numSeats, double total) {
        double feePerSeat = 14.99;
        double fees = numSeats * feePerSeat;
        double taxes = 16.99; //tax percent wasn't given so I just used flat number in example
        double grandTotal = total + fees + taxes;
        
        System.out.printf(
        "Thank you for reserving with us. Here's your receipt:\n" + 
        "-----------------------------------------------------\n" +
        "Subtotal: $%.2f\n" +
        "Fees: %d x $%.2f = $%.2f\n" +
        "Taxes: $%.2f\n" +
        "=====================================================\n" +
        "Total: $%.2f\n" +
        "-----------------------------------------------------\n", total, numSeats, feePerSeat, fees, taxes, grandTotal);
    }


}