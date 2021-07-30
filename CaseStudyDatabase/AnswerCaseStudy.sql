SELECT * FROM quan_ly_khu_nghi_duong_furama.nhanvien;
/*
2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có 
tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
và có tối đa 15 ký tự.
*/

select *
from nhanvien
where (HoTen like 'H%' or HoTen like 'T%' or HoTen like 'K%' ) and char_length(HoTen)<15;

-- cau 3 :3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from khachhang
where ((year(now())-year(NgaySinh))>17 and (year(now())-year(NgaySinh)) <51) and (DiaChi='Đà nẵng' or DiaChi ='Quảng trị');

/* 
4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
 Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/
select khachhang.IDKhachHang ,count(hopdong.IDKhachHang)
from hopdong
inner join khachhang on hopdong.IDKhachHang = khachhang.IDKhachHang
where khachhang.IDLoaiKhach=(
								select IDLoaiKhach
								from loaikhach
								where TenLoaiKhach='Diamond')
group by IDKhachHang 
order by count(IDKhachHang) ;

/*
5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong 
và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. 
(Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/

select hd1.IDKhachHang,HoTen,lk.TenLoaiKhach,hd1.IDHopDong,hd1.TenDichVu,hd1.NgayLamHopDong,hd1.NgayKetThuc,hd1.TongTien
from khachhang as kh
inner join loaikhach as lk on lk.IDLoaiKhach=kh.IDLoaiKhach
left join (select hd.IDKhachHang, a.IDHopDong,dv.TenDichVu,NgayLamHopDong,NgayKetThuc,(dv.ChiPhiThue+a.tong) as TongTien
			from  hopdong as hd
			inner join dichvu as dv 
			on dv.IDDichVu =hd.IDDichVu
			inner join (select SoLuong*dvdk.gia as tong ,IDHopDong
						from hopdongchitiet as hdct
						inner join dichvudikem as dvdk on dvdk.IDDichVuDiKem = hdct.IDDichVuDiKem) as a
						on hd.IDHopDong =a.IDHopDong) as hd1
				on hd1.IDKhachHang=kh.IDKhachHang ;
                

select khachhang.IDKhachHang,khachhang.HoTen,loaikhach.TenLoaiKhach,hopdong.IDHopDong,dichvu.TenDichVu,hopdong.NgayLamHopDong,hopdong.NgayKetThuc, 
sum(dichvu.ChiPhiThue +(hopdongchitiet.SoLuong*dichvudikem.gia)) as TongTien
from khachhang
inner join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach
left join hopdong on hopdong.IDKhachHang = khachhang.IDKhachHang
left join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
left join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
left join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
group by hopdong.IDHopDong;
/*
6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của 
tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
*/
select dichvu.IDDichVu,dichvu.TenDichVu,dichvu.DienTich,dichvu.ChiPhiThue,loaidichvu.TenLoaiDichVu
from dichvu
inner join loaidichvu on dichvu.IDLoaiDichVu = loaidichvu.IDLoaiDichVu
inner join hopdong on dichvu.IDDichVu = hopdong.IDDichVu
where dichvu.IDLoaiDichVu NOT IN (select dichvu.IDLoaiDichVu
							from hopdong
                            inner join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
                            where month(NgayLamHopDong)>=1 and month(NgayLamHopDong)<=3 and year(NgayLamHopDong)=2019);
                            
/* 
7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của 
tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
*/

select dichvu.IDDichVu,dichvu.TenDichVu,dichvu.DienTich,dichvu.SoNguoiToiDa,dichvu.ChiPhiThue,loaidichvu.TenLoaiDichVu,loaidichvu.IDLoaiDichVu
from dichvu
inner join loaidichvu on dichvu.IDLoaiDichVu = loaidichvu.IDLoaiDichVu
inner join hopdong on dichvu.IDDichVu = hopdong.IDDichVu 
where  year(hopdong.NgayLamHopDong)=2018 and dichvu.IDLoaiDichVu NOT IN (select dichvu.IDLoaiDichVu
																			from hopdong
																			inner join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
																			where  year(NgayLamHopDong)=2019);

/*
8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
*/
-- cach 1
select  distinct HoTen
from khachhang;
-- cach 2
select   HoTen
from khachhang
group by HoTen;
-- cach 3
select  distinct HoTen
from khachhang
order by HoTen ;

/*
9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
*/

select month(NgayLamHopDong),count(IDKhachHang)
from hopdong
where year(NgayLamHopDong)=2019
group by month(NgayLamHopDong)
order by month(NgayLamHopDong) ;

/*
10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
 Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).
*/
select hopdongchitiet.IDHopDong,NgayLamHopDong,NgayKetThuc,TienDatCoc,IDDichVu  -- ,count(hopdongchitiet.IDDichVuDiKem) as soLuongDichVuDiKem
from hopdong
inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
group by hopdong.IDHopDong;

/*
11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
*/

