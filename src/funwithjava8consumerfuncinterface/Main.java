package funwithjava8consumerfuncinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * The Consumer functional interface was introduced in
 * Java 8.  It takes one parameter and returns no value.
 * It's intended to operate on the parameter.
 */
public class Main {
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args){
        /*
         * This example shows how to use the
         * Consumer functional interface
         */
        numbers = Arrays.asList(1,2,3,4,5);
        consumerExample();

        /*
         * This example shows how to use the
         * Consumer andThen functional interface
         */
        consumerAndThenExample();
    }

    public static void consumerExample(){
        Consumer<List<Integer>> multiply = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
        multiply.accept(numbers);
        for (Integer number: numbers){
            System.out.println(number);
        }
    }

    public static void consumerAndThenExample(){
        Consumer<List<Integer>> multiply = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        Consumer<List<Integer>> print = list ->
        {
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        };

        multiply.andThen(print).accept(numbers);
    }
}
