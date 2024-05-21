package funwithjava8streams;

import java.util.ArrayList;
import java.util.List;

/**
*/
public class MainExample_anyMatch {

    /**
     * The CarInventory class represents the vehicles on a dealer's lot by VIN, make, model
     * and body style.
     *
     * The VehicleLoan class represents a loan by VIN number.
     *
     * This simple example will create a list of vehicle loans and check to see if any of
     * those vehicles (by VIN number) are on this dealer's lot.
     *
     * We are calling java.util.collections.stream to return a java.util.Stream for the List
     * of car inventory on the dealer's lot.  If the VIN number on any of the vehicles in
     * our vehicle loans list matches the VIN number on any of the cars on the dealer's lot,
     * we print an appropriate message.
     *
     * We are using java.util.stream.anyMatch to accomplish this.  anyMatch takes a
     * Predicate, which is an expression that returns a boolean result.
     */
    public static void main(String[] args) {
        List<CarInventory> inventory = buildCarInventory();
        List<VehicleLoan> loans = buildVehicleLoans();
        boolean loanFound = false;
        for (VehicleLoan vehicleLoan:loans) {
            if (inventory.stream()
                    .anyMatch(inventoryVehicle -> vehicleLoan.getVinNumber()
                            .equals(inventoryVehicle.getVinNumber()))){
                loanFound = true;
            }
        }
        if (loanFound) {
            System.out.println("There is a car on our lot matching your vehicle loan VIN");
        } else {
            System.out.println("There is no car on our lot matching your vehicle loan VIN");
        }
    }

    /**
     * Builds a list of CarInventory objects, representing all of the cars
     * on this fictional dealer's lot.
     */
    private static List<CarInventory> buildCarInventory(){
        List<CarInventory> result = new ArrayList<>();
        result.add(new CarInventory(123456789L,"Honda","Accord", "EXL"));
        result.add(new CarInventory(234234234L,"Toyota","Camry", "CONV"));
        result.add(new CarInventory(456745674L,"Toyota","Land Rover", ""));
        result.add(new CarInventory(678967896L,"Ford","F150", "EXTENDED CAB"));
        return result;
    }

    /**
     * Builds a list of VehicleLoan objects, representing all of the
     * vehicle loans on a fictional financier's books.
     */
    private static List<VehicleLoan> buildVehicleLoans(){
        List<VehicleLoan> result = new ArrayList<>();
        result.add(new VehicleLoan(234346663L,"abcde"));
        result.add(new VehicleLoan(234234234L,"ddjdj"));
        result.add(new VehicleLoan(999393939L,"pppdp"));
        return result;
    }


}