insert into users (name, username, password)
values ('Maling Pangsit', "maling@gmail.com", "$2y$10$kiU/PfCni12boP6FWBACyulQ2jxhkep6Szv40VyyaZoXNxgMdiQiG"),
        ('Farhan Kebaba', "kebab@gmail.com", "$2y$10$GmPZEdYJLNkLGKdPxyixCuGgURteIxaAK8VL2EwrhX5lb4QEbu8ne");

insert into tasks (title, description, status, expiration_date)
values ("Mabar Mobile Legend", "Mabar mobile legend bareng squad", "TODO", "2023-12-28 00:00:00"),
        ("Mabar PUBG", null, "IN_PROGRESS", "2023-12-29 00:00:00"),
        ("Tidur", null, "   DONE", null);

insert into users_tasks (task_id, user_id)
values (1, 2),
        (2, 2),
        (3, 2),
        (4, 1);

insert into users_roles (user_id, role)
values (1, "ROLE_ADMIN"),
        (1, "ROLE_USER"),
        (2, "ROLE_USER");