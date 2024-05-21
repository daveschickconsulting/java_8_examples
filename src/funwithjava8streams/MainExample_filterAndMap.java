package funwithjava8streams;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
*/
public class MainExample_filterAndMap {

    /**
     * The CarInventory class represents the vehicles on a dealer's lot by VIN, make, model
     * and body style.
     *
     * This simple example will create a list of vehicles on a dealer's lot and print off a
     * list of all the Toyotas on the lot by VIN number.
     *
     * We are calling java.util.collections.stream to return a java.util.Stream for the List
     * of car inventory on the dealer's lot.  If the make of any of the vehicles on the lot
     * is 'Toyota' it will be included in a mapped List of vehicle VIN numbers.
     *
     * We are using java.util.stream.filter and java.util.map to accomplish this.
     */
    public static void main(String[] args) {
        List<CarInventory> inventory = buildCarInventory();

        /*
         * filter takes a Predicate and returns a stream where that Predicate condition
         * is 'true'.  In this case, we are filtering to return only those vehicles
         * whose make is 'Toyota'.
         */


        /*
         * map takes a function and returns a java.util.stream with the results
         * of that function. In this example, it's returning a stream of
         * VIN numbers from the car inventory stream that's been filtered to
         * include only Toyota make vehicles.
         */

        /*
         * java.util.stream.collect takes a Collector and performs a
         * reduction on the elements of the stream. This is a terminal
         * operation (meaning it's the last thing you'll do in this stream).
         *
         * java.util.stream.Collectors.toList() returns a Collector that
         * accumulates the input elements into a new List.
         *
         */

        List<Long> matchingVins = inventory.stream()
                .filter(inventoryVehicle -> StringUtils.startsWith(inventoryVehicle.getMake(),"Toyota")).map(carInventory ->
                carInventory.getVinNumber()).collect(Collectors.toList());

        /*
         * Print list of all the Toyota's by VIN number
         */
        System.out.println("Here are all of the Toyotas by VIN number: \n");
        for (Long matchedVin:matchingVins) {
            System.out.println(matchedVin);
        }

    }


    /**
     * Builds a list of CarInventory objects, representing all cars
     * on this fictional dealer's lot.
     */
    private static List<CarInventory> buildCarInventory(){
        List<CarInventory> result = new ArrayList<>();
        result.add(new CarInventory(123456789L,"Honda","Accord", "EXL"));
        result.add(new CarInventory(234234234L,"Toyota","Camry", "CONV"));
        result.add(new CarInventory(675675676L,"Chevrolet","Silverado", "CREW CAB"));
        result.add(new CarInventory(456745674L,"Toyota","Land Rover", "MOD"));
        result.add(new CarInventory(678967896L,"Ford","F150", "EXTENDED CAB"));
        return result;
    }

}