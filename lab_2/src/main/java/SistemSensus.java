import java.util.Scanner;

/**
 * @author Template Author: Ichlasul Affan and Arga Ghulam Ahmad
 *
 * This template is used for Programming Foundations 2 Tutorial 2 Term 2 2017/2018.
 * It is recommended to use this template as the base for completing Tutorial 2.
 * You are allowed to make modifications to the template as long it still matches
 * with the tutorial specification.
 *
 * Code Author (Mahasiswa):
 * @author Nicolaus Christian Gozali, NPM 1706020446, Kelas ProgF 2, GitLab Account: nicolauscg
 */

public class SistemSensus {

	public static void main(String[] args) {
		// Create a new Scanner object to read input from standard input
		Scanner input = new Scanner(System.in);

        // TODO This section corresponds to tutorial problem about "Slum Census"
		// The interface to get input from user
		System.out.print("CENSUS DATA PRINTING PROGRAM\n" +
				"--------------------\n" +
				"Nama Kepala Keluarga   : ");
		String nama = input.nextLine();
		System.out.print("Alamat Rumah           : ");
		String alamat = input.nextLine();
		System.out.print("Panjang Tubuh (cm)     : ");
		int panjang = Integer.parseInt(input.nextLine());
		if ( !(0 < panjang && panjang <= 250) ){
			System.out.println("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Lebar Tubuh (cm)       : ");
		int lebar = Integer.parseInt(input.nextLine());
		if ( !(0 < lebar && lebar <= 250) ){
			System.out.println("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Tinggi Tubuh (cm)      : ");
		int tinggi = Integer.parseInt(input.nextLine());
		if ( !(0 < tinggi && tinggi <= 250) ){
			System.out.println("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Berat Tubuh (kg)       : ");
		float berat = Float.parseFloat(input.nextLine());
		if ( !(0 < panjang && panjang <= 150) ){
			System.out.println("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Jumlah Anggota Keluarga: ");
		int makanan = Integer.parseInt(input.nextLine());
		if ( !(0 < makanan && makanan <= 20) ){
			System.out.println("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Tanggal Lahir          : ");
		String tanggalLahir = input.nextLine();
		System.out.print("Catatan Tambahan       : ");
		String catatan = input.nextLine();
		System.out.print("Jumlah Cetakan Data    : ");
		int jumlahCetakan = Integer.parseInt(input.nextLine());


		// TODO Bagian ini digunakan untuk soal Tutorial "Sensus Daerah Kumuh"
		// TODO Hitung rasio berat per volume (rumus lihat soal)
		int rasio = (int)(berat / (panjang*lebar*tinggi/1000000.0));

        String catatan_output;
		for (int i=0; i < jumlahCetakan; i++) {
			// TODO Minta masukan terkait nama penerima hasil cetak data
			System.out.print("\nPencetakan " + (int)(i + 1) + " dari " + jumlahCetakan + " untuk: ");
			String penerima = input.nextLine().toUpperCase(); // Lakukan baca input lalu langsung jadikan uppercase

			// TODO Periksa ada catatan atau tidak
			if (catatan.length() == 0) catatan_output = "tidak ada catatan tambahan";
			else catatan_output = "Catatan: " + catatan;

			// TODO Cetak hasil (ganti string kosong agar keluaran sesuai)
			String hasil = "DATA SIAP DICETAK UNTUK " + penerima + "\n" +
						   "-----------------\n" + 
						   nama + " - " + alamat + "\n" + 
						   "Lahir pada tanggal " + tanggalLahir + "\n" +
						   "Rasio Berat Per Volume     = " + rasio + " kg/m3" + "\n" +
						   catatan_output;
			System.out.println(hasil);
		}


		// TODO Bagian ini digunakan untuk soal bonus "Rekomendasi Apartemen"
		// TODO Hitung nomor keluarga dari parameter yang telah disediakan (rumus lihat soal)
		int ascii_sum=0;
		for (int j=0; j < nama.length(); j++){
			ascii_sum += (int)nama.charAt(j);
		}
		int calculation = ((panjang*lebar*tinggi) + ascii_sum) % 10000;

		// TODO Gabungkan hasil perhitungan sesuai format sehingga membentuk nomor keluarga
		String nomorKeluarga = nama.charAt(0) + String.valueOf(calculation);

		// TODO Hitung anggaran makanan per tahun (rumus lihat soal)
		int anggaran = 50000 * 365 * makanan;

		// TODO Hitung umur dari tanggalLahir (rumus lihat soal)
		int tahunLahir = Integer.parseInt(tanggalLahir.split("-")[2]); // lihat hint jika bingung
		int umur = 2018 - tahunLahir;

		// TODO Lakukan proses menentukan apartemen (kriteria lihat soal)
		String apartment;
		if (anggaran > 100000000 && umur >= 19 && umur <= 1018){
			apartment = "Mares, Margonda";
		}else if (anggaran >= 0 && umur >= 19 && umur <=1018){
			apartment = "Teksas, Literature";
		}else{
			apartment = "PPMT, Rotunda";
		}

		// TODO Cetak rekomendasi (ganti string kosong agar keluaran sesuai)
		String rekomendasi = "\nRECOMMENDATIONS OF APARTMENTS\n" +
							  "--------------------\n" +
							  "KNOWN: Family ID: " + nama + " - " + nomorKeluarga + "\n" +
							  "CONSIDER: Annual food budget: Rp " + anggaran + "\n" + 
							  "Age of family head: " + umur + " years old" + "\n" +
							  "HAS DECIDED: Family  will be placed at:\n" +
							  apartment;

		System.out.println(rekomendasi);

		input.close();
	}
}
