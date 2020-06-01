use p2p_database;
------------------------------------------------
create table user(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
userid                     varchar(30) NOT NULL,
password                   varchar(39),
first_name                 varchar(20) NOT NULL,
last_name                  varchar(20),
PRIMARY KEY(ID)
);
select * from user;
------------------------------------------------
create table client(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
first_name                 varchar(30),
last_name                  varchar(30),
PRIMARY KEY(ID)
);
select * from client;
------------------------------------------------
create table company(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
name                       varchar(30) NOT NULL,
url                        varchar(30),
contact                    varchar(30),
PRIMARY KEY(ID)
);
select * from company;
------------------------------------------------
create table registration (
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
client_id                  int         NOT NULL,
company_id                 int         NOT NULL,
company_client_id          varchar(30) NOT NULL,
date_created               timestamp,
userid                     varchar(30),
password                   varchar(30),
two_factor_auth            boolean,
city                       varchar(30),
address                    varchar(30),
postal_code                varchar(20),
residence_country          varchar(20),
phone                      varchar(20),
email                      varchar(20),
language                   varchar(20),
document                   varchar(30),
contact                    varchar(30),
notif_daily_summary        boolean,
notif_deposits             boolean,
notif_successful_withdrawl boolean,
notif_bonus_payment        boolean,
notif_newsletters          boolean,
agreement                  BLOB,
PRIMARY KEY(ID),
FOREIGN KEY (client_id)       REFERENCES client(id)        ON DELETE CASCADE,
FOREIGN KEY (company_id)      REFERENCES company(id)       ON DELETE CASCADE,
UNIQUE(client_id, company_id)
);
select * from registration;
------------------------------------------------
create table account(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
registration_id            int         NOT NULL,
account                    varchar(30) NOT NULL,
currency                   varchar(3),
PRIMARY KEY(ID),
FOREIGN KEY (registration_id) REFERENCES registration(id)  ON DELETE CASCADE,
UNIQUE(account, currency)
);
select * from account;
------------------------------------------------
create table investaccount(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
registration_id            int         NOT NULL,
currency                   varchar(3)  NOT NULL,
balance                    float       NOT NULL,
description                varchar(30),
PRIMARY KEY(ID),
FOREIGN KEY (registration_id) REFERENCES registration(id)  ON DELETE CASCADE,
UNIQUE(registration_id, currency)
);
select * from investaccount;
------------------------------------------------
create table investment(
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
registration_id            int         NOT NULL,
loan_id                    varchar(30) NOT NULL,
interest_rate              float       NOT NULL,
my_investment              float       NOT NULL,
investment_date            date        NOT NULL,
currency                   varchar(3)  NOT NULL,
issue_date                 date,
loan_type                  varchar(30),
amortization_method        varchar(30),
loan_originator            varchar(30),
rating                     varchar(2),
loan_amount                float,
remaining_principal        float,
next_payment_date          date,
estimated_next_payment     float,
ltv                        varchar(20),
remaining_term             int,
payments_received          int,
status                     varchar(20),
buyback_guarantee          boolean,
schedule_extension         boolean,
received_payments          float,
pending_payments           float,
outstanding_principal      float,
secondary_market_amount    float,
price                      float,
discount_premium           float,
PRIMARY KEY(ID),
FOREIGN KEY(registration_id)  REFERENCES registration(id)  ON DELETE CASCADE,
UNIQUE(registration_id, loan_id)
);
select * from investment;
------------------------------------------------
create table taxreport (
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
registration_id            int         NOT NULL,
tax_year                   int         NOT NULL,
tax_report                 BLOB,
PRIMARY KEY(ID),
FOREIGN KEY (registration_id) REFERENCES registration(id)  ON DELETE CASCADE,
UNIQUE(registration_id, tax_year)
);
------------------------------------------------
create table movement (
id                         int         NOT NULL AUTO_INCREMENT,
created                    timestamp   NOT NULL,
registration_id            int         NOT NULL,
trans_date                 date        NOT NULL,
investment_id              int, 
account_id                 int,
investaccount_id           int         NOT NULL,
amount                     float       NOT NULL,
currency                   varchar(3)  NOT NULL,
description                varchar(20),
PRIMARY KEY(ID),
FOREIGN KEY(registration_id)  REFERENCES registration(id)  ON DELETE CASCADE,
FOREIGN KEY(investment_id)    REFERENCES investment(id)    ON DELETE CASCADE,
FOREIGN KEY(account_id)       REFERENCES account(id)       ON DELETE CASCADE,
FOREIGN KEY(investaccount_id) REFERENCES investaccount(id) ON DELETE CASCADE
);
select * from movement;
------------------------------------------------
commit;