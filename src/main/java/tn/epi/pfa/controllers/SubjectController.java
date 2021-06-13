package tn.epi.pfa.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.epi.pfa.dto.RestResponse;
import tn.epi.pfa.dto.SingleFieldRequest;
import tn.epi.pfa.entities.Subject;
import tn.epi.pfa.services.ISubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectService iSubjectService;

    @GetMapping
    @ApiOperation("Get all subjects")
    @ApiResponse(code = 200, message = "sucess", response = Subject[].class)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iSubjectService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Get subject by id")
    @ApiResponse(code = 200, message = "success", response = Subject.class)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iSubjectService.findById(id));
    }

    @PostMapping
    @ApiOperation("Add new subject")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> save(@RequestBody SingleFieldRequest subjectName) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName.getValue());
        iSubjectService.save(subject);
        return ResponseEntity.ok(new RestResponse(true, "Subject added successfully"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete subject by id")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> delete(@PathVariable Long id){
        iSubjectService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Subject deleted successfully"));
    }
}
