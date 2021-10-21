package com.timegate.vportal.tester.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TesterEntityRepository extends JpaRepository<TesterEntity, String> {

    List<TesterEntity> findByName(String name);

    List<TesterEntity> findByNameOrEmail(String name, String email);

    List<TesterEntity> findAllByNameIgnoreCaseStartsWith(String id);

    List<TesterEntity> findAllByIdLike(String id);
}

