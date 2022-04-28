package com.example.accessingdataneo4j.model.domain.neo4j;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/28 11:22
 */
@Builder
@Node
@Data
public class Dept {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String deptName;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Dept> childDepts = new ArrayList<>();
}
