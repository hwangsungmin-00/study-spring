package minimin.springstudy.controller;

import minimin.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired //의존성을 넣어 준다고 생각
    public MemberController(MemberService memberService){
        this.memberService= memberService;
    }
}
