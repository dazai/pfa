package tn.epi.pfa.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.epi.pfa.doa.IImageDao;
import tn.epi.pfa.doa.IParagraphDao;
import tn.epi.pfa.doa.ITitleDao;
import tn.epi.pfa.dto.LessonDto;
import tn.epi.pfa.dto.LessonResponse;
import tn.epi.pfa.dto.LessonResponseDto;
import tn.epi.pfa.dto.RestResponse;
import tn.epi.pfa.entities.*;
import tn.epi.pfa.services.ILessonService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private ILessonService iLessonService;

    @Autowired
    private IImageDao iImageDao;

    @Autowired
    private IParagraphDao iParagraphDao;

    @Autowired
    private ITitleDao iTitleDao;

    @GetMapping
    @ApiOperation("Get all lessons")
    @ApiResponse(code = 200, message = "sucess", response = Lesson[].class)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iLessonService.findAll());
    }

    @GetMapping("/content/{id}")
    public ResponseEntity<?> findAllBlocs(@PathVariable Long id) {
        List<Image> images = iImageDao.findAllByLessonId(id);
        List<Paragraph> paragraphs = iParagraphDao.findAllByLessonId(id);
        List<Title> titles = iTitleDao.findAllByLessonId(id);
        LessonResponseDto response = new LessonResponseDto();
        LessonResponse lesson = iLessonService.findById(id);
        response.setLessonTitle(lesson.getLessonTitle());
        List<Bloc> blocs = new ArrayList<>();
        blocs.addAll(images);
        blocs.addAll(paragraphs);
        blocs.addAll(titles);
        blocs.sort(Comparator.comparing(Bloc::getOrderValue));
        response.setBlocs(blocs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get lesson by id")
    @ApiResponse(code = 200, message = "success", response = Lesson.class)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iLessonService.findById(id));
    }

    @PostMapping
    @ApiOperation("Add new lesson")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> save(@RequestBody LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setLessonTitle(lessonDto.getLessonTitle());
        lesson.setSubjectId(lessonDto.getSubjectId());
        iLessonService.save(lesson);
        return ResponseEntity.ok(new RestResponse(true, "Lesson added successfully"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete lesson by id")
    @ApiResponse(code = 200, message = "success", response = RestResponse.class)
    public ResponseEntity<?> delete(@PathVariable Long id){
        iLessonService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Lesson deleted successfully"));
    }
}
