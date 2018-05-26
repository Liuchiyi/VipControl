package com.chiyi.vip.web.handler;

import com.chiyi.common.ThisSystemException;
import com.chiyi.vip.entity.UserEntity;
import com.chiyi.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginHandler {
    @Autowired
    UserFunction fun;

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request){
        try {
            UserEntity user=fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
        } catch (Exception e) {
            request.setAttribute("message",e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }


    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        //让当前session失效
        session.invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/updatepassword.do")
    public String updatepasswordView(){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/updatepassword.do")
    public String updatepassword(String oldPassword, String newPassword, String newPasswordConfirm,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity)session.getAttribute("currentUser");
        try {
            fun.updatePassword(userEntity.getId(),oldPassword,newPassword,newPasswordConfirm);
        } catch (ThisSystemException e) {
            request.setAttribute("message",e.getMessage());
            return "updatepassword";
        }
        session.setAttribute("message","修改成功，请重新登陆");
        return "redirect:/login.jsp";
    }
}
