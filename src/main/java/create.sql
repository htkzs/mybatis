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

# drop table user;
# drop table person;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `age` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1,'zhangsan',23),(2,'lisi',24);


CREATE TABLE `address` (
                           `address_id` int(10) NOT NULL,
                           `province` varchar(10) DEFAULT NULL,
                           `city` varchar(10) DEFAULT NULL,
                           `town` varchar(10) DEFAULT NULL,
                           PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `address` VALUES (1,'陕西省','宝鸡市','扶风县'),(2,'陕西省','西安市','户县');


CREATE TABLE `person` (
                          `no` int(10) NOT NULL AUTO_INCREMENT,
                          `name` varchar(10) DEFAULT NULL,
                          `age` int(10) DEFAULT NULL,
                          `height` mediumtext,
                          `address_id` int(10) DEFAULT NULL,
                          PRIMARY KEY (`no`),
                          KEY `address_id` (`address_id`),
                          CONSTRAINT `person_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `person` VALUES (1,'zhangsan',23,'1.75',1),(2,'lisi',23,'1.85',2),(3,'wangwu',24,'1.95',1);

CREATE TABLE `animals` (
                           `id` int(10) NOT NULL AUTO_INCREMENT,
                           `nick_name` varchar(10) DEFAULT NULL,
                           `actual_name` varchar(10) DEFAULT NULL,
                           `age` int(10) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `animals` VALUES (1,'小黑','哈士奇',2),(2,'小花','泰迪',3);


# 查询Address对用的人的信息
select address.address_id,province,city,town,no,name,age,height
from address left join person on address.address_id = person.address_id
where person.address_id=1;


select * from person where no=1 and name='zhangsan' and age=23 and height=1.75;
desc person;

update person set name='admin',age=23,height=178 where no=1;