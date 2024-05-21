package funwithjava8streams;

/**
 * This class represents the vehicles on a dealer's lot
 * by VIN number, make, model and body style.
 */
public class CarInventory {
    public CarInventory(Long vinNumber, String make, String model, String bodyStyle) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.bodyStyle = bodyStyle;
    }

    private Long vinNumber;
    private String make;
    private String model;
    private String bodyStyle;

    public Long getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Long vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
}