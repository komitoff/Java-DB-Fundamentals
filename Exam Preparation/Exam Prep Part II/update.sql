#3 - UPDATE
SELECT m.sent_on, c.start_date
FROM chats AS c
INNER JOIN messages AS m
ON m.chat_id=c.id
WHERE m.sent_on < c.start_date
ORDER BY c.start_date;