package com.cs79_1.interactive_dashboard.Controller;

import com.cs79_1.interactive_dashboard.Service.BatchImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ops/import")
public class BatchImportController {

    @Autowired
    private BatchImportService batchImportService;

    private static final Logger logger = LoggerFactory.getLogger(BatchImportController.class);

    @PostMapping("/individual-attributes")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> importIndividualAttributes(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()){
                return ResponseEntity.badRequest().body("File is empty");
            }

            String fileName = file.getOriginalFilename();
            if (fileName == null || !fileName.toLowerCase().endsWith(".csv")) {
                return ResponseEntity.badRequest().body("File is not csv");
            }

            batchImportService.importIndividualAttributes(file);
            return ResponseEntity.ok("Import successful");
        } catch (Exception e) {
            logger.error("Error importing Individual Attributes: " + e.getMessage() + e.getStackTrace());
            return ResponseEntity.badRequest().body("Error importing Individual Attributes: " + e.getMessage());
        }
    }

    @PostMapping("/workout-single")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> importWorkoutSingle(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("participantId") String participantId) {
        try {
            if (file.isEmpty()){
                return ResponseEntity.badRequest().body("File is empty");
            }

            batchImportService.importWorkoutAmountData(file, participantId);
            return ResponseEntity.ok("Import WorkoutAmount data of " + participantId + "successful");
        } catch (Exception e) {
            logger.error("Error importing WorkoutSingle: " + e.getMessage() + e.getStackTrace());
            return ResponseEntity.badRequest().body("Error importing WorkoutSingle: " + e.getMessage());
        }
    }

    @PostMapping("/workout-batch")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> importWorkoutBatch(@RequestParam("files") MultipartFile[] files) {
        try {
            if (files.length == 0){
                return ResponseEntity.badRequest().body("Please select at least one file");
            }

            batchImportService.importMultipleWorkoutAmountData(files);
            return ResponseEntity.ok("Import successful");
        } catch (Exception e) {
            logger.error("Error importing WorkoutBatch: " + e.getMessage() + e.getStackTrace());
            return ResponseEntity.badRequest().body("Error importing WorkoutBatch: " + e.getMessage());
        }
    }

    @GetMapping("/status")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Batch Import Service is running");
    }
}
