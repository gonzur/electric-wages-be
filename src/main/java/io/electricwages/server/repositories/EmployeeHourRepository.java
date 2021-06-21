package io.electricwages.server.repositories;

import io.electricwages.server.models.EmployeeHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeHourRepository extends JpaRepository<EmployeeHour, Long> {
}
