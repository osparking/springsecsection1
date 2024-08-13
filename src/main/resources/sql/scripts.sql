# 데이터베이스 테이블 전부 삭제
drop database bumsoap;
create database bumsoap;
# 혹은
drop table authorities;
drop table users;
drop table customer;

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`)
 VALUES ('범이','jbum@bumsoap.space','01023456789',
    '{bcrypt}$2a$12$P8b.dKAy1RGQC2ioIORiUu4lCcDDTFIms8uDDt8PWlxrakfxj2bfi',
    'admin', CURDATE());
    