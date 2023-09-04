package AliquotaAnual.validation.component;

public class NotNull {
    public static boolean isValid(Object value){
        return !value.equals(null);
    }
}