-- 코드를 입력하세요
SELECT count(*)
from USER_INFO
where JOINED between '2021-01-01' and '2021-12-31'
  and  AGE between 20 and 29;