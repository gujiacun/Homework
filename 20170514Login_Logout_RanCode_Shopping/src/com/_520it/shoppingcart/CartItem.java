//需求：模拟购物车的增删改操作
//建CartItem类，存储商品信息；建Shoppingcart类，表示购物车对象，存储商品对象和商品的总价
//在Shoppingcart类里建增/删/算出总金额的方法
//建item.jsp页面，标题为商品信息，建名称（下拉框），数量，付款按钮
//在servlet中建ShoppingcartServlet，在service方法里请求分发（拿cmd，根据页面传进来不同的cmd的值去不同方法）
//请求分发后，建list/addItem/deleteItem方法，在addItem方法中拿页面的商品名和数量，封装至商品类的对象里，
//假如商品名与拿到的值对应，手动设置id和价格。通过session拿购物车对象，若没有就新建并放到session中
//把商品添加进购物车，重定向至list.jsp
//新建list.jsp，这里就是模仿的购物车，有编号/名称/价格/数量/操作，导入标签库，循环购物车对象里的商品集合，根据列名输出属性
//删除操作，在ShoppingcartServlet中新建deleteItem方法，拿购物车对象，id，调用Shoppingcart中的deleteItem方法，重定向至list.jsp
package com._520it.shoppingcart;

public class CartItem {
//从servlet中拿到页面中的信息，把信息设置到这里，所以这里定义变量，提供set/get
    public CartItem(){}
    private Long id;
    private String name;
    private Double price;
    private Integer number;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
}
