package com.cs79_1.interactive_dashboard.Controller;

import com.cs79_1.interactive_dashboard.Security.SecurityUtils;
import com.cs79_1.interactive_dashboard.Service.FlaskAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simulation")
public class SimulationController {
    @Autowired
    FlaskAPIService flaskAPIService;

    private static final Logger logger = LoggerFactory.getLogger(SimulationController.class);

    @GetMapping("/heatmap")
    public ResponseEntity<?> getHeatmap() {
        long userId = SecurityUtils.getCurrentUserId();
        try {
            Object response = flaskAPIService.getHeatmap(userId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }

    }
}
