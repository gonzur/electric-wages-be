package io.electricwages.server.repositories;

import io.electricwages.server.models.DailyTimeReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTimeReportRepository extends JpaRepository<DailyTimeReport, Long> {
}
