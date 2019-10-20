package com.victory.ddd.china.sample.infrastructure.dao;

import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PurchaseOrderDao {
//    @ResultMap("po.purchaseOrder")
    @Select("SELECT * FROM t_purchase_order")
    List<PurchaseOrderPO> getAll();

//    @ResultMap("po.purchaseOrder")
    @Select("SELECT * FROM t_purchase_order WHERE id = #{orderId}")
    Optional<PurchaseOrderPO> getById(@NonNull Integer orderId);

    @Insert("INSERT INTO t_purchase_order(code) VALUES(#{code})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(@NonNull PurchaseOrderPO order);
}
