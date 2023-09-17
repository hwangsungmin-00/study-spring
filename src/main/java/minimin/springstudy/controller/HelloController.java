package minimin.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //template에 있는 html파일 이름과 같으니 거기로 찾아간다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

// mvc 방식이랑 밑에 api 방식이랑 비교해보고 싶으면 소스 보기 해보면 된다=> 직관적인 차이를 알 수 있음 html 형식이냐 그냥 그대로 값이 들어가냐

    @GetMapping("hello-string")
    @ResponseBody  // 이 body는 http의 body부분임 (헤더랑 바디 있는거에서)
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;  //"hello spring"  View같은게 없이 이 값이 그냥 그대로 들어감
    }

    //text가 아닌 data를 전달해야 할 때 api방식이 유용함

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; //json 방식으로 나옴 
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
