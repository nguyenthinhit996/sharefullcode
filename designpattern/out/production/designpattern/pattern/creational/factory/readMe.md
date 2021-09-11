
factory patter là một trong những kiểu phổ biến sử dụng trong java. thuộc kiểu creational pattern
là một trong những cách tốt nhất để khởi tạo đối tượng, khởi tạo đối tượng mà không biểu thị cho
client biết cách hoạt động như thế nào thông qua interface.

có 2 kiểu :
fucntion factory hàm tạo ra new object.
astract factory là factory của factory.

ví dụ trong demo fucntion factory
một nhà máy sản xuất phương tiên giao thông trên bờ sản xuất ra xe máy, xe hơi, xe đạp
thì đựa vào function 1 type xe nào đó, thì nó sẽ sản xuất 1 chiếc xe có kiểu tương ứng.

ví dụ trong demo astract factory.
công ty ở ví dụ 1 đã rất thành công nên giờ muốn mở rộng ra thêm ở thêm 1 mô hình 
sản xuất thêm phương tiện chạy dưới nước (tàu , du thuyền, motonuoc).
như vậy công ty có 2 nhanh sản xuất 1 là về phương tiện trên bờ, và phương tiện ở dưới nước.
