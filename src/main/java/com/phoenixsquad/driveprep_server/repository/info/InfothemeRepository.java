package com.phoenixsquad.driveprep_server.repository.info;

import com.phoenixsquad.driveprep_server.model.info.Infotheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfothemeRepository extends CrudRepository<Infotheme, Long> {

    @Query("SELECT t FROM Infotheme t INNER JOIN Sign s ON t.id = s.infotheme.id")
    List<Infotheme> getSignInfoThemes();

    @Query("SELECT t FROM Infotheme t INNER JOIN Rule r ON t.id = r.infotheme.id")
    List<Infotheme> getRuleInfoThemes();

}
