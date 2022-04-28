package com.example.accessingdataneo4j.model.domain.neo4j.plm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * description:
 * EBOM的装配关系
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/28 17:14
 */
@Data
@RelationshipProperties
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EBOMAsmRelation {

    @Id
    @GeneratedValue
    private Long id;

    private Long quantity;

    private String name;

    private String type;

    @TargetNode
    private EBOMPart assembledPart;

}
