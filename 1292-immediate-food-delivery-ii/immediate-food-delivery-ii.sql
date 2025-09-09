# Write your MySQL query statement below


SELECT
    ROUND(
        SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END)*100/COUNT(*)
        ,
        2
    ) AS immediate_percentage
  
FROM
  Delivery d1
INNER JOIN (
  SELECT
    customer_id,
    MIN(order_date) AS most_recent_order
  FROM
    Delivery
  GROUP BY
    customer_id
) AS d2 ON d1.customer_id = d2.customer_id AND d1.order_date = d2.most_recent_order
ORDER BY
  d1.customer_id