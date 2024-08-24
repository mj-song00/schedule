drop table if exists post;
create Table `post` (
                        userId int not null primary key auto_increment,
                        contents varchar(100) not null,
                        password varchar(20) not null,
                        createdAt date not null,
                        updatedAt date
);

drop table if exists comment;
create Table `comment`(
                          commentId int not null primary key auto_increment,
                          comments varchar(100) not null
                          createdAt date not null,
                          updatedAt date
);