package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 이전에는 private final MemberRepository memberRepository = new MemberRepository();
    // 위와 같이 객체를 주입하여사용하였으나 이는 DIP에 위배됨

    // 오직 MemberRepository 인터페이스에만 의존
    private final MemberRepository memberRepository;

    // 이 생성자에서는 어떠한 구현 객체가 들어올 지 알 수 없음
    // 어떠한 구현 객체가 주입될지는 AppConfig에서만 결정 가능
    // 의존관계는 외부에 맡기고 실행에만 집중
    @Autowired
    public MemberServiceImpl(@Qualifier("memberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // Configuration 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
