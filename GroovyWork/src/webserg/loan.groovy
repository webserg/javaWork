package webserg

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 12, 2010
 * Time: 4:09:41 PM
 */

a = 100
p = 20
n = 12
s = 1000
//s =  a*(1-(n/(1+p))) / p
a1 = (s * p) / (1-( n/(1+p) ))
//a2 = s * p / (1 - (1/(1+p)) ** n )
//a1 =  3 ** -12 
println(a1)