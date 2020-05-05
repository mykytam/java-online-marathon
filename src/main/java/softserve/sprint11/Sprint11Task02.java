package softserve.sprint11;

//Create a class Plant, which includes private fields String name, Color color and Type type, and constructor with three String parameters where these fields are initialized. Color and Type are Enum.
//Color contains White, Red, Blue entries, Type contains Rare and Ordinary entries.
//Override the method toString( ) for Plant class which returns result formatted like following: {type: Rare, color: Red, name: MyPlant}
//Create classes ColorException and TypeException as derived from Exception.
// Both classes should have a constructor with one String parameter and pass this parameter to the base class.
//The constructor of Plant should throw a corresponding exception whenever an inappropriate parameter is passed.

enum Color {
    White, Red, Blue
}

enum Type {
    Rare, Ordinary
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}

class Plant {
    Color color;
    Type type;
    private String name;

    public Plant(String name, Color color, Type type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public Plant(String type, String color, String name) throws TypeException, ColorException {

        try {
            this.type = Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new TypeException(type);
        }

        try {
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException e) {
            throw new ColorException(color);
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return "{type: " + type +
                ", color=" + color +
                ", name=" + name +
                '}';
    }
}