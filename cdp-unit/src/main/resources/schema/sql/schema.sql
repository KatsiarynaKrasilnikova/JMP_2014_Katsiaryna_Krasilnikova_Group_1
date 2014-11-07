create table account (
    id int,
    username varchar(255),
    amountDeposit numeric(12,2),
    interestRate numeric(12,2),
    depositPeriod numeric(12,2),
    primary key (id)
);