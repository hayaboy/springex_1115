package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//SampleService의 입장에서 인터페이스만 바라보므로 실제 객체가 SampleDAOImpl의 인스턴스인지 알 수 없지만, 코드를 작성하는데 아무런 문제가 없습니다.
//이처럼 객체와 객체의 의존 관계의 실제 객체를 몰라도 가능하게 하는 방식을 느슨한 결합(loose coupling)이라고 합니다.
//느슨한 결합을 이용하면 나중에 SampleDAO 타입의 객체를 다른 객체로 변경하더라도 SampleService 타입을 이용하는 코드를 수정할 일이 없기 때문에 보다 유연한 구조가 됩니다.
public interface SampleDAO {


}
