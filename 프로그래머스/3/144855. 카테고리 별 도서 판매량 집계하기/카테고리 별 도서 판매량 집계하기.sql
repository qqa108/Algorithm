-- 코드를 입력하세요
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK_SALES S JOIN BOOK B
ON S.BOOK_ID = B.BOOK_ID
WHERE S.SALES_DATE LIKE "%2022-01%"
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;