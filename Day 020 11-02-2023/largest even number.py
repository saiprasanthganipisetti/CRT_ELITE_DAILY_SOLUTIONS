s = input()
l = set()
for i in s:
    if i.isdigit():
        l.add(i)
       
ans = sorted(list(l),reverse = True)

if int(ans[-1])%2 == 0:
    print("".join(ans))
else:
    i = len(ans)-2
    flag = 0
    while(int(ans[-1]) % 2 != 0 and i >= 0):
        if(int(ans[i]) %2 == 0):
            temp = ans[i]
            ans[i] = ans[-1]
            ans[-1] = temp
            ans[:len(ans)-1] = sorted(ans[:len(ans)-1],reverse = True)
            print("".join(ans))
            flag = 1
            break
        i -= 1
    if flag == 0:
        print(-1)
