package webserg.sql

/**
 * Author: Sergiy Doroshenko
 * Date: Jan 27, 2010
 * Time: 5:38:22 PM
 */
jobId = "QU_OPER"
jobTitle = "Quarry Operator"
minSalary = 1
maxSalary = 5
import groovy.sql.Sql
sql = Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr",
                      "oracle.jdbc.pool.OracleDataSource")
sql.execute(
   """INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
   VALUES(${jobId}, ${jobTitle}, ${minSalary}, ${maxSalary})""")
