select ID, LENGTH
from FISH_INFO
where LENGTH is not null
order by LENGTH desc, ID asc
    limit 10;