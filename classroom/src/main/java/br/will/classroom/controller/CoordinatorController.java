package br.will.classroom.controller;

import br.will.classroom.controller.dto.CoordinatorExampleDto;
import br.will.classroom.model.coordinator.Coordinator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.service.CoordinatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("coordenador")
public class CoordinatorController {
    @Autowired
    private CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Save and Register Coordinators "))
    @Operation(summary = "Create a Coordinator and return status (200)", tags = "Coordinator")
    @PostMapping
    public ResponseEntity<CoordinatorDto> createCoordinator(@RequestBody CoordinatorDto coordinatorDto) {
        return ResponseEntity.status(200).body(this.coordinatorService.createCoordinator(coordinatorDto).convert());
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Get information from Coordinators by id "))
    @Operation(summary = "Get a Coordinator by Id and return status (200)", tags = "Coordinator")
    @GetMapping("/{id}")
    public ResponseEntity<CoordinatorDto> getCoordinatorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.coordinatorService.getCoordinatorId(id).convert());
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Update information from a Coordinator "))
    @Operation(summary = "Update a Coordinator and return status (200)", tags = "Coordinator")
    @PutMapping
    public ResponseEntity <CoordinatorDto> updateCoordinator(@RequestBody CoordinatorDto coordinatorDto) {
        return ResponseEntity.status(200).body(this.coordinatorService.updateCoordinator(coordinatorDto).convert());
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Deletes a Coordinator's information using their ID"))
    @Operation(summary = "Deletes a Coordinator and returns status (200)", tags = "Coordinator")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.coordinatorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    
}
