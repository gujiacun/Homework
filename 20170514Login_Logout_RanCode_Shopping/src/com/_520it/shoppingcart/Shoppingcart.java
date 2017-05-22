package com._520it.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shoppingcart {
//建list集合，存储商品对象
    List<CartItem> items = new ArrayList<>();
  //在Shoppingcart类里建增/删/算出总金额的方法
    
    //把商品存放在集合中,参数为新传入的商品
    public void addItem(CartItem newItem){
        //如果新传入的商品的id与集合中的某商品的id相同（即集合中已存在此商品），把这商品的数量加1
        for (CartItem item : items) {
            //假如集合中已存在此商品，只需把数量+1，然后结束方法 
            if (item.getId().equals(newItem.getId())) {
                item.setNumber(item.getNumber()+newItem.getNumber());
                return;
            }
        }
      //假如集合中不存在此商品，把新商品添加进集合
        items.add(newItem);
    }
    //删除
    public void deleteItem(Long id){
        //从集合中删除商品，用迭代器
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem item = (CartItem) iterator.next();
            //如果集合中有某一商品的id与传进来的id相同，删除
            if (item.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
    }
    
    //算出总金额
    public double getTotalPrice() {
        double totalPrice = 0.0;
        //用循环拿出每个商品的价格，相加，赋值
        for (CartItem item : items) {
            totalPrice += item.getPrice()*item.getNumber();
        }
        return totalPrice;
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
