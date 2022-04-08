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
            new MenuItem("1-1","首页", "/home",null),
            new MenuItem("1-2","商品管理", "/goods",new MenuItem[] {
                    new MenuItem("1-2-1","商品列表", "/goods/list",null),
                    new MenuItem("1-2-2","添加商品", "/goods/add",null),
            }),
            new MenuItem("1-3","订单管理", "/order",new MenuItem[] {
                    new MenuItem("1-3-1","订单列表", "/order/list",null),
                    new MenuItem("1-3-2","添加订单", "/order/add",null),
            }),
            new MenuItem("1-4","用户管理", "/user",new MenuItem[] {
                    new MenuItem("1-4-1","用户列表", "/user/list",null),
                    new MenuItem("1-4-2","添加用户", "/user/add",null),
            }),
            new MenuItem("1-5","角色管理", "/role",new MenuItem[] {
                    new MenuItem("1-5-1","角色列表", "/role/list",null),
                    new MenuItem("1-5-2","添加角色", "/role/add",null),
            }),
            new MenuItem("1-6","权限管理", "/permission",new MenuItem[] {
                    new MenuItem("1-6-1","权限列表", "/permission/list",null),
                    new MenuItem("1-6-2","添加权限", "/permission/add",null),
            }),
        };
    }

    private MenuItem[] menuItems;

    @Data
    @AllArgsConstructor
    public static class MenuItem{
        private String id;
        private String name;
        private String url;
        private MenuItem[] children;
    }

}
