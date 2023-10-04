package AuctionAPI.controller;

import AuctionAPI.dto.AuctionDto;
import AuctionAPI.dto.SaleDto;
import AuctionAPI.model.AuctionModel;
import AuctionAPI.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {
    private final AuctionService auctionService;

    @PostMapping("")
    public ResponseEntity<AuctionModel> save(@RequestBody AuctionDto auction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(auctionService.save(auction));
    }

    @PostMapping("/sale")
    public ResponseEntity<AuctionModel> sale(@RequestBody SaleDto sale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(auctionService.sale(sale));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuctionModel>> save() {
        return ResponseEntity.status(HttpStatus.CREATED).body(auctionService.listAll());
    }
}
