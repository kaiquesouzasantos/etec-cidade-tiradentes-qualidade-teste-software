package AliquotaAnual.service;

import AliquotaAnual.component.rule.AliquotaRule;
import AliquotaAnual.dto.AliquotaDto;
import AliquotaAnual.exception.ExceptionGeneric;
import AliquotaAnual.mapper.AliquotaMapper;
import AliquotaAnual.model.AliquotaModel;
import AliquotaAnual.validation.component.*;
import AliquotaAnual.validation.rule.Validation;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AliquotaService implements Validation<AliquotaDto> {
    public AliquotaModel save(AliquotaDto aliquota) {
        validated(aliquota);

        return AliquotaRule.calculated(
                AliquotaMapper.toMapper(aliquota)
        );
    }

    @Override
    public boolean validate(AliquotaDto value) {
        return Stream.of(
                NotNull.isValid(value.getNome()),
                NotNull.isValid(value.getRendimentos()),
                NotNull.isValid(value.getCpf()),
                NotEmpty.isValid(value.getNome()),
                NotEmpty.isValid(value.getCpf()),
                StringValidation.isValid(value.getNome()),
                PositiveOrZero.isValid(value.getRendimentos()),
                CPFValidation.isValid(value.getCpf())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(AliquotaDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
