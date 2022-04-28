package com.example.accessingdataneo4j.model.repository.oracle;

import com.example.accessingdataneo4j.model.domain.oracle.BookPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2021/5/27 8:45
 */
@Transactional
public interface BookRepository extends JpaRepository<BookPO, Long>, JpaSpecificationExecutor<BookPO> {
    List<BookPO> getAllByIdIn(Set<Long> id);

    List<BookPO> getAllByNameIsNotNull();

    void deleteAllByIdIn(Set<Long> id);



}
