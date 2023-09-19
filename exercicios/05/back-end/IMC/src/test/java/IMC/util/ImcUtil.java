package IMC.util;

import IMC.dto.ImcDto;
import IMC.model.ImcModel;

public class ImcUtil {
    public static final String NOME = "TESTE", NOME_ALTERNATIVO = "TESTADO", ESTADO = "";
    public static final Double ALTURA = 0.0, PESO = 0.0, IMC = 0.0;

    public static ImcModel factoryModel() {
        return ImcModel
                .builder()
                .nome(NOME)
                .estado(ESTADO)
                .altura(ALTURA)
                .peso(PESO)
                .imc(IMC)
                .build();
    }

    public static ImcModel factoryModel(String nome, Double peso, Double altura) {
        return ImcModel
                .builder()
                .nome(nome)
                .peso(peso)
                .altura(altura)
                .build();
    }

    public static ImcDto factoryDto() {
        return ImcDto
                .builder()
                .nome(NOME)
                .peso(PESO)
                .altura(ALTURA)
                .build();
    }

    public static ImcDto factoryDto(String nome, Double peso, Double altura) {
        return ImcDto
                .builder()
                .nome(nome)
                .peso(peso)
                .altura(altura)
                .build();
    }
}
