# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table usuario (
  id                        bigint not null,
  viagem_id                 bigint not null,
  nome                      varchar(255),
  email                     varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (id))
;

create table viagem (
  id                        bigint not null,
  local                     varchar(255),
  data                      varchar(255),
  descricao                 varchar(255),
  organizador_id            bigint,
  senha                     varchar(255),
  constraint pk_viagem primary key (id))
;

create sequence usuario_seq;

create sequence viagem_seq;

alter table usuario add constraint fk_usuario_viagem_1 foreign key (viagem_id) references viagem (id) on delete restrict on update restrict;
create index ix_usuario_viagem_1 on usuario (viagem_id);
alter table viagem add constraint fk_viagem_organizador_2 foreign key (organizador_id) references usuario (id) on delete restrict on update restrict;
create index ix_viagem_organizador_2 on viagem (organizador_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists usuario;

drop table if exists viagem;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists usuario_seq;

drop sequence if exists viagem_seq;

