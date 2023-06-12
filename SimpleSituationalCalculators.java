import java.util.Scanner;

public class SimpleSituationalCalculators {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which calculator would you like to use?" + 
            "\n1: Compound Interest Calculator" +
            "\n2: Fibonacci Calculator" +
            "\n3: Unit Converter" +
            "\n4: World Population Calculator");
        int calculatorChoice = sc.nextInt();

        switch (calculatorChoice) {
            case 1:
                CompoundInterestCalculator compoundInterestCalculator = new CompoundInterestCalculator();
                break;
            case 2:
                FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
                break;
            case 3:
                UnitConverter unitConverter = new UnitConverter();
                break;
            case 4:
                WorldPopulationCalculator worldPopulationCalculator = new WorldPopulationCalculator();
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }

        sc.close();
    }


    
}