create table product
(
    pid        varchar(255)   not null
        primary key,
    pname      varchar(255)   null comment '商品名',
    price      decimal(10, 2) null comment '商品价格',
    imgurl     varchar(255)   null comment '商品图片',
    `describe` text           null comment '商品的描述'
)
    comment '商品';

INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin01', '商品名01', 10.00, 'small01.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin02', '商品名02', 20.00, 'small02.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin03', '商品名03', 30.00, 'small03.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin04', '商品名04', 40.00, 'small04.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin05', '商品名05', 50.00, 'small05.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin06', '商品名06', 60.00, 'small06.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin07', '商品名07', 70.00, 'small07.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin08', '商品名08', 80.00, 'small08.jpg', '商品的描述');
INSERT INTO store.product (pid, pname, price, imgurl, `describe`) VALUES ('shangpin09', '商品名09', 90.00, 'small09.jpg', '商品的描述');