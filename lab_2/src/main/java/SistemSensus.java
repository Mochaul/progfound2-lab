import java.util.Scanner;

/**
 * @author Template Author: Ichlasul Affan dan Arga Ghulam Ahmad
 * Template ini digunakan untuk Tutorial 02 DDP2 Semester Genap 2017/2018.
 * Anda sangat disarankan untuk menggunakan template ini.
 * Namun Anda diperbolehkan untuk menambahkan hal lain berdasarkan kreativitas Anda
 * selama tidak bertentangan dengan ketentuan soal.
 *
 * Cara penggunaan template ini adalah:
 * 1. Isi bagian kosong yang ditandai dengan komentar dengan kata TODO
 * 2. Ganti titik-titik yang ada pada template agar program dapat berjalan dengan baik.
 *
 * Code Author (Mahasiswa):
 * @author Nicolaus Christian Gozali, NPM 1706020446, Kelas ProgF 2, GitLab Account: nicolauscg
 */

public class SistemSensus {
	public static void main(String[] args) {
		// Buat input scanner baru
		Scanner input = new Scanner(System.in);


		// TODO Bagian ini digunakan untuk soal Tutorial "Sensus Daerah Kumuh"
		// User Interface untuk meminta masukan
		System.out.print("PROGRAM PENCETAK DATA SENSUS\n" +
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