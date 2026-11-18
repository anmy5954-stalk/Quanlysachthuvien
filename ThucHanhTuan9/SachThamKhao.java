import java.util.Scanner;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập thuế: ");
        thue = sc.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(", Thuế: " + thue + ", Thành tiền: " + tinhThanhTien());
    }

    @Override
    public double tinhThanhTien() {
        return getSoLuong() * getDonGia() + thue;
    }
}