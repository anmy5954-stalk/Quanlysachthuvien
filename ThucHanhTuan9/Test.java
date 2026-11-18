import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private ArrayList<Sach> dsSach = new ArrayList<>();

    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sách: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập sách thứ " + (i + 1) + ":");
            System.out.print("Chọn loại (1: Sách giáo khoa, 2: Sách tham khảo): ");
            int chon = sc.nextInt();

            Sach s;
            if (chon == 1) {
                s = new SachGiaoKhoa();
            } else {
                s = new SachThamKhao();
            }
            s.nhap();
            dsSach.add(s);
        }
    }

    public void xuatDanhSach() {
        System.out.println("\nDANH SÁCH SÁCH");
        for (Sach s : dsSach) {
            s.xuat();
        }
    }

    public void tinhTongThanhTien() {
        double tongSGK = 0;
        double tongSTK = 0;
        for (Sach s : dsSach) {
            if (s instanceof SachGiaoKhoa) {
                tongSGK += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongSTK += s.tinhThanhTien();
            }
        }
        System.out.println("\nTổng thành tiền Sách giáo khoa: " + tongSGK);
        System.out.println("Tổng thành tiền Sách tham khảo: " + tongSTK);
    }

    public void tinhTBCDonGiaSTK() {
        double tongDonGia = 0;
        int dem = 0;
        for (Sach s : dsSach) {
            if (s instanceof SachThamKhao) {
                tongDonGia += s.getDonGia();
                dem++;
            }
        }
        if (dem > 0) {
            System.out.println("Trung bình cộng đơn giá Sách tham khảo: " + (tongDonGia / dem));
        } else {
            System.out.println("Không có sách tham khảo!");
        }
    }

    public void xuatSGKTheoNXB() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập nhà xuất bản cần tìm: ");
        String nxb = sc.nextLine();

        System.out.println(" Sách giáo khoa của NXB " + nxb );
        for (Sach s : dsSach) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.xuat();
            }
        }
    }

    public static void main(String[] args) {
        Test ql = new Test();
        ql.nhapDanhSach();
        ql.xuatDanhSach();
        ql.tinhTongThanhTien();
        ql.tinhTBCDonGiaSTK();
        ql.xuatSGKTheoNXB();
    }
}