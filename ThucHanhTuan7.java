import java.util.ArrayList;

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

    public SACH(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

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

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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