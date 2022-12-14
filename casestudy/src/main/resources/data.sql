
insert into education_degree ( name)
values
("Trung cấp"),
("Cao đẳng"),
("Đại học"),
("Sau đại học");


insert into position (name)
values
("Sale-Marketing"),
("Hành chính"),
("Phục vụ"),
("Quản lý");

insert into division (name) values
("group 1"),("group 2"),("group 3"),("group 4");

insert into role (id, name) values
(1,"Administrator"),
(2,"Editor"),
(3,"Author"),
(4,"Contributor"),
(5,"Subscriber");

insert into user (id, username,is_enabled,password) values
(1,"nguyenvanan",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(2,"levanbinh",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(3,"hothiyen",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(4,"vocongtoan",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(5,"nguyenbinhphat",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(6,"khucnguyenannghi",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(7,"nguyenhuuha",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(8,"nguyenhadong",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(9,"tonghoang",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"),
(10,"nguyencongdao",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");


insert into employee(id, name, day_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id, username)
values
(1,"Nguyễn Văn An","1970-11-07","4562317861",10000000,"0901234121","annguyen@gamil.com","295 Nguyễn Tất Thành, Đà Nẵng",1,3,1,"nguyenvanan"),
(2,"Lê Văn Bình","1997-04-09","654231234",70000000,"0934212314","binhlv@gmail.com","22 Yên Bái, Đà Nẵng",1,2,2,"levanbinh"),
(3,"Hồ Thị Yến","1995-12-12","999231723",14000000,"0412352315","thiyen@gamil.com","K234/11 Hải Châu, Gia Lai",1,3,2,"hothiyen"),
(4,"Võ Công Toản","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Hoàng Diệu, Quảng Trị",1,4,4,"vocongtoan"),
(5,"Nguyễn Bỉnh Phát","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Yên Bái, Đà Nẵng",2,1,1,"nguyenbinhphat"),
(6,"Khúc Nguyễn An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguyễn Tất Thành, Đà Nẵng",2,2,3,"khucnguyenannghi"),
(7,"Nguyễn Hữu Hà","1993-01-01","534323231",8000000,"0941234553","nhh101@gmail.com","4 Nguyễn Chí Thanh, Huế",2,3,2,"nguyenhuuha"),
(8,"Nguyễn Hà Đông","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 Hùng Vương, Hà Nội",2,4,4,"nguyenhadong"),
(9,"Tòng Hoang","1982-09-03","256781231",6000000,"0245144444","hoangtong@gmail.com","213 Hàm Nghi, Đà Nẵng",2,4,4,"tonghoang"),
(10,"Nguyễn Công Đạo","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Hoà Khánh, Đồng Nai",2,3,2,"nguyencongdao");



insert into customer_type(id, name)
values
(1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

insert into customer(id,name, date_of_birth, gender, id_card, phone_number, email, address, customer_type_id)
values
(1,"Nguyễn Thị Hào","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng, Đà Nẵng",5),
(2,"Phạm Xuân Diệu","1992-08-08",1,"865342123","0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),
(3,"Trương Đình Nghệ","1990-02-27",1,"488645199","0373213122","nghenhan2702@gamil.com","K323/12 Ông Ích Khiêm, Vinh",1),
(4,"Dương Văn Quan","1981-07-08",1,"543432111","0490039241","duongquan@gmail.com","K453/12 Lê Lợi, Đà Nẵng",1),
(5,"Hoàng Trần Nhi Nhi","1995-12-09",0,"795453345","0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),
(6,"Tôn Nữ Mộc Châu","2005-12-06",0,"732434215","0988888844","tonnuchau@gmail.com","37 Yên Thế, Đà Nẵng",4),
(7,"Nguyễn Mỹ Kim","1984-04-08",0,"856453123","0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh",1),
(8,"Nguyễn Thị Hào","1999-04-08",0,"965656433","0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum",3),
(9,"Trần Đại Danh","1994-07-01",1,"432341235","0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt, Quảng Ngãi",1),
(10,"Nguyễn Tâm Đắc","1989-07-01",1,"344343432","0987654321","dactam@gmail.com","22 Ngô Quyền, Đà Nẵng",2);



insert into rent_type(id, name)
values
(1,"year"),
(2,"month"),
(3,"day"),
(4,"hour");

insert into facility_type(id, name)
values
(1,"Villa"),
(2,"House"),
(3,"Room");

insert into facility(id, name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free, rent_type_id, facility_type_id)
values
(1,"Villa Beach Front",25000,1000000,10,"vip","có hồ bơi",500,4,null,3,1),
(2,"House Princess 01",14000,5000000,7,"vip","có thêm bếp nướng",null,3,null,2,2),
(3,"Room Twin 01",5000,1000000,2,"normal","có tivi",null,null,"1 xe máy,1 xe đạp",4,3),
(4,"Villa No Beach Front",22000,9000000,8,"normal","có hồ bơi",300,3,null,3,1),
(5,"House Princess 02",10000,4000000,5,"normal","có thêm bếp nướng",null,2,null,3,2),
(6,"Room Twin 02",3000,900000,2,"normal","có tivi",null,null,"1 xe máy",4,3);


insert into database_furama_module4.attach_facility (id,name,cost,unit,status) values
(1,"karaoke",10000,"giờ","tiện nghi, hiện đại"),
(2,"Thuê xe máy",10000,"chiếc","hỏng 1 xe"),
(3,"Thuê xe đạp",20000,"chiếc","tốt"),
(4,"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn,tráng miệng"),
(5,"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn,tráng miệng"),
(6,"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn,tráng miệng");




insert into database_furama_module4.contract(id,start_date,end_date,deposit,employee_id,customer_id,facility_id) values
(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1),
(13,'2019-12-12','2020-12-08',0,3,1,3);


insert into database_furama_module4.contract_detail (id,quantity,contract_id,attach_facility_id) values

(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

