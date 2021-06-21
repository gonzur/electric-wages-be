package io.electricwages.server.repositories;

import io.electricwages.server.models.DailyTimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTimeReportRepository extends JpaRepository<DailyTimeReport, Long> {
}
