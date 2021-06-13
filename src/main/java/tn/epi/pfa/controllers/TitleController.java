package tn.epi.pfa.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.epi.pfa.dto.RestResponse;
import tn.epi.pfa.dto.TitleDto;
import tn.epi.pfa.entities.Title;
import tn.epi.pfa.services.ITitleService;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private ITitleService iTitleService;

    @GetMapping
    @ApiOperation("Get all titles")
    @ApiResponse(code = 200, message = "success", response = Title[].class)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iTitleService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Get title by id")
    @ApiResponse(code = 200, message = "success", response = Title.class)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iTitleService.findById(id));
    }

    @PostMapping
    @ApiOperation("Add new title")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> save(@RequestBody TitleDto titleDto) {
        Title title = new Title();
        title.setTitleId(new ObjectId().toString());
        title.setTitleContent(titleDto.getTitleContent());
        title.setOrderValue(titleDto.getOrderValue());
        title.setLessonId(titleDto.getLessonId());
        iTitleService.save(title);
        return ResponseEntity.ok(new RestResponse(true, "Title added successfully"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete title by id")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> delete(@PathVariable Long id){
        iTitleService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Title deleted successfully"));
    }
}
