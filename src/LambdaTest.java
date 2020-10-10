import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    static class test1{
        List<String> scanCodeList = new ArrayList<>();

        public List<String> getScanCodeList() {
            return scanCodeList;
        }

        public void setScanCodeList(List<String> scanCodeList) {
            this.scanCodeList = scanCodeList;
        }
    }

    private static final double PASS_THRESHOLD = 3.0;

    public static void main(String[] args) {
//        String str = "545784329/a/a/123,1321654654/123/123,/123/123/1,";
//        String[] strings = str.split(",");
//        System.out.println(strings.length);
//        for (String s : strings) {
//            System.out.println(s);
//        }

//        String clickPercentStr = null;
//        Long getClickCount = 1L;
//        Long getImpCount = 2L;
//        clickPercentStr = getClickCount / getImpCount * 100.0 + "%";
//        System.out.println(clickPercentStr);

//        // Lambda表达式的书写形式
//        Runnable run = () -> System.out.println("Hello World");// 1
//        ActionListener listener = event -> System.out.println("button clicked");// 2
//        Runnable multiLine = () -> {// 3 代码块
//            System.out.print("Hello");
//            System.out.println(" Hoolee");
//        };
//        BinaryOperator<Long> add = (Long x, Long y) -> x + y; // 4
//        BinaryOperator<Long> addImplicit = (x, y) -> x + y; // 5 类型推断
//
//        run.run();
//        multiLine.run();
//        ActionEvent actionEvent = new ActionEvent(run, 1, "");
//        listener.actionPerformed(actionEvent);
//        System.out.println(add.apply(1L,2L));
//
//        System.out.println(addImplicit.apply(2L,3L));
//
//        ConsumerInterface<String> consumerInterface = str -> System.out.println(str);
//        consumerInterface.accept("1");
//
//        MyStream<String> stream = new MyStream<String>();
//        stream.setList(Arrays.asList("1","2","3"));
//        stream.myForEach(str -> System.out.println(str));
//
//
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("I", "love", "you", "so", "deeply"));
        list4.forEach(new Consumer<String>(){
            @Override
            public void accept(String str){
                if(str.length() > 2)
                    System.out.println(str);
            }
        });

        list4.forEach(str -> {
            if (str.length() > 2) {
                System.out.println(str);
            }
        });
//
//        list.sort((str1, str2) -> str1.length()-str2.length());
//
//        list.replaceAll(str->{
//            if (str.length() >= 2) {
//                return str.toUpperCase();
//            }
//            return str;
//        });
//
//
//
//        //list.removeIf(str -> str.length() > 2);
//
//        list.forEach( str -> {
//            if (str.length() > 0) {
//                System.out.println(str);
//            }
//        });



        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        //map.remove(2);
        map.compute(0, (k,v) -> "null");
        println(map);
        map.forEach((k, v) -> map.merge(k, v, (v1, v2) -> v1 + " - " + v2));
        println(map);


        map.replaceAll((k, v) -> {
            if (k >= 2) {
                return v.toUpperCase();
            }
            return v;
        });

        println(map);
        println(null);
        String[] array = {"I", "love", "you", "so", "deeply"};
        Supplier<Stream<String>> supplier = ()->Stream.of(array);
        Stream<String> stream = supplier.get();
        stream
                .filter(s -> s.length() <= 3)
                .distinct()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "so", "so", "deeply"));


        println(list.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2).get());
        println(list.stream().reduce(0, (sum, str) -> sum + str.length(), (a, b) -> a + b));
        println(list.stream().max(Comparator.comparingInt(String::length)).get());
        println(list.stream().max((str1, str2) -> str1.length() - str2.length()).get());
        println("---------------------------------------------------------------------------------------");
        list.stream().map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

        println(supplier.get().collect(Collectors.toList()));
        println(supplier.get().collect(Collectors.toSet()));
        println("-================================================================================-");
        println(supplier.get().collect(Collectors.toMap(Function.identity(), String::length)));
        println(supplier.get().collect(Collectors.toMap(t -> t, String::length)));

        List<String> list1 = supplier.get().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        println(list1);
        ArrayList<String> list2 = supplier.get().collect(Collectors.toCollection(ArrayList::new));
        println(list2);
        HashSet<String> hashSet = supplier.get().collect(Collectors.toCollection(HashSet::new));
        println(hashSet);

        Student student1 = new Student("student1", 100,99);
        Student student2 = new Student("student2", 89,79);
        Student student3 = new Student("student3", 59,59);
        Student student4 = new Student("student4", 59,99);
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
        Supplier<Stream<Student>> supplier1 = () -> Stream.of(new Student[]{student1, student2, student3, student4});
        Map<Student, Double> studentToGPA =
                students.stream().collect(
                        Collectors.toMap(
                            Function.identity(), student -> computeGPA(student)
                    )
                );
        println(studentToGPA);

        Map<Boolean, List<Student>> passingFailing = supplier1.get().collect(Collectors.partitioningBy(student -> computeGPA(student) >= PASS_THRESHOLD));
        println("passingFailing" + passingFailing);

        passingFailing = supplier1.get().collect(Collectors.groupingBy(student -> computeGPA(student) >= PASS_THRESHOLD));
        println("passingFailing" + passingFailing);


        println(list.stream().collect(Collectors.joining(",", "{","}")));

    }

    private static double computeGPA(Student student) {
        return (student.getEnglishScore() + student.getMathScore()) * 1.0 / 50.0;
    }

    public static void println(HashMap<Integer, String> map){
        System.out.println("---------------------------------------");
        if (map != null) {
            map.forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }

    public static void println(Object o){
        System.out.println("---------------------------------------");
        if (o == null) {
            System.out.println("null");
        } else if (o instanceof String) {
            System.out.println(o);
        } else {
            System.out.println(o.getClass()+": " + o.toString());
        }
    }
    public static void println(String s, HashMap<Integer, String> map){
        System.out.println("---------------------------------------");
        if (map != null) {
            map.forEach((k, v) -> System.out.println(s + ": " + k + " : " + v));
        } else {
            System.out.println(s + ": " + "null");
        }
    }

    public static void println(String s, Object o){
        System.out.println("---------------------------------------");
        if (o != null) {
            System.out.println(s + ": " + o.getClass()+": " + o.toString());
        } else {
            System.out.println(s + ": " + "null");
        }
    }

//    public static void println(Collection<Object> c){
//        System.out.println("---------------------------------------");
//        System.out.println(c.getClass()+": " + c.toString());
//    }
}
