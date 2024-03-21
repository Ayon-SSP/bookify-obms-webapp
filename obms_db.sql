CREATE TABLE tbl_author 
( 
    author_id VARCHAR2(10) NOT NULL, 
    author_name VARCHAR2(50) NOT NULL, 
    author_bio VARCHAR2(1000), 
    author_score NUMBER, 
    author_image VARCHAR2(255),
    author_birth_date DATE, 
CONSTRAINT pk_author 
    PRIMARY KEY (author_id),
CONSTRAINT ck_author_id
    CHECK (REGEXP_LIKE(author_id, 'au[0-9]{5}')),
CONSTRAINT ck_author_score   CHECK ((author_score >= 0 AND author_score <= 5))
) 
/
INSERT INTO tbl_author VALUES ('au91004','J.R.R. Tolkien','John Ronald Reuel Tolkien was an English writer, poet, philologist, and academic, best known as the author of the high fantasy works The Hobbit, The Lord of the Rings, and The Silmarillion.',4.5, 'jrrtolkien.jpg', TO_DATE('03-JAN-1892', 'DD-MON-YYYY'));
/
-- INSERT INTO tbl_author VALUES ('au91002','J.K. Rowling','J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series.',4.5, 'jkrowling.jpg, TO_DATE('31-JUL-1965', 'DD-MON-YYYY'));




INSERT INTO tbl_book (book_id, author_id, category_id, genre_ids, book_title, book_description, book_publish_date, book_price, discontinued, book_pages, book_discount, available_quantity, book_language, book_publisher, book_isbn, book_cover_image) VALUES ('bo00018', 'au00013', 'bc00003', type_genre_id_list('ge00001', 'ge00002','ge00003'), 'Equal Rites', 'Equal Rites is a comic fantasy novel by Terry Pratchett. Published in 1987, it is the third novel in the Discworld series and the first in which the main character is not Rincewind.', TO_DATE('1987-01-01', 'YYYY-MM-DD'), 105.00, 0, 288, 0, 100, 'English', 'Gollancz', '9780575070708', 'https://www.example.com/equal_rites.jpg');




INSERT INTO tbl_book (book_id, author_id, category_id, genre_ids, book_title, book_description, book_publish_date, book_price, discontinued, book_pages, book_discount, available_quantity, book_language, book_publisher, book_isbn, book_cover_image) VALUES ('bo16118', 'au00013', 'bc00003', type_genre_id_list('ge00001', 'ge00002','ge00003'), 'Equal Rites', 'Equal Rites is a comic fantasy novel by Terry Pratchett. Published in 1987, it is the third novel in the Discworld series and the first in which the main character is not Rincewind.', TO_DATE('1987-01-01', 'YYYY-MM-DD'), 105.00, 0, 288, 0, 100, 'English', 'Gollancz', '9780575070708', 'https://www.example.com/equal_rites.jpg');

-- DELETE BOOK WITH BOOKID = bo16118
DELETE FROM tbl_book WHERE book_id = 'bo16118';

SELECT * FROM tbl_book
WHERE book_id = 'bo16118';

select * from tbl_book;

select * from tbl_customer;