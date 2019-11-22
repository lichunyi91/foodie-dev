package com.imooc.controller;

import com.imooc.enums.YseOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/carousel")
    @ApiOperation(value = "获取首页的轮播图列表", notes = "获取首页的轮播图列表", httpMethod = "GET")
    public IMOOCJSONResult carousel() {
        List<Carousel> carousels = carouselService.queryAll(YseOrNo.YES.type);
        return IMOOCJSONResult.ok(carousels);
    }

    @GetMapping("/cats")
    @ApiOperation(value = "获取商品分类（一级分类）", notes = "获取商品分类（一级分类）", httpMethod = "GET")
    public IMOOCJSONResult cats() {
        List<Category> categories = categoryService.queryAllRootLeveCat();
        return IMOOCJSONResult.ok(categories);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            IMOOCJSONResult.errorMsg("分类不存在");
        }

        List<CategoryVO> categoryVOS = categoryService.queryAllRootLeveCat(rootCatId);
        return IMOOCJSONResult.ok(categoryVOS);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVO> sixNewItemsLazy = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(sixNewItemsLazy);
    }

}
