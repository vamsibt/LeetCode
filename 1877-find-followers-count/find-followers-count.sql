# Write your MySQL query statement below
SELECT DISTINCT f1.user_id, f2.cnt AS followers_count
FROM Followers f1
LEFT JOIN(
    SELECT user_id, COUNT(follower_id) AS cnt
    FROM Followers
    GROUP BY user_id
 ) AS f2
ON f1.user_id = f2.user_id
ORDER BY f1.user_id;