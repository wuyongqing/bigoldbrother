package charactor;

public class C extends B {
    private B b = new B(3);
    public C (int i) {
        super(4);
        System.out.println("C" + i);
    }

    public static void main(String[] args) {
        new C(5);
    }
}
