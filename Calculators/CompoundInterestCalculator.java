import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.Math;

public class CompoundInterestCalculator {
    
    BigDecimal principleInvestment;
    double interestRate;
    int compoundsPerYear;
    int years;
    BigDecimal finalValue;
    BigDecimal totalInterest;

    CompoundInterestCalculator(){
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the initial deposit or loan?");
        principleInvestment = sc.nextBigDecimal();

        System.out.println("What is the interest rate?(In percentage)");
        interestRate = sc.nextDouble()/100;

        System.out.println("How often per year is it compounded");
        compoundsPerYear = sc.nextInt();

        System.out.println("How many years is the money gaining interest?");
        years = sc.nextInt();

        finalValue = calculateCompoundInterest(principleInvestment, interestRate, compoundsPerYear, years);
        totalInterest = finalValue.subtract(principleInvestment);

        System.out.printf("Amount Earned (A) : %s\n", finalValue);
        System.out.printf("Total Interest Earned: %s\n", totalInterest);

        sc.close();
    }

    public BigDecimal calculateCompoundInterest(BigDecimal principleInvestment, double interestRateInDecimal, int compoundsPerYear, int years)
    {
        //Formula: A = P * ((1 + r / n) ^ (nt))
        double baseOfSquare = 1 + (interestRateInDecimal / compoundsPerYear);
        double exponentOfSquare = compoundsPerYear * years;
        double power = Math.pow(baseOfSquare, exponentOfSquare);

        System.out.println(baseOfSquare);
        System.out.println(exponentOfSquare);
        System.out.println(power);

        BigDecimal result = new BigDecimal(power).multiply(principleInvestment);

        return result;
    }

}