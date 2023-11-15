package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);


    List<TodoVO> selectAll();

   TodoVO selectOne(Long tno);

    void update(TodoVO todoVO);

    void delete(Long tno);

}
