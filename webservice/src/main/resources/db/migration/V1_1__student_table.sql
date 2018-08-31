CREATE TABLE student (
  id SERIAL,
  name VARCHAR NOT NULL,
  address_id INTEGER NOT NULL,
  FOREIGN KEY (address_id) REFERENCES address(id),
  PRIMARY KEY(id)
);
