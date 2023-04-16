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
/** 이 클래스는 페이시스템으로 페이에 대한 모든 것을 관리하기 위한 클래스입니다.
 *
 * @param response The response to check
 * @return True if the response was correct, false otherwise
 */
import java.util.Scanner;

 class PaySystem {
    void payment(double price){
        //결제를 위한 유저와의 소통창구
        OrderSystem orderSys = new OrderSystem();
        //System.out.println(orderSys.line);

        System.out.println("");
        System.out.println("How do you wish to pay for your order?");
        System.out.print("(Enter 1 for cash or 2 for credit.) : ");
        int payN = orderSys.choice(2);
        if (payN == 1) {
            System.out.println("Cash payment summary : ");
            System.out.println("");
            System.out.println("Payment amount :"+ String.format("%.2f",price));
        }else{
            System.out.println("");
            System.out.println("Please enter your payment information : ");
            System.out.println("");
            System.out.print("Card holder name : ");
            Scanner scan = new Scanner(System.in);
            String name = scan.next();
            System.out.print("Credit card type (e.g.. MasterCard) : ");
            String type = scan.next();
            System.out.print("Credit card number (e.g.. 1234123412341234) : ");
            String number = scan.next();
            System.out.print("Expiration date (e.g.. 04/2023) : ");
            String date = scan.next();
            System.out.println("");
            System.out.println(orderSys.line);
            System.out.println("");
            System.out.println("Credit payment summary : ");
            System.out.println("");
            System.out.println(String.format("%15s: %s","Customer Name",name));
            System.out.println(String.format("%15s: $ %.1f","Payment amount",price));
            System.out.println(String.format("%15s: ************%-4s","Card number",number.substring(number.length() - 4)));
            System.out.println(String.format("%15s: %s","Exp date",date));
        }
        System.out.println("");
        System.out.println(orderSys.line);
    }
}
