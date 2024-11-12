select ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d')
from ANIMAL_INS
order by ANIMAL_ID asc