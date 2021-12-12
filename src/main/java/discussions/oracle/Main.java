package discussions.oracle;

public class Main {
    public static void main(String[] args) {
        Child child = new Child("Abc", "Rahul", "Agarwal", "toys");
        child.sayHello();
    }
}

class Parent {
    protected String asset;
    private String firstName;
    protected final String surName;

    public Parent(String asset, String firstName, String surName) {
        this.surName = surName;
    }

    private void sayHello() {
        System.out.println("discussions.oracle.Parent is saying hello");
    }
}

class Child extends Parent {
    String toys;

    public Child(String asset, String fName, String sName, String toys) {
        super("","","");
        this.toys = toys;
    }

    void sayHello() {
        System.out.println("discussions.oracle.Child is saying hello");
    }
}
