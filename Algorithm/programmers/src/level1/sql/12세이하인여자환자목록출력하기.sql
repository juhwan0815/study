select PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO
from PATIENT
where AGE <= 12
  and GEND_CD = 'W'
order by AGE desc, PT_NAME asc;
