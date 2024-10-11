select ugb.TITLE, ugb.BOARD_ID, ugr.REPLY_ID, ugr.WRITER_ID, ugr.CONTENTS, DATE_FORMAT(ugr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD ugb
         join USED_GOODS_REPLY ugr on ugb.BOARD_ID = ugr.BOARD_ID
where YEAR(ugb.CREATED_DATE) = '2022' and MONTH(ugb.CREATED_DATE) = '10'
order by ugr.CREATED_DATE asc, ugb.TITLE asc
