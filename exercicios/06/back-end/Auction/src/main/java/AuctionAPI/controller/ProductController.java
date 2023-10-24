package AuctionAPI.controller;

import AuctionAPI.dto.ProductDto;
import AuctionAPI.model.ProductModel;
import AuctionAPI.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductModel> save(@RequestBody ProductDto product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAll());
    }
}
