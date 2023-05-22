package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer>,
        PagingAndSortingRepository<Question, Integer> {

}
