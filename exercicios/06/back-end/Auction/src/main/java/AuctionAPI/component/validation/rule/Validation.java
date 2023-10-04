package AuctionAPI.component.validation.rule;

public interface Validation<T> {
    boolean validate(T value);
    void validated(T value);
}
