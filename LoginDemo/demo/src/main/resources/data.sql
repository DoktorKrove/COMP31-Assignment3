INSERT INTO USER  
(USER_ID, USER_NAME,USER_ROLE,USER_ADDRESS)
VALUES
    ( NULL, 'Ravneet', 'manager','Princess Street'),
    ( NULL, 'Aman', 'employee'.'Bath Road'),
    ( NULL, 'Dan', 'customer','Daly Street'),
    ( NULL, 'Sam', 'customer','xyz Street'),
    ( NULL, 'James', 'manager','ABC Street'),
    ( NULL, 'Leif', 'employee','Princess Road')
;


INSERT INTO ORDER
(ORDER_ID, PIZZA_NUMBER, PIZZA_SIZE, ORDER_TOTAL, ORDER_STATUS, ORDER_DATE)
 VALUES

    (NULL, 2, 'MEDIUM', '25.16','COMPLETED', 2020-11-30),
    (NULL, 1, 'SMALL', '12.01','COMPLETED', 2020-11-29),
    (NULL, 3, 'LARGE', '52.45','IN-PROCESS', 2020-12-07),
    (NULL, 2, 'X-LARGE', '32.05','IN-PROCESS', 2020-12-07)
;
    
INSERT INTO TOPPING  
(TOPPING_ID, TOPPING_NAME,TOPPING_PRICE,ORDER_ID)
VALUES

     (NULL, 'ONION', '1.9',1),
     (NULL, 'MUSHROOM', '1.9',2),
     (NULL, 'GREEN PEPPER', '1.9',1),
     (NULL, 'PINEAPPLE', '1.9',3)
;
     
    

