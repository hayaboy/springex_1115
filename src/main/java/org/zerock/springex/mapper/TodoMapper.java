package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);


    List<TodoVO> selectAll();

   TodoVO selectOne(Long tno);

    void update(TodoVO todoVO);

    void delete(Long tno);




    //페이징 처리(원하는 글의 갯수 선택) 후 글 요청
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);


    //글의 전체 갯수 구함
    int getCount(PageRequestDTO pageRequestDTO);



}
