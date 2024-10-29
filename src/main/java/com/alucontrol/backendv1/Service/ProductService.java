package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.DataAccessException;
import com.alucontrol.backendv1.Exception.InternalServerException;
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Product;
import com.alucontrol.backendv1.Projection.Product.ItemPriceProjection;
import com.alucontrol.backendv1.Projection.Product.ProductStockProjection;
import com.alucontrol.backendv1.Repository.ProductRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
    public Product saveProduct(Product product) {

        try{
            //Confitura o campo 'itemAvailableQty' com a mesma quantidade do campo 'itemQuantity'
            product.setItemAvailableQty(product.getItemQuantity());

            Product savedProduct = productRepository.save(product);

            LoggerUtil.info("Product saved successfully: " + savedProduct);
            return savedProduct;

        }catch (DataAccessException e){
            LoggerUtil.error("Error while saving product: " + product, e);
            throw new InternalServerException("Failed to save product data. " + e.getMessage());
        }
    }

    //Metodo de Atualização de Produtos que ja existentem por meio do "ID"
    public Product saveProductChanges(Product updatedProduct, Long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        LoggerUtil.info("Starting updating product: " + productOptional);

        if (productOptional.isPresent()) {

            Product product = productOptional.get();

            product.setItemDescription(updatedProduct.getItemDescription());
            product.setItemQuantity(updatedProduct.getItemQuantity());
            product.setItemAvailableQty(updatedProduct.getItemAvailableQty());
            product.setProductType(updatedProduct.getProductType());
            product.setItemPrice(updatedProduct.getItemPrice());
            product.setDateModified(updatedProduct.getDateModified());//this will get data and time when the item has been changed

            Product savedProduct = productRepository.save(product);

            LoggerUtil.info("Product Updated Successfully: " + savedProduct);
            return savedProduct;
        }

        throw new ResourceNotFoundException("Product ID:" + id + " not found");
    }

    //Metodo de Leitura buscando todos os produtos existentes na base de dados
    public List<Product> findAllProducts() {

        return productRepository.findAll();
    }

    //Metodo de Leitura buscando um produto específico por meio do "ID"
    public Product findProductById(Long id) {

        Optional<Product> productFound = productRepository.findById(id);

        if (productFound.isPresent()) {
            return productFound.get();
        }

        throw new ResourceNotFoundException("Product ID:" +  id + " not found.");
    }

    //Metodo de Leitura buscando os produtos por meio da selecao de do tipo cadastrado
    public List<ItemPriceProjection> findProductByType(String productType) {

        List<ItemPriceProjection> productsByType = productRepository.findProductsByProductType(productType);

        if (productsByType == null){
            throw new ResourceNotFoundException("Product Type:" + productType + " not found.");
        }

        return productsByType;
    }

    //Method de leitura que busca os produtos por meio da seleção do tipo do cadastro e retorna a quantidade
    public List<ProductStockProjection> findProductStockByType(String productType) {

        List<ProductStockProjection> productsFound = productRepository.findProductsAndQtyByProductType(productType);

        if (productsFound == null){
            throw new ResourceNotFoundException("Product Type:" + productType + " not found.");
        }

        return productsFound;
    }
}
