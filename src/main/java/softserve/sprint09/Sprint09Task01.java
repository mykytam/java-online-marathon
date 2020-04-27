package softserve.sprint09;

// Create a String intToRoman(int number) to convert integer to Roman numerals

public class Sprint09Task01 {

    public String intToRoman(int number) throws IllegalArgumentException {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("The number must be positive and do not exceed 3999");
        } else {
            return thousands[number / 1000] +
                    hundreds[(number % 1000) / 100] +
                    tens[(number % 100) / 10] +
                    units[number % 10];
        }
    }
}

