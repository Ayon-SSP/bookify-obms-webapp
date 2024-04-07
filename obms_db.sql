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


select * from tbl_book;


-- -------------------------------------------


-- Create a nested table type for storing genre ids
CREATE OR REPLACE
    TYPE type_genre_id_list AS TABLE OF VARCHAR2(10)
/

-- Create table for storing book information
CREATE TABLE tbl_book
(
    book_id VARCHAR2(10) NOT NULL,
    author_id VARCHAR2(10) NOT NULL,
    category_id VARCHAR2(10) NOT NULL,
    genre_ids type_genre_id_list,
    book_title VARCHAR2(100) NOT NULL,
    book_description VARCHAR2(1000),
    book_publish_date DATE,
    book_price NUMBER,
    discontinued NUMBER DEFAULT 0 NOT NULL,
    book_pages NUMBER,
    book_discount NUMBER DEFAULT 0,
    available_quantity NUMBER,
    book_language VARCHAR2(100),
    book_publisher VARCHAR2(100),
    book_isbn VARCHAR2(13),
    book_cover_image VARCHAR2(255),
CONSTRAINT pk_book
    PRIMARY KEY (book_id),
CONSTRAINT ck_book_id
    CHECK (REGEXP_LIKE(book_id, 'bo[0-9]{5}')),
CONSTRAINT ck_book_book_price   CHECK ((book_price > 0)),
CONSTRAINT ck_discontinued   CHECK ((discontinued = 0 or discontinued = 1)),
CONSTRAINT ck_book_pages   CHECK ((book_pages >= 0)),
CONSTRAINT ck_book_discount   CHECK ((book_discount >= 0 AND book_discount <= 1)),
CONSTRAINT ck_available_quantity   CHECK ((available_quantity >= 0)),
CONSTRAINT fk_book_author 
    FOREIGN KEY (author_id) 
    REFERENCES tbl_author(author_id)
    ON DELETE CASCADE,
CONSTRAINT fk_book_category 
    FOREIGN KEY (category_id) 
    REFERENCES tbl_book_category(category_id)
    ON DELETE CASCADE
) NESTED TABLE genre_ids STORE AS genre_ids_table
/

-- display all the books with genre_id = ge00001
SELECT * FROM tbl_book
WHERE genre_ids IS NOT EMPTY 
    AND (
        SELECT * 
        FROM TABLE(genre_ids) 
        WHERE COLUMN_VALUE = 'ge00001') IS NOT NULL;

select * from TBL_SHOPPING_CART
where customer_id = 'cu00001' AND book_id = 'bo00001';

DELETE FROM TBL_SHOPPING_CART
WHERE customer_id = 'cu00001' AND book_id = 'bo00001';


select * from TBL_WISHLIST where CUSTOMER_WISHLIST_ID = 'wi00008';
select * from TBL_WISHLIST_ITEM where customer_id = 'cu00001' and CUSTOMER_WISHLIST_ID = 'wi00008';


select * from TBL_ORDERS;
select * from TBL_ORDER_DETAIL;