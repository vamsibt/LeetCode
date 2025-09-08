# Write your MySQL query statement below

-- SELECT r.contest_id, ROUND(COUNT(DISTINCT r.user_id)*100/(SELECT Count(DISTINCT user_name) FROM Users),2) AS percentage
-- FROM Register r, Users u
-- WHERE u.user_id = r.user_id
-- GROUP BY r.contest_id
-- ORDER BY percentage DESC,
--  r.contest_id ASC;

SELECT 
    r.contest_id,
    ROUND(COUNT(DISTINCT r.user_id) * 100.0 / (SELECT COUNT(*) FROM Users), 2) AS percentage
FROM Register r
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id ASC;
