package AliquotaAnual.controller;

import AliquotaAnual.dto.AliquotaPostDto;
import AliquotaAnual.dto.AliquotaPutDto;
import AliquotaAnual.model.AliquotaModel;
import AliquotaAnual.service.AliquotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aliquota")
public class AliquotaController {
    private final AliquotaService aliquotaService;

    @PostMapping("")
    public ResponseEntity<AliquotaModel> save(AliquotaPostDto aliquota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aliquotaService.save(aliquota));
    }

    @PutMapping("")
    public ResponseEntity<AliquotaModel> update(AliquotaPutDto aliquota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aliquotaService.update(aliquota));
    }

    @DeleteMapping("")
    public ResponseEntity<AliquotaModel> update(@RequestParam UUID id) {
        aliquotaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<AliquotaModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(aliquotaService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AliquotaModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(aliquotaService.findAll());
    }
}
