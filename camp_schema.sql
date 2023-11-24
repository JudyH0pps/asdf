drop database if exists campdb;
create database campdb;
use campdb;

-- user Table Create SQL
-- 테이블 생성 SQL - user
CREATE TABLE user
(
    `id` int auto_increment,
    `userId` VARCHAR(200) NOT NULL,
    `password` VARCHAR(200) NOT NULL,
    `email` varchar(200) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE camp
(
    `id` int auto_increment,
    `userKey` int NOT NULL,
    `name` varchar(200) NOT NULL,
    `address` varchar(200) NOT NULL,
    `description` varchar(1000) NOT NULL,
    `img` varchar(200) NOT NULL,
    `orgImg` varchar(200) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userKey`) REFERENCES user(`id`)
);

CREATE TABLE review
(
    `id` int auto_increment,
    `userKey` int NOT NULL,
    `campKey` int NOT NULL,
    `content` varchar(1000) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userKey`) REFERENCES user(`id`),
    FOREIGN KEY (`campKey`) REFERENCES camp(`id`)
);

CREATE TABLE camp_like
(
    `id` int auto_increment,
    `userKey` int NOT NULL,
    `campKey` int NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userKey`) REFERENCES user(`id`),
    FOREIGN KEY (`campKey`) REFERENCES camp(`id`),
    unique (`userKey`, `campKey`)
);

-- user 테이블 데이터 삽입
INSERT INTO user (userId, password, email)
VALUES
    ('john', 'password123', 'john.doe@example.com'),
    ('jane', 'password456', 'jane.smith@example.com'),
    ('alex', 'password789', 'alex.wilson@example.com'),
    ('emma', 'passwordabc', 'emma.jones@example.com'),
    ('michael', 'passworddef', 'michael.brown@example.com'),
    ('olivia', 'passwordxyz', 'olivia.davis@example.com'),
    ('william', 'password123', 'william.thomas@example.com'),
    ('sophia', 'password456', 'sophia.johnson@example.com'),
    ('jackson', 'password789', 'jackson.taylor@example.com'),
    ('ssafy', 'ssafy', 'ssafy@ssafy.com');

-- camp 테이블 데이터 삽입
INSERT INTO camp (userKey, name, address, description)
VALUES
    (1, '캠프장 A', '서울시 강남구 123번지', '아름다운 전망을 가진 멋진 캠프장'),
    (2, '캠프장 B', '서울시 강북구 456번지', '자연에 둘러싸인 아늑한 캠프장'),
    (3, '캠프장 C', '서울시 강서구 789번지', '현대적인 편의시설이 갖춰진 넓은 캠프장'),
    (4, '캠프장 D', '서울시 동작구 321번지', '숲 속에 자리한 고요한 캠프장'),
    (5, '캠프장 E', '서울시 도봉구 654번지', '평화로운 호수 근처에 위치한 조용한 캠프장'),
    (6, '캠프장 F', '서울시 마포구 987번지', '등산로가 있는 모험적인 캠프장'),
    (7, '캠프장 G', '서울시 송파구 1234번지', '놀이터가 있는 가족 친화적인 캠프장'),
    (8, '캠프장 H', '서울시 양천구 5678번지', '한적한 장소로 편안한 휴식을 제공하는 캠프장'),
    (9, '캠프장 I', '서울시 영등포구 9012번지', '아늑한 캐빈이 있는 러스틱한 캠프장'),
    (10, '캠프장 J', '서울시 종로구 3456번지', '아름다운 일몰이 있는 경치 좋은 캠프장');

-- review 테이블 데이터 삽입
INSERT INTO review (userKey, campKey, content)
VALUES
    (1, 1, '숙박시설이 정말로 최고네요! 강력히 추천합니다.'),
    (2, 2, '기대 이상이었습니다. 꼭 다시 방문할 것입니다.'),
    (3, 3, '시설이 끝내줍니다. 멋진 경험이었습니다.'),
    (4, 4, '즐거운 휴가를 보냈습니다. 자연경관을 좋아하는 사람들에게 완벽합니다.'),
    (5, 5, '조용하고 쾌적한 환경이 너무 좋았어요. 다시 방문하고 싶습니다.'),
    (6, 6, '등산로가 깔끔하고 좋아요. 등산을 좋아하시는 분들께 좋습니다.'),
    (7, 7, '가족 여행에 아주 좋습니다. 아이들이 너무 즐거워했어요.'),
    (8, 8, '위치는 즐거운 휴식을 위해 딱입니다.'),
    (9, 9, '아늑한 카라반 시설은 분위기 있는 추억을 만들어 주었습니다.'),
    (10, 10, '일몰이 정말로 장관이었습니다.');
   
INSERT INTO camp_like (userKey, campKey) VALUES
    (1, 1), (1, 2), (1, 3), (1, 4), (2, 5), (2, 6), (2, 7), (2, 8),
    (3, 9), (3, 10), (3, 1), (3, 2), (4, 3), (4, 4), (4, 5), (4, 6),
    (5, 7), (5, 8), (5, 9), (5, 10), (6, 1), (6, 2), (6, 3), (6, 4),
    (7, 5), (7, 6), (7, 7), (7, 8), (8, 9), (8, 10);