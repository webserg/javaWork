package webserg.regexp

twister = 'she sells sea shells at the sea shore of seychelles'
// some more complicated regex:
// word that starts and ends with same letter
regex = /\b(\w)\w*\1\b/
start = System.currentTimeMillis()
100000.times {
    twister =~ regex
}
first = System.currentTimeMillis() - start
start = System.currentTimeMillis()
pattern = ~regex   //transforms to util.regex.Pattern
100000.times {
    pattern.matcher(twister)
}
second = System.currentTimeMillis() - start
assert first > second * 1.20   //The precompiled pattern version is at least 20% faster