package com.hujy.demo.mapper;

import com.hujy.demo.entity.Order;
import com.hujy.demo.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Description
 *
 * @author hujy
 * @version 1.0
 * @date 2019-09-19 16:46
 */
@Mapper
public interface OrderItemMapper {
    @Insert("insert into t_order_item(order_id,remark) values(#{orderId},#{remark})")
    Integer save(OrderItem orderItem);

    @Select("select order_id orderId  from t_order_item " +
            "where  order_id = #{orderId}")
    OrderItem selectByOrderId(Integer orderId);
}
