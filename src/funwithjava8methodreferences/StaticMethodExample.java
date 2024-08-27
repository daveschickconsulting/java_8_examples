package funwithjava8methodreferences;


import java.util.Arrays;
import java.util.List;

/**
 * This example illustrates how a static method reference works.
 *
 * In this example, we are creating a new Thread, which takes a Runnable.
 *
 * Runnable is a functional interface in the sense that it implements
 * only one abstract method (which you must override).
 *
 * In this example, we are creating a Thread and overriding its Runnable
 * with a method that prints a simple message to the console.
 */
public class StaticMethodExample {

    public static void main(String[] args) {
        /**
         * Our first example shows the 'longhand' way of providing a Runnable
         * implementation to the new Thread and overriding its single abstract method
         * by using an anonymous inner class.
         */
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Old anonymous inner class way...");
            }});
        t2.start();

        /**
         * Our second example tightens this up a little bit by showing how to
         * provide a Runnable implementation to the new Thread by using a lambda
         * expression to create an anonymous inner class and override its single abstract method.
         */
        t2 = new Thread(()-> System.out.println("Lambda expression way...."));
        t2.start();

        /**
         * And finally, here's an example of doing the same thing but using a static
         * method reference.  The StaticMethodExample class has defined a static method
         * that provides a single method implementation. This is used to create an
         * anonymous inner class implementation of Runnable and override its single
         * abstract method with the method provided in the static method reference.
         */
        t2 = new Thread(StaticMethodExample::threadStatus);
        t2.start();

        /**
         * Here's another static method reference example.  The forEach method of
         * Iterable takes a Consumer functional interface (which by definition
         * overrides a single abstract method).
         *
         * The code below Creates an anonymous inner class implementation of a
         * Consumer functional interface and overrides its single abstract method
         * with the public void println(String x) method.
         */
        List<String> artists = Arrays.asList("billy joey","john prine","steve goodman");
        artists.forEach(System.out::println);

    }

    /**
     * This is the static method implemented in this class that prints
     * a simple message to the console.
     */
    public static void threadStatus(){
        System.out.println("Static method reference way...");
    }

}
