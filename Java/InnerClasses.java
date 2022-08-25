import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class W3 extends W4 {

    static class W5 {
        protected Integer value = 105;
    }

    abstract static class W6 {
        public abstract void recursiveFunction();
        public static void tester() {
            System.out.println("Valid");
        }
    }

    private final int numOfDays = 0;

    public static void main(String[] args) {

        System.out.println(testerMethod());
        W3 obj = new W3();
        W4 obj2 = new W4();
        System.out.println(W4.recursiveFunc(5, 7));
        System.out.println(obj2.identifier);
        Scanner sc = new Scanner(System.in);
        String values = sc.nextLine();
        System.out.println(values);
        LocalDate time = LocalDate.now();
        System.out.println(time);
        HashMap<String, String> listOfGoods = new HashMap<String, String>();
        listOfGoods.put("Chicken", "20lb");
        for(String i : listOfGoods.keySet()) {
            System.out.println(listOfGoods.get(i));
        }
    }

    public LinkedList<Integer> returnLinks(int num) {
        LinkedList<Integer> values = new LinkedList<Integer>();
        values.addFirst(num);
        return values;
    }

    public static void factorialTests() {
        System.out.println(factorial(5));
        System.out.println(factorial(4.5));
        System.out.println(factorial(3));
        System.out.println(factorial(4.4));
    }

    static int factorial(int num) {
        int sum = 1;
        for(int i = 1; i <= num; i++) {
            sum += i*sum;
        }
        return sum;
    }

    static double factorial(double num) {
        double sum = 1;
        for(int i = 1; i <= num; i++) {
            sum += i*sum;
        }
        return sum;
    }
}

import java.lang.Math;

public class DatabaseManager {

    protected final String keyCode;
    protected final int mappingNumber;

    public DatabaseManager(String keyCode, int mappingNumber) {
        this.keyCode = keyCode;
        this.mappingNumber = mappingNumber;
    }

    public static void testingMath() {
        float test = Math.nextAfter(4, 5);
        System.out.println(test);
    }
}

import java.util.ArrayList;

public class W4 {

    protected final String identifier = "SLO239OKa";
    ArrayList<Integer> nums = new ArrayList<Integer>();

    public static int recursiveFunc(int start, int end) {
        if(end > start) {
            return end + recursiveFunc(start, end - 1);
        } else {
            return end;
        }
    }

    static String testerMethod() {
        return "This is a test of extended class abilities";
    }
}

import javax.tools.Tool;

enum Level {
    LOW,
    MEDIUM,
    HIGH
}

public interface W7 {

    public <User> User createUser();
    public Tool deleteUser();
}


