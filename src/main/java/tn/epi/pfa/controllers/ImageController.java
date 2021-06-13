package tn.epi.pfa.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.epi.pfa.dto.ImageDto;
import tn.epi.pfa.dto.RestResponse;
import tn.epi.pfa.entities.Image;
import tn.epi.pfa.services.IImageService;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private IImageService iImageService;


    @GetMapping
    @ApiOperation("Get all images")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success", response = Image[].class)
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iImageService.findAll());
    }

    @ApiOperation("Get image by id")
    @ApiResponse(code = 200, message = "success", response = Image.class)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iImageService.findById(id));
    }

    @PostMapping
    @ApiOperation("Add new image")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> save(@RequestBody ImageDto imageDto) throws IOException {

        Image image = new Image();
        image.setImageId(new ObjectId().toString());
        image.setLegend(imageDto.getLegend());
        image.setOrderValue(imageDto.getOrderValue());
        image.setUrl(imageDto.getUrl());
        image.setLessonId(imageDto.getLessonId());
        iImageService.save(image);
        return ResponseEntity.ok(new RestResponse(true, "Image added successfully"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete image by id")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iImageService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Image deleted successfully"));
    }
}
