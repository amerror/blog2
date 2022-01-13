package com.company.controller;

import com.company.service.LoginService;
import com.company.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zytwl
 */
@RestController
@RequestMapping(value ="logout")
public class LoginOutController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public Result LoginOut(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
