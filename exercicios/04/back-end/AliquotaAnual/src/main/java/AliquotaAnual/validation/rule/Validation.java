package AliquotaAnual.validation.rule;

public interface Validation<T, E> {
    boolean validatePost(T value);
    void validatedPost(T value);
    boolean validatePut(E value);
    void validatedPut(E value);
}
