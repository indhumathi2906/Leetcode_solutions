# Write your MySQL query statement below
select
DATE_FORMAT(trans_date,'%Y-%m') AS month,
country,
count(*) as trans_count,
sum(amount) as trans_total_amount,
sum(state='approved') as approved_count,
sum(case when state='approved' then amount else 0 END) as
approved_total_amount
from transactions
group by
DATE_FORMAT(Trans_date,'%Y-%m'),
country;