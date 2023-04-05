-- 코드를 입력하세요
select count(*)
from (select Name, count(*)
      from ANIMAL_INS
      where Name is not null
      group by Name) r;