package com.company.controller;

import com.company.service.LoginService;
import com.company.vo.Result;
import com.company.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zytwl
 */
@RestController
@RequestMapping(value ="login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
