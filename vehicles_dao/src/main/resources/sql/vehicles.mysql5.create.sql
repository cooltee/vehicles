create table veh_user
(
   id                   bigint(16) not null comment '主键id',
   name                 varchar(16) comment '姓名',
   password             varchar(16) comment '密码',
   comments             varchar(64) comment '备注',
   state                tinyint(1) comment '状态',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_user comment '用户表';

create table veh_group
(
   id                   bigint(16) not null comment '主键id',
   name                 varchar(16) comment '姓名',
   comments             varchar(64) comment '备注',
   state                tinyint(1) comment '状态',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_group comment '用户组表';

create table veh_permission
(
   id                   bigint(16) not null comment '主键id',
   name                 varchar(16),
   permission_code      varchar(16),
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

create table veh_vehicle
(
   id                   bigint(16) not null comment '主键id',
   registration_plate   varchar(16) comment '车牌号',
   manufacturers        varchar(64) comment '车辆制造商',
   models               varchar(64) comment '车辆型号',
   vehicle_type         tinyint(4) comment '车辆类型',
   vehicle_purpose      tinyint(4) comment '车辆用途',
   purchase_price       decimal(20,2) comment '购入价格',
   purchase_dept        varchar(32) comment '购入部门',
   purchase_date        date comment '购入日期',
   archives_no          varchar(32) comment '档案编号',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_vehicle comment '车辆信息表';

create table veh_driver
(
   id                   bigint(16) not null comment '主键id',
   name                 varchar(16) not null comment '姓名',
   gender               tinyint(1) not null comment '性别',
   id_card              varchar(18) comment '身份证',
   telphone             varchar(16) comment '联系电话',
   dept                 varchar(16) comment '所属部门',
   allow_date           date comment '准驾日期',
   allow_type           tinyint(4) comment '准驾车型',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_driver comment '驾驶员信息表';

create table veh_drive_record
(
   id                   bigint(16) not null comment '主键id',
   driver_id            bigint(16) comment '驾驶员id',
   vehicle_id           bigint(16) comment '车辆id',
   distance             double(16,3) comment '总路程（km）',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_drive_record comment '出行记录表';

alter table veh_drive_record add constraint FK_Reference_10 foreign key (vehicle_id)
      references veh_vehicle (id) on delete restrict on update restrict;

alter table veh_drive_record add constraint FK_Reference_9 foreign key (driver_id)
      references veh_driver (id) on delete restrict on update restrict;

create table veh_cost
(
   id                   bigint(16) not null comment '主键id',
   vehicle_id           bigint(16) comment '车辆id',
   amount               decimal(16,2) not null comment '金额（￥）',
   cost_type            tinyint(1) comment '花费类型',
   spend_date           date comment '花费日期',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_cost comment '费用汇总表';

alter table veh_cost add constraint FK_Reference_5 foreign key (vehicle_id)
      references veh_vehicle (id) on delete restrict on update restrict;

create table veh_other_record
(
   id                   bigint(16) not null comment '主键id',
   cost_id              bigint(16) comment '费用id',
   description          varchar(255) comment '费用说明',
   create_time          timestamp,
   update_time          timestamp,
   primary key (id)
);

alter table veh_other_record comment '其他费用记录表';

alter table veh_other_record add constraint FK_Reference_6 foreign key (cost_id)
      references veh_cost (id) on delete restrict on update restrict;

create table veh_oil_record
(
   id                   bigint(16) not null,
   cost_id              bigint(16) not null comment '主键id',
   oil_price            decimal(16,2) comment '燃油单价（￥/L）',
   oil_volume           decimal(16,3) comment '燃油体积（L）',
   oil_discount         decimal(3,2) comment '燃油折扣',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '更新时间',
   primary key (id)
);

alter table veh_oil_record comment '燃油记录表';

alter table veh_oil_record add constraint FK_Reference_3 foreign key (cost_id)
      references veh_cost (id) on delete restrict on update restrict;

create table veh_repair_record
(
   id                   bigint(16) not null,
   cost_id              bigint(16) comment '费用id',
   description          varchar(255) comment '维修说明',
   create_time          timestamp,
   update_time          timestamp,
   primary key (id)
);

alter table veh_repair_record comment '维修记录表';

alter table veh_repair_record add constraint FK_Reference_4 foreign key (cost_id)
      references veh_cost (id) on delete restrict on update restrict;
