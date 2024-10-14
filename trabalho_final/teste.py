def add(x: float, y: float) -> float:
    return (x + y)

def sub(x: float, y: float) -> float:
    return (x - y)

def div(x: float, y: float) -> float:
    return (x / y)

def mult(x: float, y: float) -> float:
    return (x * y)

a: float
b: float
a = 10.5
b = 20.3
b = add(a, b)
print(b)
b = sub(a, b)
print(b)
b = div(a, b)
print(b)
b = mult(a, b)
print(b)