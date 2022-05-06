package com.example.accessingdataneo4j.model.repository.st;

import com.example.accessingdataneo4j.model.domain.st.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, String> {

}
