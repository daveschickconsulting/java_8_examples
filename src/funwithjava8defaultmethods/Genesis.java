package funwithjava8defaultmethods;

public class Genesis implements Car {
    @Override
    public void setUpAWD(String awdDetails) {
        System.out.println("AWD input: " + awdDetails);
    }
}
