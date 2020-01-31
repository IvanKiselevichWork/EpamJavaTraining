-- register user
INSERT INTO user(login, hash) values(?, ?)

-- sign in user
SELECT idUser, login, hash FROM user WHERE login=? AND hash=?

-- add record
INSERT INTO record(userId, cause, date, amount) values(?, ?, ?, ?)

-- remove record
DELETE FROM record WHERE idRecord=?

-- get records by userId
SELECT idRecord, userId, cause, date, amount FROM record WHERE userId=?