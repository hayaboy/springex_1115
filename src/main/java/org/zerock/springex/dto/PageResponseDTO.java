package org.zerock.springex.dto;


import lombok.*;

import java.util.List;


@Data
@ToString
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor  대신
public class PageResponseDTO<E> {


    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    //게시판이나 회원 정보 등도 페이징 처리가 필요하므로 공통적인 처리를 위해서 제너릭으로 구성
    private List<E> dtoList;



    @Builder(builderMethodName = "withAll")  // withAll이라는 이름의 메서드가 빌더 클래스에 생성될 것입니다. 일반적으로 "with" 접두사를 사용하여 해당 필드의 값을 설정하는 메서드 이름을 지정
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
       this.page = pageRequestDTO.getPage();
       this.size = pageRequestDTO.getSize();

       this.total=total;
       this.dtoList=dtoList;

        this.end =   (int)(Math.ceil(this.page / 10.0 )) *  10;

        this.start = this.end - 9;

        int last =  (int)(Math.ceil((total/(double)size)));

        this.end =  end > last ? last: end;

        this.prev = this.start > 1;

        this.next =  total > this.end * this.size;


    }





}
