import example.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Before generics
        List list = new ArrayList();
        list.add(10);
        list.add("Himanshu");

        Integer num = (Integer) list.get(0); // casting is needed

//        Integer num1 = (Integer) list.get(1);  // runtime error Cast cast exception
        // Error found in runtime, very dangerous in production systems.

        String name = (String) list.get(1); // Too much casting (ugly and error-prone)

//        Post Generics:

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
//        integers.add("Hello"); // compile time error
//        Java enforces: list can only contain integers.

        Integer num2 = integers.get(0); // clean no casting

//         Generic means parameterizing types;
//        like function takes parameters, Generics make type as parameter.

            Box box = new Box();
            box.setValue(1);
            box.setValue("Himanshu");
            // same issue which we discussed.

        BoxGeneric<Integer> bg1 = new BoxGeneric<>(1,2);

        BoxGeneric<String> bg2 = new BoxGeneric<>("1", "2");
        // same class different types.
        // generics ko labelled container samjho
//        BoxGeneric<Integer> bg1 -> only integers allowed
//        BoxGeneric<String> bg2  -> only Strings allowed

//        Without generics:
//        one box -> anything goes -> chaos
//        with generics each box has a label -> safe and organised.

// one method works for all types
        bg1.printGeneric(3);
        bg1.printGeneric("Value is 3");


//  Important rule which leads to wild cards (Generics are invariant)
//        Invariant: Invariant means unchanging, constant, or unaltered by specific transformations.
//        In software, it is a condition that remains true throughout program execution.
        List<Number> numList = new ArrayList<>();
        numList.add(3.15); // Number is parent class for Integer, Double etc.

        Double db1 = (Double) numList.get(0); // again same issue casting is required
//        Integer int1 = (Integer) numList.get(0); // error Class cast exception (double cannot be cast into Integer)
        Integer int3 = Integer.valueOf((Integer) numList.get(0));
        System.out.println(db1);
//        System.out.println(int1);
        System.out.println(int3);

//        double db3 = 3.253;
//        int int4  = (int) db3;  // explicit casting krni padegi because data lose hoga.
//        System.out.println(int4);

        List<Integer> integerList = new ArrayList<>();
//        List<Number> numbers = integerList; // invariant, it should be same through out
//        Eveenthough integer is number still not allowed

//        Advantages:
//        1. catches error early.
//        2. No casting
//        3. Reusability: write once use everywhere.
//        4. Readability: 👉 Immediately clear what it holds

//        Bounded generics:

//        NumberBox<String> nbStr = new NumberBox<>(); // restricting type
        NumberBox<Double> numberBox = new NumberBox<>();

//        Real Case in systems:
        ResponseDTO<User> userResponseDTO= new ResponseDTO<>();
        ResponseDTO<Account> accResponseDTO= new ResponseDTO<>();

//     Generics allow you to write type-safe, reusable code by treating types as parameters


//        Now the BIG problem generics couldn't solve: --> Too strict (invariance)
//        Thats where wild cards come into picture.
    }
}