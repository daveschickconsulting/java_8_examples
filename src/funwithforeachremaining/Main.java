package funwithforeachremaining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main (String[] args){
        /**
         * Prior to Java 8, we would iterate a collection like this:
         */

        List<String> cars = new ArrayList<>();
        cars.add("Honda");
        cars.add("Toyota");
        cars.add("Ford");
        cars.add("Subaru");

        Iterator<String> iterator = cars.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    /**
     * Java 8 introduced forEachRemaining (Consumer ?) to make this more concise.
     * A Consumer represents an operation that accepts a single input argument and returns
     * no result.
     *
     * So now we can do the same thing as above with one line of code:
     */
        cars.iterator().forEachRemaining((car) -> System.out.println(car));
    }
}
