package com.solera.crm.repository;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    List<Opportunity> findByUser(User user);
}
