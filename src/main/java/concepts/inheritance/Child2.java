package concepts.inheritance;

/**
 * @author raag
 */
public class Child2 extends AbstractParent implements AbstractInterface{
    public Child2(String s) {
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
