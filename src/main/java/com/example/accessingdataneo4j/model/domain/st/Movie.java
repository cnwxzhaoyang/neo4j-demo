package com.example.accessingdataneo4j.model.domain.st;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
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
public class Movie {

    @Id
    private String title;

    @Property("tagline")
    private String description;

    @Relationship(value = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Actor> actors = new ArrayList<>();

    @Relationship(value = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Person> directors = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }
}
