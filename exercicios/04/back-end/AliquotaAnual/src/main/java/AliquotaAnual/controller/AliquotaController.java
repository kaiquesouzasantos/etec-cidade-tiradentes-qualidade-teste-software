package AliquotaAnual.controller;

import AliquotaAnual.dto.AliquotaDto;
import AliquotaAnual.model.AliquotaModel;
import AliquotaAnual.service.AliquotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aliquota")
public class AliquotaController {
    private final AliquotaService aliquotaService;

    @GetMapping("")
    public ResponseEntity<AliquotaModel> save(@RequestBody AliquotaDto aliquota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aliquotaService.save(aliquota));
    }
}
