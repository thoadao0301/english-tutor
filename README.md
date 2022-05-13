# english-tutor

### MySql
+ Install mysql image
```
    docker pull mysql
    docker run --name some-mysql -d mysql/mysql-server:latest
    docker logs some-mysql # copy password root
    docker exec -it some-mysql bash
    mysql -uroot -p
    enter copied password
    #  Change password
    ALTER USER 'root'@'localhost' IDENTIFIED  BY '12345';
```