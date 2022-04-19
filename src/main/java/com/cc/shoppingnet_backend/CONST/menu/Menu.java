package com.cc.shoppingnet_backend.CONST.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Menu {

    public static final Menu DEFAULT = new Menu();

    static {
        DEFAULT.menuItems = new MenuItem[] {
            new MenuItem("1-1","首页", "/home","el-icon-s-home",new MenuItem[]{
                    new MenuItem("1-1-1","回到首页","/home/backToHome","el-icon-menu",null)
            }),
            new MenuItem("1-2","商品管理", "/goods","el-icon-s-goods",new MenuItem[] {
                    new MenuItem("1-2-1","商品列表", "/goods/list","el-icon-menu",null),
                    new MenuItem("1-2-2","添加商品", "/goods/add","el-icon-menu",null),
            }),
            new MenuItem("1-3","订单管理", "/order","el-icon-s-order",new MenuItem[] {
                    new MenuItem("1-3-1","订单列表", "/order/list","el-icon-menu",null),
                    new MenuItem("1-3-2","添加订单", "/order/add","el-icon-menu",null),
            }),
            new MenuItem("1-4","用户管理", "/user","el-icon-user-solid",new MenuItem[] {
                    new MenuItem("1-4-1","用户列表", "/user/list","el-icon-menu",null),
            }),
            new MenuItem("1-5","权限管理", "/rights","el-icon-notebook-1",new MenuItem[] {
                    new MenuItem("1-5-1","权限列表", "/rights/list","el-icon-menu",null),
                    new MenuItem("1-5-2","角色列表", "/roles/list","el-icon-menu",null),
            }),
            new MenuItem("1-6","数据统计", "/data","el-icon-s-data",new MenuItem[] {
                    new MenuItem("1-6-1","系统设置", "/data/setting","el-icon-menu",null),
                    new MenuItem("1-6-2","系统日志", "/data/log","el-icon-menu",null),
            })
        };
    }

    private MenuItem[] menuItems;

    @Data
    @AllArgsConstructor
    public static class MenuItem{
        private String id;
        private String name;
        private String url;
        private String icon;
        private MenuItem[] children;
    }

}
