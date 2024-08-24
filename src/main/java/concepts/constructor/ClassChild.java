package concepts.constructor;

/**
 * @author raag
 */
public class ClassChild extends ClassParent{

    ClassChild() {
        System.out.println("ClassChild");
    }

    ClassChild(int x) {
        this();
//        super();
        System.out.println(x);
        System.out.println("Child");
    }
}
