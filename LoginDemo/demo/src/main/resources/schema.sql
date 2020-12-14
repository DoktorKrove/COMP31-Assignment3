/* Written By Aman Prajapati*/

DROP TABLE IF EXISTS TOPPING;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    USER_ID int PRIMARY KEY AUTO_INCREMENT,
    USER_NAME VARCHAR(20),
    USER_ROLE VARCHAR(20),
    USER_ADDRESS VARCHAR(50)
);




CREATE TABLE ORDERS
(
    ORDER_ID int PRIMARY KEY AUTO_INCREMENT,
    PIZZA_NUMBER INT,
    PIZZA_SIZE VARCHAR(15),
    ORDER_TOTAL DECIMAL(6,2),
    ORDER_STATUS VARCHAR(15),
    ORDER_DATE DATE,
    ORDER_TOPPINGS VARCHAR(20),
    USER_ID INT,
    FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
);




CREATE TABLE TOPPING
(
    TOPPING_ID int PRIMARY KEY AUTO_INCREMENT,
    TOPPING_NAME VARCHAR(50),
    TOPPING_PRICE DECIMAL(4,2)
);