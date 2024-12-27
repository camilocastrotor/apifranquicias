package com.api.prueba.user.franquicia.services;

import com.api.prueba.user.common.exception.ResourceNotFoundException;
import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.FranchiseDTO;
import com.api.prueba.user.franquicia.model.dto.ProductDTO;
import com.api.prueba.user.franquicia.model.dto.TopProductDTO;
import com.api.prueba.user.franquicia.model.entity.Branch;
import com.api.prueba.user.franquicia.model.entity.Franchise;
import com.api.prueba.user.franquicia.model.entity.Product;
import com.api.prueba.user.franquicia.repository.BranchRepository;
import com.api.prueba.user.franquicia.repository.FranchiseRepository;
import com.api.prueba.user.franquicia.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchiseService {


    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FranchiseDTO addFranchise(FranchiseDTO franchiseDTO) {
        Franchise franchise = modelMapper.map(franchiseDTO, Franchise.class);
        Franchise savedFranchise = franchiseRepository.save(franchise);
        return modelMapper.map(savedFranchise, FranchiseDTO.class);
    }

    public BranchDTO addBranch(Long franchiseId, BranchDTO branchDTO) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));
        Branch branch = modelMapper.map(branchDTO, Branch.class);
        branch.setFranchise(franchise);
        Branch savedBranch = branchRepository.save(branch);
        return modelMapper.map(savedBranch, BranchDTO.class);
    }

    public ProductDTO addProduct(Long branchId, ProductDTO productDTO) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        Product product = modelMapper.map(productDTO, Product.class);
        product.setBranch(branch);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public ProductDTO updateStock(Long productId, int stock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(stock);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    public List<TopProductDTO> getTopProducts(Long franchiseId) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));

        return franchise.getBranches().stream().map(branch -> {
            Product topProduct = branch.getProducts().stream()
                    .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()))
                    .orElse(null);

            ProductDTO productDTO = topProduct != null ? modelMapper.map(topProduct, ProductDTO.class) : null;
            return new TopProductDTO(branch.getName(), productDTO);
        }).collect(Collectors.toList());
    }
    public FranchiseDTO updateFranchiseName(Long id, String newName) {
        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franchise not found"));

        franchise.setName(newName);
        franchiseRepository.save(franchise);

        return new FranchiseDTO(franchise.getId(), franchise.getName());
    }
}
