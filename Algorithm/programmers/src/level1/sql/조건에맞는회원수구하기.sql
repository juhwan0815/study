select count(*) as USERS
from USER_INFO
where JOINED between '2021-01-01' and '2021-12-31'
  and age between 20 and 29