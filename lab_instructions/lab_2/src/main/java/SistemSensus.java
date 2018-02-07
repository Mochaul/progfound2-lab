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
 * @author ....., NPM ....., Kelas ....., GitLab Account: .....
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
		String nama = .....;
		System.out.print("Alamat Rumah           : ");
		String alamat = .....;
		System.out.print("Panjang Tubuh (cm)     : ");
		... panjang = .....;
		System.out.print("Lebar Tubuh (cm)       : ");
		... lebar = .....;
		System.out.print("Tinggi Tubuh (cm)      : ");
		... tinggi = .....;
		System.out.print("Berat Tubuh (kg)       : ");
		... berat = .....;
		System.out.print("Jumlah Anggota Keluarga: ");
		... makanan = .....;
		System.out.print("Tanggal Lahir          : ");
		String tanggalLahir = .....;
		System.out.print("Catatan Tambahan       : ");
		String catatan = .....;
		System.out.print("Jumlah Cetakan Data    : ");
		... jumlahCetakan = .....;


		// TODO Bagian ini digunakan untuk soal Tutorial "Sensus Daerah Kumuh"
		// TODO Hitung rasio berat per volume (rumus lihat soal)
		... rasio = (...) (...);

		for (.....) {
			// TODO Minta masukan terkait nama penerima hasil cetak data
			System.out.print("Pencetakan " + ... + " dari " + jumlahCetakan + " untuk: ");
			String penerima = .....; // Lakukan baca input lalu langsung jadikan uppercase

			// TODO Periksa ada catatan atau tidak
			if (.....) catatan = .....;
			else catatan = .....;

			// TODO Cetak hasil (ganti string kosong agar keluaran sesuai)
			String hasil = "";
			.....;
		}


		// TODO Bagian ini digunakan untuk soal bonus "Rekomendasi Apartemen"
		// TODO Hitung nomor keluarga dari parameter yang telah disediakan (rumus lihat soal)



		// TODO Gabungkan hasil perhitungan sesuai format sehingga membentuk nomor keluarga
		String nomorKeluarga = "";

		// TODO Hitung anggaran makanan per tahun (rumus lihat soal)
		... anggaran = (...) (...);

		// TODO Hitung umur dari tanggalLahir (rumus lihat soal)
		... tahunLahir = .....; // lihat hint jika bingung
		... umur = (...) (...);

		// TODO Lakukan proses menentukan apartemen (kriteria lihat soal)





		// TODO Cetak rekomendasi (ganti string kosong agar keluaran sesuai)
		String rekomendasi = "";
		.....;

		input.close();
	}
}