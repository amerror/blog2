package com.company.controller;

import com.company.service.CategoryService;
import com.company.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zytwl
 */
@RestController
@RequestMapping(value = "categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result categories(){
        return categoryService.findAll();
    }
}
