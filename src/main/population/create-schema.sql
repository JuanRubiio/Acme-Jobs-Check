
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `link` varchar(255),
        `moment` datetime(6),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `aolet` (
       `id` integer not null,
        `version` integer not null,
        `badge` varchar(255),
        `text` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `answer_worker` varchar(255),
        `aolet` bit not null,
        `badge` varchar(255),
        `cc` varchar(255),
        `confirmation` varchar(255),
        `last_update` datetime(6),
        `message_rejected` varchar(255),
        `moment` datetime(6),
        `qualifications` varchar(255),
        `reference_number` varchar(255),
        `skills` varchar(255),
        `statement` varchar(255),
        `status` varchar(255),
        `job_id` integer not null,
        `worker_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `audit_record` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `moment` datetime(6),
        `status` varchar(255),
        `title` varchar(255),
        `auditor_id` integer not null,
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `firm` varchar(255),
        `responsability_statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `goal_bronze` varchar(255),
        `goal_gold` varchar(255),
        `goal_silver` varchar(255),
        `reward_bronze_amount` double precision,
        `reward_bronze_currency` varchar(255),
        `reward_gold_amount` double precision,
        `reward_gold_currency` varchar(255),
        `reward_silver_amount` double precision,
        `reward_silver_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target` varchar(255),
        `sponsor_id` integer not null,
        `cvv` integer not null,
        `credit_card` varchar(255),
        `month_expired` integer not null,
        `year_expired` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `company_record` (
       `id` integer not null,
        `version` integer not null,
        `ceo_name` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `incorporated` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` integer not null,
        `web_site` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `credit_card` (
       `id` integer not null,
        `version` integer not null,
        `cvv` integer not null,
        `credit_card` varchar(255),
        `month_expired` integer not null,
        `year_expired` integer not null,
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customisation_parameters` (
       `id` integer not null,
        `version` integer not null,
        `spam_threshold` double precision,
        `spam_words_en` varchar(255),
        `spam_words_es` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `duty` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `percentage` double precision,
        `title` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `garcia_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `bulletin_name` varchar(255),
        `dni` varchar(255),
        `name` varchar(255),
        `surname` varchar(255),
        `type` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor_record` (
       `id` integer not null,
        `version` integer not null,
        `investing_statement` datetime(6),
        `name_investor` varchar(255),
        `sector` varchar(255),
        `stars` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `jimenez_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `bulletin_name` varchar(255),
        `name` varchar(255),
        `nif` varchar(255),
        `surname` varchar(255),
        `type` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `active` bit,
        `deadline` datetime(6),
        `description` varchar(255),
        `link` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `status` varchar(255),
        `title` varchar(255),
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `sender_id` integer not null,
        `thread_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `non_commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target` varchar(255),
        `sponsor_id` integer not null,
        `jingle` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `confirmation` bit,
        `deadline` datetime(6),
        `max_price_amount` double precision,
        `max_price_currency` varchar(255),
        `min_price_amount` double precision,
        `min_price_currency` varchar(255),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `confirmation` bit,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request_auditor` (
       `id` integer not null,
        `version` integer not null,
        `firm` varchar(255),
        `responsability_statement` varchar(255),
        `authenticated_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `rivero_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `bulletin_name` varchar(255),
        `name` varchar(255),
        `nif` varchar(255),
        `surname` varchar(255),
        `type` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `sponsor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `organisation_name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `thread` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `title` varchar(255),
        `sender_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `thread_user` (
       `id` integer not null,
        `version` integer not null,
        `creator_thread` bit,
        `thread_id` integer not null,
        `user_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `qualifications_record` varchar(255),
        `skills_record` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXnhikaa2dj3la6o2o7e9vo01y0 on `announcement` (`moment`);

    alter table `aolet` 
       add constraint UK_a3ksflekvpcofl7ypjnf9rewb unique (`job_id`);
create index IDXnlv6ege1ixororpblu3lctiev on `application` (`reference_number`);
create index IDXg54pxa1gngqheaipukeg8jypk on `application` (`moment`);
create index IDX2q2747fhp099wkn3j2yt05fhs on `application` (`status`);

    alter table `application` 
       add constraint UK_rf84q38qr35ymh5nn0dcxfdue unique (`reference_number`);
create index IDXrc4ws05g8xybytvf60fgv6o5m on `audit_record` (`moment`);
create index IDXof878cqun8l1ynh0ao94bw3au on `audit_record` (`status`);
create index IDXnr284tes3x8hnd3h716tmb3fr on `challenge` (`deadline`);
create index IDX9jc4iq7uvk5yosailsy4darru on `commercial_banner` (`month_expired`);
create index IDX92jg8cgrmnrvixadn2e7a6a7a on `commercial_banner` (`year_expired`);
create index IDX9pkce3d1y6w47wadap5s5xptc on `company_record` (`stars`);
create index IDXkdedh59d4nlotef0ugh1ky8qm on `credit_card` (`month_expired`);
create index IDX8y5dhdokiy08xsb1smd6k1fgj on `credit_card` (`year_expired`);

    alter table `credit_card` 
       add constraint UK_4cr95y27s8ti6otoyflmma6oy unique (`sponsor_id`);
create index IDXk2t3uthe649ao1jllcuks0gv4 on `investor_record` (`stars`);
create index IDXfdmpnr8o4phmk81sqsano16r on `job` (`deadline`);
create index IDX28ur9xm72oo1df9g14xhnh8h3 on `job` (`status`);

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);
create index IDXeq5fhm2b5j1q3ex9vhpmvlwg0 on `message` (`moment`);
create index IDXcp4664f36sgqsd0ihmirt0w0 on `offer` (`ticker`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);
create index IDXh9syauj4iixf18uts83saik5d on `request` (`ticker`);
create index IDXlrvsw21ylkdqa1shrkwg1yssx on `request` (`deadline`);

    alter table `request` 
       add constraint UK_9mxq3powq8tqctclj0fbi2nih unique (`ticker`);

    alter table `request_auditor` 
       add constraint UK_ei3fu6x562eyti7w3e0lsu522 unique (`authenticated_id`);
create index IDX6gmkj2nkoj8vh2sll34p8ogcc on `thread` (`moment`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `aolet` 
       add constraint `FK6aqhcf5q0n808w63ec8g811c4` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKoa6p4s2oyy7tf80xwc4r04vh6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKmbjdoxi3o93agxosoate4sxbt` 
       foreign key (`worker_id`) 
       references `worker` (`id`);

    alter table `audit_record` 
       add constraint `FKdcrrgv6rkfw2ruvdja56un4ji` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `audit_record` 
       add constraint `FKlbvbyimxf6pxvbhkdd4vfhlnd` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `banner` 
       add constraint `FKjoxwdnjr54soq3j89kt3fgrtj` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `commercial_banner` 
       add constraint FK_q9id3wc65gg49afc5tlr1c00n 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `credit_card` 
       add constraint `FK31l5hvh7p1nx1aw6v649gw3rc` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `duty` 
       add constraint `FKs2uoxh4i5ya8ptyefae60iao1` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `message` 
       add constraint `FKkajds58b00e2wf9dge5biqf3p` 
       foreign key (`sender_id`) 
       references `user_account` (`id`);

    alter table `message` 
       add constraint `FK28hjkn063wrsjuiyyf8sm3s2v` 
       foreign key (`thread_id`) 
       references `thread` (`id`);

    alter table `non_commercial_banner` 
       add constraint FK_2l8gpcwh19e7jj513or4r9dvb 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `request_auditor` 
       add constraint `FK9giuqpn53mab8yca7a3noeckl` 
       foreign key (`authenticated_id`) 
       references `authenticated` (`id`);

    alter table `sponsor` 
       add constraint FK_20xk0ev32hlg96kqynl6laie2 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `thread` 
       add constraint `FK7l9cby7ycfrtiaueqtiayiumr` 
       foreign key (`sender_id`) 
       references `user_account` (`id`);

    alter table `thread_user` 
       add constraint `FKlsfnry2wohx5gt6xja8l3fnq7` 
       foreign key (`thread_id`) 
       references `thread` (`id`);

    alter table `thread_user` 
       add constraint `FK4p3fmvrwrvqu3390ub5c0miq0` 
       foreign key (`user_id`) 
       references `user_account` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
