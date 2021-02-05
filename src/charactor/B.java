package charactor;

public class B extends A {
    private A a = new A(1);
    public B (int i) {
        super(2);
        System.out.println("B" + i);
    }
}
