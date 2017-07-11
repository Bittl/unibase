package Tests;

/**
 * Created by ПКПК on 11.07.2017.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...

        String s = null;

//        try{
//
//        }catch{
//
//        }

        return s;
    }
}
