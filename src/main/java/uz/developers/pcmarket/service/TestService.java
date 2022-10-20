package uz.developers.pcmarket.service;

import uz.developers.pcmarket.entity.Test;
import uz.developers.pcmarket.payload.ApiResponce;

import java.util.List;

public interface TestService {
    List<Test> getTests();

    Test getTest(Integer id);

    ApiResponce addTest(Test test);

    ApiResponce editTest(Integer id, Test test);

    ApiResponce deleteTest(Integer id);
}
