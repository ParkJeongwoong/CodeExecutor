CREATE TABLE IF NOT EXISTS rock (
    id int NOT NULL AUTO_INCREMENT,
    color varchar(50) NOT NULL,
    shape varchar(100) NOT NULL,
    size int NOT NULL,
    weight int NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='예시'
;