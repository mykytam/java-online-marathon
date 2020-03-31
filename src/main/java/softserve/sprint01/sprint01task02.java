package softserve.sprint01;

// You need to double the number and return it.

public class sprint01task02 {
    public static void main( String[] args )
    {
        System.out.println(doubleNumber(5.27));
    }

    public static float doubleNumber(double number) {
        float res = (float) (number+number);
        return res;
    }
}
