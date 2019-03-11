package com.hy.salon.basic.dao;

import com.hy.salon.basic.entity.ProductStockMovement;
import com.hy.salon.basic.vo.ProductStockMovementVo;
import com.zhxh.core.data.BaseDAOWithEntity;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("productStockMovementDao")
public class ProductStockMovementDao extends BaseDAOWithEntity<ProductStockMovement> {
    public List<ProductStockMovement> getProductBymovementType(Integer recordCreateType,Long movementType) {
        Map parameters = new HashMap();
        parameters.put("recordCreateType", recordCreateType);
        parameters.put("movementType", movementType);
        String where = "record_create_type=#{recordCreateType} and movement_type=#{movementType}";
        Map listMap = new HashMap();
        listMap.put("where", where);
        return this.getList(listMap, parameters);
    }

    public List<ProductStockMovementVo> findProductStock(Integer movementType,String createTime,String endTime) {
        Map parameters = new HashMap();
        parameters.put("movementType", movementType);
        parameters.put("cTime", createTime);
        parameters.put("eTime", endTime);
        return this.getSqlHelper().getSqlSession().selectList(SQL_GET_PRODUCT_BY_TYPE, parameters);
    }
        protected final static String SQL_GET_PRODUCT_BY_TYPE = "com.hy.salon.basic.dao.GET_PRODUCT_BY_TYPE";

}