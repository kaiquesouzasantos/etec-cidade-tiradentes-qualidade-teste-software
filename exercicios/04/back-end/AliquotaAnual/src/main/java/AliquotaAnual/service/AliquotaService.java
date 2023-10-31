package AliquotaAnual.service;

import AliquotaAnual.component.rule.AliquotaRule;
import AliquotaAnual.dto.AliquotaPostDto;
import AliquotaAnual.dto.AliquotaPutDto;
import AliquotaAnual.exception.ExceptionGeneric;
import AliquotaAnual.mapper.AliquotaMapper;
import AliquotaAnual.model.AliquotaModel;
import AliquotaAnual.repository.AliquotaRepository;
import AliquotaAnual.validation.component.*;
import AliquotaAnual.validation.rule.Validation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AliquotaService implements Validation<AliquotaPostDto, AliquotaPutDto> {
    private final AliquotaRepository aliquotaRepository;

    @Transactional
    public AliquotaModel save(AliquotaPostDto aliquota) {
        validatedPost(aliquota);

        return aliquotaRepository.save(
                AliquotaRule.calculated(AliquotaMapper.toMapper(aliquota))
        );
    }

    public AliquotaModel update(AliquotaPutDto aliquota) {
        validatedPut(aliquota);

        return aliquotaRepository.save(
                AliquotaRule.calculated(AliquotaMapper.toMapper(aliquota, findById(aliquota.getId())))
        );
    }

    public void delete(UUID id) {
        aliquotaRepository.deleteById(id);
    }
    
    public AliquotaModel findById(UUID id) {
        return aliquotaRepository.findById(id).orElseThrow(
                () -> new ExceptionGeneric("", "", 400)
        );
    }

    public List<AliquotaModel> findAll() {
        return aliquotaRepository.findAll();
    }

    @Override
    public boolean validatePost(AliquotaPostDto value) {
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
    public void validatedPost(AliquotaPostDto value) {
        if(!validatePost(value))
            throw new ExceptionGeneric("", "", 404);
    }

    @Override
    public boolean validatePut(AliquotaPutDto value) {
        return Stream.of(
                NotNull.isValid(value.getRendimentos()),
                PositiveOrZero.isValid(value.getRendimentos())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validatedPut(AliquotaPutDto value) {
        if(!validatePut(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
