CREATE TABLE vehicles.veh_user
(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL
);
ALTER TABLE vehicles.veh_user COMMENT = '用户表';