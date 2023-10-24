package AliquotaAnual.util;

import AliquotaAnual.dto.AliquotaPostDto;
import AliquotaAnual.model.AliquotaModel;

public class AliquotaUtil {
    public static final String NOME = "TESTE", CPF = "72221891066", NOME_ALTERNATIVO = "TESTADO", CPF_ALTERNATIVO = "17451340007";
    public static final Double RENDIMENTOS = 2000.0, RENDIMENTOS_ALTERNATIVO = 5000.0;

    public static AliquotaModel factoryModel() {
        return AliquotaModel
                .builder()
                .nome(NOME)
                .cpf(CPF)
                .rendimentos(RENDIMENTOS)
                .build();
    }

    public static AliquotaModel factoryModel(String nome, String cpf, Double rendimentos) {
        return AliquotaModel
                .builder()
                .nome(nome)
                .cpf(cpf)
                .rendimentos(rendimentos)
                .build();
    }

    public static AliquotaPostDto factoryDto() {
        return AliquotaPostDto
                .builder()
                .nome(NOME)
                .cpf(CPF)
                .rendimentos(RENDIMENTOS)
                .build();
    }

    public static AliquotaPostDto factoryDto(Double rendimentos) {
        return AliquotaPostDto
                .builder()
                .nome(NOME)
                .cpf(CPF)
                .rendimentos(rendimentos)
                .build();
    }

    public static AliquotaPostDto factoryDto(String nome, String cpf, Double rendimentos) {
        return AliquotaPostDto
                .builder()
                .nome(nome)
                .cpf(cpf)
                .rendimentos(rendimentos)
                .build();
    }
}
