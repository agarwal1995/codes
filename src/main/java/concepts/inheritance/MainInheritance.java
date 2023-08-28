package concepts.inheritance;

/**
 * @author raag
 */
public class MainInheritance {

    public static void main(String[] args) {
        AbstractParent obj1 = new Child1("As");
        AbstractParent obj2 = new Child2("NS");

        obj1.method1();
        obj2.method1();

        ((AbstractInterface) obj1).method2();
        ((AbstractInterface) obj2).method2();
    }
}
