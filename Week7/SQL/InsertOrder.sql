Use ecommerce;
DROP PROCEDURE IF EXISTS InitOrderData;
DELIMITER $
CREATE PROCEDURE InitOrderData()
/*30 seconds*/
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit = 0;
    WHILE i<=1000000 DO
            insert into ecommerce.Order (CustomerId, ProductId, UnitPrice, Quantity, SubTotal, Status, CreatedDate, UpdatedDate)
            VALUES (i ,1, 1, 1, 1,0, now() , null);
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL InitOrderData();

DROP PROCEDURE IF EXISTS InitOrderDataPreparedStatement;
DELIMITER $
CREATE PROCEDURE InitOrderDataPreparedStatement()
/*32 seconds*/
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    Prepare stm1 from  'insert into ecommerce.Order (CustomerId, ProductId, UnitPrice, Quantity, SubTotal, Status, CreatedDate, UpdatedDate) VALUES (? ,1, 1, 1, 1,0, now() , null);';
    WHILE i<=1000000 DO
            set @a=i;
            execute stm1 using @a;
        SET i = i+1;
    END WHILE;
    DEALLOCATE PREPARE stm1;
    commit;
END $
CALL InitOrderDataPreparedStatement();


Use ecommerce;
DROP PROCEDURE IF EXISTS InitOrderDataConcate;
DELIMITER $
CREATE PROCEDURE InitOrderDataConcate()
/*9 seconds, we can refactor the query  by using prepare statement*/
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit = 0;
    set @createTime = now();
    WHILE i<=1000000 DO
            insert into ecommerce.Order (CustomerId, ProductId, UnitPrice, Quantity, SubTotal, Status, CreatedDate, UpdatedDate)
            VALUES
            (i ,1, 1, 1, 1,0,  @createTime  , null),
            (i+1 ,1, 1, 1, 1,0,  @createTime  , null),
            (i+2 ,1, 1, 1, 1,0, @createTime  , null),
            (i+3 ,1, 1, 1, 1,0,  @createTime  , null),
            (i+4 ,1, 1, 1, 1,0, @createTime , null),
            (i+5 ,1, 1, 1, 1,0,  @createTime  , null),
            (i+6 ,1, 1, 1, 1,0, @createTime  , null),
            (i+7 ,1, 1, 1, 1,0,  @createTime  , null),
            (i+8 ,1, 1, 1, 1,0,  @createTime  , null),
            (i+9 ,1, 1, 1, 1,0,  @createTime  , null);
        SET i = i+10;
    END WHILE;
    commit;
END $
CALL InitOrderDataConcate();