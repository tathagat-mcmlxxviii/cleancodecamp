
-- Insert test data for authors
INSERT INTO author (id, name) VALUES
(-9991, 'Tathagat'),
(-9992, 'Bettina');

-- Insert test data for genres
INSERT INTO genre (id, name) VALUES
(-9991, 'Action'),
(-9992, 'Romance');

-- Insert test data for publishers
INSERT INTO publisher (id, name) VALUES
(-9991, 'Publisher 1'),
(-9992, 'Publisher 2');

-- Insert test data for books
INSERT INTO book (id, title, author_id, genre_id, publisher_id, isin) VALUES
(-9991, 'Book 1', -9991, -9991, -9991, 'ISBN-1'),
(-9992, 'Book 2', -9991, -9992, -9992, 'ISBN-2');
