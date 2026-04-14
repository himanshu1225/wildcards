import java.util.ArrayList;
import java.util.List;

public class WildCardMain {
    public static void main(String[] args) {
//        1. <T> vs ? (THIS IS THE HEART)
//        where as
//        2. ? → UNKNOWN type
//        3. write (? vs T)
//        4. List<Object> vs List<?> (VERY IMPORTANT)

//        a. you can add anything
        List<Object> obs = new ArrayList<>();
        obs.add(10);
        obs.add("Himanshu");
//      But
        List<Integer> intList = new ArrayList<>();
//        List<Object> objList = intList; // ❌ NOT allowed

//        This can do
        List<?> wildList = intList;
//      But
//      wildList.add(2);   // not allowed


//        5. Wild cards deep understanding. (PECS)
//        a. Producer extends (for reading data but cannot write)
//        b. Consumer super (for writing data, but cannot read safely)


    }

//    <T> vs ? (THIS IS THE HEART)
//    Here you know type (T) -> Read and write is allowed
    public <T> void process(List<T> list){
        T value = list.get(0);
    }

    //        ? → UNKNOWN type
//    Type is unknown so only can read, write not allowed
    public void processWild(List<?> list){
        Object obj = list.get(0);
//        list.add(10); //List could be List<String>
//                          Adding Integer would break it
    }

//    Why write allowed in generics -> because type is consistent
    public <V> void writeGenerics(List<V> objList, V value) {
        objList.add(value);
    }

//     a. Producer extends (for reading data but cannot write)
    public void read(List<? extends Number> list){
        Integer objInt = (Integer) list.get(0);
//        String objStr = (String) list.get(0);
        Double objDouble = (Double) list.get(0);

//        can read data but writing not allowed
//        list.add(num); // not allowed
     }
//    b. Consumer super (for writing data, but cannot read safely)
     public void write(List<? super Integer> list){
//        👉 Why safe?
//          Because:
//          If list is List<Integer> → OK
//          If list is List<Number> → Integer is a Number → OK
//          If list is List<Object> → Integer is an Object → OK
        list.add(20);
//        list.add(10.4);   not allowed
//         list.add("Him"); not allowed.

//         Why reading not safe.
//         Integer x = list.get(0); // ❌ Why error?
//         Compiler only knows:  list is List<? super Integer>
//         It DOES NOT know the exact type
//          Possible reality:

//         case 1: List<Integer>   get(0) will return integer --> ok
//         case 2: List<Number>    Integer x = list.get(0); // ❌ Number → Integer not guaranteed
//         case 3: List<Object>    Integer x = list.get(0); // ❌ Object → Integer not guaranteed

//         SO what is safe in reading:
         Object obj = list.get(0); // ✅ ALWAYS SAFE
//         Every type is object

    }

}
