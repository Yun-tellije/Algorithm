-- 코드를 입력하세요
SELECT i.animal_id, i.name
FROM animal_ins AS i
LEFT JOIN animal_outs AS o
    ON i.animal_id = o.animal_id
WHERE o.name IS NOT NULL
ORDER BY o.datetime - i.datetime DESC
LIMIT 2;