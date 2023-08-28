package concepts.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author raag
 */
public abstract class AbstractParent {
    @Setter
    private String val;

    public abstract void method1();

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
