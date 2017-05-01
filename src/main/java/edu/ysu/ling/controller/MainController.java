package edu.ysu.ling.controller;

import edu.ysu.ling.crawlerController.BossZhiPinController;
import edu.ysu.ling.pojo.User;
import edu.ysu.ling.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by 10047 on 2017/4/3.
 */
@Controller
public class MainController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(BossZhiPinController.class);
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /*@RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") String userId, Model model){
        User user = userService.findUserByUserId("1001");
        logger.info("userId----------"+userId);
        model.addAttribute("user", user);
        return "test";
    }*/

    @RequestMapping(value = "/User/register.do", method = RequestMethod.POST)
    public String RegisterUser(String account, String password, String emailCode, Model model , HttpServletRequest request) {
        if (account.length() == 0 || password.length() == 0 || emailCode.length() == 0) {
            return "login";
        }
        if (StringUtils.isNotBlank(emailCode)) {
            model.addAttribute("errormessage", "验证码错误");
        }
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setAccount(account);
        user.setMailAddress(account);
        user.setPassword(password);
        user = userService.addUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("userinfo", user);
        return "redirect:index";
    }

    @RequestMapping(value = "/User/login.do", method = RequestMethod.POST)
    public String LoginUser(String account, String password, Model model,HttpServletRequest request) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        if (userService.loginVerify(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("userinfo", user);
            return "redirect:/jsp/index.jsp";
        } else {
            model.addAttribute("errormessage", "账号或密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "/User/logout.do")
    public String LogoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "/jsp/index";
    }
}
