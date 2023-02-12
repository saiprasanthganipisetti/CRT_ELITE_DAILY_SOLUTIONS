length = int(input())
s = input()
q = int(input())
for i in range(q):
    p = int(input())
    print(s[:p-1].count(s[p-1]))
