# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table usuario (
  id                        bigint not null,
  nome                      varchar(255),
  email                     varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (id))
;

create sequence usuario_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists usuario_seq;

