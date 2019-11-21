package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    public List<Category> queryAllRootLeveCat();

    public List<CategoryVO> queryAllRootLeveCat(Integer rootCatId);

}
