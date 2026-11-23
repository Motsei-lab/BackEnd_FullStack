package com.mecerintered.backend_fullstack.Repository;

import com.mecerintered.backend_fullstack.Entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People,Long> {
}
