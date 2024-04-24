package funwithjava8foreach;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * This is a simple java application that demonstrates the use of
 * Java 8's forEach feature.
 */
public class Main {
    private static final List<VacationProperty> LIST_OF_PROPERTIES = asList(
            new VacationProperty("Marriot Marquis",true,false,true,true),
            new VacationProperty("Intercontinental Monterey",false,false,true,true),
            new VacationProperty("Embassy Suites Peoria",true,true,true,true));

    public static void main(String[] args) {
        /*
         * Loop through the list of vacation properties and apply the
         * logic found in VacationPropertyConsumer to each
         */
        firstExample();

        System.out.println("\n");

        /*
         * Loop through the list of vacation properties and apply the
         * logic found in the Consumer<VacationProperty> defined
         * in-line
         */
        secondExample();

        System.out.println("\n");

        /*
         * Long hand version of secondExample
         */
        thirdExample();

        System.out.println("\n");

        /*
         * A shorter way of accomplishing the thirdExample
         */
        fourthExample();

        System.out.println("\n");
    }

    /**
     * This example uses a separate Consumer class to execute
     * the logic for each element in the List.
     */
    public static void firstExample(){
        LIST_OF_PROPERTIES.forEach(new VacationPropertyConsumer());
    }

    /**
     * This example defines the consumer logic in the method itself,
     * without creating a separate class.
     *
     */
    public static void secondExample(){
        Consumer<VacationProperty> printListOfAmenities =
                (property) -> {
                    StringBuilder sb = new StringBuilder(property.getName())
                            .append(" has the following amenities: ");
                    if (property.isParking()){
                        sb.append(" Parking ");
                    }
                    if (property.isPool()){
                        sb.append(" Pool ");
                    }
                    if (property.isRestaurant()){
                        sb.append(" Restaurant ");
                    }
                    if (property.isSpa()){
                        sb.append(" Spa ");
                    }
                    property.setSummary(sb.toString());
                    System.out.println(property.getSummary());
                };
        LIST_OF_PROPERTIES.forEach(printListOfAmenities);
    }

    /**
     * The third example is a long-hand way of doing the same thing
     * as example two.
     */
    public static void thirdExample() {
        LIST_OF_PROPERTIES.forEach(new Consumer<VacationProperty>() {
            public void accept(VacationProperty vacationProperty) {
                StringBuilder sb = new StringBuilder(vacationProperty.getName())
                        .append(" has the following amenities: ");
                if (vacationProperty.isParking()){
                    sb.append(" Parking ");
                }
                if (vacationProperty.isPool()){
                    sb.append(" Pool ");
                }
                if (vacationProperty.isRestaurant()){
                    sb.append(" Restaurant ");
                }
                if (vacationProperty.isSpa()){
                    sb.append(" Spa ");
                }
                vacationProperty.setSummary(sb.toString());
                System.out.println(vacationProperty.getSummary());

            }
        });
    }

    /**
     * The final example is another way to accomplish the same thing as
     * example three.
     */
    public static void fourthExample() {
        LIST_OF_PROPERTIES.forEach((vacationProperty) -> {
            StringBuilder sb = new StringBuilder(vacationProperty.getName())
                    .append(" has the following amenities: ");
            if (vacationProperty.isParking()){
                sb.append(" Parking ");
            }
            if (vacationProperty.isPool()){
                sb.append(" Pool ");
            }
            if (vacationProperty.isRestaurant()){
                sb.append(" Restaurant ");
            }
            if (vacationProperty.isSpa()){
                sb.append(" Spa ");
            }
            vacationProperty.setSummary(sb.toString());
            System.out.println(vacationProperty.getSummary());
        });
    }

}