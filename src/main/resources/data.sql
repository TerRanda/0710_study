insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (1, '홍길동', 'mars@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (2, '박남순', 'namsun@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (3, '이순신', 'leesunsin@gmail.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (4, '강감찬', 'kangkamchan@gmail.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (5, '홍길동', 'cantCallPapa@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (6, '홍길동', 'notMyFather@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (7, '홍길동', 'EastWestLight@thejoeun.com', now(), now());

--shift+alt+클릭으로 범위 지정 = 동시작성.
insert into users(`id`, `name`,`email`) values (1, "아지르", "azir@esports.com");
insert into users(`id`, `name`,`email`) values (2, "카이사", "kaisa@esports.com");
insert into users(`id`, `name`,`email`) values (3, "밀리오", "milio@esports.com");

insert into publisher(`id`, `name`, `create_at`, `update_at`) values(1, "T1 esports", now(), now());
insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (1, "아이언에서 챌린저까지", 1, now(), now());
insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (2, "플옵에서 결승까지", 1, now(), now());
insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (5, "플옵에서 결승까지", 1, now(), now());
insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (3, "LCK에서 월즈까지", 1, now(), now());
insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (4, "LCK에서 월즈까지", 1, now(), now());



--insert into member3(`name`, `age`, `id`, `nickname`, `email`) values ('보라돌이', 10, '보라보라', 'bora123@gmail.com');
--insert into member3(`name`, `age`, `id`, `nickname`, `email`) values ('뚜비', 9, '뚜비뚜밥', 'ddu123@gmail.com');
--insert into member3(`name`, `age`, `id`, `nickname`, `email`) values ('뽀', 3, '뽀오', 'bbo123@gmail.com');
