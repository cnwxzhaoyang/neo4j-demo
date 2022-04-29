package com.example.accessingdataneo4j.model.repository.neo4j.plm;

import com.example.accessingdataneo4j.model.domain.neo4j.plm.EBOMPart;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EBOMPartRepository extends Neo4jRepository<EBOMPart, Long> {

    @Query("match(a:EBOMPart) where a.itemCode = $itemCode return a")
    List<EBOMPart> queryByItemCode(@Param("itemCode")String itemCode);

    @Query("match(:EBOMPart{itemCode: $itemCode}) -->(x) return x")
    List<EBOMPart> queryChildrenByItemCode(@Param("itemCode")String itemCode);

//    @Query("match(:EBOMPart{itemCode: $itemCode})-[y:has_part] ->(x) return x,y")
//    List<EBOMPart> queryChildrenWithRelationByItemCode(@Param("itemCode")String itemCode);

    @Query("match(:EBOMPart{itemCode: $itemCode})-[y:has_part] ->(x) return x,collect(y)")
    List<EBOMPart> queryChildrenWithRelationByItemCode(@Param("itemCode")String itemCode);

    @Query("match path=(x)-[y:has_part] ->(z:EBOMPart) where x.itemCode=$itemCode return path")
    List<PathValue> queryPathByItemCode(@Param("itemCode")String itemCode);


}
