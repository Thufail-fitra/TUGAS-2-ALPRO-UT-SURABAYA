package TUGAS_2.ALPRO_MUHAMMAD_THUFAIL_FITRATALLAH;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.InputMismatchException;


public class Main {

    // Konstanta untuk "magic numbers" agar kode lebih mudah dibaca dan diubah.
    private static final double GAJI_GOLONGAN_A = 5000000;
    private static final double GAJI_GOLONGAN_B = 6500000;
    private static final double GAJI_GOLONGAN_C = 9500000;

    public static void main(String[] args) {
        // Inisialisasi formatter untuk menampilkan mata uang dalam format Rupiah
        //Locale localeID = new Locale("id", "ID"); // ini udah usang dipake di java 19
        //NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);

        // Menggunakan try-with-resources untuk manajemen Scanner yang lebih aman.
        // Scanner akan otomatis ditutup setelah blok try selesai.
        try (Scanner input = new Scanner(System.in)) {
            // Menampilkan judul program
            System.out.println("=============================================");
            System.out.println("=== PROGRAM HITUNG GAJI KARYAWAN ===");
            System.out.println("=============================================");

            // Meminta input golongan dari pengguna
            System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
            char golongan = input.next().toUpperCase().charAt(0);

            // Meminta input jam lembur dari pengguna
            System.out.print("Masukkan Jumlah Jam Lembur: ");
            int jamLembur = input.nextInt();

            //  Memanggil method terpisah untuk mendapatkan gaji pokok.
            double gajiPokok = getGajiPokok(golongan);

            // Validasi hasil dari getGajiPokok
            if (gajiPokok == 0) {
                System.out.println("Golongan tidak valid. Program berhenti.");
                return; // Menghentikan eksekusi jika golongan tidak valid
            }

            // Memanggil method terpisah untuk mendapatkan persentase lembur.
            double persentaseLembur = getPersentaseLembur(jamLembur);

            // --- Menggunakan Operator untuk menghitung total penghasilan ---
            double gajiLembur = gajiPokok * persentaseLembur;
            double totalGaji = gajiPokok + gajiLembur;

            // --- Menampilkan Output (Tampilan ke Layar) ---
            System.out.println("\n---------------------------------------------");
            System.out.println("               DETAIL PENGHASILAN");
            System.out.println("---------------------------------------------");
            System.out.println("Golongan Anda         : " + golongan);
            System.out.println("Gaji Pokok            : " + currencyFormatter.format(gajiPokok));
            System.out.println("Jam Lembur            : " + jamLembur + " Jam");
            System.out.println("Gaji Lembur           : " + currencyFormatter.format(gajiLembur));
            System.out.println("---------------------------------------------");
            System.out.println("Total Penghasilan     : " + currencyFormatter.format(totalGaji));
            System.out.println("---------------------------------------------");
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("               TUGAS 2 ALGORITMA DAN PEMROGRAMAN");
            System.out.println("-------------------------------------------------------------");
            System.out.println("NAMA                    : " + "Muhammad Thufail Fithratallah");
            System.out.println("NIM                     : " + "056324926");
            System.out.println("UPBJJ DAERAH            : " + "Surabaya");
            System.out.println("FAKULTAS                : " + "SAINS DAN TEKNOLOGI");
            System.out.println("PROGRAM STUDI           : " + "SISTEM INFORMASI");
            System.out.println("TUTOR/DOSEN YTH.        : " + "Malisa Huzaifa, S.Kom., M.T.");
            System.out.println("KODE KELAS              : " + "465");
            System.out.println("-------------------------------------------------------------");



        } catch (InputMismatchException e) {
            // Menangani error jika user memasukkan teks untuk jam lembur
            System.err.println("Input tidak valid. Harap masukkan angka untuk jam lembur.");
        } catch (Exception e) {
            // Menangani error umum lainnya
            System.err.println("Terjadi error: " + e.getMessage());
        }
    }

    /**
     * Method terpisah untuk menentukan Gaji Pokok berdasarkan Golongan
     * menggunakan statement switch yang lebih rapi.
     * @param golongan char 'A', 'B', atau 'C'
     * @return gaji pokok sebagai double, atau 0 jika golongan tidak valid.
     */
    private static double getGajiPokok(char golongan) {
        switch (golongan) {
            case 'A':
                return GAJI_GOLONGAN_A;
            case 'B':
                return GAJI_GOLONGAN_B;
            case 'C':
                return GAJI_GOLONGAN_C;
            default:
                return 0; // Mengindikasikan golongan tidak valid
        }
    }

    /**
     * Method terpisah untuk menentukan Persentase Gaji Lembur.
     * @param jamLembur jumlah jam lembur
     * @return persentase lembur dalam format desimal (misal: 0.38 untuk 38%)
     */
    private static double getPersentaseLembur(int jamLembur) {
        if (jamLembur >= 5) {
            return 0.38; // 38%
        } else if (jamLembur == 4) {
            return 0.36; // 36%
        } else if (jamLembur == 3) {
            return 0.34; // 34%
        } else if (jamLembur == 2) {
            return 0.32; // 32%
        } else if (jamLembur == 1) {
            return 0.30; // 30%
        } else {
            return 0; // Jika tidak lembur (0 jam atau kurang)
        }
    }
}
