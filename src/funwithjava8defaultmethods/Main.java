package funwithjava8defaultmethods;

/**
 * Java 8 introduced the ability to define
 * methods in an interface. See below for
 * examples of static and default interface
 * method implementations
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Genesis is a class that implements the
         * Car interface.
         *
         * The Car interface defines a method definition 'setUpAWD'
         * that must be implemented in the Genesis class.
         *
         * The Car interface also defines a default method
         * implementation called 'log' that is actually implemented
         * in the Car interface class itself.
         *
         * The Car interface also defines a static method
         * implementation called 'pring' that is also implemented
         * in the Car interface class itself.
         *
         * This use of 'default' and 'static' method implementations
         * in an Interface is new with Java 8
         */
        Genesis genesis = new Genesis();
        genesis.setUpAWD("all wheel drive tech data");
        genesis.log("AWD setup complete");
        Car.print("Car setup complete");
    }
}
