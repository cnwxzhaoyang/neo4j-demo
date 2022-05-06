package com.example.accessingdataneo4j.model.domain.example;

import org.springframework.data.neo4j.core.schema.RelationshipId;

import java.util.List;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/5/5
 */
public class Roles {

    @RelationshipId
    private Long id;

    private final List<String> roles;

    private final PersonEntity person;

    public Roles(List<String> roles, PersonEntity person) {
        this.roles = roles;
        this.person = person;
    }

    public List<String> getRoles(){
        return roles;
    }
}
