package com.example.accessingdataneo4j.model.domain.example;

import org.springframework.data.neo4j.core.schema.Id;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/5/5
 */
public class PersonEntity {

    @Id
    private final String name;

    private final Integer born;

    public PersonEntity(String name, Integer born) {
        this.name = name;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public Integer getBorn() {
        return born;
    }
}
