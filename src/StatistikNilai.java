import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class StatistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);

        } while (true);

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang sah.");
            input.close();
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        // Menghitung total dan rata-rata.
        int total = 0;

        for (int i = 0; i < daftar.size(); i++) {
            total += daftar.get(i);
        }

        double rataRata = (double) total / daftar.size();

        System.out.printf(Locale.forLanguageTag("id-ID"), "Rata-rata : %.2f%n", rataRata);

        // Mencari nilai tertinggi dan terendah.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int i = 1; i < daftar.size(); i++) {
            int x = daftar.get(i);
            if (x > tertinggi) {
                tertinggi = x;
            }
            if (x < terendah) {
                terendah = x;
            }
        }
        System.out.println("Tertinggi : " + tertinggi);
        System.out.println("Terendah : " + terendah);

        // Menghitung nilai yang di atas rata-rata.
        int diAtasRataRata = 0;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i) > rataRata) {
                diAtasRataRata++;
            }
        }
        System.out.println("Di atas rata2 : " + diAtasRataRata + " orang");

        // Menghitung distribusi grade.
        int[] jumlahGrade = new int[5];
        for (int i = 0; i < daftar.size(); i++) {
            int x = daftar.get(i);
            if (x >= 90) {
                jumlahGrade[0]++;
            } else if (x >= 80) {
                jumlahGrade[1]++;
            } else if (x >= 70) {
                jumlahGrade[2]++;
            } else if (x >= 60) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }
        char[] grade = {'A', 'B', 'C', 'D', 'E'};
        System.out.print("Distribusi : ");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(grade[i] + "=" + jumlahGrade[i]);
            if (i < jumlahGrade.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        input.close();
    }

}
