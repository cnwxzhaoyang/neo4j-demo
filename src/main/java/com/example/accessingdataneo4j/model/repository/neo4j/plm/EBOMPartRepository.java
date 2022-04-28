package com.example.accessingdataneo4j.model.repository.neo4j.plm;

import com.example.accessingdataneo4j.model.domain.neo4j.plm.EBOMPart;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EBOMPartRepository extends Neo4jRepository<EBOMPart, String> {

}
