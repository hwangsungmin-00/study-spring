package minimin.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //template에 있는 html파일 이름과 같으니 거기로 찾아간다.
    }
}
