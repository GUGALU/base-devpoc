CREATE TABLE tb_user (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE address (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    postal_code VARCHAR(255),
    country VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE permission (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255)
);

CREATE TABLE user_permission (
    user_id BIGINT,
    permission_id BIGINT,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);
