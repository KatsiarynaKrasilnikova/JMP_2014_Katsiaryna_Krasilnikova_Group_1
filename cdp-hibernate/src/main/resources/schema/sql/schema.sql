create table ContactInfo (
        userId bigint not null,
        created datetime not null,
        modified datetime not null,
        version bigint not null,
        birthday date,
        firstName varchar(255) not null,
        lastName varchar(255) not null,
        primary key (userId)
    );

create table Project (
        id bigint not null auto_increment,
        created datetime not null,
        modified datetime not null,
        version bigint not null,
        name varchar(255) not null,
        primary key (id)
    );

create table Skill (
        id bigint not null auto_increment,
        created datetime not null,
        modified datetime not null,
        version bigint not null,
        name varchar(255) not null,
        primary key (id)
    );

create table User (
        id bigint not null auto_increment,
        created datetime not null,
        modified datetime not null,
        version bigint not null,
        email varchar(255) not null,
        password varchar(255) not null,
        role varchar(255) not null,
        projectId bigint,
        primary key (id)
    );

create table user_skill (
        userId bigint not null,
        skillId bigint not null,
        primary key (userId, skillId)
    );