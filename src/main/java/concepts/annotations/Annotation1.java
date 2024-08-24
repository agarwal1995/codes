package concepts.annotations;

/**
 * @author raag
 */
public @interface Annotation1 {

    Class<? extends ParentAnnotation> scenario();

}
