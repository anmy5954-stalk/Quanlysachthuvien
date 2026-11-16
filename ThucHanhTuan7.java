import java.util.ArrayList;
import java.time.Year;
// Yêu cầu 3: Lớp Test dùng để tạo đối tượng và thực thi quản lý danh sách SACH
public class ThucHanhTuan7 {

    public static void main(String[] args) {
        // Yêu cầu 4: Tạo và quản lý danh sách SACH bằng ArrayList
        ArrayList<SACH> danhSachSach = new ArrayList<>();

        // Yêu cầu 3: Khởi tạo các đối tượng từ lớp SACH
        SACH s1 = new SACH("S01", "Lập trình Java", "Nguyễn Văn A", 2021, 10);
        SACH s2 = new SACH("S02", "Cấu trúc dữ liệu và giải thuật", "Trần Thị B", 2020, 5);
        SACH s3 = new SACH("S03", "Cơ sở dữ liệu", "Lê Văn C", 2022, 12);

        danhSachSach.add(s1);
        danhSachSach.add(s2);
        danhSachSach.add(s3);

        // Hiển thị danh sách sách trong thư viện
        System.out.println("=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        for (SACH s : danhSachSach) {
            s.hienThiThongTin();
        }
        //[ TUẦN 8]: DEMO KIỂM TRA RÀNG BUỘC CỦA SETTER TUẦN 8 
        System.out.println("\n=== [BỔ SUNG TUẦN 8] KIỂM TRA RÀNG BUỘC DỮ LIỆU SỬ DỤNG SETTER ===");
        
        // Thu nhập / Thử nghiệm cập nhật năm xuất bản không hợp lệ (lớn hơn năm hiện tại)
        System.out.print("Sửa năm xuất bản của S01 thành 2030: ");
        s1.setNamXuatBan(2030); 

        // Thử nghiệm cập nhật số lượng không hợp lệ (số âm)
        System.out.print("Sửa số lượng của S01 thành -5: ");
        s1.setSoLuong(-5);

        // Thử nghiệm cập nhật thông tin hợp lệ
        System.out.print("Sửa năm xuất bản của S01 thành 2024: ");
        s1.setNamXuatBan(2024);
        
        System.out.print("Sửa số lượng của S01 thành 15: ");
        s1.setSoLuong(15);

        // In lại thông tin s1 sau khi cập nhật
        System.out.println("\n-> Thông tin cuốn sách S01 sau khi cập nhật hợp lệ:");
        s1.hienThiThongTin();
    }
}


// Yêu cầu 1: Lớp SACH biểu diễn thông tin cuốn sách
class SACH {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public SACH() {
    }
    // Yêu cầu 4 (Tuần 8): Constructor có tham số đầy đủ khởi tạo tất cả các thuộc tính
    public SACH(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;

    // Sử dụng setter trong constructor để đảm bảo dữ liệu hợp lệ ngay khi khởi tạo
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yêu cầu 2 (Tuần 8): Cung cấp đầy đủ public getters và setters cho tất cả các thuộc tính
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // [ TUẦN 8 - YÊU CẦU 3]: Kiểm tra điều kiện trong setNamXuatBan 
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue(); // Lấy năm hiện tại hệ thống
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
            System.out.println("Cập nhật năm xuất bản thành công: " + namXuatBan);
        } else {
            System.out.println("Lỗi: Năm xuất bản phải > 0 và <= " + currentYear + "!");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    //  [ TUẦN 8 - YÊU CẦU 3]: Kiểm tra điều kiện trong setSoLuong 
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
            System.out.println("Cập nhật số lượng thành công: " + soLuong);
        } else {
            System.out.println("Lỗi: Số lượng không được nhỏ hơn 0!");
        }
    }

    // Yêu cầu 2: Phương thức hienThiThongTin()
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach + 
                           " | Tiêu đề: " + tieuDe + 
                           " | Tác giả: " + tacGia + 
                           " | Năm xuất bản: " + namXuatBan + 
                           " | Số lượng: " + soLuong);
    }
}