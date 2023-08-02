create table if not exists Event(
    id int not null auto_increment,
    name varchar(255) not null,
    description TEXT not null,
    start_date date not null,
    end_date date not null,
    cfp_start_date date not null,
    cfp_end_date date not null,
    location varchar(255) not null,
    website varchar(255) not null,
    primary key (id)
);

