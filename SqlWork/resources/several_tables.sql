SELECT first.cname, second.cname, first.rating FROM Customers first, Customers second
WHERE first.rating = second.rating
AND first.cname < second.cname;