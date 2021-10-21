package com.timegate.vportal.tester.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timegate.vportal.common.utils.MessageLogger;
import com.timegate.vportal.tester.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TesterServiceImpl implements TesterService {

    @Autowired
    TesterEntityRepository testerEntityRepository;

    @Autowired
    ModelMapper modelMapper;

    MessageLogger logger = new MessageLogger();

    public TesterDto saveTester(TesterDto testerDto) {
        /* dto -> entity builder */
        TesterEntity testerEntity = new TesterEntity.TesterBuilder(testerDto).build();

        /* save (insert) */
        testerEntity = testerEntityRepository.save(testerEntity);

        return modelMapper.map(testerEntity, TesterDto.class);
    }

    public boolean removeTester(TesterDto testerDto) {
        /* dto -> entity builder */
        TesterEntity testerEntity = new TesterEntity.TesterBuilder(testerDto).build();

        try {
            /* remove (delete) */
            testerEntityRepository.delete(testerEntity);
        } catch (IllegalArgumentException e) {
            logger.errorLog(new Object(){}, e);
            return false;
        }

        return true;
    }

    public List<TesterDto> getTester(TesterDto testerDto) {
        List<TesterEntity> returnTesterEntity = new ArrayList<TesterEntity>();
        List<TesterDto> returnTesterDto = new ArrayList<TesterDto>();

        /* search (select) */
        if(testerDto.getId() != null && !testerDto.getId().isEmpty()) {
            if(testerEntityRepository.findById(testerDto.getId()).orElse(null) != null) {
                // search set to id value
                returnTesterEntity.add(testerEntityRepository.findById(testerDto.getId()).orElse(null));
            } else {
                // search for LIKE set to id value
                //return testerEntityRepository.findAllByNameIgnoreCaseStartsWith(testerDto.getId());
                returnTesterEntity = testerEntityRepository.findAllByIdLike("%"+testerDto.getId()+"%");
            }
            logger.infoLog(new Object(){}, "id");
        }
        else if( (testerDto.getName() != null && !testerDto.getName().isEmpty())
                && (testerDto.getEmail() != null && !testerDto.getEmail().isEmpty()) ) {
            returnTesterEntity = testerEntityRepository.findByNameOrEmail(testerDto.getName(), testerDto.getEmail());
            logger.infoLog(new Object(){}, "name&email");
        }
        else if(testerDto.getName() != null && !testerDto.getName().isEmpty()) {
            returnTesterEntity = testerEntityRepository.findByName(testerDto.getName());
            logger.infoLog(new Object(){}, "name");
        } else {
            returnTesterEntity = testerEntityRepository.findAll();
            logger.infoLog(new Object(){}, "findAll");
        }

        // return value mapping
        for(TesterEntity temp : returnTesterEntity) {
            returnTesterDto.add(modelMapper.map(temp, TesterDto.class));
        }

        return returnTesterDto;
    }

    /**
     * Querydsl test
     */
    private final JPAQueryFactory queryFactory;

    public TesterServiceImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<TesterDto> findByQuerydsl(TesterDto testerDto) {
        List<TesterDto> returnTesterDto = new ArrayList<TesterDto>();
        List<TesterEntity> returnTesterEntity =
                queryFactory.selectFrom(QTesterEntity.testerEntity)
                    .where(
                        QTesterEntity.testerEntity.id.like('%'+testerDto.getId()+'%')
                        /*
                        QTesterEntity.testerEntity.id.in(
                                JPAExpressions
                                        .select(QTesterEntity.testerEntity.id)
                                        .from(QTesterEntity.testerEntity)
                                        .where(QTesterEntity.testerEntity.id.like(testerDto.getId()))
                        )
                        */
                    )
                    .fetch();

        // return value mapping
        for(TesterEntity temp : returnTesterEntity) {
            returnTesterDto.add(modelMapper.map(temp, TesterDto.class));
        }

        return returnTesterDto;
    }

}
