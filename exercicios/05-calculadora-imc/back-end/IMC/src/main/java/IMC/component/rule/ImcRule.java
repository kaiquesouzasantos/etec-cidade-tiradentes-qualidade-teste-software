package IMC.component.rule;

import IMC.model.ImcModel;

public class ImcRule {
    public static ImcModel calculated(ImcModel imc) {
        imc.setImc(getImc(imc.getPeso(), imc.getAltura()));
        imc.setEstado(getEstado(imc.getImc()));

        return imc;
    }

    public static Double getImc(Double peso, Double altura) {
        return (peso / (altura * altura));
    }

    public static String getEstado(Double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade Grau I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade Grau II";
        } else if (imc >= 40) {
            return "Obesidade Grau III";
        }

        return "N/A";
    }
}
