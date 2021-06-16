package io.electricwages.server.repositories;

import io.electricwages.server.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long> {
}
