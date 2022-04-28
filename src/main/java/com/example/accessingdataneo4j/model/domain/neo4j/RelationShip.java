package com.example.accessingdataneo4j.model.domain.neo4j;

import lombok.Builder;
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
 * date 2022/4/28 11:24
 */
@Builder
@Data
@RelationshipProperties
public class RelationShip {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private Dept child;
}
