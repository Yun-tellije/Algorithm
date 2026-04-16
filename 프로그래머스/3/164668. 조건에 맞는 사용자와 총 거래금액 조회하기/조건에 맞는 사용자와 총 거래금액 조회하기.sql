-- 코드를 입력하세요
SELECT ugu.user_id, ugu.nickname, SUM(ugb.price) AS total_sales
FROM used_goods_board AS ugb
JOIN used_goods_user AS ugu
    ON ugb.writer_id = ugu.user_id
WHERE ugb.status = 'DONE'
GROUP BY ugu.user_id
HAVING SUM(ugb.price) >= 700000
ORDER BY total_sales;