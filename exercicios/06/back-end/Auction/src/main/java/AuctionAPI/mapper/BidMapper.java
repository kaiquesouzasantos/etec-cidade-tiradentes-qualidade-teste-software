package AuctionAPI.mapper;

import AuctionAPI.dto.BidDto;
import AuctionAPI.model.BidModel;
import org.springframework.beans.BeanUtils;

public class BidMapper {
    public static BidModel toMapper(BidDto objetoEntrada) {
        BidModel objetoSaida = new BidModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
