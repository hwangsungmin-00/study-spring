package minimin.springstudy;

import minimin.springstudy.aop.TimeTraceAop;
import minimin.springstudy.repository.JpaMemberRepository;
import minimin.springstudy.repository.MemberRepository;
import minimin.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    public SpringConfig(EntityManager em){
        this.em=em;
    }
*/
    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

 */
/*
    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        //return new JpaMemberRepository(em);
    }

 */
}
