veh_user

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)  | NO   | PRI | NULL              |                             |
| name        | varchar(16) | YES  |     | NULL              |                             |
| username    | varchar(16) | YES  |     | NULL              |                             |
| password    | varchar(16) | YES  |     | NULL              |                             |
| comments    | varchar(64) | YES  |     | NULL              |                             |
| state       | tinyint(1)  | YES  |     | NULL              |                             |
| create_time | timestamp   | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_group

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)  | NO   | PRI | NULL              |                             |
| name        | varchar(16) | YES  |     | NULL              |                             |
| comments    | varchar(64) | YES  |     | NULL              |                             |
| state       | tinyint(1)  | YES  |     | NULL              |                             |
| create_time | timestamp   | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_user_group_rela

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(20) | NO   | PRI | NULL              |                             |
| group_id    | bigint(20) | YES  | MUL | NULL              |                             |
| user_id     | bigint(20) | YES  | MUL | NULL              |                             |
| create_time | timestamp  | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp  | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_permission

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id              | bigint(16)  | NO   | PRI | NULL              |                             |
| name            | varchar(16) | YES  |     | NULL              |                             |
| permission_code | varchar(16) | YES  |     | NULL              |                             |
| create_time     | timestamp   | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time     | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_group_permission_rela

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id            | bigint(20) | NO   | PRI | NULL              |                             |
| group_id      | bigint(20) | YES  | MUL | NULL              |                             |
| permission_id | bigint(20) | YES  | MUL | NULL              |                             |
| create_time   | timestamp  | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time   | timestamp  | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_driver

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)  | NO   | PRI | NULL              |                             |
| name        | varchar(16) | NO   |     | NULL              |                             |
| gender      | tinyint(1)  | NO   |     | NULL              |                             |
| id_card     | varchar(18) | YES  |     | NULL              |                             |
| telphone    | varchar(16) | YES  |     | NULL              |                             |
| dept        | varchar(16) | YES  |     | NULL              |                             |
| allow_date  | date        | YES  |     | NULL              |                             |
| allow_type  | tinyint(4)  | YES  |     | NULL              |                             |
| create_time | timestamp   | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_vehicle

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id                 | bigint(16)    | NO   | PRI | NULL              |                             |
| registration_plate | varchar(16)   | YES  |     | NULL              |                             |
| manufacturers      | varchar(64)   | YES  |     | NULL              |                             |
| models             | varchar(64)   | YES  |     | NULL              |                             |
| vehicle_type       | tinyint(4)    | YES  |     | NULL              |                             |
| vehicle_purpose    | tinyint(4)    | YES  |     | NULL              |                             |
| purchase_price     | decimal(20,2) | YES  |     | NULL              |                             |
| purchase_dept      | varchar(32)   | YES  |     | NULL              |                             |
| purchase_date      | date          | YES  |     | NULL              |                             |
| archives_no        | varchar(32)   | YES  |     | NULL              |                             |
| create_time        | timestamp     | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time        | timestamp     | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_cost

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)    | NO   | PRI | NULL              |                             |
| vehicle_id  | bigint(16)    | YES  | MUL | NULL              |                             |
| amount      | decimal(16,2) | NO   |     | NULL              |                             |
| cost_type   | tinyint(1)    | YES  |     | NULL              |                             |
| spend_date  | date          | YES  |     | NULL              |                             |
| create_time | timestamp     | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp     | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_drive_record

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)   | NO   | PRI | NULL              |                             |
| driver_id   | bigint(16)   | YES  | MUL | NULL              |                             |
| vehicle_id  | bigint(16)   | YES  | MUL | NULL              |                             |
| distance    | double(16,3) | YES  |     | NULL              |                             |
| create_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_oil_record

| Field        | Type          | Null | Key | Default           | Extra                       |
|:------------:|:-------------:|:----:|:---:|:-----------------:|:---------------------------:|
| id           | bigint(16)    | NO   | PRI | NULL              |                             |
| cost_id      | bigint(16)    | NO   | MUL | NULL              |                             |
| oil_price    | decimal(16,2) | YES  |     | NULL              |                             |
| oil_volume   | decimal(16,3) | YES  |     | NULL              |                             |
| oil_discount | decimal(3,2)  | YES  |     | NULL              |                             |
| create_time  | timestamp     | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time  | timestamp     | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_repair_record

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)   | NO   | PRI | NULL              |                             |
| cost_id     | bigint(16)   | YES  | MUL | NULL              |                             |
| description | varchar(255) | YES  |     | NULL              |                             |
| create_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |

veh_other_record

| Field       | Type        | Null | Key | Default           | Extra                       |
|:-----------:|:-----------:|:----:|:---:|:-----------------:|:---------------------------:|
| id          | bigint(16)   | NO   | PRI | NULL              |                             |
| cost_id     | bigint(16)   | YES  | MUL | NULL              |                             |
| description | varchar(255) | YES  |     | NULL              |                             |
| create_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |                             |
| update_time | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
