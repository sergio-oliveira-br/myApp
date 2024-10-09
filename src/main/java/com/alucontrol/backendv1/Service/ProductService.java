package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Metodo de Salvamento
    public ResponseEntity<Product> saveProduct(Product product) {

        //Confitura o campo 'itemAvailableQty' com a mesma quantidade do campo 'itemQuantity'
        product.setItemAvailableQty(product.getItemQuantity());
        Product savedProduct = productRepository.save(product);
        LoggerUtil.info("Product saved successfully: " + savedProduct.toString());

        return ResponseEntity.ok(savedProduct);
    }

    //Metodo de Atualização de Produtos que ja existentem por meio do ID

    //Metodo de Leitura buscando todos os produtos existentes na base de dados
    public ResponseEntity<List<Product>> findAllProducts() {

        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    //Method de Leitura buscando uma despesa especifica

}
