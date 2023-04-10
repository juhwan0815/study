-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where NAME like "%EL%"
and ANIMAL_TYPE = 'DOG'
order by NAME asc;