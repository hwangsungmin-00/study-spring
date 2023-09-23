package minimin.springstudy.controller;

import minimin.springstudy.domain.Member;
import minimin.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired //의존성을 넣어 준다고 생각
    public MemberController(MemberService memberService){
        this.memberService= memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member =new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
