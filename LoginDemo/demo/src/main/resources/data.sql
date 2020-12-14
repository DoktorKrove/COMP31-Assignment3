INSERT INTO USER  
(USER_NAME,USER_ROLE,USER_ADDRESS)
VALUES
    ('Ravneet', 'manager','Princess Street'),
    ('Aman', 'employee','Bath Road'),
    ('Dan', 'customer','Daly Street'),
    ('Sam', 'customer','xyz Street'),
    ('James', 'manager','ABC Street'),
    ('Leif', 'employee','Princess Road')
;


INSERT INTO ORDERS
(ORDER_ID, PIZZA_NUMBER, PIZZA_SIZE, ORDER_TOTAL, ORDER_STATUS, ORDER_DATE ,USER_ID, ORDER_TOPPINGS)
 VALUES

    (1, 2, 'MEDIUM', 25.16,'COMPLETED', '2020-11-30', 3, '01'),
    (2, 1, 'SMALL', 12.01,'COMPLETED', '2020-11-29', 3, '01,02'),
    (3, 3, 'LARGE', 52.45,'IN-PROCESS', '2020-12-07', 4, '01,02,03'),
    (4, 2, 'X-LARGE', 32.05,'IN-PROCESS', '2020-12-07', 3, '01,02,03,04')
;
    
INSERT INTO TOPPING  
(TOPPING_NAME, TOPPING_PRICE)
VALUES
    ('TOMATO SAUCE', 2.50),
    ('CHEESE', 2.89),
    ('PEPPERONI', 3.50),
    ('HAM', 3.0),
    ('ONION', 1.90),
    ('MUSHROOM', 1.90),
    ('GREEN PEPPER', 1.90),
    ('PINEAPPLE', 1.90)
;