package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "select p from Product p where " +
            "p.name like concat('%', :name, '%') " +
            "and p.price >= :price " +
            "and (p.productType.cid = :typeId or :typeId = -1)")
    Page<Product> search(@Param("name") String name,
                         @Param("price") Double price,
                         @Param("typeId") Integer typeId,
                         Pageable pageable);
}