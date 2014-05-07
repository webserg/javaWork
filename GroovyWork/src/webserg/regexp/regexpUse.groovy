package webserg.regexp
twister = 'she sells sea shells at the sea shore of seychelles'
// twister must contain a substring of size 3
// that starts with s and ends with a
assert twister =~ /s.a/
finder = (twister =~ /s.a/)
assert finder instanceof java.util.regex.Matcher
finder.each{
  match -> println match
}

matcher = 'a b c' =~ /\S/
assert matcher[0] == 'a'
assert matcher[1..2] == 'bc'
assert matcher.count == 3

matcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/
assert matcher.hasGroup()
assert matcher[0] == ['a:1', 'a', '1']

('xy' =~ /(.)(.)/).each { all, x, y ->
assert all == 'xy'
assert x == 'x'
assert y == 'y'
}

assert (~/..../).isCase('bear')  //equivalent full match of that pattern
switch('bear'){
case ~/..../ : assert true; break
default : assert false
}
beasts = ['bear','wolf','tiger','regex']
assert beasts.grep(~/..../) == ['bear','wolf']
//============================================================================================
// twister must contain only words delimited by single spaces
assert twister ==~ /(\w+ \w+)*/
WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)
assert matches instanceof java.lang.Boolean
assert (twister ==~ /s.e/) == false
wordsByX = twister.replaceAll(WORD, 'x')
assert wordsByX == 'x x x x x x x x x x'
words = twister.split(/ /)
assert words.size() == 10
assert words[0] == 'she'