package com.example.cinemaspringboot.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController{
    @RequestMapping (value ="/")
        @ResponseBody

        public String home() {return "Hello";}

}
