package com.company.vo.params;

import lombok.Data;

/**
 * @author zytwl
 */
@Data
public class LoginParam {
    private String account;
    private String password;
    private String nickname;
}
