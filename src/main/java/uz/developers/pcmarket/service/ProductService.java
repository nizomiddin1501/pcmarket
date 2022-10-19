package uz.developers.pcmarket.service;

import uz.developers.pcmarket.entity.Product;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.ProductDto;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProduct(Integer id);

    ApiResponce addProduct(ProductDto productDto);

    ApiResponce editProduct(Integer id, ProductDto productDto);

    ApiResponce deleteProduct(Integer id);
}
