__author__ = 'webserg'
dict = {'key': 'value', 'server': 'db.diveintopython3.org', 'database': 'mysql'}
print(dict['server'])
a_dict = {"k": "v"}
a_dict["k2"] = "v2"
a_dict["k3"] = ['1', 2, '3']
print(a_dict)
print(a_dict["k3"][2])
a_dict["k3"] = [elem * 2 for elem in a_dict["k3"]]
print(a_dict["k3"])
dict.setdefault('epmty')
print(dict['unexisted'])
