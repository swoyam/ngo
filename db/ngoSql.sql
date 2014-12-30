-- Created by Vertabelo (http://vertabelo.com)
-- Script type: create
-- Scope: [tables, references, sequences, views, procedures]
-- Generated at Fri Dec 26 07:47:46 UTC 2014



-- tables
-- Table: "Users"
CREATE TABLE IF NOT EXISTS "Users" (
    "user_id" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,
    "username" varchar(255) NOT NULL,
    "license_key" varchar(255) NOT NULL,
    "start_date" datetime NOT NULL,
    "end_date" datetime NOT NULL,
    "license_type" varchar(200) NOT NULL
);

-- Table: "answers"
CREATE TABLE IF NOT EXISTS "answers" (
    "ans_id" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,
    "answer" text,
    "questions_q_id" integer NOT NULL,
    "organization_office_id" integer NOT NULL,
    FOREIGN KEY ("questions_q_id") REFERENCES "questions" ("q_id"),
    FOREIGN KEY ("organization_office_id") REFERENCES "organization" ("office_id")
);

-- Table: "organization"
CREATE TABLE IF NOT EXISTS "organization" (
    "office_id" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,
    "office_name" text NOT NULL,
    "address" text,
    "website" varchar(200),
    "email" varchar(200),
    "telephone_no" varchar(50) NOT NULL,
    "mobile_number" varchar(50),
    "chair_person" varchar(255) NOT NULL,
    "head_of_org" varchar(255) NOT NULL,
    "sector_sector_id" integer NOT NULL,
    FOREIGN KEY ("sector_sector_id") REFERENCES "sector" ("sector_id")
);

-- Table: "questions"
CREATE TABLE IF NOT EXISTS "questions" (
    "q_id" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,
    "question" text NOT NULL
);

-- Table: "sector"
CREATE TABLE IF NOT EXISTS "sector" (
    "sector_id" integer NOT NULL  PRIMARY KEY AUTOINCREMENT,
    "sector_name" varchar(400) NOT NULL,
    "sector_desc" text
);





-- End of file.
