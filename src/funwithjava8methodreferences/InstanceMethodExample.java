package funwithjava8methodreferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * In this example, we are going to create a List of Beer objects, each of which has a name
 * and a number of ounces.
 *
 * Then we will use Java 8's Stream interface to convert that List to a Stream and call a
 * sorting method on each element of the Stream to sort the Beer objects by ounces.
 *
 * The sorting method we will use happens to take a Comparator, which is in essence a
 * functional interface with a single abstract method which must be overridden.  We will use
 * our method reference shorthand to use an instantiated BeerComparator object to create the
 * anonymous inner class for the Comparator that our Stream.sorted method requires.
 *
 * The BeerComparator class provides a single method implementation the Comparator functional
 * interface requires, and will sort Beer objects by ounces.
 *
 */
public class InstanceMethodExample {

    public static void main (String args[]){

        /**
         * In this example, we will create a List of Beer objects - each having a different value for
         * ounces.
         */
        List<Beer> beerList = Arrays.asList(new Beer("Coors", 12), new Beer("Coors", 24),new Beer("Blatz",48));

        /**
         * Next we instantiate a BeerComparator, which in essence is a functional interface, because
         * it contains a single abstract method which we must override (and which we have overridden in the
         * BeerComparator class).
         *
         * The BeerComparator class will compare two beers and tell us which has the
         * greater ounces size.
         */
        BeerComparator beerComparator = new BeerComparator();


        /**
         * We can now use the Stream class to create a Stream of Beer objects our
         * List and sort them using a Stream.sorted method that takes a Comparator
         * implementation.  We are using the method reference shorthand to create
         * an anonymous inner class implementation of Comparator with its single
         * abstract method overridden with our BeerComparator compar method.
         *
         * We then use a static method reference to print each Beer object element
         * of the sorted stream.  This is possible because we have implemented a
         * toString method in the Beer object.
         */
        beerList.stream().sorted(beerComparator::compare).forEach(System.out::println);
    }

    /**
     * Here we have implemented a Comparator class that will compare
     * the ounces of two particular beers so we can sort them by ounce.
     */
    public static class BeerComparator implements Comparator<Beer>{
        @Override
        public int compare(Beer beer1, Beer beer2) {
            return beer1.getOunces().compareTo(beer2.getOunces());
        }
    }
}
