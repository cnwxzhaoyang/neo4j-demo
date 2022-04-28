package com.example.accessingdataneo4j.model.domain.neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/28 15:45
 */
@Data
@RelationshipProperties
public class EBOM {

    @Id @GeneratedValue
    private Long relationshipId;

    private Long quantity;

    private String name;

    @TargetNode
    private Part part;
}
