insert into user (id, username, password, firstname, lastname, email, enabled) values (1, 'admin', '$2a$08$ldnhpz7euksi6ao14twuau08mzhwrl4kyzggu5xfigalo/vxd5doi', 'admin', 'admin', 'admin@admin.com', 1);
insert into user (id, username, password, firstname, lastname, email, enabled) values (2, 'user', '$2a$08$ukvvwpulis18s19s5pzfn.yhpzt3oaqhzndwqbcw9pft6uftkxkdc', 'user', 'user', 'enabled@user.com', 1);
insert into user (id, username, password, firstname, lastname, email, enabled) values (3, 'disabled', '$2a$08$ukvvwpulis18s19s5pzfn.yhpzt3oaqhzndwqbcw9pft6uftkxkdc', 'user', 'user', 'disabled@user.com', 0);

insert into authority (id, name) values (1, 'ROLE_USER');
insert into authority (id, name) values (2, 'ROLE_ADMIN');

insert into user_authority (user_id, authority_id) values (1, 1);
insert into user_authority (user_id, authority_id) values (1, 2);
insert into user_authority (user_id, authority_id) values (2, 1);
insert into user_authority (user_id, authority_id) values (3, 1);