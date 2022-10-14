
numeric_int = 100
numeric_float = 23.5
numeric_complex = 25j
binary_bytes = b"Good morning"
binary_bytearray = (b'\x00\x00\x00\x45\xe3')
binary_memoryview = memoryview(bytes(34))
text_str = "Hello"
boolean_bool = True
set_set = set(["shoes", "shirts", "pants"])
set_frozenset = frozenset({"computer", "tablet", "smartphone"})
sequence_list = list(("cars","trains","bikes"))
sequence_tuple = tuple(["boats","planes","bicycles"])
sequence_dict = dict({"Make":"BMW","Model":"X20","Year":"2052"})
print(f"{numeric_int} is of type " + str(type(numeric_int)))
print(f"{numeric_float} is of type " + str(type(numeric_float)))
print(f"{numeric_complex} is of type " + str(type(numeric_complex)))
print(f"{binary_bytes} is of type " + str(type(binary_bytes)))
print(f"{binary_bytearray} is of type " + str(type(binary_bytearray)))
print(f"{binary_memoryview} is of type " + str(type(binary_memoryview)))
print(f"{text_str} is of type " + str(type(text_str)))
print(f"{boolean_bool} is of type " + str(type(boolean_bool)))
print(f"{set_set} is of type " + str(type(set_set)))
print(f"{set_frozenset} is of type " + str(type(set_frozenset)))
print(f"{sequence_list} is of type " + str(type(sequence_list)))
print(f"{sequence_tuple} is of type " + str(type(sequence_tuple)))
print(f"{sequence_dict} is of type " + str(type(sequence_dict)))

