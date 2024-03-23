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

select * from tbl_user_review;

select * from tbl_customer_address;


-- Create table for storing customer address information
CREATE TABLE tbl_customer_address (
    customer_address_id VARCHAR2(10) NOT NULL,
    address_type VARCHAR2(16) NOT NULL,
    customer_id VARCHAR2(10) NOT NULL, 
    address_line1 VARCHAR2(255),
    address_line2 VARCHAR2(255),
    address_line3 VARCHAR2(255),
    city VARCHAR2(100),
    state VARCHAR2(100),
    country VARCHAR2(100),
    postalcode VARCHAR2(6),
    landmark VARCHAR2(255),
    phone VARCHAR2(24), 
CONSTRAINT pk_customer_address 
    PRIMARY KEY (customer_address_id), 
CONSTRAINT ck_customer_address_id
    CHECK (REGEXP_LIKE(customer_address_id, 'ca[0-9]{5}')),
-- Create a unique constraint for (address_type, customer_id)
CONSTRAINT ck_address_type_customer_id
    UNIQUE (address_type, customer_id),
CONSTRAINT fk_customer_address_customer 
    FOREIGN KEY (customer_id) 
    REFERENCES tbl_customer(customer_id)
    ON DELETE CASCADE
)
/

INSERT INTO tbl_customer_address VALUES ('ca10001', 'Shipping', 'cu00001', '123 Main St', 'Apt 101', 'Building A', 'New York', 'NY', 'USA', '10001', 'Near Central Park', '123-456-7890');

-- UPDATE EVERYTHING IN THE ABOVE ca10001
UPDATE tbl_customer_address SET address_line1 = '654 Main St', address_line2 = 'Apt 101', address_line3 = 'Building A', city = 'New York', state = 'NY', country = 'USA', postalcode = '10001', landmark = 'Near Central Park', phone = '123-456-7890' WHERE customer_id = 'cu00001' AND address_type = 'Shipping';