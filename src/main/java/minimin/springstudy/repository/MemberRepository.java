package minimin.springstudy.repository;

import minimin.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> finbyId(Long id);
    Optional<Member> finbyName(String name);
    List<Member> findAll();
}
