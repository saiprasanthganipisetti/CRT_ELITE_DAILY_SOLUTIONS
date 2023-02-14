months = {'jan' : 1, 'feb' : 2, 'mar' : 3, 'apr' : 4, 'may' : 5, 'jun' : 6, 'jul' : 7, 'aug' : 8, 'sep' : 9, 'oct' : 10,             'nov' : 11, 'dec' : 12}

rev_months = {1 : 'Jan', 2 : 'Feb', 3 : 'Mar', 4 : 'Apr', 5 : 'May', 6 : 'Jun', 7 : 'Jul', 8 : 'Aug', 9 : 'Sep', 10: 'Oct', 11: 'Nov', 12: 'Dec'}

l = [x.split() for x in input().split(',')]


#converting months to numbers  eg: jun => 6, jan => 1
for date in l :
    date[1] = months[date[1].lower()]
   
"""converting the data format from dd mm yyyy to yyyy mm dd so that sorting in this format gives the ascending order of      dates"""
for i in range(len(l)):
    l[i] = l[i][::-1]
   
#sorting
l.sort()

#converting the date format back to dd mm yyyy
for i in range(len(l)):
    l[i] = l[i][::-1]
   
output = ""
   
for date in range(len(l)-1):
    output += l[date][0]+" "+rev_months[l[date][1]]+" "+l[date][2] + ", "

output += l[-1][0]+" "+rev_months[l[-1][1]]+" "+l[-1][2]

print(output)
