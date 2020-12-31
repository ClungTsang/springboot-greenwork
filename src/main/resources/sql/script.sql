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

INSERT INTO greenwork.elefee (rangee, fee) VALUES ('high', 1.114);
INSERT INTO greenwork.elefee (rangee, fee) VALUES ('low', 0.333);
INSERT INTO greenwork.elefee (rangee, fee) VALUES ('normal', 0.685);

INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws001', 'wa001', '2', 'fa001', '2', 'la001', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws002', 'wa002', '2', 'fa002', '2', 'lg002', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws003', 'wa003', '2', 'fa003', '2', 'lg003', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws004', 'wa004', '2', 'fa004', '2', 'lg004', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws005', 'wa005', '2', 'fa005', '2', 'lg005', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws006', 'wa006', '2', 'fa006', '2', 'lg006', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws007', 'wa007', '2', 'fa007', '2', 'lg007', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws008', 'wa008', '2', 'fa008', '2', 'lg008', '2', null);
INSERT INTO greenwork.envequip (workshopid, warn, warnstatus, fan, fanstatus, light, lightstatus, fee) VALUES ('ws009', 'wa009', '2', 'fa009', '2', 'lg009', '2', null);

INSERT INTO greenwork.standard (name, low, hight) VALUES ('humidity', '20', '80');
INSERT INTO greenwork.standard (name, low, hight) VALUES ('pm10', '10', '20');
INSERT INTO greenwork.standard (name, low, hight) VALUES ('pm1_0', '10', '20');
INSERT INTO greenwork.standard (name, low, hight) VALUES ('pm2_5', '20', '115');
INSERT INTO greenwork.standard (name, low, hight) VALUES ('temperature', '20', '40');

INSERT INTO greenwork.user (telephone, username, account, password, job, hiredate, phonemac, checkin, checked, machineid, workshopid) VALUES ('13544292818', '姚鹏飞', 'Neal', '123456', '管理人员', '2019-05-27 16:57:14', '01-00-5e-00-00-02', '6', '通过审核', 'ma202', 'ws002');
INSERT INTO greenwork.user (telephone, username, account, password, job, hiredate, phonemac, checkin, checked, machineid, workshopid) VALUES ('13645926794', '刘德华', 'ldh', '1234', '生产人员', '2019-06-17 10:46:18', 'e3:r4:t5:y6:u7:i8', '0', '通过审核', 'ma202', 'ws002');
INSERT INTO greenwork.user (telephone, username, account, password, job, hiredate, phonemac, checkin, checked, machineid, workshopid) VALUES ('15916865266', '梁锦明', 'kimminh', '123', '管理人员', '2019-05-28 01:04:09', 'ff-ff-ff-ff-ff-ff', '8', '通过审核', '123', 'ws001');
INSERT INTO greenwork.user (telephone, username, account, password, job, hiredate, phonemac, checkin, checked, machineid, workshopid) VALUES ('18680271761', '曾楚龙', 'ClungTsang', '9527', '管理人员', '2019-05-30 15:16:19', 'e3:r4:t5:y6:u7:i8', '17', '通过审核', null, null);
INSERT INTO greenwork.user (telephone, username, account, password, job, hiredate, phonemac, checkin, checked, machineid, workshopid) VALUES ('19925356666', '李华', 'lihua', '123456', '生产人员', '2019-06-17 14:32:45', 'e3:r4:t5:y6:u7:i8', '0', '通过审核', 'ma303', 'ws003');

