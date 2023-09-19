package IMC.validation.component;

public class PositiveOrZero {
    public static boolean isValid(Double value){
        return value >= 0.0;
    }

    public static boolean isValid(Integer value){
        return value >= 0;
    }

    public static boolean isValid(int value){
        return value >= 0;
    }
}
