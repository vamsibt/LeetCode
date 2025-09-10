# Write your MySQL query statement below
SELECT MAX(n1.num) as num
FROM MyNumbers n1
JOIN(
    SELECT num, COUNT(num) as cnt
    FROM MyNumbers
    GROUP BY num
) AS n2
ON n1.num = n2.num AND cnt = 1

