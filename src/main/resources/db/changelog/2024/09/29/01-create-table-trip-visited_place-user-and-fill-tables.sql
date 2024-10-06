-- create table user_info
-- (
--     user_info_id  uuid        not null
--         constraint user_info_pk primary key,
--     username varchar(50) not null unique,
--     email    varchar(50) not null unique
-- --                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

create table trip
(
    trip_id         uuid         not null
        constraint trip_pk primary key,
    trip_name       varchar(50)  not null,
    trip_start_date timestamp(6) not null,
    trip_end_date   timestamp(6) not null,
    organizer_id    uuid not null,
    created_at      timestamp(6) default now()
);


create table visited_place
(
    visited_place_id uuid          not null
        constraint visited_place_pk primary key,
    place_name       varchar(50)   not null,
    country          varchar(50)   not null,
    latitude         double precision not null,
    longitude        double precision not null,
    photo_url        varchar(50), -- not null,
    visit_date       timestamp(6)  not null,
    trip_id          uuid
        constraint visited_place_trip_trip_id_fk
            references trip
            on delete cascade
);


create table trip_participant
(
    trip_id uuid not null,
    participant_id uuid not null,
    primary key (trip_id, participant_id),
    foreign key (trip_id) references
        trip (trip_id)
        on delete cascade
);
