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

/** This method checks a given response for correctness.
 *
 * @param response The response to check
 * @return True if the response was correct, false otherwise
 */
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        //주문들을 저장하기 위한 저장소
        ArrayList<OrderItem> orders = new ArrayList<>();

        //주문이 끝남을 확인하기위한 변수
        boolean orderCicle = true;

        //주문 횟수 저장
        int orderSize = orders.size();

        //총 주문 가격 저장
        double totalPrice = 0;
        //주문을 돕기위한 유저와의 연결고리
        OrderSystem orderSys = new OrderSystem();

        //피자샵 소개글 ㅎㅎ
        orderSys.intro();

        while(orderCicle){
            //새로운 주문
            orders.add(new OrderItem());

            //현재의 주문 횟수 확인
            orderSize = orders.size()-1;

            //메뉴 고르기
            orders.get(orderSize).setPizzaMenu();

            if (orders.get(orderSize).getPizzaMenu().equals("out")){
                orderCicle = false;
                orders.remove(orderSize);
                continue;
            }
            //사이즈 고르기
            orders.get(orderSize).setPizzaSize();
            //피자 개수 고르기
            orders.get(orderSize).setPizzaCount();
            //가격 연산
            orders.get(orderSize).setTotalPrice();
            totalPrice = 0;
            for (int i = 0; i < orderSize + 1; i++) {
                totalPrice += orders.get(orderSize).getTotalPrice();
            }
            orderSys.currentOrderTotal(totalPrice);
        }
        //주문완료 후 주문 내역서 보여주기
        orderSys.firstShow();//주문 내역서 첫줄 출력
        for (int i = 0; i < orderSize; i++) {
            orderSys.showAllOrder(orders.get(i));
        }
        orderSys.lastShow(totalPrice);//주문 내역서 마지막줄 출력
        //페이
        PaySystem pay = new PaySystem();
        pay.payment(totalPrice);
        //잘가요
        orderSys.goodbye();
    }
}