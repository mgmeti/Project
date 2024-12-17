
INSERT INTO APP_USER (name) VALUES ('John Doe');
INSERT INTO APP_USER (name) VALUES ('Ramesh');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the chemical symbol for water?', 'H2O', 'CO2', 'O2', 'H2', 'A');
    
INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What planet is known as the Red Planet?', 'Earth', 'Venus', 'Mars', 'Jupiter', 'C');
    
INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the boiling point of water in Celsius?', '100°C', '50°C', '0°C', '75°C', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('Who developed the theory of relativity?', 'Isaac Newton', 'Albert Einstein', 'Galileo Galilei', 'Nikola Tesla', 'B');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the largest organ in the human body?', 'Heart', 'Liver', 'Skin', 'Brain', 'C');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the primary gas in the Earth''s atmosphere?', 'Oxygen', 'Nitrogen', 'Carbon Dioxide', 'Hydrogen', 'B');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('Which planet is closest to the Sun?', 'Earth', 'Venus', 'Mercury', 'Mars', 'C');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the atomic number of Carbon?', '6', '8', '2', '4', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the smallest bone in the human body?', 'Stapes', 'Femur', 'Tibia', 'Humerus', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the hardest substance found in nature?', 'Diamond', 'Gold', 'Iron', 'Platinum', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('How many bones are in the adult human body?', '206', '100', '300', '250', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the center of an atom called?', 'Electron', 'Neutron', 'Proton', 'Nucleus', 'D');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What type of animal is a Komodo dragon?', 'Lizard', 'Bird', 'Mammal', 'Fish', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the speed of light in a vacuum?', '300,000 km/s', '150,000 km/s', '500,000 km/s', '200,000 km/s', 'A');

INSERT INTO QUESTION (text, optionA, optionB, optionC, optionD, answer)
VALUES 
    ('What is the process by which plants make their own food?', 'Respiration', 'Transpiration', 'Photosynthesis', 'Digestion', 'C');

INSERT INTO SESSION (start_time,end_time, user_id)
VALUES ('2024-12-17 10:00:00','2024-12-17 15:00:00', 2); 

INSERT INTO SESSION_STATISTICS (total_answered, correct_answers, incorrect_answers, session_id)
VALUES (2, 1, 1, 1);  

INSERT INTO ANSWER_SUBMISSION (selected_answer, is_correct, session_id, question_id)
VALUES 
    ('A', TRUE, 1, 1), 
    ('B', FALSE, 1, 2);  
