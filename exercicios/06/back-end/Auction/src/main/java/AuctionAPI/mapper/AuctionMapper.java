package AuctionAPI.mapper;

import AuctionAPI.component.dependency.DateDependency;
import AuctionAPI.dto.AuctionDto;
import AuctionAPI.model.AuctionModel;
import org.springframework.beans.BeanUtils;

public class AuctionMapper {
    public static AuctionModel toMapper(AuctionDto objetoEntrada) {
        AuctionModel objetoSaida = new AuctionModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        objetoSaida.setStart(DateDependency.getDate());

        return objetoSaida;
    }
}
