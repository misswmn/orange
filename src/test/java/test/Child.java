package test;

/**
 * @author wangmn
 * @date 2017/8/8
 */

class People {
    public People() {
        System.out.println("people 无参构造 ###");
    }

    public People(String name) {
        System.out.println("people 有参构造 ###"); //
    }

    {
        System.out.println("people 代码块执行 ###"); // 3
    }

    static {
        System.out.println("people 静态代码块 ###");// 1
    }
}

class Father extends People {
    public Father() {
        System.out.println("father 无参构造 ...."); // 4
    }

    public Father(String name) {
        System.out.println("father 有参构造 ...."); //
    }

    {
        System.out.println("father 代码块执行 ...."); // 3
    }

    static {
        System.out.println("father 静态代码块 ....");// 1
    }
}

public class Child extends Father {
    public Child() {
        System.out.println("child 无参构造 $$$"); //
    }

    public Child(String name) {
        System.out.println("child 有参构造 $$$"); // 6
    }

    {
        System.out.println("child 代码块执行 $$$"); // 5
    }

    static {
        System.out.println("child 静态代码块 $$$"); // 2
    }

    public static void main(String[] args) {
        new Child();
    }
}
