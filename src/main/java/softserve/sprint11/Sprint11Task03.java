package softserve.sprint11;

// The constructor of Plant throws a corresponding exception whenever an inappropriate parameter is passed.
//(public Plant(String type, String color, String name) throws ColorException, TypeException)
// Write a static tryCreatePlant method that takes 3 string parameters - type, color and name and returns an instance of Plant, created based on passed params. (
// Don't create any classes, write as if you are already inside a class.)
// The tryCreatePlant method should catch exceptions that can be thrown.
// If inappropriate type passed as a parameter, a Plant object should be returned anyway, with Ordinary type.
// If an inappropriate color is passed, set Red color for created instance.

public class Sprint11Task03 {
    static Plant tryCreatePlant(String type, String color, String name) throws ColorException, TypeException {

        try {
            try {
                return new Plant(type, color, name);
            } catch (TypeException e) {
                return new Plant(Type.Ordinary.name(), color, name);
            } catch (ColorException e) {
                return new Plant(type, Color.Red.name(), name);
            }
        } catch (TypeException | ColorException e) {
            return new Plant(Type.Ordinary.name(), Color.Red.name(), name);
        }
    }
}
