-- 코드를 입력하세요
SELECT c.car_id
FROM car_rental_company_car AS c
JOIN car_rental_company_rental_history AS r
    ON c.car_id = r.car_id
WHERE c.car_type = '세단'
    AND MONTH(r.start_date) >= 10
GROUP BY c.car_id
ORDER BY car_id DESC;