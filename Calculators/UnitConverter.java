import java.util.Scanner;

public class UnitConverter {
    double gallonsInOneLiter = 0.264172;
    double litersInOneGallon = 3.78541;
    double milesInOneKilometer = 0.621;
    double kilometersInOneMile = 1.609;

    String[] units = {"liters", "gallons", "kilometers", "miles"};
    double[] unitConversionRates = {gallonsInOneLiter, litersInOneGallon, milesInOneKilometer, kilometersInOneMile};

    UnitConverter() {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < units.length; i++) {
            String fromUnit = units[i];
            String toUnit = i%2 == 0 ? units[i+1] : units[i-1];
            double conversionRate = unitConversionRates[i];
            double value = 0.0;

            boolean validInput = false;

            while(!validInput){
                System.out.printf("%d. %s to %s:\n" +
                                    "Please enter a value for %s: ", i + 1, fromUnit, toUnit, fromUnit);
                try {
                    value = Integer.parseInt(sc.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("\nPlease enter a valid number");
                }
            }
            printConversion(fromUnit, toUnit, value, conversionRate);
        }

        sc.close();
    }

    public void printConversion(String fromUnit, String toUnit, double value, double conversionRate) {
        System.out.printf("%,.2f %s = %,.2f %s\n\n", value, fromUnit, (value * conversionRate), toUnit);
    }
}
