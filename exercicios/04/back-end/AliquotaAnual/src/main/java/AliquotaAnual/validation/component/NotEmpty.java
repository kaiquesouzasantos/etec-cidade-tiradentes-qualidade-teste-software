package AliquotaAnual.validation.component;

public class NotEmpty {
    public static boolean isValid(String value){
        return !value.isEmpty();
    }
}
