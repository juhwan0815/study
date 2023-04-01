-- 코드를 입력하세요
select NAME, DATETIME
from (SELECT ANIMAL_ID, NAME, DATETIME
      from ANIMAL_INS
      order by ANIMAL_ID desc) as result
