package com.cs79_1.interactive_dashboard.Controller;

import com.cs79_1.interactive_dashboard.Entity.WorkoutAmount;
import com.cs79_1.interactive_dashboard.Service.WorkoutAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    WorkoutAmountService workoutAmountService;

    @GetMapping("/raw/{userId}")
    public ResponseEntity<List<WorkoutAmount>> getWorkoutAmount(@PathVariable Long userId) {
        try {
            List<WorkoutAmount> data = workoutAmountService.getWorkoutAmountRawData(userId);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
