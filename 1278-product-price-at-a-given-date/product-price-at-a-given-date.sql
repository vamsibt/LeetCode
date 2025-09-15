# Write your MySQL query statement below
SELECT p4.product_id, CASE WHEN p3.new_price IS NULL THEN 10 ELSE p3.new_price END AS price
FROM Products p4
LEFT JOIN(
    SELECT p1.*
    FROM Products p1
    JOIN(
        SELECT*, MAX(change_date) AS newDAY
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY (product_id)
    ) AS p2 ON p1.product_id = p2.product_id AND p1.change_date = p2.newDay
) AS p3 ON p4.product_id = p3.product_id
GROUP BY p4.product_id
