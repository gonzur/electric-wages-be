package io.electricwages.server.repositories;

import io.electricwages.server.models.EmployeeHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeHourRepository extends JpaRepository<EmployeeHour, Long> {
}
