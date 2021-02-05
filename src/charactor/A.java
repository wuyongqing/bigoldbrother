package charactor;

import java.util.HashSet;
import java.util.Set;

public class A {
    public A (int i) {
        System.out.println("A" + i);
    }
    public void t() {

    }
    public class E {
        public A p() {
            System.out.println("ppp");
            return A.this;
        }
    }
    public E e() {
        return new E();
    }

    public class G implements F {
        public G(String i) {

        }
        @Override
        public int value() {
            return 0;
        }
    }

    public F f(String x) {
        return new G(x) {
            private String a = x;
            public int value() {
                System.out.println(a);
                return super.value();
            }
        };
//        return new F() {
//            private int i;
//
//            public int value() {
//                return i;
//            }
//        };
    }

    public static void main(String[] args) {
        A a = new A(1);
        F f = a.f("1");
        System.out.println("----");
        f.value();
        System.out.println("----");
        A.E e = a.new E();
        System.out.println(e.p());
        String aaa = "123";
        System.out.println(aaa.substring(0, aaa.length() - 1));

        String[] split = "44".split(",");
        Set<Long> standardIds = new HashSet<>(split.length);
        for (String s : split) {
            standardIds.add(Long.parseLong(s));
        }

        String[] split2 = "1,2,3".split(",");
        Set<Long> standardIds2 = new HashSet<>(split2.length);
        for (String s : split2) {
            standardIds2.add(Long.parseLong(s));
        }
        if (standardIds2.retainAll(standardIds) && standardIds2.size() == 0) {
            System.out.println(standardIds2);
        }
    }
}
