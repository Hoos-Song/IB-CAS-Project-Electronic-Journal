USE master
IF EXISTS (SELECT name FROM sysobjects
    WHERE name = 'setStudentID')
DROP PROCEDURE setStudentID
GO
USE master
GO
CREATE PROCEDURE setStudentID
    @lastName nchar(55),
    @firstName nchar(55),
	@ID nchar(20),
	@password nchar(10)
AS
INSERT INTO dbo.CASpasswordID
VALUES (    
	@lastName,
    @firstName,
	@ID,
	@password)
GO

