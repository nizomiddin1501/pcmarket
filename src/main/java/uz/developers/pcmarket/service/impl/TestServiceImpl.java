package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.Test;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.repository.TestRepository;
import uz.developers.pcmarket.service.TestService;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getTests() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return testRepository.findAll();
    }

    @Override
    public Test getTest(Integer id) {
        Optional<Test> optionalTest = testRepository.findById(id);
        if (optionalTest.isPresent()) {
            return optionalTest.get();
        }
        return null;
    }

    @Override
    public ApiResponce addTest(Test test) {
        testRepository.save(test);
        return new ApiResponce("Test is saved",true);
    }

    @Override
    public ApiResponce editTest(Integer id, Test test) {
        Optional<Test> optionalTest = testRepository.findById(id);
        if (optionalTest.isEmpty()) {
            return new ApiResponce("Test is not found",false);
        }
        Test editingTest = optionalTest.get();
        editingTest.setName(test.getName());
        testRepository.save(editingTest);
        return new ApiResponce("Test is edited",true);
    }

    @Override
    public ApiResponce deleteTest(Integer id) {
        testRepository.deleteById(id);
        return new ApiResponce("Test is deleted",true);
    }
}
