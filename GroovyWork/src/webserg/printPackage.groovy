package webserg

/**
 * Author: Sergiy Doroshenko
 * Date: Dec 25, 2009
 * Time: 11:07:41 PM
 */
def classes = [String, List, File]
for (clazz in classes){
  println clazz.'package'.name
}
println( [String, List, File].'package'.name )