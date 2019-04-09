package jdk8.methodreferencesFunctionInterfaceDefaultmethod;

@FunctionalInterface
interface Sayable{
    void say();
    default void test(){
        System.out.println("test");
    }
}

public class mrFiDmTest {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        // Referring static method ::MethodReference::saySomething
        Sayable sayable = mrFiDmTest::saySomething;
        // Calling interface method
        sayable.say();
        sayable.test();
    }
}
