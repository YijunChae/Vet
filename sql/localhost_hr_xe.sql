--drop table vet_user;
create table vet_user(
    no          number(20)
    ,id         varchar2(200) primary key
    ,pw         varchar2(200) not null
    ,name       varchar2(100) not null
    ,breed      varchar2(100) not null
    ,gender     varchar2(100) not null
    ,age        number(5)    not null
    ,protector  varchar2(100) not null
    ,phone      varchar2(100) not null
);

--drop sequence seq_vet_user_no;
create sequence seq_vet_user_no nocache;

insert into vet_user
 values(seq_vet_user_no.nextval, 'dani', 'love', '�ٴ�', '�����(��ġŲ)', 'M', 2, 'ä����', '010-1111-1111');

insert into vet_user
 values(seq_vet_user_no.nextval, 'blanc', 'peace', '���', '�����(���)', 'M', 3, '������', '010-1111-1112');
 
insert into vet_user
 values(seq_vet_user_no.nextval, 'summer', 'haha123', '�ϱ�', '��(��Ʈ����)', 'M', 5, '������', '010-1111-1113');
 
insert into vet_user
 values(seq_vet_user_no.nextval, 'o', 'julia', '����', '�����(�̰�Ǫ��)', 'F', 4, '������', '010-1111-1114');
 
insert into vet_user
 values(seq_vet_user_no.nextval, 'victory', 'v3', '����', '��(�����ݸ�)', 'M', 3, '������', '010-1111-1115');

select * from vet_user;
commit;


--drop table vet_admin;
create table vet_admin(
    empNo       number(20)
    ,id         varchar2(200) primary key
    ,pw         varchar2(200) not null
    ,vet       varchar2(100) not null
    ,grade      varchar2(100) not null
    ,phone      varchar2(100) not null
);

--drop sequence seq_vet_admin_empNo;
create sequence seq_vet_admin_empNo nocache;

insert into vet_admin
 values(seq_vet_admin_empNo.nextval, 'master', 'song', '�۰�', '��ǥ����', '010-7777-1111');

insert into vet_admin
 values(seq_vet_admin_empNo.nextval, 'bestvet', 'lee', '�̻��', '����', '010-7777-1112');
 
insert into vet_admin
 values(seq_vet_admin_empNo.nextval, 'min', 'jeong', '�����', '����', '010-7777-1113');
 
insert into vet_admin
 values(seq_vet_admin_empNo.nextval, 'zero', 'kim', '�迵��', '����(��ȯ�⳻��)', '010-7777-1114');
 
insert into vet_admin
 values(seq_vet_admin_empNo.nextval, 'woo', 'choi', '������', '����(�Ȱ�)', '010-7777-1115');


select * from vet_admin;
commit;






-- vet_schedule
--drop table vet_schedule;
CREATE TABLE vet_schedule (
    scheduleId VARCHAR2(20) PRIMARY KEY
    ,animalId VARCHAR2(20)
    ,animalName VARCHAR2(20)
    ,demand VARCHAR2(200)
    ,vetId VARCHAR2(20)
    ,vetName VARCHAR2(20)
    ,scheduleDate TIMESTAMP
    ,reservationStatus VARCHAR2(20) DEFAULT '���δ��'
    ,CONSTRAINT FK_vet_schedule_Aninal FOREIGN KEY (animalId) REFERENCES vet_user(id) ON DELETE CASCADE
    ,CONSTRAINT FK_vet_schedule_Vet FOREIGN KEY (vetId) REFERENCES vet_admin(id) ON DELETE CASCADE
);

-- seq_vet_schedule_id
--drop sequence seq_vet_schedule_id;
CREATE SEQUENCE seq_vet_schedule_id nocache;


-- vet_chart
CREATE TABLE vet_chart (
    chartId VARCHAR2(20) PRIMARY KEY
    ,animalId VARCHAR2(20)
    ,animalName VARCHAR2(20)
    ,vetId VARCHAR2(20)
    ,vetName VARCHAR2(20)
    ,treatDate TIMESTAMP
    ,diagnosis VARCHAR2(300)
    ,treatment VARCHAR2(300)
    ,CONSTRAINT FK_vet_chart_Animal FOREIGN KEY (animalId) REFERENCES vet_user(id) ON DELETE CASCADE
    ,CONSTRAINT FK_vet_chart_Vet FOREIGN KEY (vetId) REFERENCES vet_admin(id) ON DELETE CASCADE
);
--drop table vet_chart;


-- seq_vet_chart_id
CREATE SEQUENCE seq_vet_chart_id nocache;
--DROP SEQUENCE seq_vet_chart_id;









select * from vet_user;
select * from vet_admin;
select * from vet_schedule;
select * from vet_chart;