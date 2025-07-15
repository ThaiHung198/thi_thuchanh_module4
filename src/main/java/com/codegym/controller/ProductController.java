package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    // Hiển thị danh sách và tìm kiếm (Giữ nguyên)
    @GetMapping("")
    public String showList(Model model,
                           @PageableDefault(size = 5) Pageable pageable,
                           @RequestParam Optional<String> searchName,
                           @RequestParam Optional<Double> searchPrice,
                           @RequestParam Optional<Integer> searchType) {

        String name = searchName.orElse("");
        Double price = searchPrice.orElse(0.0);
        Integer typeId = searchType.orElse(-1);

        Page<Product> productPage = productService.search(name, price, typeId, pageable);
        List<ProductType> productTypes = productTypeService.findAll();

        model.addAttribute("productPage", productPage);
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("name", name);
        model.addAttribute("price", price == 0.0 ? "" : price);
        model.addAttribute("typeId", typeId);

        return "list";
    }

    // Hiển thị form thêm mới (Giữ nguyên)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeService.findAll());
        return "create";
    }

    // Xử lý thêm mới (Giữ nguyên)
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute Product product,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypes", productTypeService.findAll());
            return "create";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sản phẩm thành công!");
        return "redirect:/products";
    }

    // ----- PHẦN SỬA (Giữ nguyên) -----
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "redirect:/products";
        }
        model.addAttribute("product", productOptional.get());
        model.addAttribute("productTypes", productTypeService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute Product product,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypes", productTypeService.findAll());
            return "edit";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/products";
    }

    // ----- PHẦN XÓA MỚI (THAY THẾ CHO CẢ 2 HÀM XÓA CŨ CỦA BẠN) -----
    // Hàm này xử lý cả xóa 1 và xóa nhiều sản phẩm
    @PostMapping("/delete")
    public String deleteProducts(@RequestParam("productIds") int[] productIds, RedirectAttributes redirectAttributes) {
        // Kiểm tra xem có ID nào được chọn không để tránh lỗi
        if (productIds == null || productIds.length == 0) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng chọn ít nhất một sản phẩm để xóa!");
        } else {
            productService.deleteMultiple(productIds);
            redirectAttributes.addFlashAttribute("message", "Đã xóa các sản phẩm được chọn!");
        }
        return "redirect:/products";
    }
}