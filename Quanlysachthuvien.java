import java.util.Scanner;

public class Quanlysachthuvien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bài 1: Nhập thông tin sách
        System.out.println("Nhap thong tin sach");
        
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhap Tac gia sach: ");
        String tacGiaSach = scanner.nextLine();

        System.out.print("Nhap nam xuat ban sach: ");
        int nxbSach = scanner.nextInt();

        System.out.print("Nhap don gia sach: ");
        double donGiaSach = scanner.nextDouble();

        System.out.print("Nhap so luong sach: ");
        int slSach = scanner.nextInt();

        // Hiển thị lại thông tin
        System.out.println("\n--- THONG TIN SACH DA NHAP ---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGiaSach);
        System.out.println("Nam xuat ban: " + nxbSach);
        System.out.println("Don gia: " + donGiaSach);
        System.out.println("So luong: " + slSach);

        // Bài 2: Tính thành tiền = đơn giá × số lượng.
        double thanhTien = donGiaSach * slSach;
        //Bài 3: Phí vận chuyển = 5% giá trị sách.
        double phiVanChuyen = thanhTien * 0.05;

        //Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
        double tongTienNhap = thanhTien + phiVanChuyen;

        System.out.println("Thanh tien: " + thanhTien);
        System.out.println("Phi van chuyen: " + phiVanChuyen);
        System.out.println("Tong tien nhap: " + tongTienNhap);

        scanner.close();

    }
}