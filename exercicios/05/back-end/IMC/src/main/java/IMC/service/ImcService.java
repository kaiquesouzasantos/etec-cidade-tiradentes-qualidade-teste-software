package IMC.service;

import IMC.component.rule.ImcRule;
import IMC.dto.ImcPostDto;
import IMC.dto.ImcPutDto;
import IMC.exception.ExceptionGeneric;
import IMC.mapper.ImcMapper;
import IMC.model.ImcModel;
import IMC.respository.ImcRepository;
import IMC.validation.component.*;
import IMC.validation.rule.Validation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImcService implements Validation<ImcPostDto, ImcPutDto> {
    private final ImcRepository imcRepository;
    private final ImcValidation imcValidation;

    @Transactional
    public ImcModel save(ImcPostDto imc) {
        validatedPost(imc);

        return
                imcRepository.save(
                        ImcRule.calculated(ImcMapper.toMapper(imc))
                );
    }

    public ImcModel update(ImcPutDto imc) {
        validatedPut(imc);

        return imcRepository.save(
                ImcRule.calculated(ImcMapper.toMapper(imc, findById(imc.getId())))
        );
    }

    public void delete(UUID id) {
        imcRepository.deleteById(id);
    }

    public ImcModel findById(UUID id) {
        return imcRepository.findById(id).orElseThrow(
                () -> new ExceptionGeneric("", "", 404)
        );
    }

    public List<ImcModel> findAll() {
        return imcRepository.findAll();
    }

    public boolean validatePost(ImcPostDto value) {
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
    public boolean validatePut(ImcPutDto value) {
        return Stream.of(
                imcValidation.isValid(value.getId()),
                NotNull.isValid(value.getPeso()),
                NotNull.isValid(value.getAltura()),
                PositiveOrZero.isValid(value.getPeso()),
                PositiveOrZero.isValid(value.getAltura()),
                PesoSuperiorAltura.isValid(value.getPeso(), value.getAltura())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validatedPost(ImcPostDto value) {
        if(!validatePost(value))
            throw new ExceptionGeneric("", "", 404);
    }

    @Override
    public void validatedPut(ImcPutDto value) {
        if(!validatePut(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
