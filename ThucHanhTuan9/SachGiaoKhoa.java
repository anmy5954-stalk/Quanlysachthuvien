import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tình trạng (moi/cu): ");
        tinhTrang = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(", Tình trạng: " + tinhTrang + ", Thành tiền: " + tinhThanhTien());
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return getSoLuong() * getDonGia();
        } else {
            return getSoLuong() * getDonGia() * 0.5;
        }
    }
}