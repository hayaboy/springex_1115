package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Repository
//@Primary //단일 값 종속성을 자동 연결하기 위해 여러 후보가 자격을 갖춘 경우 Bean에 우선 순위를 부여해야 함을 나타냅니다
public class EventSampleDAOImpl implements SampleDAO{
}
