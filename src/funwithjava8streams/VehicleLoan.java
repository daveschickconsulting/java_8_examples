package funwithjava8streams;

/**
 * This class represents a list of vehicle loans outstanding
 * by VIN number
 */
public class VehicleLoan {

    public VehicleLoan(Long vinNumber, String loanIdentifier) {
        this.vinNumber = vinNumber;
        this.loanIdentifier = loanIdentifier;
    }

    private Long vinNumber;
    private String loanIdentifier;

    public Long getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Long vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }
}
