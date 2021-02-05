package charactor;

public class MyException {
    static class A extends Exception {}

    static class B extends A {
        @Override
        public void printStackTrace() {
            System.out.println(msg);
            super.printStackTrace();
        }

        String msg = "";
        public B(String msg) {
            this.msg = msg;
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            StringBuilder a = new StringBuilder();
            System.out.println(a.toString().trim());
            throw new B("B");
        } catch (B b) {
            b.printStackTrace();
            throw new B("B1");
        }
    }
}
