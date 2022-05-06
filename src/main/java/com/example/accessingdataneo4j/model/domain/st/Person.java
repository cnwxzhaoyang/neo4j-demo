package com.example.accessingdataneo4j.model.domain.st;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/5/5
 */

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer born;

    @Relationship("REVIEWED")
    private List<Movie> reviewed = new ArrayList<>();

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

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public List<Movie> getReviewed() {
        return reviewed;
    }

    public void setReviewed(List<Movie> reviewed) {
        this.reviewed = reviewed;
    }
}
