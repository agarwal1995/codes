package concepts.annotations;

import lombok.Getter;
import lombok.Setter;

/**
 * @author raag
 */
@Setter
@Getter
public abstract class ParentAnnotation {

    protected String identifier;
    protected String desc;

    protected void setIdentifier() {
        this.identifier = this.getClass().getSimpleName();
    }

    protected abstract void setDesc();
}
