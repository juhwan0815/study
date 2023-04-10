-- 코드를 입력하세요
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') as NAME, SEX_UPON_INTAKE
from (
         select ANIMAL_ID, ANIMAL_TYPE, NAME, SEX_UPON_INTAKE
         from ANIMAL_INS
         order by ANIMAL_ID asc
     ) r;

