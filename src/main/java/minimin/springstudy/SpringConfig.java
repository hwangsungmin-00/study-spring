package minimin.springstudy;

import minimin.springstudy.repository.MemberRepository;
import minimin.springstudy.repository.MemoryMemberRepository;
import minimin.springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberSerice(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
