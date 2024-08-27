package funwithjava8flatmap;

import java.util.List;

public class InputObject {
    private List<InputObjectThing> inputObjectThings;
    private AnotherInputObjectThing anotherInputObjectThing;
    private String inputObjectName;

    public AnotherInputObjectThing getAnotherInputObjectThing() {
        return anotherInputObjectThing;
    }

    public void setAnotherInputObjectThing(AnotherInputObjectThing anotherInputObjectThing) {
        this.anotherInputObjectThing = anotherInputObjectThing;
    }

    public String getInputObjectName() {
        return inputObjectName;
    }

    public void setInputObjectName(String inputObjectId) {
        this.inputObjectName = inputObjectId;
    }

    public List<InputObjectThing> getInputObjectThings() {
        return inputObjectThings;
    }

    public void setInputObjectThings(List<InputObjectThing> inputObjectThings) {
        this.inputObjectThings = inputObjectThings;
    }
}
