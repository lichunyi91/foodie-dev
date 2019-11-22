package com.imooc.service.impl;

import com.imooc.mapper.CategoryMapper;
import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryMapperCustom categoryMapperCustom;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLeveCat() {
        Example example =new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> queryAllRootLeveCat(Integer rootCatId) {
        List<CategoryVO> subCatList = categoryMapperCustom.getSubCatList(rootCatId);
        return subCatList;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
        public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("rootCatId",rootCatId);
            List<NewItemsVO> sixNewItemsLazy = categoryMapperCustom.getSixNewItemsLazy(map);
            return sixNewItemsLazy;
    }
}
