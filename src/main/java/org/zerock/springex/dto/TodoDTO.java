package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


//JPA에서는 DTO가 필수
@Data  // getter, setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {


    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;


    private boolean finished;

    @NotEmpty
    private String writer;
}
