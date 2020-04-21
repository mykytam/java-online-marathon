package softserve.sprint07;

// Create a LineType enum that contains different kind of lines
// Write a method that takes the constant of LineType type as input, and returns the message “The line is <LineType> type”.

enum LineType {
    SOLID("The line is solid type") {
        @Override
        String getDescription() {
            return description;
        }
    },
    DOTTED("The line is dotted type") {
        @Override
        String getDescription() {
            return description;
        }
    },
    DASHED("The line is dashed type") {
        @Override
        String getDescription() {
            return description;
        }
    },
    DOUBLE("The line is double type") {
        @Override
        String getDescription() {
            return description;
        }
    };

    String description;

    LineType(String description) {
        this.description = description;
    }

    String getDescription() {
        return null;
    }
}


class Drawing {
    public static String drawLine(LineType lineType) {
        String result = "The line is " + lineType.getDescription() + " type";
        return result;
    }
}