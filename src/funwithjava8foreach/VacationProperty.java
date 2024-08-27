package funwithjava8foreach;

/**
 * A simple pojo describing the amenities available
 * at a given vacation property.
 */
public class VacationProperty {

    public VacationProperty(String name, boolean parking, boolean restaurant,
                            boolean pool, boolean spa) {
        setName(name);
        setParking(parking);
        setRestaurant(restaurant);
        setPool(pool);
        setSpa(spa);
    }
    public String name;
    public boolean parking;
    public boolean restaurant;
    public boolean pool;
    public boolean spa;
    public String summary = new String("This location has: ");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}