drop table if exists post;
create Table `post` (
                        postId int not null primary key auto_increment,
                        contents varchar(100) not null,
                        password varchar(20) not null,
                        createdAt date not null,
                        updatedAt date
);

drop table if exists comment;
create Table `comment`(
                          commentId int not null primary key auto_increment,
                          comments varchar(100) not null,
                          createdAt date not null,
                          updatedAt date
);

drop table if exists user;
create Table `user`(
                        userId int not null primary key auto_increment,
                        email  varchar(20) not null,
                        createdAt date not null,
                        updatedAt date not null,
);

drop table if exist user_posts;
create Table `user_posts`(
                        upId int not null primary key auto_increment,
                        userId int not null,
                        postId int not null,
                        manager varchar(20),
                        createdAt date not null,
                        updatedAt date not null,
)