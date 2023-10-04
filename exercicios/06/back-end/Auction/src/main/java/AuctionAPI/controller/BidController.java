package AuctionAPI.controller;

import AuctionAPI.dto.BidDto;
import AuctionAPI.model.BidModel;
import AuctionAPI.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bid")
public class BidController {
    private final BidService bidService;

    @PostMapping("")
    public ResponseEntity<BidModel> save(@RequestBody BidDto bid) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bidService.save(bid));
    }

    @GetMapping("/highest")
    public ResponseEntity<List<BidModel>> save(@RequestParam UUID auction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bidService.listHighestBidsByAuction(auction));
    }
}
