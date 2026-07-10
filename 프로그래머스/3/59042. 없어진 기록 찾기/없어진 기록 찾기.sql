select O.ANIMAL_ID, O.NAME
from ANIMAL_OUTS O
left join ANIMAL_INS I using (ANIMAL_ID)
where I.ANIMAL_ID is null
order by O.ANIMAL_ID;