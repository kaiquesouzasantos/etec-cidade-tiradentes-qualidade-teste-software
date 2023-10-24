package IMC.util;

import IMC.dto.ImcPostDto;
import IMC.model.ImcModel;

public class ImcUtil {
    public static final String NOME = "TESTE", NOME_ALTERNATIVO = "TESTADO", ESTADO = "Peso Normal";
    public static final Double ALTURA = 2.0, PESO = 90.0, IMC = 22.5, ALTURA_ALTERNATIVA = 1.7, PESO_ALTERNATIVO = 60.0;

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

    public static ImcPostDto factoryDto() {
        return ImcPostDto
                .builder()
                .nome(NOME)
                .peso(PESO)
                .altura(ALTURA)
                .build();
    }

    public static ImcPostDto factoryDto(String nome, Double peso, Double altura) {
        return ImcPostDto
                .builder()
                .nome(nome)
                .peso(peso)
                .altura(altura)
                .build();
    }
}
