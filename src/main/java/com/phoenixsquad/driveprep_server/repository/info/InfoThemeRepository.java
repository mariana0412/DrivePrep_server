package com.phoenixsquad.driveprep_server.repository.info;

import com.phoenixsquad.driveprep_server.model.info.InfoTheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoThemeRepository extends CrudRepository<InfoTheme, Long> {

    @Query("SELECT t FROM InfoTheme t INNER JOIN Sign s ON t.id = s.infoTheme.id")
    List<InfoTheme> getSignInfoThemes();

    @Query("SELECT t FROM InfoTheme t INNER JOIN Rule r ON t.id = r.infoTheme.id")
    List<InfoTheme> getRuleInfoThemes();

}
