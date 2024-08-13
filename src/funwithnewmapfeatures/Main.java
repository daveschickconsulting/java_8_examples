package funwithnewmapfeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String [] args){
        /**
         * Java 8 introduced some new Map features.  We will demonstrate each below.
         */
        replaceAll();

        compute();

    }

    /**
     * Map added a new method with Java 8 -- default void replaceAll(BiFunction).
     * This method can be used to replace all of the values in a map with the results
     * of the function provided.
     *
     * In the following example, we will use replaceAll to double all of the Integer values
     * in a given HashMap.
     */
    private static void replaceAll (){
        Map<String,Integer> doubler = new HashMap<>();
        doubler.put("one",1);
        doubler.put("two",2);
        doubler.put("three",3);
        doubler.put("four",4);
        doubler.put("five",5);

        System.out.println("HashMap1: "
                + doubler.toString());


        doubler.replaceAll((key,value) -> value * 2);

        System.out.println("HashMap2: "
                + doubler.toString());

    }

    /**
     * Map compute(Key, BiFunction) method was introduced with Java 8.
     * Replaces the value for a given key in the map with the computed value
     * returned by the function.  If the function returns null, then the key is removed.
     */
    private static void compute(){
        Map<String, String> map = new HashMap<>();
        map.put("Province", "New Brunswick");
        map.put("Country", "Canada");

        System.out.println("Map: " + map);

        map.compute("Province", (key, val)
                -> val.concat(" - Maritime Province"));
        map.compute("Country", (key, val)
                -> val.concat(" - North America"));

        System.out.println("New Map: " + map);
    }
}
