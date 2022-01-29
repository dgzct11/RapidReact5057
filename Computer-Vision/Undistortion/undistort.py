xc = 650.8270
yc = 426.4030
xd = 0
yd = 0
K2 = -0.4421
K1 = 0.1789
r = ((xd - xc)**2 + (yd - yc)**2)**0.5
xu = xc + (xd - xc)/(1 + K1*(r)**2 + K2*(r)**4)
yu = yc + (yd - yc)/(1 + K1*(r)**2 + K2*(r)**4)
print(xu)
print(yu)