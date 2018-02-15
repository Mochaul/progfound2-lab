# **Tutorial 3: Rekursif (Soal Tutorial)**

Dasar-dasar Pemrograman 2 - CSGE601021 | Fakultas Ilmu Komputer, Universitas Indonesia, Semester Genap 2017/2018

**Dibuat oleh DS | KD**

* * *
Pada tutorial sebelumnya, Anda telah mempelajari mengenai konsep pemrograman Java dan berbagai operasi data di Java. Anda juga telah menyinggung sedikit materi mengenai method (return pada bagian branching statement). Kali ini, Anda akan mempelajari lebih mengenai method, dan mengenai suatu fungsi yang disebut recursive method.

## **Tujuan Pembelajaran**
1. Memahami cara membuat **method** dalam Java.
2. Memahami konsep **recursive method**.

### **Before You Start...**
1. Lakukan `git pull upstream master` dengan menggunakan Command Prompt pada folder repository lokal Anda.
2. Kerjakan soal tersebut kemudian letakkan file jawaban anda di folder `lab_3/src/main/java`. Kami sudah menyediakan folder kosong untuk kamu.
3. Setelah selesai mengimplementasikan kode tersebut, lakukan add, commit, dan push code kalian tersebut.

## **Materi Tutorial**

### **Methods in Java**

Di DDP 1, Anda sudah belajar cara mendefinisikan sebuah fungsi menggunakan bahasa Python. Definisi fungsi pada Java mirip dengan definisi fungsi di Python, hanya kita harus mendefinisikan tipe data parameter fungsi tersebut, dan tipe data yang akan dikembalikan oleh fungsi tersebut.

### Python

```Python
def jumlah(angka1, angka2):
    return angka1 + angka2
```

### Java

```Java
public static int jumlah(int angka1, int angka2){
    return angka1 + angka2;
}
```

> **Catatan**
> Untuk memanggil sebuah method dalam main, method tersebut harus menggunakan keyword static. Hal ini akan dipelajari lebih dalam pada tutorial berikutnya.

### **Recursive Method**

Pada tutorial kali ini, Anda akan belajar suatu fungsi yang disebut recursive method. Sebuah fungsi dapat dikatakan rekursif jika fungsi tersebut memanggil dirinya sendiri. Biasanya fungsi rekursif digunakan untuk menyelesaikan permasalahan yang dapat direduksi menjadi masalah serupa yang lebih kecil.

Salah satu contohnya adalah menghitung faktorial sebuah bilangan. Perhatikan gambar berikut:

