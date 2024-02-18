package AuctionAPI.service;

import AuctionAPI.component.validation.component.NotEmpty;
import AuctionAPI.component.validation.component.NotNull;
import AuctionAPI.component.validation.component.PositiveOrZero;
import AuctionAPI.component.validation.rule.Validation;
import AuctionAPI.dto.ProductDto;
import AuctionAPI.exception.ExceptionGeneric;
import AuctionAPI.mapper.ProductMapper;
import AuctionAPI.model.ProductModel;
import AuctionAPI.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService implements Validation<ProductDto> {
    private final ProductRepository productRepository;

    public ProductModel save(ProductDto product) {
        validated(product);

        return productRepository.save(ProductMapper.toMapper(product));
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> listAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean validate(ProductDto value) {
        return Stream.of(
                NotNull.isValid(value.getName()),
                NotNull.isValid(value.getDescription()),
                NotNull.isValid(value.getManufacturer()),
                NotNull.isValid(value.getMinimumPrice()),
                NotEmpty.isValid(value.getName()),
                NotEmpty.isValid(value.getDescription()),
                NotEmpty.isValid(value.getManufacturer()),
                PositiveOrZero.isValid(value.getMinimumPrice())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(ProductDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
