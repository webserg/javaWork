package webserg

/**
 * Author: Sergiy Doroshenko
 * Date: Dec 25, 2009
 * Time: 10:36:31 PM
 */
def number=0
new File ('../hello.groovy').eachLine { line ->
number++
println "$number: $line"
}