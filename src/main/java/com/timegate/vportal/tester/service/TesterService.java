package com.timegate.vportal.tester.service;

import com.timegate.vportal.tester.domain.TesterDto;

import java.util.List;

public interface TesterService {

    /**
     * insert into tester
     *
     * @param testerDto
     * @return TesterEntity
     */
    public TesterDto saveTester(TesterDto testerDto);

    /**
     *  Delete from tester
     *
     * @param testerDto
     * @return boolean
     */
    public boolean removeTester(TesterDto testerDto);

    /**
     * multi search
     *
     * @param testerDto
     * @return List<TesterEntity>
     */
    public List<TesterDto> getTester(TesterDto testerDto);

    /**
     * Querydsl search
     *
     * @param testerDto
     * @return List<TesterDto>
     */
    public List<TesterDto> findByQuerydsl(TesterDto testerDto);
}
