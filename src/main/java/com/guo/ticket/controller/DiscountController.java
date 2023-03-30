package com.guo.ticket.controller;

import com.guo.ticket.common.entity.Response;
import com.guo.ticket.domain.entities.DiscountCategory;
import com.guo.ticket.domain.repositories.DiscountCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    
    @Autowired
    private DiscountCategoryRepository discountCategoryRepository;
    
    @GetMapping("/{code}")
    public Response<DiscountCategory> getDiscount(@PathVariable("code") String code) {
        DiscountCategory discount = discountCategoryRepository.getByCode(code);
        if (discount == null) {
            return Response.fail("Discount not found");
        }
        return Response.success(discount);
    }
    
    @PostMapping("")
    public Response<DiscountCategory> createDiscount(@RequestBody DiscountCategory discount) {
        discount.save();
        return Response.success(discount);
    }
    
    @PutMapping("/{code}")
    public Response<DiscountCategory> updateDiscount(@RequestBody DiscountCategory discount) {
        Assert.notNull(discount.getCode(), "编码不能为空");
        DiscountCategory oldDiscount = discountCategoryRepository.getByCode(discount.getCode());
        if (oldDiscount == null) {
            return Response.fail("Discount not found");
        }
        discount.update();
        return Response.success(oldDiscount);
    }
    
    @DeleteMapping("/{code}")
    public Response<String> deleteDiscount(@PathVariable("code") String code) {
        DiscountCategory discount = discountCategoryRepository.getByCode(code);
        if (discount == null) {
            return Response.fail("Discount not found");
        }
        discount.delete(discount.getId());
        return Response.success("Delete success");
    }
}
