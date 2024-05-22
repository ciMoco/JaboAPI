-- 创建库
create database if not exists jaboapi;

-- 切换库
use jaboapi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    accessKey    varchar(512)                           not null comment 'accessKey',
    secretKey    varchar(512)                           not null comment 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 接口信息
create table if not exists interface_info
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `method` varchar(256) not null comment '请求类型',
    `requestParams` text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';

insert into interface_info (`name`, `description`, `url`, `method`, `requestHeader`, `responseHeader`, `status`, `userId`) values ('崔智渊', '东农业大学', 'www.nicky-carroll.net', '邵立诚', '钟思远', '贺琪', 0, 731);
insert into interface_info (`name`, `description`, `url`, `method`, `requestHeader`, `responseHeader`, `status`, `userId`) values ('姜风华', '中国大学', 'www.maximo-russel.io', '邵睿渊', '沈越彬', '吴志泽', 0, 8);
insert into interface_info (`name`, `description`, `url`, `method`, `requestHeader`, `responseHeader`, `status`, `userId`) values ('蒋鑫磊', '东北农业大学', 'www.donovan-jast.io', '余伟宸', '钟晋鹏', '白果', 0, 33114165);
insert into interface_info (`name`, `description`, `url`, `method`, `requestHeader`, `responseHeader`, `status`, `userId`) values ('覃耀杰', '东南技术大学', 'www.rebbeca-strosin.org', '武思聪', '朱语堂', '贾晓啸', 0, 337293027);