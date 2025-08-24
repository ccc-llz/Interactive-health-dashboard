package com.cs79_1.interactive_dashboard.Repository;

import com.cs79_1.interactive_dashboard.Entity.WorkoutAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutAmountRepository extends JpaRepository<WorkoutAmount, Long> {
    public void deleteByUserId(Long userId);
}
