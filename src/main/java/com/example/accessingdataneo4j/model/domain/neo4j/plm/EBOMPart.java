package com.example.accessingdataneo4j.model.domain.neo4j.plm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
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
 * date 2022/4/28 17:12
 */
@Node
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EBOMPart {

    @Id
    @GeneratedValue
    @Version
    private Long id;

    private String itemCode;

    private String name;

    private String version;

    private Long itemDefId = -1L;

    private String type;

    @Relationship(value = "has_part",direction = Relationship.Direction.OUTGOING)
    private Set<EBOMAsmRelation> asmRelations = new HashSet<>();
}
