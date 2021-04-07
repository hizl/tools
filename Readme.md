_**Описание**_


В этом приложении я затронул такие темы как использование JPA в реализации Hibernate.
Статья про работу JPA и Hibernate [здесь](https://java-master.com/%d1%87%d1%82%d0%be-%d1%82%d0%b0%d0%ba%d0%be%d0%b5-hibernate/).
Большое спасибо автору. На ресурсе много полезных и актуальных статей, про работу web-application, веб технологий в целом.

В данном репозитории я применю технологии, и реализую для моего понимания использования Hibernate.
Рассмотрю какие нужны зависимости в **pom.xml**.
Использование конфигурационного файла **hibernate.cfg.xml**, для корректного подключения к базе данных.

Рассмотрю отношения UniDirectional, BiDirectional, где я буду использовать аннотации.
@OneToOne со всеми необходимыми настройками и описанием этих настроек.

Для начала я подключил по [гайду](https://java-master.com/%d1%87%d1%82%d0%be-%d1%82%d0%b0%d0%ba%d0%be%d0%b5-hibernate/),
необходимые зависимости для корректной работы в pom.xml. Автор очень-очень доступно описал процесс подключения,
поэтому я просто повторил, мои отличия будут в использование MySQL - базы данных.
Затем я создал базу данных. **FINANCE**, с необходимыми таблицами, которые выглядят вот так:

<CREATE TABLE DIVIDENDS
(
id                 MEDIUMINT   NOT NULL AUTO_INCREMENT,
my_current_date    VARCHAR(20) NOT NULL,
my_current_company VARCHAR(20) NOT NULL,
my_current_price   int,
PRIMARY KEY (id),
details_id         int,
foreign key (details_id) references CONTACT_DETAILS (id_contact)
);
.
.
create table CONTACT_DETAILS
(
id_contact      int primary key not null auto_increment,
name_contact    VARCHAR(20)     NOT NULL,
surname_contact VARCHAR(20)     NOT NULL
);>

В данной таблице стоит уделить внимание, что вторичный ключ из таблицы DIVIDENDS указывает на поле
details_id, который в свою очередь ссылается на таблицу CONTACT_DETAILS и ее автоинкрементируемое поле
id_contact.

**details_id         int,
foreign key (details_id) references CONTACT_DETAILS (id_contact)**




Дальше я создал необходимый пакет **entity** с сущностями, который имеет те же самые поля что и база данных.
Подробней также описано в ссылках выше, которые я предоставил в качестве примера. 
Автор очень доступно сделал описание. Я хотел бы сделать акцент на отношениях использования
UniDirectional, BiDirectional, @OneToOne(...)


Я рассмотрю UniDirectional отношения с аннотацией @OneToOne(....)

```
class Dividends {
        field....
        getters and setters and constructor
        .
        .
        and
        .
        .
        //описание связи
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "details_id")
        private ContactDetails contactDetails;
}
```

Аннотация @OneToOne означает что у класса Dividends есть отношения с классом ContactsDetails.
Параметры в скобках (cascade = CascadeType.ALL) означает возможные события для каскадирования.
Про каскадирование событий можно почитать в [книге](https://disk.yandex.ru/i/9d3Dn1lu-p1Akg)
__Стр.239 Каскадирование событий__. Очень интересно описано какие бывают виды событий и когда используются.





**@OneToOne(mappedBy = "contactDetails",cascade = CascadeType.ALL)
Dividends dividends;**