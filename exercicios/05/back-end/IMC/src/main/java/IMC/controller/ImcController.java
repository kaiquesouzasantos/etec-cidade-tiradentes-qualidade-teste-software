package IMC.controller;

import IMC.dto.ImcPostDto;
import IMC.dto.ImcPutDto;
import IMC.model.ImcModel;
import IMC.service.ImcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imc")
public class ImcController {
    private final ImcService imcService;

    @PostMapping("")
    public ResponseEntity<ImcModel> save(@RequestBody ImcPostDto imc) {
        return ResponseEntity.status(HttpStatus.CREATED).body(imcService.save(imc));
    }

    @PutMapping("")
    public ResponseEntity<ImcModel> update(@RequestBody ImcPutDto imc) {
        return ResponseEntity.status(HttpStatus.CREATED).body(imcService.update(imc));
    }

    @DeleteMapping("")
    public ResponseEntity<ImcModel> update(@RequestParam UUID id) {
        imcService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<ImcModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(imcService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImcModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(imcService.findAll());
    }
}
