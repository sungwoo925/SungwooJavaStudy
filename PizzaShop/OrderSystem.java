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
/** 이 클래스는 오더시스템으로 주문에서 사용자와의 상호작용을 위한 클래스입니다.
 *
 * @param response The response to check
 * @return True if the response was correct, false otherwise
 */

import java.util.Scanner;
import java.util.InputMismatchException;

class OrderSystem {
    //선긋기
    String line = "*******************************************";

    //Integer type 선택기
    int choice(int n){
        //스캐너 생성
        Scanner scan = new Scanner(System.in);
        //문자입력 예외처리를 위한 변수 True : 예외의 경우
        boolean devilUser = false;
        //첫 유저 입력받기
        int userChoise = 0;
        try {
            userChoise = scan.nextInt();
        }catch (InputMismatchException  e){//예외처리 부분
            userChoise = 0;
            System.out.println("이건 좀...");
            scan.nextLine();
            devilUser = true;
        }
        //유저가 정상적인 입력갑을 입력할 때까지 입력받기
        while (userChoise < 1 || userChoise > n){
            if (devilUser){
                System.out.println("문자를 입력하셨습니다.... 숫자(1~" +
                        Integer.toString(n) +
                        ")사이의 값을 입력하세요.");
                devilUser = false;
            }else{
                if (userChoise < 1){//입력값이 작은경우
                    System.out.print("입력값이 0보다 작습니다.(1~" +
                            Integer.toString(n) +
                            ")사이의 값을 입력하세요.");
                }else{//입력값이 큰 경우
                    System.out.print("입력값이 " +
                            Integer.toString(n) +
                            "보다 큽니다.(1~" +
                            Integer.toString(n) +
                            ")사이의 값을 입력하세요.");
                }
            }

            try {
                userChoise = scan.nextInt();
            }catch (InputMismatchException e){//예외처리 부분
                userChoise = 0;
                System.out.println("이건 좀...");
                scan.nextLine();
                devilUser = true;
            }
        }
        // 주문 라인 그어주기
        System.out.println("");
        System.out.println(line);
        return userChoise;
    }

    //피자 메뉴 선택
    int pizzaMenuChoice(){
        //User에게 메뉴 보여주기
        System.out.println("");
        System.out.println("Specialty Pizza Menu");
        System.out.println("");
        System.out.println("1) Meat Lovers");
        System.out.println("2) Vegetarian");
        System.out.println("3) Hawaiian");
        System.out.println("4) Philly Steak");
        System.out.println("5) BBQ Chicken");
        System.out.println("6) 메뉴로 나가기");
        System.out.println("");
        System.out.print("Your choise (1~6) ");
        return choice(6);
    }
    //피자 크기 선택
    int pizzaSizeChoice(){
        //User에게 크기 보여주기
        System.out.println("");
        System.out.println("Available Sizes and Prices");
        System.out.println("");
        System.out.println(String.format("%-15s -$10.0","1) 10\" Personal"));
        System.out.println(String.format("%-15s -$14.5","2) 14\" Medium"));
        System.out.println(String.format("%-15s -$19.0","3) 16\" Large"));
        System.out.println(String.format("%-15s -$23.0","4) 18\" Extra Large"));
        System.out.println("");
        System.out.print("Your choise (1~4) ");
        return choice(4);
    }

    //피자 개수 선택
    int pizzaCount(){
        int count = 0;
        System.out.println("");
        System.out.print("How many personal pizza? ");
        return choice(100);
    }
    //모든 메뉴를 보여주기 위한 코드
    void firstShow(){
        System.out.println(String.format("%-15s %-13s %-10s %-6s",
                "Type",
                "Size",
                "Quantity",
                "Price"));

        System.out.println(line);
        System.out.println("");
    }
    void showAllOrder(OrderItem view){
        System.out.println(String.format("%-15s %-13s %-10s %.2f",
                view.getPizzaMenu(),
                view.getPizzaSize(),
                Integer.toString(view.getPizzaCount()),
                view.getTotalPrice()));//잠시
    }
    void lastShow(double price){
        System.out.println("");
        System.out.println(String.format("Order Total : $ %.1f",price));
        System.out.println("");
        System.out.println(line);
    }

    //현재가격 프린트를위한 코드
    void currentOrderTotal(double money){
        System.out.println("");
        System.out.println("Your current order total is $ " + String.format("%.2f",money));
        System.out.println("");
        System.out.println(line);
    }
    //피자샵 소개글
    void intro(){
        System.out.println(line);
        System.out.println("");
        System.out.println("Welcome to 성우's 피자가게");
        System.out.println("2019250020박성우");
        System.out.println("");
        System.out.println(line);
    }
    void goodbye(){
        System.out.println("");
        System.out.println("Thank you for visiting 성우's 피자가게!");
        System.out.println("건강하세요!");
        System.out.println("");
        System.out.println(line);
    }
}