package webserg.sql

/**
 * Author: Sergiy Doroshenko
 * Date: Dec 24, 2009
 * Time: 10:20:33 PM
 */
import groovy.sql.Sql
sql = Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl", "cfp_static_feeds","cfp_static_feeds", "oracle.jdbc.driver.OracleDriver")
//sql.execute('create table TableA (FirstName varchar(40),&nbsp; LastName varchar(40))')
//sql.execute('INSERT INTO TableA (FirstName,LastName) values (?,?)',['Stan','Juka'])


sql.eachRow('select * FROM forvaltere') {
  println "TableA row: ${it.id}, ${it.navn}"
}
