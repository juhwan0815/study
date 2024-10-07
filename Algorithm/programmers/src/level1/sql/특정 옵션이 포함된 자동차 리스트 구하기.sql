select CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like '%네비게이션%'
order by CAR_ID desc;
