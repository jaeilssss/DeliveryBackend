package com.example.deliverybackend.interfaces.category;

import com.example.deliverybackend.application.category.CategoryFacade;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryApiController extends BaseController {
    private final CategoryFacade categoryFacade;
    private final CategoryDtoMapper categoryDtoMapper;

    @PostMapping("/add")
    public Response addCategory(@RequestBody @Valid CategoryDto.AddCategoryRequest addCategoryRequest) {
        System.out.println("컨트롤러 -> :" + addCategoryRequest.getCategoryName());
        categoryFacade.addCategory(categoryDtoMapper.of(addCategoryRequest));
        return Response.success(true);
    }

    @GetMapping("/get/all")
    public Response getAllCategory() {
        return Response.success(categoryFacade.getAllCategory());
    }

}
