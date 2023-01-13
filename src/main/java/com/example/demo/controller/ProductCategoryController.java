package com.example.demo.controller;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @PostMapping
    public ResponseEntity<?> createProductCategory(){
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().build();
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<?> getProductCategory(){
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().build();
        return ResponseEntity.ok().body(responseDTO);
    }
}
