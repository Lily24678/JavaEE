create table category
(
    cid   varchar(32) not null comment '主键'
        primary key,
    cname varchar(50) not null comment '类目名称'
)
    comment '商品类目表';

INSERT INTO `store_v1.0`.category (cid, cname) VALUES ('3786a9e715144c43bb461c2a9dbb4631', '瓜果蔬菜');
INSERT INTO `store_v1.0`.category (cid, cname) VALUES ('7c87dc564aeb4985baa99b16b194a5f8', '数码家电');
INSERT INTO `store_v1.0`.category (cid, cname) VALUES ('cbb4c0b53aa840f0bf0878d2775a2e99', '四季衣服');