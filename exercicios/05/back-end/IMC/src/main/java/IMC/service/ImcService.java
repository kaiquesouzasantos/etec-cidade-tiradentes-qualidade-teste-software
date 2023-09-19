package IMC.service;

import IMC.component.rule.ImcRule;
import IMC.dto.ImcDto;
import IMC.exception.ExceptionGeneric;
import IMC.mapper.ImcMapper;
import IMC.model.ImcModel;
import IMC.validation.component.*;
import IMC.validation.rule.Validation;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ImcService implements Validation<ImcDto> {
    public ImcModel save(ImcDto imc) {
        validated(imc);

        return ImcRule.calculated(
                ImcMapper.toMapper(imc)
        );
    }

    @Override
    public boolean validate(ImcDto value) {
        return Stream.of(
                NotNull.isValid(value.getNome()),
                NotNull.isValid(value.getPeso()),
                NotNull.isValid(value.getAltura()),
                NotEmpty.isValid(value.getNome()),
                StringValidation.isValid(value.getNome()),
                PositiveOrZero.isValid(value.getPeso()),
                PositiveOrZero.isValid(value.getAltura()),
                PesoSuperiorAltura.isValid(value.getPeso(), value.getAltura())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(ImcDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
