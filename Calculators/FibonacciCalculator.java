import java.util.Scanner;

//ToDo: Set limit for verification

public class FibonacciCalculator {

    FibonacciCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to have in the sequence? (It must be greater than 2)");
        int numberOfNumbers = sc.nextInt();
        int[] sequence = new int[numberOfNumbers];

        System.out.println("Do you want to skip the odd numbers? 1 = yes, 2 = no");
        int skipOddNumbers = sc.nextInt();

        sequence[0] = 0;
        sequence[1] = 1;

        for (int i = 2; i < numberOfNumbers; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        if (skipOddNumbers == 1) {
            for (int i = 0; i < numberOfNumbers; i++) {
                if (sequence[i] % 2 == 0) {
                    System.out.printf("\t%d\t%d\n",(i + 1), sequence[i]);
                } else {
                    System.out.printf("\t%d\n",(i + 1));
                }
            }
        } else {
            for (int i = 0; i < numberOfNumbers; i++) {
                System.out.printf("\t%d\t%d\n",(i + 1), sequence[i]);
            }
        }
        
        sc.close();
        
    }
}