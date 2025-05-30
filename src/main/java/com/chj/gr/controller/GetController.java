package com.chj.gr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chj.gr.config.properties.SwaggerParamsProperties;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Execution GET", description = "Endpoints for executing GET operation..")
@RestController
@RequestMapping("/squeleton/get")
public class GetController {

	private SwaggerParamsProperties swaggerParamsProperties;
	
    public GetController(SwaggerParamsProperties swaggerParamsProperties) {
		this.swaggerParamsProperties = swaggerParamsProperties;
	}
	
	@GetMapping("/test0")
	public ResponseEntity<String> test() throws Exception {

		return ResponseEntity.ok(swaggerParamsProperties.toString());
	}
	
	
	
    @Operation(summary = "Execute test1", 
			description = "Execute test1 description")
    @ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "test1", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Invalid or empty count", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
	})
	@GetMapping("/test1")
	public ResponseEntity<String> test(@Parameter(description = "count of", required = true) int count) throws Exception {

		return ResponseEntity.ok("Exécution completed '/test'");
	}
    
	
	@Operation(summary = "Execute test1", 
			description = "Execute test1 description")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "test1", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Invalid or empty record list", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
	})
    @GetMapping("/test2")
    public ResponseEntity<String> test2() {
        
		return ResponseEntity.ok("Exécution completed '/tes2'");
    }
    
	@Operation(summary = "Execute test3", 
			description = "Execute test3 description")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "test3", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Invalid or empty record list", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
	})
    @GetMapping("/test3")
    public ResponseEntity<String> test3() {
    	
		return ResponseEntity.ok("Exécution completed '/tes3'");
    }

	
	@Operation(summary = "Execute test4", 
			description = "Execute test4 description")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "test4", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Invalid or empty record list", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
	})
    @GetMapping("/test4")
    public ResponseEntity<String> test4() {
    	
		return ResponseEntity.ok("Exécution completed '/test4'");
    }
    
    
}
