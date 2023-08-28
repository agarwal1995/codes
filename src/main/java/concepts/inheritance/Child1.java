package concepts.inheritance;

/**
 * @author raag
 */
public class Child1 extends AbstractParent implements AbstractInterface{

    public Child1(String s) {
        setVal(s);
    }
    @Override
    public void method2() {
        System.out.println("method2" + this.getVal());
    }

    @Override
    public void method1() {
        System.out.println("method1" + this.getVal());
    }
}
