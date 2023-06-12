import java.lang.Math;

public class WorldPopulationCalculator{
    double populationIn2018InBillions = 7.6440;
    double growthRate = 0.0109;
    int year = 2018;

    WorldPopulationCalculator(){
        System.out.println("These are the predicted world population for the next 25 years (Starting in 2018)");
        for (int i = 0; i <= 25; i++) {
            System.out.printf("Year %d:\t%f\n", year + i, populationIn2018InBillions * Math.pow(growthRate + 1, i));
        }
    }
}