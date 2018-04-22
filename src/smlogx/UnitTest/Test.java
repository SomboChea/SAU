package smlogx.UnitTest;

public class Test {

    public void test() {
        System.out.println("From Unit.Test.test()");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();

        Test t2 = new Test();
        t.test();
    }
}
