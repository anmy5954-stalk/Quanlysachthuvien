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
    // Bài 3: ArrayList<Sach> danhSachSach quản lý đối tượng sách[cite: 6]
    private static ArrayList<Sach> danhSachSach = new ArrayList<>();
    // Bài 2: ArrayList<String> quản lý danh sách mã sách[cite: 6]
    private static ArrayList<String> danhSachMaSach = new ArrayList<>();

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
                    xoaSachTheoMa(); // Bổ sung Tuần 6: Xóa sách
                    break;
                case 6:
                    suaSachTheoMa(); // Bổ sung Tuần 6: Sửa sách
                    break;
                case 7:
                    xuLyMangSoLuong(); // Bài 1: Mảng int[] soLuong[cite: 6]
                    break;
                case 8:
                    xuLyBai2_ArrayListMaSach(); // Bài 2: ArrayList<String> mã sách[cite: 6]
                    break;
                case 9:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình! Tạm biệt.");
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng chọn lại!\n");
            }
        } while (luaChon != 9);
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
    private static void xuLyBai2_ArrayListMaSach() {
        int luaChonB2 = 0;
        do {
            System.out.println("\n--- BÀI 2: QUẢN LÝ DANH SÁCH MÃ SÁCH (ArrayList<String>) ---");
            System.out.println("1. Thêm mã sách | 2. Hiển thị | 3. Tìm | 4. Xóa | 5. Quay lại");
            System.out.print("Chọn (1-5): ");
            try {
                luaChonB2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                luaChonB2 = -1;
            }

            switch (luaChonB2) {
                case 1:
                    System.out.print("Nhập mã sách cần thêm: ");
                    danhSachMaSach.add(sc.nextLine());
                    System.out.println(">> Đã thêm!");
                    break;
                case 2:
                    System.out.println("Danh sách mã sách: " + danhSachMaSach);
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = sc.nextLine();
                    System.out.println(danhSachMaSach.contains(maTim) ? ">> Tìm thấy!" : ">> Không thấy!");
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = sc.nextLine();
                    System.out.println(danhSachMaSach.remove(maXoa) ? ">> Đã xóa!" : ">> Không thấy để xóa!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChonB2 != 5);
    }


    //  Thêm sách
    private static void themSach() {
        System.out.println("\n--- THÊM SÁCH MỚI ---");
        Sach s = new Sach();
        s.nhapThongTin(sc);
        danhSachSach.add(s);
        System.out.println(">> Đã thêm sách mới thành công!\n");
    }


    //  Xóa sách theo mã
    private static void xoaSachTheoMa() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        System.out.print("\nNhập mã sách cần xóa: ");
        String maCanXoa = sc.nextLine();
        boolean daXoa = false;

        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maCanXoa)) {
                danhSachSach.remove(i);
                daXoa = true;
                System.out.println(">> Đã xóa thành công sách có mã: " + maCanXoa + "\n");
                break;
            }
        }

        if (!daXoa) {
            System.out.println(">> Không tìm thấy sách có mã " + maCanXoa + " để xóa!\n");
        }
    }

    // Chức năng 5: Sửa sách theo mã
    private static void suaSachTheoMa() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        System.out.print("\nNhập mã sách cần sửa: ");
        String maCanSua = sc.nextLine();
        Sach sachSua = null;

        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanSua)) {
                sachSua = s;
                break;
            }
        }

        if (sachSua == null) {
            System.out.println(">> Không tìm thấy sách có mã " + maCanSua + " để sửa!\n");
            return;
        }

        System.out.println("--- Nhập thông tin mới cho sách mã [" + maCanSua + "] ---");
        System.out.print("  Tên sách mới: ");
        sachSua.setTenSach(sc.nextLine());
        System.out.print("  Số lượng mới: ");
        sachSua.setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.print("  Đơn giá mới: ");
        sachSua.setDonGia(Double.parseDouble(sc.nextLine()));

        System.out.println(">> Đã cập nhật thông tin sách thành công!\n");
    }

    // Chức năng 6: Tính tổng số lượng
    private static void tinhTongSoLuong() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        int tongSoLuong = 0;
        for (Sach s : danhSachSach) {
            tongSoLuong += s.getSoLuong();
        }

        System.out.println("\n>> Tổng số lượng tất cả các cuốn sách trong thư viện: " + tongSoLuong + "\n");
    }

    // Chức năng 7: Tính tổng giá trị
    private static void tinhTongGiaTri() {
        if (danhSachSach.isEmpty()) {
            System.out.println("\n>> Danh sách sách đang trống!\n");
            return;
        }

        double tongGiaTri = 0.0;
        for (Sach s : danhSachSach) {
            tongGiaTri += s.getThanhTien();
        }

        System.out.printf("\n>> Tổng giá trị tiền sách trong thư viện: %.2f VNĐ\n\n", tongGiaTri);
    }

    // Bài 1: Mảng int[] soLuong cho 5 cuốn sách (chức năng phụ 9)
    private static void xuLyMangSoLuong() {
        int[] soLuong = new int[5];
        System.out.println("\n--- BÀI 1: NHẬP SỐ LƯỢNG CHO 5 CUỐN SÁCH ---");
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Nhập số lượng cuốn sách thứ " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
        }

        // Hiển thị số lượng
        System.out.print("Danh sách số lượng vừa nhập: ");
        int tong = 0;
        int max = soLuong[0];

        for (int sl : soLuong) {
            System.out.print(sl + " ");
            tong += sl;
            if (sl > max) {
                max = sl;
            }
        }
        System.out.println();

        // Tính tổng & Tìm số lượng lớn nhất
        System.out.println(">> Tổng số lượng: " + tong);
        System.out.println(">> Số lượng lớn nhất: " + max + "\n");
    }
}