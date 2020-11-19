create table user
(
    uid       varchar(64)  not null
        primary key,
    username  varchar(20)  null comment '用户登陆名',
    password  varchar(20)  null comment '用户登陆密码',
    name      varchar(255) null,
    email     varchar(30)  null comment '注册邮箱',
    telephone varchar(20)  null comment '注册电话号码',
    birthday  date         null comment '生日日期',
    sex       varchar(10)  null comment '性别',
    state     int          null comment '状态：0注销用户，1正常用户',
    address   varchar(255) null comment '地址',
    area_code int          null comment '所在区域行政编码'
)
    comment ' 注册用户的信息';

INSERT INTO store.user (uid, username, password, name, email, telephone, birthday, sex, state, address, area_code) VALUES ('50e59e85-197c-4e4b-9d44-9d79309d8479', 'xiaoming', '123', '小明', 'xiaoming@163.com', '123xxxxxxxxxxx', '2020-10-23', '男', 1, null, null);