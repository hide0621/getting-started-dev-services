-- このファイルは、quarkusアプリケーションが起動する際に自動的に実行される
-- このファイルには、データベースに初期データを投入するためのSQLを記述することができる
-- なおファイルパスは、src/main/resources配下に置く必要があり、
-- ファイル名は「import.sql」である必要がある

INSERT INTO Greeting(id, name)
VALUES (nextval('Greeting_SEQ'), 'Alice');
INSERT INTO Greeting(id, name)
VALUES (nextval('Greeting_SEQ'), 'Bob');


-- 上記に加えて、以下の行を追加してみた
INSERT INTO Greeting(id, name)
VALUES (nextval('Greeting_SEQ'), 'Charlie');