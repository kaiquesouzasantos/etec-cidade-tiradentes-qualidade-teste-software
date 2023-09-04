package AliquotaAnual.validation.rule;

public interface Validation<T> {
    boolean validate(T value);
    void validated(T value);
}