select dichvudikem.IDDichVuDiKem,dichvudikem.TenDichVuDiKem,dichvudikem.TrangThaiKhaDung,dichvudikem.gia,dichvudikem.DonVi
from hopdong
inner join khachhang on hopdong.IDKhachHang = khachhang.IDKhachHang
inner join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach
inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
where (khachhang.DiaChi = 'Quảng Ngãi' or khachhang.DiaChi ='Vinh' ) and TenLoaiKhach='Diamond'
group by IDDichVuDiKem;
 /*
 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
 (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã 
 từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019
 */
 select hopdongchitiet.IDHopDong, nhanvien.HoTen,khachhang.HoTen,khachhang.SDT,dichvu.TenDichVu  , count(hopdongchitiet.IDDichVuDiKem) as soLuongDiKem, sum(hopdong.TienDatCoc) as TongTienDatCoc
 from hopdong
 inner join nhanvien on hopdong.IDNhanVien = nhanvien.IDNhanVien
 inner join khachhang on khachhang.IDKhachHang = hopdong.IDKhachHang
 inner join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
 inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
 where  month(hopdong.NgayLamHopDong)>9 and year(hopdong.NgayLamHopDong) and 
 dichvu.IDDichVu not in (
 select dichvu.IDDichVu
				from hopdong
                inner join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
				where  year(hopdong.NgayLamHopDong)=2019 and month(hopdong.NgayLamHopDong)<6
 )
 
group by hopdong.IDHopDong;

/*
13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
*/

select dichvudikem.*,count(dichvudikem.IDDichVuDiKem)
from hopdongchitiet
inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
group by dichvudikem.IDDichVuDiKem
having count(dichvudikem.IDDichVuDiKem) = (select count(dichvudikem.IDDichVuDiKem)
											from hopdongchitiet
											inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
											group by dichvudikem.IDDichVuDiKem
                                            order by count(dichvudikem.IDDichVuDiKem) desc
                                            limit 1
                                            );

/*
14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
*/
	select dichvudikem.*
	from hopdongchitiet
	inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
	group by dichvudikem.IDDichVuDiKem
	having count(dichvudikem.IDDichVuDiKem) =1;
    
    /*
    15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
    mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
    */
       
select nhanvien.IDNhanVien,nhanvien.HoTen,trinhdo.TrinhDo ,bophan.TenBoPhan,nhanvien.SDT,nhanvien.DiaChi ,count(nhanvien.IDNhanVien) as soHopDong
from hopdong
inner join nhanvien on hopdong.IDNhanVien =nhanvien.IDNhanVien
inner join trinhdo on nhanvien.IDTrinhDo =trinhdo.IDTrinhDo
inner join bophan on nhanvien.IDBoPhan =bophan.IDBoPhan
where year(hopdong.NgayLamHopDong) =2018 or year(hopdong.NgayLamHopDong) =2019
group by nhanvien.IDNhanVien
having count(nhanvien.IDNhanVien) = 3;

/*
16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
*/
    
delete from  nhanvien
where IDNhanVien not in (
			SELECT hopdong.IDNhanVien
			FROM hopdong
			where year(hopdong.NgayLamHopDong) between 2017 and 2019) 
;


-- phai can xoa themm ben hop dong nưa ư?

/*
17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
*/
 -- tại sao ở đây phải đặt một bí danh đặt cho nó
  update khachhang
  set IDLoaiKhach = (select IDLoaiKhach from loaikhach where TenLoaiKhach='Diamond')
  where IDKhachHang in (SELECT * FROM(
 select kh.IDKhachHang
 from hopdong
 inner join khachhang as kh on hopdong.IDKhachHang = kh.IDKhachHang
 inner join loaikhach on kh.IDLoaiKhach = loaikhach.IDLoaiKhach
 where hopdong.TongTien >10000000 and loaikhach.TenLoaiKhach = 'Platinum') tab ) ;
 
 /*
 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
 */
 delete from khachhang
 where IDKhachHang in ( 
 select hopdong.IDKhachHang
 from hopdong
 where year(hopdong.NgayLamHopDong) <2016) ;

 /*
 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
 */
 update dichvudikem
 set gia =gia*10
 where IDDichVuDiKem in (
 select * from (
 select dichvudikem.IDDichVuDiKem
from hopdongchitiet
inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
group by dichvudikem.IDDichVuDiKem
having count(dichvudikem.IDDichVuDiKem) > 2) table1);

 /*
 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID 
 (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
*/
select IDKhachHang as id,HoTen,Email,SDT,NgaySinh,DiaChi
from khachhang
union
select IDNhanVien,HoTen,Email,SDT,NgaySinh,DiaChi
from nhanvien    ;
                                                                                                                                                                                                                                                                                                                                             
/*
21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và
 đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
*/ 

create view V_NHANVIEN
as
select nhanvien.*
from hopdong
inner join nhanvien on hopdong.IDNhanVien = nhanvien.IDNhanVien
where hopdong.NgayLamHopDong ='2019-12-12'
group by hopdong.IDNhanVien
having count( hopdong.IDNhanVien)>=1;

/*
22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với 
tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
*/

create view V_NHANVIEN_Lieu_chieu
as
select *
from nhanvien
where DiaChi='Liên Chiểu';







 
 