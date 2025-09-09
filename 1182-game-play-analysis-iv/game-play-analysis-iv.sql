# Write your MySQL query statement below
SELECT ROUND(COUNT(DISTINCT a1.player_id) /(SELECT COUNT(DISTINCT player_id) FROM Activity),2) as fraction
FROM Activity AS a1
JOIN(
    SELECT player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) AS next_date
    FROM Activity
    GROUP BY player_id
) as a2
ON a1.player_id = a2.player_id AND a1.event_date = a2.next_date

