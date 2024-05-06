import copy
N=int(input())
arr = [list(map(str,input())) for _ in range(N)]
diy=[0,0,1,-1]
dix=[1,-1,0,0]

maxi=1
def bfs(bayeol,sty,stx):
    global maxi
    cnt1=1
    cnt2=1
    for m in range(1,N):
        if 0<=sty+m<N and bayeol[sty+m][stx]==bayeol[sty][stx]:
            cnt1+=1
        else:
            break
    for m in range(1,N):
        if 0<=stx+m<N and bayeol[sty][stx+m]==bayeol[sty][stx]:
            cnt2+=1
        else:
            break
    for m in range(1,N):
        if 0<=sty-m<N and bayeol[sty-m][stx]==bayeol[sty][stx]:
            cnt1+=1
        else:
            break
    for m in range(1,N):
        if 0<=stx-m<N and bayeol[sty][stx-m]==bayeol[sty][stx]:
            cnt2+=1
        else:
            break
    if cnt1>maxi:
        maxi = cnt1
    if cnt2>maxi:
        maxi = cnt2

for i in range(N):
    for j in range(N):
        for k in range(4):
            dy = diy[k]+i
            dx = dix[k]+j
            if dy<0 or dx<0 or dy>=N or dx>=N:
                continue
            if arr[dy][dx]==arr[i][j]:
                continue
            lst = copy.deepcopy(arr)
            lst[dy][dx],lst[i][j]=lst[i][j],lst[dy][dx]
            for z in range(N):
                for q in range(N):
                    bfs(lst,z,q)
            
bfs(arr,0,0)
print(maxi)