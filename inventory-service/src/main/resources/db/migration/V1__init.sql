create table `t_inventory`
(
    `id`           bigint(20) not null auto_increment,
    `sku_code`     varchar(255),
    `quantity`     int(11),
    primary key (id)
)