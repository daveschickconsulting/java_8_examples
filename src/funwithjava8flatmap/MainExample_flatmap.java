package funwithjava8flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
*/
public class MainExample_flatmap {

    /**
     * In this example, we are trying to create a List<TargetObject> from a
     * List<InputObject>.  InputObject contains a List<InputObjectThing>.  For
     * each InputObjectThing, we want to create a TargetObject and return that
     * as a List<TargetObject>.
     *
     *
     * Here is the class hierarchy and composition for this example:
     *
     * InputObject
     *     List<InputObjectThing> inputObjectThings;
     *     AnotherInputObjectThing anotherInputObjectThing
     *     String inputObjectName
     *
     * InputObjectThing
     *     String inputObjectThingId
     *
     * AnotherInputObjectThing
     *     String anotherInputObjectAction
     *
     * TargetObject
     *     String targetId      (from InputObjectThing
     *     String targetName    (from InputObject)
     *     String targetAction  (from AnotherInputObjectThing)
     *
     * We start by converting our List<InputObject> to a Stream.
     *
     * For each element in that Stream, we check to see if that InputObject's List<InputObjectThing>
     * is not null.  If it's not null, we convert that List<InputObjectThing> to a Stream.
     * If it is null, we return an empty Stream.
     *
     * So at this point of the flow, we have a Stream of Streams (The InputObject parent Stream and a child
     * Stream for each of that InputObject's List<InputObjectThing>). And because of the filter, we know that
     * each InputObjectThing has a populated inputObjectThingId.
     *
     * For each InputObjectThing in this new Stream, we call the TargetObjectCreator to map elements from
     * the InputObjectThing element in this stream and its parent's InputObject.
     *
     * Coming out of this, we now have a Stream<Stream<TargetObject>>.  This is why we have to use
     * flatMap to 'flatten' this down to a Stream<TargetObject>
     *
     * We then convert the Stream<TargetObject> into a collection and return it as List<TargetObject>
     *
     */
    public static void main(String[] args) {
        List<InputObject> inputObjects = new ArrayList<>();
        List<TargetObject> result = inputObjects.stream()
                .flatMap(inputObject -> inputObject.getInputObjectThings() != null
                        ? inputObject.getInputObjectThings().stream()
                        .filter(inputObjectThing -> inputObjectThing.getInputObjectThingId() != null
                                && !inputObjectThing.getInputObjectThingId().isEmpty())
                        .map(inputObjectThing -> TargetObjectCreator.
                                createTargetObject(inputObjectThing, inputObject.getInputObjectName(),
                                        inputObject.getAnotherInputObjectThing()))
                        : Stream.empty())
                .collect(Collectors.toList());
    }

}