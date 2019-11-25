package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.bo.ShopcartVO;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    public Items queryItemById(String itemId);

    public List<ItemsImg> queryItemImgList(String itemId);

    public List<ItemsSpec> queryItemSpecList(String itemId);

    public ItemsParam queryItemParam(String itemId);

    public CommentLevelCountsVO queryCommentCounts(String itemId);

    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    public  PagedGridResult searchItems(String keywords,String sort,Integer page,Integer pageSize);

    public  PagedGridResult searchItems(Integer catId,String sort,Integer page,Integer pageSize);

    public  List<ShopcartVO> queryItemsBySpecIds(String specIds);

    public  ItemsSpec queryItemSpecById(String  specId);

    public  String queryItemMainImgById(String itemId);

    public  void decreaseItemSpecStock(String specId,int buyCounts);
}
