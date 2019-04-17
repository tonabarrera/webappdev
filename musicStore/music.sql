CREATE TABLE customer(
    customer_id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(35) NOT NULL,
    last_name varchar(35) NOT NULL,
    company varchar(35),
    city varchar(35),
    state varchar(35),
    country varchar(35),
    pastal_code varchar(35),
    phone varchar(35),
    fax varchar(35),
    email varchar(35)
);
CREATE TABLE artist(artist_id int PRIMARY KEY AUTO_INCREMENT, name varchar(50));
CREATE TABLE genre(genre_id int PRIMARY KEY AUTO_INCREMENT, name varchar(50));
CREATE TABLE media_type(media_type_id int PRIMARY KEY AUTO_INCREMENT, name varchar(35));
CREATE TABLE playlist(playlist_id int PRIMARY KEY AUTO_INCREMENT, name varchar(35));
CREATE TABLE album(
    album_id int PRIMARY KEY AUTO_INCREMENT,
    title varchar(35) NOT NULL, 
    artist_id int,
    FOREIGN KEY(artist_id) REFERENCES artist(artist_id) ON UPDATE CASCADE
);
CREATE TABLE track(
    track_id int PRIMARY KEY,
    name varchar(35) NOT NULL,
    album_id int NOT NULL,
    media_type_id int NOT NULL,
    genre_id int NOT NULL,
    composer varchar(35),
    milliseconds int,
    bytes int,
    unit_price int NOT NULL,
    FOREIGN KEY(album_id) REFERENCES album(album_id) ON UPDATE CASCADE,
    FOREIGN KEY(media_type_id) REFERENCES media_type(media_type_id) ON UPDATE CASCADE,
    FOREIGN KEY(genre_id) REFERENCES genre(genre_id) ON UPDATE CASCADE
);
CREATE TABLE playlist_track(
    playlist_id int NOT NULL,
    track_id int NOT NULL,
    PRIMARY KEY(playlist_id, track_id),
    FOREIGN KEY(track_id) REFERENCES track(track_id) ON UPDATE CASCADE,
    FOREIGN KEY(playlist_id) REFERENCES playlist(playlist_id) ON UPDATE CASCADE
);
CREATE TABLE invoice(
    invoice_id int PRIMARY KEY,
    customer_id int NOT NULL,
    invoice_date date,
    city varchar(35),
    state varchar(35),
    country varchar(35),
    postal_code varchar(35),
    total int,
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON UPDATE CASCADE
);
CREATE TABLE invoice_line(
    invoice_line_id int PRIMARY KEY,
    invoice_id int NOT NULL,
    track_id int NOT NULL,
    unit_price int,
    quantity int,
    FOREIGN KEY(invoice_id) REFERENCES invoice(invoice_id) ON UPDATE CASCADE,
    FOREIGN KEY(track_id) REFERENCES track(track_id) ON UPDATE CASCADE
);


