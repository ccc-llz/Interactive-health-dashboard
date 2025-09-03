package com.cs79_1.interactive_dashboard.Repository;

import com.cs79_1.interactive_dashboard.Entity.User;
import com.cs79_1.interactive_dashboard.Entity.WeightMetrics;
import com.cs79_1.interactive_dashboard.Enum.WeightClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightMetricsRepository extends JpaRepository<WeightMetrics, Long> {

    @Query("SELECT w.iotfL FROM WeightMetrics w WHERE w.user = :user")
    public double getIotfLByUserId(@Param("user") User user);

    @Query("SELECT w.iotfM FROM WeightMetrics w WHERE w.user = :user")
    public double getIotfMByUserId(@Param("user") User user);

    @Query("SELECT w.iotfS FROM WeightMetrics w WHERE w.user = :user")
    public double getIotfSByUserId(@Param("user") User user);

    @Query("SELECT w.iotfZ FROM WeightMetrics w WHERE w.user = :user")
    public double getIotfZByUserId(@Param("user") User user);

    @Query("SELECT w.iotfPercentile FROM WeightMetrics w WHERE w.user = :user")
    public double getIotfPercentileByUserId(@Param("user") User user);

    @Query("SELECT w.iotfClassification FROM WeightMetrics w WHERE w.user = :user")
    public WeightClassification getIotfClassificationByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraL FROM WeightMetrics w WHERE w.user = :user")
    public double getCacheraLByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraM FROM WeightMetrics w WHERE w.user = :user")
    public double getCacheraMByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraS FROM WeightMetrics w WHERE w.user = :user")
    public double getCacheraSByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraZ FROM WeightMetrics w WHERE w.user = :user")
    public double getCacheraZByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraPercentile FROM WeightMetrics w WHERE w.user = :user")
    public double getCacheraPercentileByUserId(@Param("user") User user);

    @Query("SELECT w.cacheraClassification FROM WeightMetrics w WHERE w.user = :user")
    public WeightClassification getCacheraClassificationByUserId(@Param("user") User user);

    @Query("SELECT w.omsL FROM WeightMetrics w WHERE w.user = :user")
    public double getOmsLByUserId(@Param("user") User user);

    @Query("SELECT w.omsM FROM WeightMetrics w WHERE w.user = :user")
    public double getOmsMByUserId(@Param("user") User user);

    @Query("SELECT w.omsS FROM WeightMetrics w WHERE w.user = :user")
    public double getOmsSByUserId(@Param("user") User user);

    @Query("SELECT w.omsZ FROM WeightMetrics w WHERE w.user = :user")
    public double getOmsZByUserId(@Param("user") User user);

    @Query("SELECT w.omsPercentile FROM WeightMetrics w WHERE w.user = :user")
    public double getOmsPercentileByUserId(@Param("user") User user);

    @Query("SELECT w.omsClassification FROM WeightMetrics w WHERE w.user = :user")
    public WeightClassification getOmsClassificationByUserId(@Param("user") User user);

    @Query("SELECT w.cdcL FROM WeightMetrics w WHERE w.user = :user")
    public double getCdcLByUserId(@Param("user") User user);

    @Query("SELECT w.cdcM FROM WeightMetrics w WHERE w.user = :user")
    public double getCdcMByUserId(@Param("user") User user);

    @Query("SELECT w.cdcS FROM WeightMetrics w WHERE w.user = :user")
    public double getCdcSByUserId(@Param("user") User user);

    @Query("SELECT w.cdcZ FROM WeightMetrics w WHERE w.user = :user")
    public double getCdcZByUserId(@Param("user") User user);

    @Query("SELECT w.cdcPercentile FROM WeightMetrics w WHERE w.user = :user")
    public double getCdcPercentileByUserId(@Param("user") User user);

    @Query("SELECT w.cdcClassification FROM WeightMetrics w WHERE w.user = :user")
    public WeightClassification getCdcClassificationByUserId(@Param("user") User user);
}
