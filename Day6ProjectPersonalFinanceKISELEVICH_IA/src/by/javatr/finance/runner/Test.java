package by.javatr.finance.runner;

public class Test {
    public static void main(String[] args) {
        A a = new B();
        C c = new B();
        //c.A();
        C.A();
        C.C1 c1 = new C.C1();
    }
}

class A {
    static void f(Integer i) {
        System.out.println("A integer");
    }
    static void f(Number n) {
        System.out.println("A number");
    }
    void b() {
        System.out.println(" A b");
    }
}

class B extends A implements C {
    static void f(Number n) {
        System.out.println("B b");
    }
}

interface C {
    static void A() {
        System.out.println("12121212");
    }
    class C1 {
        {
            System.out.println("asdfasdfasdf");
        }
    }
}