package AuctionAPI.controller;

import AuctionAPI.dto.BidDto;
import AuctionAPI.model.AuctionModel;
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

    @DeleteMapping("")
    public ResponseEntity<AuctionModel> delete(@RequestParam UUID id) {
        bidService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/highest")
    public ResponseEntity<List<BidModel>> findHighestBids(@RequestParam UUID auction) {
        return ResponseEntity.status(HttpStatus.OK).body(bidService.listHighestBidsByAuction(auction));
    }
}
