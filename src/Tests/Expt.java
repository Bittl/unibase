package Tests;

/**
 * Created by ПКПК on 11.07.2017.
 */
public class Expt {

    public static void main(String[] args) {
        System.out.println(sqrt(4.0));
        try {
            System.out.println(sqrt(-4.0));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static double sqrt(double x) {
        if (x < (double)0)throw new java.lang.IllegalArgumentException("Expected non-negative number, got ?");
        else return Math.sqrt(x);
        // your implementation here

//        return Math.sqrt(x);
    }

}
