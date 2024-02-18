package AuctionAPI.service;

import AuctionAPI.component.validation.component.*;
import AuctionAPI.component.validation.rule.Validation;
import AuctionAPI.dto.BidDto;
import AuctionAPI.exception.ExceptionGeneric;
import AuctionAPI.mapper.BidMapper;
import AuctionAPI.model.BidModel;
import AuctionAPI.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BidService implements Validation<BidDto> {
    private final BidRepository bidRepository;
    private final UserExists userExists;
    private final AuctionExists auctionExists;
    private final AuctionNotFinish auctionNotFinish;

    public BidModel save(BidDto bid) {
        validated(bid);

        return bidRepository.save(BidMapper.toMapper(bid));
    }

    public void deleteById(UUID id) {
        bidRepository.deleteById(id);
    }

    public List<BidModel> listHighestBidsByAuction(UUID auction) {
        var listHighestBids = bidRepository.findAllByAuction(auction).orElseThrow(
                () -> new ExceptionGeneric("", "", 400)
        );

        return listHighestBids.stream()
                .sorted(Comparator.comparing(BidModel::getBidAmount).reversed())
                .limit(3).collect(Collectors.toList());
    }

    @Override
    public boolean validate(BidDto value) {
        return Stream.of(
                NotNull.isValid(value.getUser()),
                NotNull.isValid(value.getAuction()),
                NotNull.isValid(value.getBigAmount()),
                PositiveOrZero.isValid(value.getBigAmount()),
                userExists.isValid(value.getUser()),
                auctionExists.isValid(value.getAuction()),
                auctionNotFinish.isValid(value.getAuction())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(BidDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
