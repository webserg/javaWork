package webserg
def customers = new XmlSlurper().parse(new File('customer.xml'))
for (customer in customers.corporate.customer){
  println "${customer.@name} works for ${customer.@company}"
}
