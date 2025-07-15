package com.codegym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 ký tự")
    private String name;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 100000, message = "Giá khởi điểm phải ít nhất là 100,000 VND")
    private Double price;

    @NotBlank(message = "Tình trạng không được để trống")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp", referencedColumnName = "cid")
    @NotNull(message = "Vui lòng chọn loại sản phẩm")
    private ProductType productType;
}