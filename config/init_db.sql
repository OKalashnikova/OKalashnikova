CREATE TABLE contact
(
  id INTEGER DEFAULT nextval('contact_id_seq'::regclass) PRIMARY KEY NOT NULL,
  type TEXT NOT NULL,
  value TEXT NOT NULL,
  resume_uuid CHAR(36) NOT NULL,
  CONSTRAINT contact_resume_uuid_fk FOREIGN KEY (resume_uuid) REFERENCES resume (uuid) ON DELETE CASCADE
);
CREATE TABLE resume
(
  uuid CHAR(36) PRIMARY KEY NOT NULL,
  full_name TEXT
);