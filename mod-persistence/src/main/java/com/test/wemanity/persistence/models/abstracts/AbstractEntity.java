package com.test.wemanity.persistence.models.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Version
    private int version;

    @Getter
    @Setter
    private LocalDateTime datePersistence;

    @PrePersist
    protected void initDatePersistence() {
        datePersistence = LocalDateTime.now();
    }
}