![alt text](https://i.imgur.com/hriRLZ7.png "Ilustrasi faktorial")

Apakah Anda melihat sebuah pola? Fungsi factorial di atas dipanggil empat kali, dengan parameter yang mengecil. Dapat kita simpulkan bahwa dalam fungsi factorial(n), akan terpanggil fungsi factorial(n-1) hingga selesai.
Agar fungsi rekursif tidak terus dijalankan tanpa henti, kita membutuhkan sebuah basis atau base case yang tidak menggunakan recursive call, atau tidak memanggil fungsi rekursif kembali. Perhatikan contoh kode berikut:

```Java
int factorial(int number){
    if (number <= 1) {                 //basis
        return 1;
    }
    else {                             //rekurens
        return number * factorial(number - 1);
    }
}
```

Pada dasarnya, fungsi rekursif dapat dibagi menjadi basis dan rekurens. Pada kode di atas, base case fungsi tersebut adalah jika angka parameter yaitu number kurang dari atau sama dengan satu, karena 1! = 1, dan 0! = 1 (asumsi input tidak negatif, karena faktorial negatif tidak terdefinisi). Base case ini tidak menggunakan recursive call karena bertujuan menghentikan pemanggilan rekursif jika terjadi.

Sedangkan untuk rekurens, fungsi diatas mengembalikan nilai number itu sendiri dikalikan dengan pemanggilan fungsi kembali, tetapi parameter menjadi number-1. Nilai saat pemanggilan selanjutnya akan mengecil mendekati basis. Pemanggilan factorial(4) akan mengembalikan nilai 4 dikali dengan factorial(3), yang akan mengembalikan nilai 3 dikali dengan factorial(2), hingga base case yaitu factorial(1).

### **Let's do this!?**

Sebelum kita masuk ke soal tutorial, kita akan warm-up terlebih dahulu. Untuk setiap soal, cari kasus *base case* dan kasus *rekurens*

1. Fungsi yang mengeluarkan output hitung mundur dari n sampai 1

    ```
    n = 5
    Output:
    5
    4
    3
    2
    1
    ```

2. Fungsi menghitung bilangan fibonacci ke-n (bilangan fibonacci ke-n adalah hasil jumlahan dari dua bilangan sebelumnya)

    ```
    fibonacci(6)
    Output:
    13
    ```
3. Fungsi yang memasukkan char ‘*’ di antara semua huruf dalam suatu string.

    ```
    masukkanBintang(“depechan”)
    Output:
    d*e*p*e*c*h*a*n
    ```

## **Soal Tutorial : "Kak Pewe’s Rabbit House"**

![alt text](https://i.imgur.com/vdT6fB9.png "Gambar Rabbit House")

------
**WARNING** Untuk soal tutorial ini, dilarang untuk memakai loop (for, while, etc.)

------

### **What's the story?**

Berkat bantuanmu dan Dek Depe pekan lalu, tugas Kak Pewe sebagai petugas survei Provinsi Tamfir telah terlaksana dengan baik. Sebagai ucapan terima kasih, Kak Pewe mengundang kamu dan Dek Depe untuk mengunjungi Rabbit House Provinsi Tamfir yang dikelola oleh Kak Pewe. “Rabbit House ini bukan hanya sebuah kafe untuk minum kopi, namun juga merupakan rumah yang dapat mempercepat perkembangbiakan kelinci!” kata Kak Pewe.

Rumah kelinci tersebut mempunyai beberapa peraturan:
1. Kak Pewe akan mengaktifkan rumah itu dengan memasukkan sebuah kelinci dengan nama.
2. Kelinci tersebut akan berkembang biak sekali, menghasilkan kelinci-kelinci yang merupakan setiap permutasi dari nama kelinci dewasa yang dihilangkan satu huruf.
3. Tiap kelinci baru akan langsung berkembang biak lagi sesuai aturan nomor 2.
4. Tiap kelinci akan berkembang biak sekali saja. Jika sudah berkembang biak, tidak dapat berkembang biak lagi. Kelinci baru akan terus berkembang biak hingga tidak ada kelinci baru yang dapat berkembang biak lagi (kelinci bernama satu huruf tidak dapat berkembang biak lagi). 

Contoh:
Andaikan Kak Pewe memasukkan sebuah kelinci bernama **PEWEW** ke dalam Rabbit House. Kelinci itu akan berkembang biak menghasilkan lima ekor kelinci, yaitu : **EWEW**, **PWEW**, **PEEW**, **PEWW**, dan **PEWE**. 
Keempat kelinci tersebut akan berkembang biak lagi. Kelinci bernama **EWEW** akan berkembang biak dan menghasilkan empat ekor kelinci: **WEW**, **EEW**, **EWW**, **EWE**. Hal ini akan terjadi terus hingga semua kelinci tidak dapat berkembang biak (jika kelinci memiliki nama dengan panjang 1 huruf, maka tidak dapat berkembang biak).

Dek Depe sangat penasaran, dan ingin tahu berapa total kelinci yang ada di Rabbit House setelah dimasukkan seekor kelinci. Dia meminta kamu sebagai temannya yang sudah belajar mengenai recursive method untuk mengimplementasikan sebuah program rekursif yang dapat menghitung berapa jumlah kelinci yang akan dihasilkan jika memasukkan seekor kelinci ke dalam Rabbit House.

### **Spesifikasi program**

Nama program kamu **wajib** RabbitHouse.java

Program kamu menerima dua baris input. Baris pertama berisi tipe mode yang diterima. Untuk soal wajib, baris pertama pasti **normal**. Baris kedua merupakan String nama kelinci. String nama kelinci tidak akan lebih dari **sepuluh huruf**.

Output adalah jumlah kelinci saat semua kelinci selesai berkembang biak.

Contoh masukan 1:

>normal PEWEW 

Contoh keluaran 1:

>206 

Penjelasan:

Awalnya ada satu kelinci bernama PEWEW. Kelinci PEWEW menghasilkan 5 kelinci.  **(1 X 5 = 5)**  
Setiap kelinci dari 5 kelinci hasil itu menghasilkan 4 kelinci. **(5 X 4 = 20)**  
Setiap kelinci dari 20 kelinci hasil itu menghasilkan 3 kelinci. **(20 x 3 = 60)**  
Setiap kelinci dari 60 kelinci menghasilkan 2 kelinci. **(60 x 2 = 120)**  

Sehingga 120 + 60 + 20 + 5 + 1 (si Pewew) = 206

Contoh masukan 2:

>normal A

Contoh keluaran 2:

>1

## **Soal Bonus : "Palindrome Problem"**

### **What's the story?**

Kamu telah berhasil membuat program yang dapat menghitung jumlah kelinci di Rabbit House. Namun, Kak Pewe menceritakan mengenai sebuah penyakit langka pada kelinci, yakni penyakit Palindromitis. Penyakit ini adalah penyakit genetik. Artinya semua keturunan seekor kelinci Palindromitis akan memiliki penyakit tersebut juga.

 Jika nama kelinci yang terkena Palindromitis merupakan palindrom, maka kelinci tersebut akan mati. Palindrom adalah sebuah kata yang sama jika dibaca dari depan maupun belakang, seperti “ADA” atau “MAKAM”.
Tugas kamu sekarang adalah menambahkan kondisi pada program kamu diatas agar memenuhi kondisi jika kelinci memiliki penyakit Palindromitis.

Contoh:
Kak Pewe memasukkan sebuah kelinci dengan Palindromitis bernama **PEWEW** ke dalam Rabbit House. Karena **PEWEW** bukan palindrom, kelinci itu akan berkembang biak menghasilkan lima ekor kelinci, yaitu : **EWEW**, **PWEW**, **PEEW**, **PEWW**, dan **PEWE**. 
Nama keempat kelinci tersebut bukan palindrom, maka keempat kelinci tersebut akan berkembang biak lagi. Kelinci bernama **EWEW** akan berkembang biak dan menghasilkan empat ekor kelinci: **WEW**, **EEW**, **EWW**, **EWE**.
**WEW** dan **EWE** merupakan palindrom, maka kedua kelinci tersebut akan mati. **EEW** dan **EWW** bukan palindrom, sehingga kedua kelinci tersebut hidup dan akan berkembang biak

### **Spesifikasi program**

Jika kamu ingat, program kamu menerima dua baris input : tipe mode dan nama kelinci.

Jika kamu memasukan *palindrom* ke baris pertama, program kamu harus meng-apply aturan palindrom.

Contoh masukan *palindrom* 1:

> palindrom PEWEW

Contoh keluaran *palindrom* 1:

> 62

Contoh masukan *palindrom* 2:

> palindrom A

Contoh keluaran *palindrom* 2:

> 0

## Checklist
Isi kurung siku komponen dengan x untuk menceklis komponen.
### Komponen Wajib | 100 Poin
- [ ] **Meminta masukan dari user**
- [ ] **Validasi masukan**
- [ ] **Membuat fungsi rekursif untuk menghitung jumlah kelinci**
- [ ] **Memanggil fungsi tersebut di method main, dan mengeluarkan hasil di console**

### Komponen Bonus | 10 Poin
- [ ] **Membuat kondisi untuk nama kelinci yang palindrom**
- [ ] **Mengatur agar fungsi dijalankan jika input menerima String "palindrom" sebelum nama kelinci**

-----
### **Woah, apa ini !?**

Ketika kalian meng-push hasil kerja kalian, kalian akan sadar bahwa ada logo cross merah atau centang hijau di samping hasil kerja kalian.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

Kalian mungkin memperhatikan bahwa kita mulai memakai sistem git sejak semester 2, mengikuti kakak angkatan kalian yang baru mulai memakai sistem git sejak semester 3. Salah satu guna dari menggunakan git adalah kita bisa menggunakan fitur Continuos Integration?

Apa itu Continuous Integration? Continuos Integration adalah konsep di mana ketika kalian push, hasil push kalian langsung di build (compile) dan di test (uji langsung). Jika gagal, kalian akan diberitahu.

Bagian Build baru akan dijelaskan di mata kuliah Advanced Programming. Kalian hanya perlu mengetahui bagian test.

Sistem yang digunakan untuk mengetest di Java bernama JUnit. Kita bisa menggunakan framework JUnit untuk mengetes secara langsung (tanpa harus print di command line). Untuk sekarang, kalian tidak perlu tahu cara kerja JUnit.

Kamu dapat memeriksa hasil kerja Junit di tab Commit. Tekan logo centang hijau atau cross merah untuk memeriksa detail lebih lanjut.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

Ketika kamu menekan logo tersebut, kamu akan memeriksa rangkuman dari tes tersebut yang memiliki dua lingkaran.

Jika lingkaran pertama cross, maka program kamu gagal karena compile error.
Jika lingkaran pertama centang hijau tetapi lingkaran kedua cross, maka program kamu tidak akurat.
Jika kedua lingkaran centang, berati program kamu sudah baik.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

Kamu dapat menekan tombol cross merah atau centang hijau untuk melihat hasil lebih lanjut. Sebagai contoh, jika kalain mendapat cross merah di lingkaran kedua, kamu dapat menemkan cross merah kedua untuk melihat test case mana program kalian tidak akurat.
