IF EXISTS (SELECT name FROM sysobjects
    WHERE name = 'setStudentInfo')
DROP PROCEDURE setStudentInfo
GO
USE master
GO
CREATE PROCEDURE setStudentInfo
    @lastName nchar(55),
    @firstName nchar(55),
	@startDate nchar(55),
	@endDate nchar(55),
	@projectName nchar(70),
	@creativity int,
	@action int,
	@service int,
	@objective nchar(80),
	@hours nchar(20),
	@reflection nchar(1000),
	@studentID nchar(10)
AS
INSERT INTO dbo.CASTable
VALUES (    
	@lastName,
    @firstName,
	@startDate,
	@endDate,
	@projectName,
	@creativity,
	@action,
	@service,
	@objective,
	@hours,
	@reflection,
	@studentID)
GO