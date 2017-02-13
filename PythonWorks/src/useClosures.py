import re
def plural(noun):
    if re.search('[sxz]$', noun):
        return re.sub('$', 'es', noun) 
    elif re.search('[^aeioudgkprt]h$', noun):
        return re.sub('$', 'es', noun)
    elif re.search('[^aeiou]y$', noun):
        return re.sub('y$', 'ies', noun)
    else:
        return noun + 's'

print(plural("eye"))
print(plural("horse"))

def match_sxz(noun):
    return re.search('[sxz]$', noun)
def apply_sxz(noun):
    return re.sub('$', 'es', noun)
def match_h(noun):
    return re.search('[^aeioudgkprt]h$', noun)
def apply_h(noun):
    return re.sub('$', 'es', noun)
def match_y(noun): 
    return re.search('[^aeiou]y$', noun)
def apply_y(noun): 
    return re.sub('y$', 'ies', noun)
def match_default(noun):
    return True
def apply_default(noun):
    return noun + 's'

rules = ((match_sxz, apply_sxz), 
(match_h, apply_h),
(match_y, apply_y),
(match_default, apply_default)
)

def plural2(noun):
    for matches_rule, apply_rule in rules:
        if matches_rule(noun):
            return apply_rule(noun)


print(plural2("pig"))

