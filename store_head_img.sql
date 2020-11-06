create table head_img
(
    hid varchar(64)  not null,
    uid varchar(64)  null comment '关联的注册用户id',
    url varchar(255) null comment '头像的地址',
    constraint head_img_hid_uindex
        unique (hid),
    constraint user_uid_fk
        foreign key (uid) references user (uid)
            on update cascade on delete cascade
)
    comment '用户头像';

alter table head_img
    add primary key (hid);

