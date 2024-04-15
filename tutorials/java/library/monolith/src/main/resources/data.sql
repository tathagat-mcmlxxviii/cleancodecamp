
-- Insert test data for authors
INSERT INTO author (id, name) VALUES
(-991, 'Tathagat'),
(-992, 'Bettina');

-- Insert test data for genres
INSERT INTO genre (id, name) VALUES
(-991, 'Action'),
(-992, 'Romance');

-- Insert test data for publishers
INSERT INTO publisher (id, name) VALUES
(-991, 'Publisher 1'),
(-992, 'Publisher 2');

-- Insert test data for books
INSERT INTO book (id, title, author_id, genre_id, publisher_id, isin) VALUES
(-991, 'Mission Impossible', -991, -991, -991, 'ISBN-1'),
(-992, 'Twilight', -992, -992, -992, 'ISBN-2');
