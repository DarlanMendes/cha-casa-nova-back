 CREATE EXTENSION IF NOT EXISTS "pgcrypto";

 CREATE TABLE gift (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     img_link VARCHAR(1000) NOT NULL,
     title VARCHAR(255),
     description TEXT,
     example_link VARCHAR(1000) NOT NULL
 );
