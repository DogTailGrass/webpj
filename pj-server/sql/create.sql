-- 用户表
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID（学号）',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `status` char(1) DEFAULT NULL COMMENT '状态（0正常 1删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- 用户基本信息表
drop table if exists fdu_user_basic;
create table fdu_user_basic (
  user_id       varchar(20)     not null        comment '用户ID（学号）',
  user_name     varchar(32)     default null    comment '用户名',
  user_pwd      varchar(20)     default null    comment '用户密码',
  status        char(1)         default null    comment '状态（0正常 1删除）',
  create_time   datetime        default null    comment '创建时间',
  create_by     varchar(20)     default null    comment '创建者',
  update_time   datetime        default null    comment '更新时间',
  update_by     varchar(20)     default null    comment '更新者',
  primary key (user_id)
) engine=innodb comment = '用户基本信息表';

-- 初始化表信息
insert into fdu_user_basic values ('20262010000', '张三', '1234', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_basic values ('20262010001', '李四', '1234', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_basic values ('20262010002', '王五', '1234', '1', sysdate(), 'admin', sysdate(), 'admin');

-- 用户个人信息表
drop table if exists fdu_user_info;
create table fdu_user_info (
  user_id         varchar(20)     not null        comment '用户ID（学号）',
  mobile          varchar(11)     default null    comment '手机号',
  school          varchar(32)     default null    comment '院系',
  category        char(1)         default null    comment '分类（2研究生）',
  type            char(1)         default null    comment '类型（3非全）',
  teacher_name    varchar(32)     default null    comment '辅导员姓名',
  graduation      char(1)         default null    comment '是否毕业班学生（0否 1是）',
  address         varchar(128)    default null    comment '居住地址',
  user_role       char(1)         default null    comment '用户角色（0学生 1管理员）',
  create_time     datetime        default null    comment '创建时间',
  create_by       varchar(20)     default null    comment '创建者',
  update_time     datetime        default null    comment '更新时间',
  update_by       varchar(20)     default null    comment '更新者',
  primary key (user_id)
) engine=innodb comment = '用户个人信息表';

-- 初始化表信息
insert into fdu_user_info values ('admin',       '15812345678', '软件学院', '0', '0', '赵六', '0', '上海杨浦复旦大学', '1', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_info values ('20262010000', '15812345678', '软件学院', '1', '1', '赵六', '0', '上海杨浦复旦大学', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_info values ('20262010001', '15812345678', '软件学院', '1', '1', '赵六', '0', '上海杨浦复旦大学', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_info values ('20262010002', '15812345678', '软件学院', '1', '1', '赵六', '0', '上海杨浦复旦大学', '0', sysdate(), 'admin', sysdate(), 'admin');

-- 用户其他信息表
drop table if exists fdu_user_other;
create table fdu_user_other (
  user_id           varchar(20)     not null        comment '用户ID（学号）',
  current_location  char(1)         default null    comment '现在地点（1-6）',
  has_leave         char(1)         default null    comment '14日内离沪（0否 1是）',
  has_fever         char(1)         default null    comment '14日内发热（0否 1是）',
  contact           char(1)         default null    comment '14日内接触（0否 1是）',
  infection         char(1)         default null    comment '是否感染（0否 1是）',
  create_time       datetime        default null    comment '创建时间',
  create_by         varchar(20)     default null    comment '创建者',
  update_time       datetime        default null    comment '更新时间',
  update_by         varchar(20)     default null    comment '更新者',
  primary key (user_id)
) engine=innodb comment='用户其他信息';

-- 初始化表信息
insert into fdu_user_other values ('20262010000', '1', '0', '0', '0', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_other values ('20262010001', '1', '0', '0', '0', '0', sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_user_other values ('20262010002', '1', '0', '0', '0', '0', sysdate(), 'admin', sysdate(), 'admin');

-- 每日上报信息表
drop table if exists fdu_daily_update;
create table fdu_daily_update (
  upd_date              date            not null     comment '上报日期',
  user_id               varchar(20)     not null     comment '用户ID（学号）',
  on_campus             char(1)         default null comment '是否在校（0否 1是）',
  current_area          char(1)         default null comment '所在区域（1-5）',
  current_dist          varchar(128)    default null comment '所在地点',
  temperature           char(1)         default null comment '体温范围（1-3）',
  feeling               char(1)         default null comment '是否有症状（0否 1是）',
  contact_risk          char(1)         default null comment '是否接触风险地区人员（0否 1是）',
  contact_infected      char(1)         default null comment '是否接触疑似确诊人员（0否 1是）',
  isolate               char(1)         default null comment '是否隔离（0否 1集中 2居家）',
  attention             char(1)         default null comment '是否有注意事项（0否 1是）',
  other_info            varchar(200)    default null comment '其他信息',
  create_time           datetime        default null comment '创建时间',
  create_by             varchar(20)     default null comment '创建者',
  update_time           datetime        default null comment '更新时间',
  update_by             varchar(20)     default null comment '更新者',
  primary key (upd_date,user_id)
) engine=innodb comment = '每日上报信息';

-- 初始化表信息
insert into fdu_daily_update values (current_date(), '20262010000', '1', '1', '五角场',   '1', '0', '0', '0', '0', '0', '无', sysdate(), '', sysdate(), '');
insert into fdu_daily_update values (current_date(), '20262010001', '1', '1', '南京东路',  '1', '0', '0', '0', '0', '0', '无', sysdate(), '', sysdate(), '');
insert into fdu_daily_update values (current_date(), '20262010002', '1', '1', '陆家嘴',   '1', '0', '0', '0', '0', '0', '无', sysdate(), '', sysdate(), '');

-- 公告信息表
drop table if exists fdu_notice;
create table fdu_notice (
  id            bigint(20)      not null auto_increment comment 'id',
  notice_date   date            default null            comment '发布日期',
  notice_time   time            default null            comment '发布时间',
  title         varchar(200)    default null            comment '公告标题',
  content       varchar(1000)   default null            comment '公告内容',
  status        char(1)         default null            comment '显示状态（0隐藏 1显示）',
  create_time   datetime        default null            comment '创建时间',
  create_by     varchar(20)     default null            comment '创建者',
  update_time   datetime        default null            comment '更新时间',
  update_by     varchar(20)     default null            comment '更新者',
  primary key (id)
) engine=innodb comment = '公告信息表';

-- 初始化表信息
insert into fdu_notice values (100, current_date(), current_time(), '公告 1', '这是第1条公告', 0, sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_notice values (101, current_date(), current_time(), '公告 2', '这是第2条公告', 1, sysdate(), 'admin', sysdate(), 'admin');
insert into fdu_notice values (102, current_date(), current_time(), '公告 3', '这是第3条公告', 1, sysdate(), 'admin', sysdate(), 'admin');

-- 检测初始化数据数据
select '******************* fdu_user_basic 表  ***************' ;
select * from fdu_user_basic;
select '******************* fdu_user_info 表  ***************' ;
select * from fdu_user_info;
select '******************* fdu_user_other 表  ***************' ;
select * from fdu_user_other;
select '******************* fdu_daily_update 表  ***************' ;
select * from fdu_daily_update;
select '******************* fdu_notice 表  ***************' ;
select * from fdu_notice;
