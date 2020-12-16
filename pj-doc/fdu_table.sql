DROP TABLE `fdu_daily_update`;
CREATE TABLE `fdu_daily_update` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `upd_date` date NOT NULL COMMENT '上报日期',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID（学号）',
  `on_campus` char(1) DEFAULT NULL COMMENT '是否在校（0否 1是）',
  `reason` varchar(128) DEFAULT NULL COMMENT '返校原因',
  `current_area` char(1) DEFAULT NULL COMMENT '所在区域（1-5）',
  `current_dist` varchar(128) DEFAULT NULL COMMENT '所在地点',
  `temperature` char(1) DEFAULT NULL COMMENT '体温范围（1-3）',
  `feeling` char(1) DEFAULT NULL COMMENT '是否有症状（0否 1是）',
  `contact_risk` char(1) DEFAULT NULL COMMENT '是否接触风险地区人员（0否 1是）',
  `contact_infected` char(1) DEFAULT NULL COMMENT '是否接触疑似确诊人员（0否 1是）',
  `isolate` char(1) DEFAULT NULL COMMENT '是否隔离（0否 1集中 2居家）',
  `attention` char(1) DEFAULT NULL COMMENT '是否有注意事项（0否 1是）',
  `other_info` varchar(200) DEFAULT NULL COMMENT '其他信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;

DROP TABLE `fdu_notice`;
CREATE TABLE `fdu_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `notice_time` datetime DEFAULT NULL COMMENT '发布时间',
  `title` varchar(100) DEFAULT NULL COMMENT '公告标题',
  `content` varchar(400) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT NULL COMMENT '显示状态（0隐藏 1显示）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;

DROP TABLE `fdu_user_basic`;
CREATE TABLE `fdu_user_basic` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID（学号）',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `status` char(1) DEFAULT NULL COMMENT '状态（0正常 1删除）',
  `role` char(1) DEFAULT NULL COMMENT '用户角色（0学生 1管理员）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;

DROP TABLE `fdu_user_info`;
CREATE TABLE `fdu_user_info` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID（学号）',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `school` varchar(32) DEFAULT NULL COMMENT '院系',
  `category` char(1) DEFAULT NULL COMMENT '分类（2研究生）',
  `type` char(1) DEFAULT NULL COMMENT '类型（3非全）',
  `teacher_name` varchar(32) DEFAULT NULL COMMENT '辅导员姓名',
  `graduating` char(1) DEFAULT NULL COMMENT '是否毕业班学生（0否 1是）',
  `address` varchar(128) DEFAULT NULL COMMENT '居住地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;

DROP TABLE `fdu_user_info2`;
CREATE TABLE `fdu_user_info2` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID（学号）',
  `current_location` char(1) DEFAULT NULL COMMENT '现在地点（1-6）',
  `leave` char(1) DEFAULT NULL COMMENT '14日内离沪（0否 1是）',
  `fever` char(1) DEFAULT NULL COMMENT '14日内发热（0否 1是）',
  `contact` char(1) DEFAULT NULL COMMENT '14日内接触（0否 1是）',
  `infection` char(1) DEFAULT NULL COMMENT '是否感染（0否 1是）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;



