package com.chiyi.vip.function;

import com.chiyi.vip.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface UserFunction {
    /**
     * 用户登陆
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public UserEntity login(String account, String password)throws Exception;

    @Transactional
    public UserEntity updatePassword(String id,String oldPassword, String newPassword, String newPasswordConfirm)throws Exception;
}
