import java.util.Scanner;

public class UnitConverter {
    double gallonsInOneLiter = 0.264172;
    double litersInOneGallon = 3.78541;
    double milesInOneKilometer = 0.621;
    double kilometersInOneMile = 1.609;

    UnitConverter() {

        Scanner sc = new Scanner(System.in);



        System.out.print("1. liters to gallons:\n" +
                                "Please enter a value for liters: ");
        double liters = sc.nextDouble();
        System.out.printf("%,.2f liters = %,.2f gallons\n\n", liters, (liters * gallonsInOneLiter));

        System.out.print("1. gallons to liters:\n" +
                                "Please enter a value for gallons: ");
        double gallons = sc.nextDouble();
        System.out.printf("%,.2f gallons = %,.2f liters\n\n", gallons, (gallons * litersInOneGallon));
        
        System.out.print("1. km to miles:\n" +
                                "Please enter a value for kilometers: ");
        double kilometers = sc.nextDouble();
        System.out.printf("%,.2f kilometers = %,.2f miles\n\n", kilometers, (kilometers * milesInOneKilometer));

        System.out.print("1. miles to km:\n" +
                                "Please enter a value for miles: ");
        double miles = sc.nextDouble();
        System.out.printf("%,.2f miles = %,.2f kilometers\n\n", miles, (miles * kilometersInOneMile));


        sc.close();
    }
}
