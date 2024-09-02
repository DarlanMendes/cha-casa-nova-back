UPDATE TABLE gift (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     img_link VARCHAR(1000) NOT NULL,
     title VARCHAR(500),
     description VARCHAR(1000),
     example_link VARCHAR(1000) NOT NULL,
     presenter VARCHAR(500),
     phone VARCHAR(500) UNIQUE
 );

