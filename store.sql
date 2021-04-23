create table bguser
(
    bguid    varchar(32) not null comment '主键'
        primary key,
    username varchar(20) not null comment '登陆名',
    password varchar(20) not null comment '密码',
    state    tinyint(1)  not null comment '是否禁用：1是0否',
    isdel    tinyint(1)  not null comment '是否删除：1是0否',
    updatetime datetime    not null
)
    comment '后台管理用户';

create table category
(
    cid   varchar(32) not null comment '主键'
        primary key,
    cname varchar(50) not null comment '类目名称'
)
    comment '商品类目表';

create table `orders`
(
    oid       varchar(32)    not null comment '主键'
        primary key,
    ordertime datetime       not null comment '订单产生的时间',
    total     decimal(10, 2) not null comment '订单的总计',
    state     tinyint(1)     not null comment '订单的状态。 0：未付款 1：付款，没发货 2：付款，发货3：收货',
    address   varchar(255)   null comment '收货人的地址',
    name      varchar(255)   null comment '收货人名',
    telephone varchar(11)    null comment '收货人的电话',
    uid       varchar(32)    not null comment '订单所属用户'
)
    comment '订单表';

create table orderitem
(
    itemid   varchar(32)    not null comment '订单项的编号'
        primary key,
    subcount int            not null comment '一个订单单项的总数',
    subtotal decimal(10, 2) not null comment ' 一个订单单项的小计',
    pid      varchar(32)    not null comment '一个商品对应多个订单项，一个订单项对应一个商品',
    oid      varchar(32)    not null comment '一个订单项属于一个订单'
)
    comment '订单项';

create table product
(
    pid          varchar(32)  not null comment '主键'
        primary key,
    pname        varchar(50)  not null comment '商品名称',
    market_price  decimal(10, 2) not null comment '商城价',
    shop_price    decimal(10, 2) not null comment '售价',
    pimage       varchar(200) not null comment '商品图片',
    pdate        date         not null comment '更新日期',
    is_hot       int          not null comment '是否热门：1是 0否',
    pdesc        varchar(255) not null comment '商品描述',
    pflag        int          not null comment '是否下架：1是0否',
    cid          varchar(32)  not null comment '商品类目主键'
)
    comment '商品表';

create table user
(
    uid       varchar(32) not null comment '主键'
        primary key,
    username  varchar(20) not null comment '用户名',
    password  varchar(20) not null comment '密码',
    name      varchar(20) not null comment '姓名',
    email     varchar(30) not null comment '邮箱',
    telephone varchar(20) not null comment '电话',
    birthday  date        not null comment '出生日期',
    sex       varchar(10) not null comment '性别：男，女',
    state     int         not null comment '0代表没激活，1代表激活',
    code      varchar(64)  null comment '激活码',
    headimg   varchar(255)  null comment '用户头像'
)
    comment '用户信息表';

