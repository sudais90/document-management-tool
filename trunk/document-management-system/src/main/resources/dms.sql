
insert into users(user_id, ENABLED, USERNAME, PASSWORD) values(1,1,'a','a');
insert into users(user_id, ENABLED, USERNAME, PASSWORD) values(2,1,'b','b');

insert into user_roles(USER_ROLE_ID, USER_ID,AUTHORITY) VALUES(1,1,'ROLE_USER');
insert into user_roles(USER_ROLE_ID, USER_ID,AUTHORITY) VALUES(2,2,'ROLE_ADMIN');