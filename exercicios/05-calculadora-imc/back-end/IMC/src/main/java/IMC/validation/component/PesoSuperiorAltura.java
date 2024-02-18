package IMC.validation.component;

public class PesoSuperiorAltura {
    public static boolean isValid(Double peso, Double altura){
        return peso > altura;
    }
}
