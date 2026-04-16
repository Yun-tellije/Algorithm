-- 코드를 입력하세요
SELECT p.product_code, (p.price * SUM(sales_amount)) AS sales
FROM product AS p
JOIN offline_sale AS os
    ON p.product_id = os.product_id
GROUP BY p.product_code
ORDER BY sales DESC, product_code;