package com.chiyi.vip.web.handler;



import com.chiyi.common.ThisSystemException;
import com.chiyi.vip.entity.VIPEntity;
import com.chiyi.vip.entity.VIPRankEntity;
import com.chiyi.vip.function.VipFunction;
import com.chiyi.vip.web.handler.ao.VIPAo;
import com.chiyi.vip.web.handler.vo.VIPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class VipHandler extends AbstractHandler{
    @Autowired
    VipFunction function;

    @RequestMapping(path = "/vip/qry.do" ,method = RequestMethod.GET)
    public String qryView()throws Exception{
        return "vip/qry";
    }

    @RequestMapping(path = "/vip/qry.do" ,method = RequestMethod.POST)
    public String qry(String code, HttpServletRequest request)throws Exception{
        try {
            VIPEntity v = function.queryVip(code);

            VIPVo vo=new VIPVo();
            vo.setAddress(v.getAddress());
            vo.setAge(String.valueOf(v.getAge()));
            vo.setAmount(String.valueOf(v.getAmount()/100.0));
            vo.setCode(v.getCode());
            vo.setEmail(v.getEmail());
            vo.setName(v.getName());
            vo.setQq(v.getQq());
            VIPRankEntity rank = this.getRank(request,v.getRank());
            //TODO:查询vip级别
            vo.setRank(rank.getName());
            vo.setRemark(v.getRemark());
            vo.setSex(v.isMale()?"男":"女");
            vo.setZip(v.getZip());
            request.setAttribute("v",vo);
        }catch (ThisSystemException e){
            request.setAttribute("message",e.getMessage());
        }
        return "vip/qry";
    }

    @RequestMapping(path = "/vip/add.do",method = RequestMethod.GET)
    public String addView(){
        return "vip/add";
    }

    @RequestMapping(path = "/vip/add.do",method = RequestMethod.POST)
    public String addVip(VIPAo ao,HttpServletRequest request)throws Exception{
        try{
            //1 ao传给业务方法执行
            VIPEntity vipEntity = function.addVip(ao);
            //2 业务跳转
            request.setAttribute("message","录入成功");
            //TODO:后期跳转到消费录入界面
            return "vip/add";
        }catch (ThisSystemException e){
            request.setAttribute("message",e.getMessage());
        }

        return "vip/add";
    }


}
