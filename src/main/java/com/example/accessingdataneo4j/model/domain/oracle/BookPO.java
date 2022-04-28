package com.example.accessingdataneo4j.model.domain.oracle;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * description:
 * 按钮
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2021/5/26 10:24
 */
@Entity
@Table(name = "TEST_BOOK")
@ToString
public class BookPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_TEST_BOOK")
    private Long id;

    private String name;

    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookPO buttonPO = (BookPO) o;

        return Objects.equals(id, buttonPO.id);
    }

    @Override
    public int hashCode() {
        return 2093849622;
    }
}
