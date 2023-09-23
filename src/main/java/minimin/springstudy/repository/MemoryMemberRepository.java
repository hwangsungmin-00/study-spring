package minimin.springstudy.repository;

import minimin.springstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //시퀀스는 임의로 key를 만들어준다.
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id를 시퀀스를 올려서 설정해 줌
        store.put(member.getId(), member); //아이디와 멤버 정보를 store에 넣어주고
        return member; // 반환해줌
    }

    @Override
    public Optional<Member> finbyId(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional쓰면 반환값이 null이어도 감싸줌
    }

    @Override
    public Optional<Member> finbyName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 파라미터의 name이랑 name이 같을 떄만 필터 됨
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
