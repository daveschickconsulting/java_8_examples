package funwithjava8foreach;

import java.util.function.Consumer;

public class VacationPropertyConsumer implements Consumer<VacationProperty> {

    @Override
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
}
