package funwithjava8methodreferences;

public class Beer {

    public Beer(String name, Integer ounces) {
        this.name = name;
        this.ounces = ounces;
    }

    private String name;
    private Integer ounces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOunces() {
        return ounces;
    }

    public void setOunces(Integer ounces) {
        this.ounces = ounces;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", ounces=" + ounces +
                '}';
    }
}
