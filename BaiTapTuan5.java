import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double donGia;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, int soLuong, double donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return soLuong * donGia;
    }

    public void nhapThongTin(Scanner sc) {
        System.out.print("  Nhập mã sách: ");
        this.maSach = sc.nextLine();
        System.out.print("  Nhập tên sách: ");
        this.tenSach = sc.nextLine();
        System.out.print("  Nhập số lượng: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("  Nhập đơn giá: ");
        this.donGia = Double.parseDouble(sc.nextLine());
    }

    public void xuatThongTin() {
        System.out.printf("Mã: %-8s | Tên: %-25s | SL: %-5d | Đơn giá: %-10.2f | Thành tiền: %.2f\n",
                maSach, tenSach, soLuong, donGia, getThanhTien());
    }
}

public class BaiTapTuan5 {
    private static ArrayList<Sach> danhSachSach = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
        }

        int luaChon = 0;

        do {
            hienThiMenu();
            System.out.print("Mời bạn chọn chức năng (1-5): ");
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    nhapDanhSachSach();
                    break;
                case 2:
                    tinhTongSoLuongVaGiaTri();
                    break;
                case 3:
                    timSachTheoMa();
                    break;
                case 4:
                    hienThiDanhSach();
                    break;
                case 5:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình! Tạm biệt.");
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng chọn lại!\n");
            }
        } while (luaChon != 5);
    }

    private static void hienThiMenu() {
        System.out.println("====== QUẢN LÝ THƯ VIỆN SÁCH ======");
        System.out.println("1. Nhập danh sách n cuốn sách");
        System.out.println("2. Tính tổng số lượng và tổng giá trị sách");
        System.out.println("3. Tìm sách theo mã");
        System.out.println("4. Hiển thị tất cả sách");
        System.out.println("5. Thoát");
        System.out.println("===================================");
    }

    private static void nhapDanhSachSach() {
        System.out.print("\nNhập số lượng sách cần thêm (n): ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập cuốn sách thứ " + (i + 1) + " ---");
            Sach s = new Sach();
            s.nhapThongTin(sc);
            danhSachSach.add(s);
        }
        System.out.println(">> Đã thêm thành công " + n + " cuốn sách!\n");
    }

    private static void tinhTongSoLuongVaGiaTri() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0.0;

        for (Sach s : danhSachSach) {
            tongSoLuong += s.getSoLuong();
            tongGiaTri += s.getThanhTien();
        }

        System.out.println("\n=== KẾT QUẢ THỐNG KÊ ===");
        System.out.println("Tổng số lượng sách trong thư viện: " + tongSoLuong);
        System.out.printf("Tổng giá trị các cuốn sách: %.2f VNĐ\n\n", tongGiaTri);
    }

    private static void timSachTheoMa() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        System.out.print("\nNhập mã sách cần tìm: ");
        String maCanTim = sc.nextLine();
        boolean timThay = false;

        System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                s.xuatThongTin();
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sách nào có mã: " + maCanTim);
        }
        System.out.println();
    }

    private static void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        System.out.println("\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        for (Sach s : danhSachSach) {
            s.xuatThongTin();
        }
        System.out.println();
    }
}