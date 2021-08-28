package javaCap;

public class Parent {
    String str  = "parent";
    public void call(){
        System.out.println("parent");

    }

    public String getStr(){
        return str;

    }
}

class Child extends Parent {
    String str  = "child";
    public void call(){
        System.out.println("child");
    }

    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.str + obj.getStr());
        obj.call();
        String str = "sdfsdf";
        str.concat("ddddd");
        str.replace("d", "t");
        System.out.println(str);
        Child child = new Child();
        System.out.println(child instanceof Parent);
    }
}
