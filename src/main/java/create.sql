create table animals(
                        id int(10) primary key auto_increment,
                        nick_name varchar(10),
                        actual_name varchar(10),
                        age int(10)
);

insert into animals(id,nick_name,actual_name,age) values(1,'小黑','哈士奇',2),(2,'小花','泰迪',3);

create table person(
                       no int(10) primary key auto_increment,
                       name varchar(10),
                       age int(10),
                       height long,
                       address_id int(10),
                       foreign key(address_id) references address(address_id)
);

create table address(
                        address_id int(10) primary key not null,
                        province varchar(10),
                        city varchar(10),
                        town varchar(10)
);

insert into person(no, name, age, height, address_id)
values(1,'zhangsan',23,1.75,001),(2,'lisi',23,1.85,002);
insert into address(address_id, province, city, town)
values (001,'陕西省','宝鸡市','扶风县'),(002,'陕西省','西安市','户县');

# 修改表结构增加一个外键
alter table person add constraint fk_person_address foreign key (address_id) references address(address_id);


select* from person,address where person.address_id = address.address_id and no=1;