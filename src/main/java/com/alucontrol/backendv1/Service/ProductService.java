package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Projection.Product.ProductStockProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo de Leitura buscando um produto específico por meio do ID.
    public ResponseEntity<Product> findProductById(Long id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }

        return ResponseEntity.notFound().build();
    }

    //Metodo de Leitura buscando os produtos por meio da selecao de do tipo cadastrado
    public ResponseEntity<List<ItemPriceProjection>> findProductByType(String productType) {

        if (productRepository.findProductsByProductType(productType) == null){
            LoggerUtil.error("Product type " + productType + " not found.");
            return ResponseEntity.notFound().build();
        }

        List<ItemPriceProjection> products = productRepository.findProductsByProductType(productType);
        return ResponseEntity.ok(products);
    }

    //Method de leitura que busca os produtos por meio da seleção do tipo do cadastro e retorna a quantidade
    public ResponseEntity<List<ProductStockProjection>> findProductStockByType(String productType) {

        if (productRepository.findProductsAndQtyByProductType(productType) == null){
            throw new ResourceNotFoundException("Product type " + productType + " not found.");
        }

        List<ProductStockProjection> products = productRepository.findProductsAndQtyByProductType(productType);
        return ResponseEntity.ok(products);
    }
}
