package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.dto.TestRequestParamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping()
    public String getController() {
        return "Hello World";
    }

    @PostMapping
    public String postController() {
        return "Hello World 22";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return String.format("Hello World! ID d %d", id);
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return String.format("Hello World! ID %d", id);
    }

    @GetMapping("/testModelAttribute")
    public String testControllerModelAttribute(@ModelAttribute TestRequestParamDTO testRequestParamDTO){
        return String.format("Hello World! ID %d Message : %s", testRequestParamDTO.getId(), testRequestParamDTO.getMessage());
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return String.format("Hello World! ID %d Message : %s", testRequestBodyDTO.getId(), testRequestBodyDTO.getMessage());
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();
        return responseDTO;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you go 400!");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();


//        return ResponseEntity.badRequest().body(responseDTO);
        return ResponseEntity.ok().body(responseDTO);
    }

}
