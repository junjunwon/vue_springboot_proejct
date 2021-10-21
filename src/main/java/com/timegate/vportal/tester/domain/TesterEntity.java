package com.timegate.vportal.tester.domain;

import com.timegate.vportal.common.config.CommonBuilder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name="tester")
public class TesterEntity {

    @Id
    @Column(name = "user_id", nullable = false, length = 20)
    private String id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(name = "birthday")
    private LocalDate birth;

    @Column(nullable = false, length = 20)
    private String cellPhone;

    public TesterEntity() {}

    public static class TesterBuilder implements CommonBuilder<TesterEntity> {
        private final String id;
        private final String email;
        private final String password;
        private final String name;
        private final LocalDate birth;
        private final String cellPhone;

        public TesterBuilder(TesterDto testerDto){
            this.id = testerDto.getId();
            this.email = testerDto.getEmail();
            this.password = testerDto.getPassword();
            this.name = testerDto.getName();
            this.birth = testerDto.getBirth();
            this.cellPhone = testerDto.getCellPhone();
        }

        @Override
        public TesterEntity build() {
            return new TesterEntity(this);
        }
    }

    private TesterEntity(TesterBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.name = builder.name;
        this.birth = builder.birth;
        this.cellPhone = builder.cellPhone;
    }
}