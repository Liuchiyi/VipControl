package com.chiyi.vip.function.impl;

import com.chiyi.common.ThisSystemException;
import com.chiyi.common.ThisSystemUtil;
import com.chiyi.vip.dao.VIPDao;
import com.chiyi.vip.entity.VIPEntity;
import com.chiyi.vip.function.VipFunction;
import com.chiyi.vip.web.handler.ao.VIPAo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chiyi.common.AssertThrowUtil.*;

@Service
public class VipFunctionImpl implements VipFunction {
    @Autowired
    VIPDao vipDao;

    @Override
    public VIPEntity queryVip(String code) throws Exception {
        //1验证参数
        code=$("请填写Vip账号",code);
        //2业务处理
        VIPEntity vipEntity = vipDao.select("code",code);
        if(vipEntity == null){
            throw new ThisSystemException("未找到此VIP客户["+code+"]");
        }
        //3封装业务结果
        return vipEntity;
    }

    @Override
    public VIPEntity addVip(VIPAo ao) throws Exception {
        //1验证参数
        if(ao == null){
            throw new IllegalArgumentException("ao不能为空");
        }
        //1.1验证必须输入
        String phone = $("手机号码必须填写",ao.getPhone());
        String name = $("必须填入姓名",ao.getName());

        //1.2验证手机号是否合法

        assertPatternMatch("手机号码不合法","\\d{11}",phone);
        //1.3验证手机是否已存在
        assertFalse("手机号已经存在了",vipDao.exists("code",phone));
        //1.4验证名字是否合法
        assertPatternMatch("姓名不合法","[\\u4e00-\\u9fa5]{2,}",name);

        //1.5 验证性别
        boolean male = "1".equals(ao.getSex());

        //1.6 验证年龄
        int age = ThisSystemUtil.parseInt(ao.getAge(),0);

        //2业务处理
        VIPEntity v =new VIPEntity();
        v.setAddress(ao.getAddress());
        v.setAge(age);
        v.setAmount(0);
        v.setCode(phone);
        v.setEmail(ao.getEmail());
        v.setId(ThisSystemUtil.uuid());
        v.setName(name);
        v.setQq(ao.getQq());
        v.setRank(0);
        v.setRemark(ao.getRemark());
        v.setZip(ao.getZip());

        vipDao.insert(v);
        //封装业务结果
        return v;
    }
}
