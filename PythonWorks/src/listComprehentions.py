years_of_birth = [1990, 1991, 1990, 1990, 1992, 1991]
ages = []
for year in years_of_birth:
    ages.append(2014 - year)
print(ages)
years_of_birth = [1990, 1991, 1990, 1990, 1992, 1991]
ages = [2014 - year for year in years_of_birth]
print(ages)
a = [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
print(a)
even = [item for item in a if item % 2 == 0]
print(even)
