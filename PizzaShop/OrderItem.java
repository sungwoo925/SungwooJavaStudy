package PizzaShop;
/*
Author: Sungwoo Park
E-mail: qrktjddn5807@googl.com
Course: Java Programming
Assignment: Programming Assignment 1
Due date: 04/16/2023
File: SpecialtyPizzaMenu.java
Purpose: Java application that implements an online specialty pizza shop
Compiler/IDE: Java SE Development Kit 8u181/IntelliJ IDEA
Operating system: MS Windows 10
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/

/** 이 클래스는 한 주문에 대한 정보를 저장하기위한 클래스입니다.
 *
 * @return True if the response was correct, false otherwise
 */
public class OrderItem{
    //final 변수들
    final double[] SIZE_PRICE;
    final String[] SIZE_NAME;
    final String[] MENU_NAME;

    int pizzaMenu;
    int pizzaCount;
    int pizzaSize;
    double totalPrice;

    //주문을 돕기위한 유저와의 연결고리
    OrderSystem orderSys = new OrderSystem();
    OrderItem() {
        SIZE_PRICE = new double[]{0, 10.0, 14.5, 19.0, 23.5};
        SIZE_NAME = new String[]{" ","Personal","Medium","Large","Extra Large"};
        MENU_NAME = new String[]{" ","Meat Lovers","Vegetarian","Hawaiian","Philly Steak","BBQ Chicken","out"};
    }

    //피자 메뉴 컨트롤
    public String getPizzaMenu() {
        return MENU_NAME[pizzaMenu];
    }

    public void setPizzaMenu() {
        pizzaMenu = orderSys.pizzaMenuChoice();
    }

    //피자 크기 컨트롤
    public String getPizzaSize() {
        return SIZE_NAME[pizzaSize];
    }

    public void setPizzaSize() {
        pizzaSize = orderSys.pizzaSizeChoice();
    }

    //피자 총 가격
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = (SIZE_PRICE[pizzaSize] * pizzaCount);
    }

    //피자 개수
    public int getPizzaCount() {
        return pizzaCount;
    }

    public void setPizzaCount() {
        this.pizzaCount = orderSys.pizzaCount();
    }
}