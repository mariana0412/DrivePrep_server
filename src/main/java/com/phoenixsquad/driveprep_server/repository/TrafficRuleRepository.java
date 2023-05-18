package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.TrafficRule;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TrafficRuleRepository implements TrafficRuleRepositoryInterface {
    @Override
    public <S extends TrafficRule> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TrafficRule> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TrafficRule> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<TrafficRule> findAll() {
        return null;
    }

    @Override
    public Iterable<TrafficRule> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(TrafficRule entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends TrafficRule> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
