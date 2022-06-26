Setup
1. Execute docker run --name mysqlDemo1 -p 3310:3306 -e MYSQL_ROOT_PASSWORD=test -e MYSQL_ROOT_HOST=% -d mysql:latest
2. Create database ds0;
3. Execute docker run --name mysqlDemo2 -p 3311:3306 -e MYSQL_ROOT_PASSWORD=test -e MYSQL_ROOT_HOST=% -d mysql:latest
4. Create database ds1;
5. Execute bin/start.bat to start ShardingSphere-Proxy (Please refer to ShardingProxy folder for configuration)
6. Connect to sharding proxy's mysql (port 3307)
7. Execute CREATE TABLE t_order (orderid BIGINT NOT NULL AUTO_INCREMENT, userid INT NOT NULL, status VARCHAR(50), PRIMARY KEY (orderid));






