package com.example.accessingdataneo4j.model.repository.neo4j;

import com.example.accessingdataneo4j.model.domain.neo4j.Part;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PartRepository extends Neo4jRepository<Part, Long> {

}
