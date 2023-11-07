package AuctionAPI.service;

import AuctionAPI.component.dependency.DateDependency;
import AuctionAPI.component.validation.component.NotNull;
import AuctionAPI.component.validation.component.ProductExists;
import AuctionAPI.component.validation.rule.Validation;
import AuctionAPI.dto.AuctionDto;
import AuctionAPI.dto.SaleDto;
import AuctionAPI.exception.ExceptionGeneric;
import AuctionAPI.mapper.AuctionMapper;
import AuctionAPI.model.AuctionModel;
import AuctionAPI.repository.AuctionRepository;
import AuctionAPI.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuctionService implements Validation<AuctionDto> {
    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;
    private final ProductExists productExists;

    public AuctionModel save(AuctionDto auction) {
        validated(auction);

        return auctionRepository.save(AuctionMapper.toMapper(auction));
    }

    public void deleteById(UUID id) {
        auctionRepository.deleteById(id);
    }

    public AuctionModel sale(SaleDto sale) {
        var auction = auctionRepository.findById(sale.auction()).orElseThrow(
                () -> new ExceptionGeneric("", "", 400)
        );

        auction.setFinish(DateDependency.getDate());
        auction.setBidChampion(auction.getHighestBid().getId());

        return auctionRepository.save(auction);
    }

    public List<AuctionModel> listAll() {
        return auctionRepository.findAll().stream().map(this::constructFull).collect(Collectors.toList());
    }

    private AuctionModel constructFull(AuctionModel auction) {
        constructAllBids(auction);
        constructCountBids(auction);
        constructHighestBid(auction);
        constructBidAverageValue(auction);

        return auction;
    }

    private void constructAllBids(AuctionModel auction) {
        auction.setAllBids(
                bidRepository.findAllByAuction(auction.getId()).orElseThrow(
                        () -> new ExceptionGeneric("", "", 400)
                )
        );
    }

    private void constructCountBids(AuctionModel auction) {
        auction.setCountBids(auction.getAllBids().size());
    }

    private void constructHighestBid(AuctionModel auction) {
        auction.setHighestBid(
                bidRepository.findByAuctionAndMaxBidAmount(auction.getId()).orElseThrow(
                        () -> new ExceptionGeneric("", "", 400)
                )
        );
    }

    private void constructBidAverageValue(AuctionModel auction) {
        auction.setBidAverageValue(
                bidRepository.bidAverageValue(auction.getId()).orElseThrow(
                        () -> new ExceptionGeneric("", "", 400)
                )
        );
    }

    @Override
    public boolean validate(AuctionDto value) {
        return Stream.of(
                NotNull.isValid(value.getProduct()),
                productExists.isValid(value.getProduct())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(AuctionDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
