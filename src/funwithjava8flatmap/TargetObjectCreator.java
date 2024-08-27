package funwithjava8flatmap;

import java.util.List;

public class TargetObjectCreator {
    public static TargetObject createTargetObject(InputObjectThing inputObjectThing,
                                                  String inputObjectId,
                                                  AnotherInputObjectThing anotherInputObjectThing){
        return new TargetObject();
    }
}
