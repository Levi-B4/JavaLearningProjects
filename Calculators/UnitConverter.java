import java.util.Scanner;

public class UnitConverter {
    double gallonsInOneLiter = 0.264172;
    double litersInOneGallon = 3.78541;
    double milesInOneKilometer = 0.621;
    double kilometersInOneMile = 1.609;

    UnitConverter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to convert?" +
            "\n1: Gallons to Liters" +
            "\n2: Liters to Gallons" +
            "\n3: Miles to Kilometers" +
            "\n4: Kilometers to Miles");
        int conversionChoice = sc.nextInt();

        switch (conversionChoice) {
            case 1:
                System.out.println("How many gallons?");
                double gallons = sc.nextDouble();
                System.out.println(gallons + " gallons is " + (gallons * gallonsInOneLiter) + " liters");
                break;
            case 2:
                System.out.println("How many liters?");
                double liters = sc.nextDouble();
                System.out.println(liters + " liters is " + (liters * litersInOneGallon) + " gallons");
                break;
            case 3:
                System.out.println("How many miles?");
                double miles = sc.nextDouble();
                System.out.println(miles + " miles is " + (miles * milesInOneKilometer) + " kilometers");
                break;
            case 4:
                System.out.println("How many kilometers?");
                double kilometers = sc.nextDouble();
                System.out.println(kilometers + " kilometers is " + (kilometers * kilometersInOneMile) + " miles");
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }

        sc.close();
    }
}
