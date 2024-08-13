package funwithremoveif;

import java.util.ArrayList;

public class Main {
    public static void main (String [] args){
        /**
         * The public boolean removeIf(Predicate filter) method was introduced with java 8.
         * In this example, we will create an ArrayList<String> containing the names of both
         * foreign and American car makes.  Then we will remove the "Honda" and "Toyota" makes
         * from the list using removeIf, leaving only the American cars.
         *
         */

        ArrayList<String> americanCars = new ArrayList<String>();

        americanCars.add("Toyota");
        americanCars.add("Ford");
        americanCars.add("Honda");
        americanCars.add("Chevrolet");

        americanCars.removeIf(car -> (car.equalsIgnoreCase("TOYOTA") || car.equalsIgnoreCase("HONDA")));

        americanCars.iterator().forEachRemaining((car) -> System.out.println(car));

    }
}
