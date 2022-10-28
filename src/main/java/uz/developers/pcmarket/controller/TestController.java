package uz.developers.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.pcmarket.entity.Test;
import uz.developers.pcmarket.entity.User;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.UserDto;
import uz.developers.pcmarket.service.TestService;
import uz.developers.pcmarket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {


    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity<List<Test>> getTests() {
        List<Test> tests = testService.getTests();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tests);
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable Integer id) {
        return testService.getTest(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addTest(@RequestBody Test test) {
        ApiResponce apiResponce = testService.addTest(test);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editTest(@PathVariable Integer id, @RequestBody Test test) {
        ApiResponce apiResponce = testService.editTest(id,test);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Integer id) {
        ApiResponce apiResponce = testService.deleteTest(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }



}
