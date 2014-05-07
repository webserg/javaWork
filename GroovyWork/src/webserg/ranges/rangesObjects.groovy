package webserg.ranges
result = ''
(5..9).each{ element ->
result += element
}
assert result == '56789'
assert (0..10).isCase(5)
age = 36
switch(age){
case 16..20 : insuranceRate = 0.05 ; break
case 21..50 : insuranceRate = 0.06 ; break
case 51..65 : insuranceRate = 0.07 ; break
default: throw new IllegalArgumentException()
}
assert insuranceRate == 0.06

ages = [20,36,42,56]
midage = 21..50
assert ages.grep(midage) == [36,42]//filtering
