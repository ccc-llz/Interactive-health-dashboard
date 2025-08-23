package com.cs79_1.interactive_dashboard.Repository;

import com.cs79_1.interactive_dashboard.Entity.WeightMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightMetricsRepository extends JpaRepository<WeightMetrics, Long> {
}
