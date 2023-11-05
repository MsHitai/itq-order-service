package com.itqgroup.repository;

import com.itqgroup.model.Detail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    @Query("select d from Detail d left join fetch d.order")
    List<Detail> findAllWithOrders(Pageable page);

    @Query("select d from Detail d left join fetch d.order where d.id = :id")
    Optional<Detail> findByIdWithOrder(Long id);

}
