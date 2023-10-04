package AuctionAPI.mapper;

import AuctionAPI.dto.ProductDto;
import AuctionAPI.model.ProductModel;
import org.springframework.beans.BeanUtils;

public class ProductMapper {
    public static ProductModel toMapper(ProductDto objetoEntrada) {
        ProductModel objetoSaida = new ProductModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
