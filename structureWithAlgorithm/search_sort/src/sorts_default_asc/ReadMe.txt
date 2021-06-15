
* nghịch thế : 1 nghịch thế có nghĩa là 
 i < j 
 a[i] > a[j]
 đó là 1 nghịch thế 
 1 mảng đã sort thì sẽ không tồn tại nghịch thế
 
 
Các sort thông dụng 

-----------Các thuận toán với độ phức tạp tỉ lệ thuận với  n^2   bằng với 2 vòng lặp for----------------
Selection Sort : chọn trực tiếp tìm min đưa về đầu
Insertion Sort : chèn trực tiếp , cứ chèn x cho đúng vị trí xong đẩy các vị trí lên 
Interchange Sort: đổi chỗ trực tiếp , cứ thấy nghịch thế thì dùng swap đổi chỗ giá trị liền

Bubble Sort: nổi bọt, xét các phần tử kến cận nhau xong cứ thế đưa thằng nhỏ hơn về đầu hoặc cuối tùy asc hoặc desc
Shaker Sort: phiên bản cải tiến của Bubble sort , đưa cả nhỏ hơn về đầu và đưa lớn hơn về cuối cùng 1 lúc khác vs Bubble sort đưa thằng nhỏ
về đầu rất nhanh đưa lớn về sau rất chậm

-----------Các thuận toán tỉ lện với   bằng với   ----------------

HeapSort: cải tiến của chọn trực tiếp , như sử dụng lại được các kết quả so sánh trước. -- độ phức tạp nlog2(n)
Shell Sort: cải tiến của chèn trực tiếp, sử dụng h khoảng cách và k số bước để sort --- độ phức tạp n^x với 1 < x < 2

-----------Các thuận toán chia để trị có cùng độ phức tạp nlog2(n)  ----------------

QuickSort: phân hoặc dãy để sort đổi chỗ các ngịch thế  --- nhanh nhất nhanh hơn so với nhóm có cùng độ phức tạp nlog2(n) là HeapSort và mergeSort
MergeSort: săp xếp các dẫy con từ rồi dùng merge trong lúc merge thì sort luôn chúng với nhau

Radix Sort: Sort theo phân loại sort từ hàng đơn vị -> chuc trăm -> hàng nghàn ,... 
