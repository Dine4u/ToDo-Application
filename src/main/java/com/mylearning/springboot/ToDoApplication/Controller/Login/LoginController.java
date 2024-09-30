package com.mylearning.springboot.ToDoApplication.Controller.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes("name")
public class LoginController {

    // Version 1 without Spring Security

//    private LoginService loginService;
//    private Logger logger;
//
//    @Autowired
//    public  LoginController(LoginService loginService){
//        this.loginService= loginService;
//        this.logger= LoggerFactory.getLogger(getClass());
//    }
//    //returning as JSP view
//    @RequestMapping("/loginTest")
//    public String loginPageTest(@RequestParam String name, ModelMap modelMap){
////        logger.debug("Web URL parameter is "+name);
//        logger.info("Web URL parameter is "+name);
//        modelMap.put("name",name);
//        return "loginTest";
//    }
//
//    @RequestMapping(value = "/login") //By default GET is returned - we can directly use @GETMapping
//    public String loginPage(){
//        return "login";
//    }
//
//    @RequestMapping(value = "/login",method = RequestMethod.POST) //we can directly use @POSTMapping
//    public Object welcomePage(@RequestParam String name,@RequestParam String password,ModelMap modelMap){
//        //Authentication happens at this redirection level, so add authentication/validation in this method
//        if(loginService.authenticate(name,password)){
//            modelMap.put("name",name);
////            modelMap.addAttribute("name",name);//same as put() but not allow null values
////            modelMap.put("password",password);
//            return "welcome";
//        }
//        modelMap.put("errorMessage","Invalid Credentials");
//        return "login";
//    }




    // Version 2 with Spring Security
    private Logger logger;
//    private Authentication authentication; //helps to User details like name,etc

    @Autowired
//    public LoginController(Authentication authentication){ // didn't work since bean is not created and null is autowired
    public LoginController(){
        this.logger= LoggerFactory.getLogger(getClass());
//        this.authentication=authentication;
    }

    @RequestMapping("/")
    public String welcomePage(ModelMap modelMap){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        modelMap.put("name",userName);
        return "welcome";
    }


}
