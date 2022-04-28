package com.example.accessingdataneo4j.model.domain.neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/28 15:46
 */
@Node
@Data
public class Part {

    @Id
    @GeneratedValue
    private Long id;

    private String itemCode;

    private String name;

    @Relationship(value = "has_part",direction = Relationship.Direction.OUTGOING)
    private Set<EBOM> eboms = new HashSet<>();

    private Long level;

    private String type;

    private String description;
}
