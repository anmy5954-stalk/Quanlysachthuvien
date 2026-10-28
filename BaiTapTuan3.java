import java.util.Scanner;

public class BaiTapTuan3 {
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

        // --- BÀI 4 TUẦN 4: DÙNG SWITCH CHỌN LOẠI SÁCH  ---
        System.out.println("\nChon loai sach:");
        System.out.println("1. Sach giaokhoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        int loaiSachOption = scanner.nextInt();

        String loaiSach = "";
        switch (loaiSachOption) {
            case 1:
                loaiSach = "Sach giao khoa";
                break;
            case 2:
                loaiSach = "Sach tham khao";
                break;
            case 3:
                loaiSach = "Sach chuyen nganh";
                break;
            case 4:
                loaiSach = "Sach khac";
                break;
            default:
                loaiSach = "Loai sach khong hop le";
                break;
        }


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

        // --- BÀI 1, 2, 3 TUẦN 4: IN KẾT QUẢ ĐÁNH GIÁ & PHÂN LOẠI (Ở CUỐI) ---
        System.out.println("\n--- KET QUA KIEM TRA VA PHAN LOAI ---");

        // Bài 1: Kiểm tra dữ liệu hợp lệ
        if (donGiaSach > 0 && slSach >= 0 && nxbSach > 0 && nxbSach <= 2026) {
            System.out.println("Kiem tra du lieu: Thong tin sach HOP LE");
        } else {
            System.out.println("Kiem tra du lieu: Thong tin sach KHONG HOP LE");
        }

        // Bài 2: Phân loại giá
        if (donGiaSach < 50000) {
            System.out.println("Phan loai gia: Sach gia thap");
        } else if (donGiaSach <= 100000) {
            System.out.println("Phan loai gia: Sach gia trung binh");
        } else if (donGiaSach <= 200000) {
            System.out.println("Phan loai gia: Sach gia cao");
        } else {
            System.out.println("Phan loai gia: Sach gia dac biet");
        }

        // Bài 3: Phân loại tồn kho
        if (slSach == 0) {
            System.out.println("Phan loai ton kho: Het sach");
        } else if (slSach >= 1 && slSach <= 5) {
            System.out.println("Phan loai ton kho: Sap het");
        } else if (slSach >= 6 && slSach <= 20) {
            System.out.println("Phan loai ton kho: Con it");
        } else {
            System.out.println("Phan loai ton kho: Con nhieu");
        }

        scanner.close();

    }
}