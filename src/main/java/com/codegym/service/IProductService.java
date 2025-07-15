package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IProductService {
    Page<Product> search(String name, Double price, Integer typeId, Pageable pageable);
    void save(Product product);
    Optional<Product> findById(Integer id);
    void deleteById(Integer id);
    void deleteMultiple(int[] ids);
}