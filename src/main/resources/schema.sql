--Database schema creation

CREATE TABLE IF NOT EXISTS APP_USER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS SESSION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES APP_USER(id)
);

CREATE TABLE IF NOT EXISTS QUESTION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    optionA VARCHAR(255),
    optionB VARCHAR(255),
    optionC VARCHAR(255),
    optionD VARCHAR(255),
    answer VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS ANSWER_SUBMISSION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    selected_answer VARCHAR(255),
    is_correct BOOLEAN,
    session_id BIGINT,
    question_id BIGINT,
    FOREIGN KEY (session_id) REFERENCES SESSION(id),
    FOREIGN KEY (question_id) REFERENCES QUESTION(id)
);

CREATE TABLE IF NOT EXISTS SESSION_STATISTICS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_answered INT DEFAULT 0,
    correct_answers INT DEFAULT 0,
    incorrect_answers INT DEFAULT 0,
    session_id BIGINT,
    FOREIGN KEY (session_id) REFERENCES SESSION(id)
);
