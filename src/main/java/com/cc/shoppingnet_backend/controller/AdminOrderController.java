package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.shoppingnet_backend.pojo.Logistics;
import com.cc.shoppingnet_backend.pojo.TOrder;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.info.OrderInfo;
import com.cc.shoppingnet_backend.pojo.query.OrderQuery;
import com.cc.shoppingnet_backend.service.LogisticsService;
import com.cc.shoppingnet_backend.service.OrderService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/admin/order")
@RestController
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private LogisticsService logisticsService;

    /**
     * 分页查询订单
     * @return 携带订单列表的响应
     */
    @GetMapping("/list")
    public StandardResp list(OrderQuery query){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取订单列表成功");
            QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
            if (query.getPage() == null || query.getPage() < 1) {
                query.setPage(1);
            }
            if (query.getSize() == null || query.getSize() < 1) {
                query.setSize(5);
            }
            Page<TOrder> page = new Page<>(query.getPage(), query.getSize());
            if (!StringUtils.isNullOrEmpty(query.getOrderNo())) {
                wrapper.eq("order_no", query.getOrderNo());
            }
            if (query.getOrderShop() != null && query.getOrderShop() > 0) {
                wrapper.eq("order_shop", query.getOrderShop());
            }
            if (query.getOrderStatus() != null && query.getOrderStatus() >= 0) {
                wrapper.eq("order_status", query.getOrderStatus());
            }
            if (query.getOrderUserId() != null) {
                wrapper.eq("order_user_id", query.getOrderUserId());
            }
            if (query.getStartTime() != null) {
                wrapper.ge("order_create_time", query.getStartTime());
            }
            if (query.getEndTime() != null) {
                wrapper.le("order_create_time", query.getEndTime());
            }
            resp.addData("page",orderService.page(page, wrapper));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取订单列表失败");
            e.printStackTrace();
        }
        return resp;
    }

    @GetMapping("/detail/{orderNo}")
    public StandardResp detail(@PathVariable("orderNo") String orderNo){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取订单详情成功");
            resp.addData("item",orderService.getDetail(orderNo));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取订单详情失败");
        }
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public StandardResp delete(@PathVariable("id") Integer id){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除订单成功");
            orderService.removeByIdCascader(id);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("删除订单失败");
        }
        return resp;
    }

    @PutMapping("/update")
    public StandardResp update(@RequestBody TOrder order){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("修改订单成功");
            orderService.updateById(order);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("修改订单失败");
        }
        return resp;
    }

    @PostMapping("/add")
    public StandardResp add(@RequestBody OrderInfo order){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加订单成功");
            order.setOrderNo(UUID.randomUUID().toString());
            orderService.saveOrder(order);
        }catch (Exception e){
            e.printStackTrace();
            resp = StandardResp.getErrorResp("添加订单失败");
        }
        return resp;
    }

    @GetMapping("/detail/{id}/logistics")
    public StandardResp logistics(@PathVariable("id") Integer id){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取物流信息成功");
            resp.addData("list",logisticsService.list(new QueryWrapper<Logistics>().eq("order_id",id)));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取物流信息失败");
        }
        return resp;
    }


}
