package tn.epi.pfa.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.epi.pfa.dto.ParagraphDto;
import tn.epi.pfa.dto.RestResponse;
import tn.epi.pfa.entities.Paragraph;
import tn.epi.pfa.services.IParagraphService;

@RestController
@RequestMapping("/paragraph")
public class ParagraphController {

    @Autowired
    private IParagraphService iParagraphService;

    @GetMapping
    @ApiOperation("Get all paragraphs")
    @ApiResponse(code = 200, message = "success", response = Paragraph[].class)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iParagraphService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Get paragraph by id")
    @ApiResponse(code = 200, message = "success", response = Paragraph.class)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iParagraphService.findById(id));
    }

    @PostMapping
    @ApiOperation("Add new paragraph")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> save(@RequestBody ParagraphDto paragraphDto) {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraphId(new ObjectId().toString());
        paragraph.setOrderValue(paragraphDto.getOrderValue());
        paragraph.setLessonId(paragraphDto.getLessonId());
        paragraph.setParagraphContent(paragraphDto.getParagraphContent());
        iParagraphService.save(paragraph);
        return ResponseEntity.ok(new RestResponse(true, "Paragraph added successfully"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete paragraph by id")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> delete(@PathVariable Long id){
        iParagraphService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Paragraph deleted successfully"));
    }
}
