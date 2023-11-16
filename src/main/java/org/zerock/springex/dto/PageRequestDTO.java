package org.zerock.springex.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default  //해당 표현식은 빌드 중에 명시적으로 설정되지 않은 경우 사용되는 기본값으로 사용됩니다.
    @Min(value = 1)   //@Min, @Max는 외부에서 조작하지 못하도록 제약사항
    @Positive
    private int page = 1;


    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;


    //MyBatis는 기본적으로 getXXX, setXXX를 통해서 동작하므로 #{skip}의 경우
    // getSkip()을 호출함
    public int getSkip(){
        return (this.page-1)*10;
    }
}
