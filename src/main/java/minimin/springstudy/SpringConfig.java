package minimin.springstudy;

import minimin.springstudy.repository.JpaMemberRepository;
import minimin.springstudy.repository.MemberRepository;
import minimin.springstudy.repository.MemoryMemberRepository;
import minimin.springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em){
        this.em=em;
    }

    @Bean
    public MemberService memberSerice(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
