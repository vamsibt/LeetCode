# Write your MySQL query statement below
SELECT s.student_id, s.student_name,s2.subject_name, Count(E.student_id) as attended_exams
FROM Students s
CROSS JOIN Subjects s2
LEFT JOIN Examinations E
ON s.student_id = E.student_id AND s2.subject_name = E.subject_name
GROUP BY s.student_id, s.student_name, s2.subject_name
ORDER BY s.student_id, s2.subject_name;
