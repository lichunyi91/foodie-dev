package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import lombok.Data;

import java.util.List;

@Data
public class ItemInfoVO {
    private Items item;
    private List<ItemsImg> itemsImgList;
    private List<ItemsSpec> itemsSpecList;
    private ItemsParam itemsParam;

}
