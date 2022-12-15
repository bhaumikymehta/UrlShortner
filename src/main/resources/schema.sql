DROP TABLE IF EXISTS urlShortener;

CREATE TABLE url_Shortener (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          original_url VARCHAR(250) NOT NULL,
                          short_url VARCHAR(50) NOT NULL
);