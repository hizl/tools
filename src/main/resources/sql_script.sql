CREATE DATABASE FINANCE;

DROP TABLE DIVIDENDS;
DROP TABLE CONTACT_DETAILS;


CREATE TABLE DIVIDENDS
(
    id                 MEDIUMINT   NOT NULL AUTO_INCREMENT,
    my_current_date    VARCHAR(20) NOT NULL,
    my_current_company VARCHAR(20) NOT NULL,
    my_current_price   int,
    PRIMARY KEY (id),
    details_id         int,
    foreign key (details_id) references CONTACT_DETAILS (id_contact)
);


INSERT INTO DIVIDENDS (my_current_date, my_current_company, my_current_price)
VALUES ('01.01.2019', 'Gazprom', 2000),
       ('01.01.2019', 'Avtovaz', 2500),
       ('05.01.2019', 'Sberbank', 10000),
       ('10.01.2019', 'Gazprom', 2500),
       ('07.10.2019 ', 'Avtovaz', 2100);


create table CONTACT_DETAILS
(
    id_contact      int primary key not null auto_increment,
    name_contact    VARCHAR(20)     NOT NULL,
    surname_contact VARCHAR(20)     NOT NULL
);


INSERT INTO CONTACT_DETAILS (name_contact, surname_contact)
VALUES ('Svetlana', 'Osipova'),
       ('Jenya', 'Sidorov'),
       ('Maxim', 'Osipenko'),
       ('Petr', 'Dal');
