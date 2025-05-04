package com.chj.gr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chj.gr.model.MyModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Post Execution", description = "Endpoints for executing POST operations..")
@RestController
@RequestMapping("/execute/post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Operation(summary = "Execute MyModel saving", description = "Saves a list of MyModel and returns the execution time")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "MyModel execution completed successfully", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Invalid or empty record list", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/execute1")
    public ResponseEntity<String> execute1(
        @Parameter(description = "List of Objects to save", required = true)
        @RequestBody List<MyModel> records) {
        if (records == null || records.isEmpty()) {
            logger.warn("Received empty or null record list for synchronous execution");
            return ResponseEntity.badRequest().body("Record list cannot be empty");
        }
        logger.info("Received {} records for execution", records.size());
        long startTime = System.currentTimeMillis();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        long duration = System.currentTimeMillis() - startTime;
        return ResponseEntity.ok("Synchronous execution completed in " + duration + " ms");
    }

    @Operation(summary = "Execute MyModel saving", description = "Initiates saving of a list of records and returns immediately")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Execution started successfully", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Invalid or empty record list", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/execute2")
    public ResponseEntity<String> execute2(
        @Parameter(description = "List of records to save", required = true)
        @RequestBody List<MyModel> records) {
        if (records == null || records.isEmpty()) {
            logger.warn("Received empty or null record list for execution");
            return ResponseEntity.badRequest().body("Record list cannot be empty");
        }
        logger.info("Received {} records for execution", records.size());
        return ResponseEntity.ok("Execution started");
    }
}
