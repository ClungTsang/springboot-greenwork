create table avgmach
(
    year1  char(4)    not null,
    month1 varchar(2) not null,
    day1   varchar(2) not null,
    hour1  varchar(2) not null,
    avgnrg varchar(3) not null,
    avgfre varchar(3) null
);

create table avgws
(
    year1   char(4)    not null,
    month1  varchar(2) not null,
    day1    varchar(2) not null,
    hour1   varchar(2) not null,
    avgpm   varchar(3) not null,
    avgtemp varchar(3) not null,
    avghum  varchar(3) not null
);

create table envequip
(
    envequipid  char(5) not null
        primary key,
    situation   char    not null,
    model       char(2) null,
    speed       char(2) null,
    temperature char(2) null,
    workshopid  char(5) not null
);

create table log
(
    operater  varchar(20) null,
    telephone varchar(20) null,
    content   varchar(50) not null,
    updated   datetime    not null
);

create table machinfor
(
    machineid      varchar(5)  not null
        primary key,
    machinemodel   varchar(20) not null,
    leader         varchar(8)  null,
    buyingtime     date        not null,
    productivetime date        not null,
    workshopid     char(5)     not null
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
    job        varchar(10) default '生产人员'   not null,
    hiredate   datetime                     not null,
    phonemac   varchar(50) charset ascii    not null,
    checkin    varchar(4)  default '0'      not null,
    checked    varchar(10) default '未审核'    not null,
    machineid  varchar(10)                  null,
    workshopid varchar(10)                  null
);

create table wsenvinfor
(
    workshopid  char(5)    not null,
    pm          varchar(3) not null,
    temperature varchar(2) not null,
    humidity    varchar(2) not null,
    updated     datetime   not null
)
    charset = ascii;

create table wsinfor
(
    workshopid   varchar(10)              not null
        primary key,
    workshopname varchar(50) charset utf8 null
)
    charset = ascii;


