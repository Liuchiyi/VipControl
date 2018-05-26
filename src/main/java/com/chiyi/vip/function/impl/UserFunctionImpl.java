package com.chiyi.vip.function.impl;

import static com.chiyi.common.AssertThrowUtil.*;

import com.chiyi.common.AssertThrowUtil;
import com.chiyi.common.ThisSystemException;
import com.chiyi.common.ThisSystemUtil;
import com.chiyi.vip.dao.UserDao;
import com.chiyi.vip.entity.UserEntity;
import com.chiyi.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserDao userDao;
    @Override
    public UserEntity login(String account, String password) throws Exception {
        account = $("账户不能为空",account);
        password = $("密码不能为空",password);
        password = ThisSystemUtil.EncoderByMd5(password);
        UserEntity userEntity = (UserEntity) userDao.select("account",account);
        if(userEntity == null){
            throw new ThisSystemException("账户不存在！");
        }
        if(!userEntity.getPassword().equals(password)){
            throw new ThisSystemException("密码错误！");
        }
        return userEntity;
    }

    @Override
    public UserEntity updatePassword(String id,String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1验证参数
        id = $("id不能为空",id);
        oldPassword = $("oldPassword不能为空",oldPassword);
        newPassword = $("newPassword不能为空",newPassword);
        newPasswordConfirm = $("newPasswordConfirm不能为空",newPasswordConfirm);
        assertEquals("两次密码不一致",newPassword,newPasswordConfirm);
        assertNotEquals("新密码和旧密码不能一样",oldPassword,newPassword);

        //2找到用户
        UserEntity userEntity = (UserEntity) userDao.select("id",id);
        assertNotNull("该用户不存在",userEntity);

        //3验证旧密码
        oldPassword = ThisSystemUtil.EncoderByMd5(oldPassword);
        assertEquals("旧密码不正确",userEntity.getPassword(),oldPassword);

        //4更新新密码
        newPassword = ThisSystemUtil.EncoderByMd5(newPassword);
        userEntity.setPassword(newPassword);

        userDao.update(userEntity);
        return userEntity;
    }
}
