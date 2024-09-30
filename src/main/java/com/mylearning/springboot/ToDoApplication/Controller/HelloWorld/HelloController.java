package com.mylearning.springboot.ToDoApplication.Controller.HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody  //returns below method value to web page - use this instead of view like JSPs
    public String hello(){
        return "Hello! Welcome to my App";
    }

    //Above method using HTML - not effiicient, since all HTML codes should be mapped as below
    @RequestMapping("/hello-html")
    @ResponseBody  //returns below method value to web page - use this instead of view like JSPs
    public String hellohtml(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>HTML - Hello World!</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Hello Everyone! Welcome to my HTML page");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    //Above method using JSP
    @RequestMapping("/hello-jsp")
    public String hellojsp(){
        return "helloworld"; //this file should standand directory path that is META-INF/resources/WEB-INF/jsp/   - why? because dispatch servlet and view resolver points to this location by autoconfiguration
    }
}
