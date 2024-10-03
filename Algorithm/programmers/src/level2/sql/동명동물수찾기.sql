select NAME, count(ANIMAL_ID) as COUNT
from ANIMAL_INS
where NAME is not null
group by NAME
having COUNT > 1
order by NAME asc;