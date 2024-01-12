-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(date_of_birth, 'YYYY-MM-DD') AS date_of_birth
FROM MEMBER_PROFILE
WHERE TO_CHAR(date_of_birth,'MM') = '03' 
      AND GENDER = 'W'
      and TLNO IS NOT NULL
ORDER BY MEMBER_ID ASC;