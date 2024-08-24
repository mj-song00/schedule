create Table `post` (
                        userId int not null primary key auto_increment,
                        contents varchar(100) not null,
                        password varchar(20) not null,
                        manager varchar(10) not null,
                        createdAt date not null,
                        updatedAt date
);


create Table `comment`(
                          commentId int not null primary key auto_increment,
                          commetContents varchar(100) not null
                          createdAt date not null,
                          updatedAt date
);