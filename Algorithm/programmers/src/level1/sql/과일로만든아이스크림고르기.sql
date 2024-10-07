select fh.FLAVOR
from FIRST_HALF fh
         join ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR
where fh.TOTAL_ORDER > 3000
  and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER desc;