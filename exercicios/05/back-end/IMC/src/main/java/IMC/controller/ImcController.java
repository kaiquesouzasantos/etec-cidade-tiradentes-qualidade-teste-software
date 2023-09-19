package IMC.controller;

import IMC.dto.ImcDto;
import IMC.model.ImcModel;
import IMC.service.ImcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imc")
public class ImcController {
    private final ImcService imcService;

    @GetMapping("")
    public ResponseEntity<ImcModel> save(ImcDto aliquota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(imcService.save(aliquota));
    }
}
