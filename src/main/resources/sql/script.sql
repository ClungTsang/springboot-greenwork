create table elefee
(
    rangee varchar(10) not null comment '电费时段'
        primary key,
    fee    double      null comment '电费'
)
    comment '电流电费标准' charset = utf8;

create table envequip
(
    workshopid  char(5)    not null
        primary key,
    warn        char(5)    null comment '警报',
    warnstatus  char       null comment '警报状态',
    fan         char(5)    null comment '风扇',
    fanstatus   char       not null comment '风扇状态',
    light       char(5)    null comment '光',
    lightstatus char       null comment '光照状态',
    fee         varchar(4) null comment '风扇电费'
)
    comment '风扇设备' charset = utf8;

create table log
(
    operater  varchar(20) null,
    telephone varchar(20) null,
    content   varchar(50) not null,
    updated   datetime    not null
)
    charset = utf8;

create table machinfor
(
    machineid      varchar(5)     not null
        primary key,
    machinemodel   varchar(20)    not null,
    leader         varchar(8)     null,
    buyingtime     date           not null,
    productivetime date           not null,
    workshopid     char(5)        not null,
    latitude       decimal(10, 7) null comment '纬度',
    longitude      decimal(10, 7) null comment '经度'
);

create table machruntime
(
    machineid      varchar(5)  not null,
    situation      char        not null,
    nrgconsumption varchar(10) not null,
    frequency      varchar(10) not null,
    updated        datetime    not null,
    workshopid     char(5)     not null
)
    charset = ascii;

create table standard
(
    name  varchar(12) not null
        primary key,
    low   varchar(3)  null,
    hight varchar(3)  null
);

create table user
(
    telephone  varchar(11)                  not null
        primary key,
    username   varchar(8)                   not null,
    account    varchar(30)                  not null,
    password   varchar(30) default '123456' not null,
    job        varchar(10)                  not null,
    hiredate   datetime                     not null,
    phonemac   varchar(50) charset ascii    not null,
    checkin    varchar(4)  default '0'      not null,
    checked    varchar(10)                  not null,
    machineid  varchar(10)                  null,
    workshopid varchar(10)                  null
)
    charset = utf8;

create table wsenvinfor
(
    workshopid  char(5)    not null,
    temperature varchar(5) null comment '温度',
    humidity    varchar(5) null comment '湿度',
    light       varchar(5) null comment '光照强度',
    pm1         varchar(5) null comment 'pm1',
    pm25        varchar(5) null comment 'pm2.5',
    pm10        varchar(5) null comment 'pm10',
    ele         varchar(3) null comment '电流',
    signall     varchar(2) null comment '信号',
    fre         varchar(4) null comment '频次',
    nrg         varchar(4) null comment '能耗',
    updated     datetime   not null
)
    comment '车间环境信息表' charset = ascii;

create table wsinfor
(
    workshopid   varchar(10)              not null
        primary key,
    workshopname varchar(14) charset utf8 null comment '车间名字',
    statuss      varchar(10)              null comment '修复状态',
    autoo        char                     null comment '自动化
'
)
    comment '车间信息表' charset = ascii;


