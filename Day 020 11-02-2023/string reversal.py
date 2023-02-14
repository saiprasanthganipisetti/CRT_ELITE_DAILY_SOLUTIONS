s = input()
ind = []
ans = []
for i in range(len(s)):
    if(s[i].isalpha() or s[i].isdigit()):
        ans.insert(0,s[i])
    else:
        ind.append(i)
for i in ind:
    ans.insert(i,s[i])
print("".join(ans))
