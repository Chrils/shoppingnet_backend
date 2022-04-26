package com.cc.shoppingnet_backend.pojo.info;

import com.cc.shoppingnet_backend.pojo.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsAddInfo extends Goods {

    @Data
    public static class AttrItem {
        private Integer id;
        private Integer goodsId;
        private Integer attrId;
        private String attrVals;
    }

    private AttrItem[] attrs;

    private String rawImg;

}
