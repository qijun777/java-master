# try:
#     a = 10
#     b = int(input("请输入整数："))
#     c = a / b
#     print(c)
# except (BaseException) as e:
#     print(e)
# else:
#     print('没有发生异常')
# finally:
#     print('都会执行')


# a = u'中国'
# print(a)
# print(type(a))
# c = a.encode('utf-8')
# print(type(a.encode('gbk')))
#
# print(type(c.decode()))
#
# print(type(a.encode('utf-8'))ddd)


import numpy as np

# array = np.array([[1, 2, 3], [4, 5, 6]])
np1 = np.array([2, 3])


# print(type(array))
# print(array)
# print(type([[1, 2, 3], [4, 5, 6]]))
# print(np1)


# array2 = np.array(['1', '2', '3', '4'])
# print(array2)
# print(array2.astype('int'))
# print(array.shape)

# array3 = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
# print(array3)
# print('=====================1')
# print(array3[1:, 1:])
# print('=====================2')
# print(array3[(0, 2), (2, 1)])
# print('=====================3')
# print(array3[::-1, ::-1])
# print('=====================4')
# print(array3.T)  # 转置
# print('=====================5')
# print(array3[array3 > 5])  # 取出所有大于5的数
# print('=====================6')
# print(array3 + 1)  # 所有数加1
# print('=====================7')
# print(array3 * 10)


# 对位运算
# array4 = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
# array5 = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
# print(array4 + array5)
# print('------------------1')
# print(array4 - array5)
# print('------------------2')
# print(array4 * array5)
# print('------------------3')
# print(array4 / array5)

# lines = []
# with open(r'E:\bigdata\iteaworkspace\python\data\score.txt', 'r') as file:
#     lines = file.readlines()
# course = [tuple(line.strip().split(',')) for line in lines]
# # print(course)
# # print(type(course))
#
# adtype = [('id', int), ('course', int), ('score', int)]
# np_course = np.array(course, dtype=adtype)
# print(np_course)
# print('================1')
# print(np_course['id'])
# print('================2')
# print(np_course['id'] == 1500100001)
# print('================3')
# print(np_course[np_course['id'] == 1500100001])
# print('================4')
# print(np_course['id'][::-1])

# array6 = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
# print(np.log(array6))
# print('--------------------1')
# print(np.sin(array6))
# print('--------------------2')
# print(np.cos(array6))
# print('--------------------3')
# # 计算差分
# print(np.diff(array6, axis=1))  # 从左到右
# print('--------------------4')
# print(np.diff(array6, axis=0))  # 从下到上
# print('--------------------5')
# print(np.std(array6))  # 计算标准差
# print('--------------------6')
# print(np.var(array6, axis=0))  # 方差

# r1 = np.random.rand(3, 4)
# print(r1)

# print(np.random.randint(0, 10))  # 随机产生0-10的整数


# names = np.array(['Bob','Will','Bob','Joe'])
# data = np.array([[-3, 2, 0, -1], [1, 2, 3, -4],[2.5, 1.7, -0.2, 1], [-8, -4, 9, 10]])
# print(data)
# print('====================')
# print(data[names == 'Bob', :3:2])


# def function1():
#     def function2(x):
#         print(x, end=' ')
#         print('总体来说')
#
#     return function2
#
#
# function1()('斐然')

# 函数简写
# lambda1 = lambda i: i ** i
# print(lambda1(3))

# def function3(fun):
#     list1 = [1, 2, 3, 4, 5]
#     return fun(list1)
#
#
# print(function3(lambda list1: list1[::-1]))
