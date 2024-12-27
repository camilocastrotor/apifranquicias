package com.api.prueba.user.franquicia.controller;

import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.ProductDTO;
import com.api.prueba.user.franquicia.model.dto.TopProductDTO;
import com.api.prueba.user.franquicia.services.BranchService;
import com.api.prueba.user.franquicia.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{franchiseId}/branches/{branchId}/products")
    public ProductDTO addProduct(@PathVariable Long branchId, @RequestBody ProductDTO productDTO) {
        return productService.addProduct(branchId, productDTO);
    }

    @DeleteMapping("/branches/{branchId}/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/branches/{branchId}/products/{productId}/stock")
    public ProductDTO updateStock(@PathVariable Long productId, @RequestParam int stock) {
        return productService.updateStock(productId, stock);
    }

    @GetMapping("/{franchiseId}/top-products")
    public List<TopProductDTO> getTopProducts(@PathVariable Long franchiseId) {
        return productService.getTopProducts(franchiseId);
    }
    @PutMapping("/product/{id}/name")
    public ResponseEntity<ProductDTO> updateProductName(@PathVariable Long id, @RequestBody String newName) {
        ProductDTO updatedProduct = productService.updateProductName(id, newName);
        return ResponseEntity.ok(updatedProduct);
    }

}
