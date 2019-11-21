package com.imooc.controller;

import com.imooc.enums.YseOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouselService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页",tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping("/carousel")
    @ApiOperation(value = "获取首页的轮播图",notes = "获取首页的轮播图",httpMethod = "POST")
    public IMOOCJSONResult carousel(){
        List<Carousel> carousels = carouselService.queryAll(YseOrNo.YES.type);
        return IMOOCJSONResult.ok(carousels);
    }
}
