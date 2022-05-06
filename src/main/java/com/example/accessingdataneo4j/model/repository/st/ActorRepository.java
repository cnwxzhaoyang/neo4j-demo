package com.example.accessingdataneo4j.model.repository.st;

import com.example.accessingdataneo4j.model.domain.st.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<Actor, Long> {

}
