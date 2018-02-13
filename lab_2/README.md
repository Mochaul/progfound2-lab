# **Tutorial 2: Basic Concepts of Java Programming (Tutorial Problem)**

Programming Foundations 2 -  | Faculty of Computer Science, University of Indonesia, Even Semester 2017/2018

**Created by AGA | IA**

* * *

In the previous tutorial, you have learned about some of the syntax differences in Java and Python programming. You have also learned about Git, a version control system. Now, you will learn more about the programming concepts in Java programming language.

## **Learning Objectives**
1. Understand the concept of **data type** in Java (primitive data type, reference data type, and casting).
2. Understand the **control flow** in Java (conditionals, iteratives, branching statements).
3. Understand the basic concept of **String** and String operation.
4. Understand the concepts of **_Input_ and _Output_** in Java (Scanner, System.out, parsing).


### **Before You Start...**
1. Do a `git pull upstream master` by using the Command Prompt at your local repository folder.
2. You can implement the second java tutorial source code in folder `ddp-lab/tutorial-2/main/java`.
3. Implement your code accordingly to what the lab questions asked you to do.
4. After you finish implementing your code, add, commit, then push your code.
5. Done.

## **Tutorial Materials**
### **Data Type**
Data type is what type of value can be assigned to a variable, and what operations can be applied to that variable. Operations that can be applied to a variable can be mathematical operations, relationships, and logic.
Unlike the Python language, in Java language, we have to explicitly declare variable data types to be initiated.

**Python**
```python
iniString = “DDP 2”
iniInt = 2018
iniFloat = 4.4
```

**Java**
```java
String iniString = “DDP 2”;
int iniInt = 2018;
float iniFloat = 4.4;
```

In general, every programming language has 3 data types:
1. **Primitive Data Types**

	Primitive Data Type is a data type that only has one value at maximum.
	![Primitive Data Types](https://only4techies.files.wordpress.com/2009/10/3.jpg)

	In Java programming language you can do type casting, that is to assign value of data type of a variable with different data type. There are two types of casting, ie
	- **Widening** (has already been done implicitly ):
		```java
		int anInt = 18;
		long aLong = anInt;
		float aFloat = aLong;

		// results for type casting
		// anInt = 18
		// aLong = 18
		// aFloat = 18.0
		```
	- **Narrowing** (should be explicitly defined):
		```java
		double aDouble = 18.1;
		long aLong = (long) aDouble;
		int anInt = (int) aLong;

		// results for type casting
		// aDouble = 18.1
		// aLong = 18
		// anInt = 18
		```

2. **Derived Data Types**

	Derived Data Types is a data type that can be parsed. In the Java programming language, there are parsing techniques. Parsing technique is a technique for converting non primitive data types into primitive data types, and vice versa. Where the parsed results are assigned to other variables.
	```java
	// to assign var numbers with parsed results
	// string to integer var stringNumber
	String stringNumber = "2018";
	int number = Integer.parseInt(stringNumber);
	```

3. **User Defined Data Types**

	User Defined Data Type is a self-defined data type.

### **Control Flow**
In general, the computer will execute the code sequentially from the top row down. The command in the programming language to change the order of program execution as needed is named as Control Flow. In general, the programming language there are three types of control flow orders are:

#### 1. **Decision Making**
You must have understood the concept and syntax decision making in the Python programming language. Compared with the Python programming language, the decision making on the Java programming language differs only in terms of syntax.
**Python**
```python
if (score >= 80):
	print("Score A")
elif (score >= 60 and score < 80):
	print("Score B")
else:
	print("Score C")
```

**Java**
```java
if (score >= 80){
	System.out.println("Score A");
} else if (score >= 60 && score < 80) {
	System.out.println("Score B");
} else {
	System.out.println("Score C");
}
```

#### 2. **Looping**
The concept of looping also exist in the Java programming language. Looping in java are for loop, for each loop, do while loop, and while loop.

- **While**

	Python:
	```pyton
	i = 20;
	while (i>0):
	print(i)
	i = i-1
	```

	Java:
	```java
	int i = 20;
	while (i>0) {
		System.out.print(i);
		i--;
	}
	```

- **For**

	Python:
	```python
	for x in range(20):
		print(i);
	```

	Java:
	```java
	for (int i=0; i<20; i++) {
		System.out.print(i);
	}
	```

- **Do While**

	Looping Do While is not in Python. Here is an example of its Java code:
	```java
	do {
		System.out.println("Hello");
	} while (true);
	```

#### 3. **Branching Statement**
There are some very useful statements for branching on loops: statement break, continue, and return.
- ** break ** - is used to stop the loop

	**Contoh Output:**
	```
	0
	1
	2
	```

	**Contoh Kode Python:**
	```python
	for i in range(4):
		if i == 3:
			break
	print(i)
	```

	**Contoh Kode Java:**
	```java
	int[ ] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 3) {
			break;
		}
		System.out.println(i);
	}
	```

- **continue** - is used to skip an iteration

	**Contoh Output:**
	```
	0
	2
	3
	```

	**Contoh Kode Python:**
	```python
	for i in range(3):
		if i == 1:
			continue
	print(i)
	```

	**Contoh Kode Java:**
	```java
	int[ ] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 1) {
			continue;
		}
		System.out.println(i);
	}
	```

- **return** - is used to return the value
	**Contoh Output:**
	```
	2
	```

	**Contoh Kode Python:**
	```python
	def returnNumber(number):
			return number
	print(returnNumber(2))
	```

	**Contoh Kode Java:**
	```java
	public static int returnNumber(int number) {
		return number;
	}
	public static void main(String[ ] args) {
		System.out.println(returnNumber);
	}
	```

### **String**
Like Python, non-numeric sentences are String data types. String is a data type ** reference ** and is ** immutable ** (can not replace the contents of the same object, must create a new object). The following is a comparison example of using String:

**Python**
```python
message = "DDP2"
messageSmall = "saya usep"

messageCut = message[:3]
messageBig = MessageSmall.upper()
size = len (messageSmall)
letter = messageSmall [1]

print(messageCut)
print(messageBig)
print(size)
print(letter)
```

Output program di atas:
```python
DDP
SAYA USEP
9
a
```

**Java**
```java
String message = “DDP2”;
String messageSmall = “saya usep”;

String messageCut = message.substring(0,3);
String messageBig = messageSmall.toUpperCase();
int size = messageSmall.length();
char letter = messageSmall.charAt(1);

System.out.println(messageCut);
System.out.println(messageBig);
System.out.println(size);
System.out.println(letter);
System.out.println(5 + 3 + ““ + 53);
```

Output program di atas:
```java
DDP
SAYA USEP
9
a
853
```

### **Simple Input and Output **
In general, each program requires user input, and returns it back to the desired output by the user. In the Java programming language, there are two system variables that work for Input / Output, ie ** System.in ** as ** input **, and ** System.out ** as ** output **. How to use it is as follows:
#### 1. **Output**
The output in the Java command-line is actually very easy to use, we can use some methods in System.out, like ** example ** below:

```java
String cowName = “Cang”;
float cowWeight = 1532.3;

// println -> print that end with new line
System.out.println(“Nama: “);
System.out.println(cowName);
// print -> print that end without new line
System.out.print(“Berat: “);
System.out.print(cowWeight);
```

**Keluaran program**:
```java
Nama:
Cang
Berat: 1532.3
```

#### 2. **Input**
Input on Java requires a separate input reader object to read System.in. In DDP2, you will use the Scanner object. Here is an ** example ** of use:

```java
// Initialize the Scanner object and save it in a variable
Scanner input = new Scanner(System.in);

String name = input.nextLine();
Call string1 = input.next();
String call2 = input.next();

// Close the Scanner object once it is finished (best practice)
input.close ();
```

If the user types like this in the console:
```java
Muhammad Abdurrahman
Abd Aab
```

Maka **isi variabel** setelah program dijalankan adalah:
> - `nama`  →  `“Muhammad Abdurrahman”`
> - `panggilan1`  →  `“Abd”`
> - `panggilan2`  →  `“Aab”`

#### 3. **Change the String to a number (primitive type) and number to String**
Just like Python, in the Java programming language we can also convert from ** String ** to the format of numbers in the form of ** primitive types ** such as int, float, etc..
- **Integer.parseInt()**, to change **String → int**
- **Byte.parseByte()**, to change **String → byte**
- **Short.parseShort()**, to change **String → short**
- **Long.parseLong()**, to change **String → long**
- **Float.parseFloat()**, to change **String → float**
- **Double.parseDouble()**, to change **String → double**
- **Boolean.parseBoolean()**, to change **String → boolean**
- **String.valueOf()**, to change **tipe primitif → String**

**Python**
```python
number = “553”
numberInt = int(number)
numberFloat = float(number)
number2 = str(numberFloat)
```

**Java**
```java
String number = “553”
int numberInt = Integer.parseInt(number);
float numberFloat = Float.parseFloat(number);
String number2 = String.valueOf(numberFloat);
```

**Fill in variable** after program is executed:
> - `numberInt`  →  `553`
> - `numberFloat`  →  `553.0`
> - `number2`  →  `“553.0”`

## **Tutorial: "Census of Slums"**
### **What's the story?**
Kak Pewe is a field survey officer from the Tamfir Provincial Population Department. Currently, the Tamfir Provincial Population Service will carry out data collection (which is often referred to by the census) as the special population in slum areas in Tamfir province. This census needs to be done to overcome the problems of hygiene and environmental health that are often complained of by the megapolitan environment such as the province of Tamfir.

Of course Kak Pewe is very worried about the weight of this work, which he must complete within three days, before the Central Government sends aid to tidy up the existing slums and prepare for relocation for the population. Well... Kak Pewe knows that his sister, Dek Depe has many friends who are now studying at Fasilkom UI.

Therefore, Kak Pewe sought the help of her sister, Dek Depe, to find her friends to do this task and you are the right person. One day, Dek Depe visits Fasilkom UI, and gives you a simple letter with its attachment:

> "O my friend, I want to ask your help to create a program that can print the population data after it is entered. Please help me, my brother really need it to improve the environment of the Tamfir province. All the provisions of the program to be made are attached, Thanks :) "

### **A little trigger?**
Before you do this tutorial, it's good to read the explanation of the material given earlier, then answer the following questions as "warm up" before doing the tutorial: D

> **Remember!**
> - How do we create a program that can receive input from the user?
> - How to change the input input in the form of a String into a certain data type?
> - Name the data types you know! Describe the usage of that data type!
> - What is a 'static' keyword? Explain what is meant by 'static method'!
> - Mention and describe the types of loops in the java programming language!
> - How do I create a program to print output?

### **What you need to do**
- [ ] **Request input from user **
- [ ] Name of the Head of the Family (sentence, can be more than 1 word).
- [ ] Home Address (sentence, can be more than 1 word).
- [ ] Length, Width, Height (integer, cm unit, guaranteed ≤ 250 cm).
- [ ] Weight (real number, unit kg, guaranteed ≤ 150 kg).
- [ ] Number of Family Members (integer, guaranteed ≤20).
- [ ] Date of Birth (DD-MM-YYYY format, 1000 <year <2018, guaranteed to be true).
- [ ] Additional Note (sentence, can be more than 1 word).
- [ ] Number of Data Prints (integer, guaranteed ≤ 99).
- [ ] Make sure the data type used by each input variable is the most efficient (the smallest data type that fits the needs).
- [ ] Create a good input requests user interface (we recommend using sample formats, but can adapt to your creativity).

- [ ] ** Calculate the weight ratio per volume **
- [ ] Use the formula: (Weight (kg)) / (Length (m) * Width (m) * Height (m)).
- [ ] Make sure you have adjusted input unit from cm to m when counting.
- [ ] Make sure you use the correct data type when calculating.
- [ ] The final data type of the calculation is an integer (note that the data type should be as efficient as possible → the smallest data type that fits the needs).

- [ ] ** Print data according to the format specified **
- [ ] Do looping as many as the number of prints.
- [ ] At each iteration, there is an input to request the recipient's name, then print the family data. Use the following format: (input in bold)
<pre> Printing [number] from [Number of Prints] to: <b> [Data Recipient] </ b>
DATA READY PRINTED FOR [DATA RECEIVER (UPPERCASE)]
-----------------
[Name of Family Head] - [Home Address]
Born on [Date of Birth]
Ratio Weight Per Volume = [Ratio] kg / m ^ 3
Note: [Note]
</ pre>
- [ ] If there is no record, replace the `Note: [Note]` to:
<pre> No additional notes </ pre>

### **Contoh Input dan Output**
Berikut ini adalah contoh interaksi program (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>Butterfield</b>
Alamat Rumah                   : <b>RSE</b>
Panjang Tubuh (cm)             : <b>30</b>
Lebar Tubuh (cm)               : <b>60</b>
Tinggi Tubuh (cm)              : <b>170</b>
Berat Tubuh (kg)               : <b>75</b>
Jumlah Anggota Keluarga        : <b>1</b>
Tanggal Lahir                  : <b>22-01-2000</b>
Catatan Tambahan               : <b>Belum berkeluarga, orang kaya</b>
Jumlah Cetakan Data            : <b>3</b>

Pencetakan 1 dari 3 untuk: <b>Arsip pemerintah provinsi Tamfir</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH PROVINSI TAMFIR
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya

Pencetakan 2 dari 3 untuk: <b>Badan Kesehatan Lingkungan Nasional</b>
DATA SIAP DICETAK UNTUK BADAN KESEHATAN LINGKUNGAN NASIONAL
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya

Pencetakan 3 dari 3 untuk: <b>gubernur provinsi Tamfir</b>
DATA SIAP DICETAK UNTUK GUBERNUR PROVINSI TAMFIR
--------------------
Butterfield - RSE
Lahir pada tanggal 22-01-2000
Rasio Berat Per Volume     = 245 kg/m^3
Catatan: Belum berkeluarga, orang kaya
</pre>

Berikut ini adalah contoh lain interaksi program yang mungkin terjadi  (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>master Shifu</b>
Alamat Rumah                   : <b>Ninja</b>
Panjang Tubuh (cm)             : <b>36</b>
Lebar Tubuh (cm)               : <b>71</b>
Tinggi Tubuh (cm)              : <b>189</b>
Berat Tubuh (kg)               : <b>68.5</b>
Jumlah Anggota Keluarga        : <b>7</b>
Tanggal Lahir                  : <b>12-03-1971</b>
Catatan Tambahan               : <b></b>
Jumlah Cetakan Data            : <b>2</b>

Pencetakan 1 dari 2 untuk: <b>komunitas lingkungan hidup Fasilkom</b>
DATA SIAP DICETAK UNTUK KOMUNITAS LINGKUNGAN HIDUP FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

Pencetakan 2 dari 2 untuk: <b>Arsip pemerintah kabupaten Fasilkom</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH KABUPATEN FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan
</pre>

### **Any templates?**
Jadi... ternyata Dek Depe punya teman yang bersedia untuk mempermudah kamu dalam menyelesaikan pekerjaan ini, namun karena ia sibuk, ia hanya mampu membuat **template**nya saja. **Template** terdapat pada `/lab_2/src/main/java/SistemSensus.java`.

Bagaimana cara menggunakannya? Langsung modifikasi template tersebut, isi dengan kode-kode jawaban kalian :) Panduan lebih lanjutnya sudah ada di dalam kode templatenya ya!

## **Soal Bonus: "Rekomendasi Apartemen"**
### **What's the story?**
Berkat bantuanmu, Kak Pewe berhasil melaksanakan sensus terhadap slums di Provinsi Tamfir tepat waktu. Setelah dilakukan penataan lingkungan selama satu bulan, ternyata tidak semua orang bisa menempati daerah tersebut, sehingga ada yang perlu direlokasi. Mak Dis selaku kepala Dinas Perumahan Rakyat Provinsi Tamfir telah memberikan rekomendasi tiga apartemen yang akan dijadikan tempat relokasi, beserta ketentuan dalam menentukan tempat relokasi. Kak Pewe diminta untuk mendata ulang terhadap orang-orang yang memenuhi prasyarat untuk dapat direlokasi. Dan ia tentu meminta bantuan adiknya, Dek Depe, sekali lagi.

Oleh karena itu, Dek Depe juga meminta bantuanmu sekali lagi untuk melanjutkan program yang telah dibuat sebelumnya, lalu menambahkan fitur baru sesuai checklist berikut:

### **What you need to do**
- [ ] **Validasi masukan**

	Validasi dilakukan setelah pengguna selesai memasukkan semua masukan yang dibutuhkan. Jika masukan tidak sesuai dengan ketentuan di bawah maka:
	- [ ] Tampilkan message **langsung** saat user memasukkan input yang tidak valid (di luar batasan yang ditentukan):
		<pre>WARNING: Keluarga ini tidak perlu direlokasi!</pre>
	- [ ] Keluar dari program (hint: gunakan branching statement yang sesuai)
	Berikut ini adalah ketentuan masukan yang harus divalidasi:
		- [ ] 0 < **panjang tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **lebar tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **tinggi tubuh** ≤ 250 cm, merupakan bilangan **bulat**.
		- [ ] 0 < **berat tubuh** ≤ 150 kg, merupakan bilangan **riil**.
		- [ ] 0 < **jumlah anggota keluarga** ≤ 20, merupakan bilangan **bulat**.

- [ ] ***Generate* number pengenal keluarga**
	- [ ] Gunakan format: `[letter pertama nama kepala keluarga][Hasil kalkulasi]`.
	- [ ] Untuk kalkulasi, gunakan rumus:
		```
		((Panjang * Tinggi * Lebar) + Jumlah ASCII tiap letter nama) mod 10000.
		```

		**Contoh Kasus:**
		```java
		nama = “are NG”
		panjang = 71
		lebar = 26
		tinggi = 37
		```
		Maka **number keluarga** adalah: `a8795`.

- [ ] **Hitung anggaran makanan per tahun**
	- [ ] Gunakan rumus: `Rp 50000 * 365 * (jumlah anggota keluarga)`.
	- [ ] Pastikan kamu menggunakan tipe data yang tepat **saat menghitung**.
	- [ ] Tipe data akhir hasil perhitungan adalah **bilangan bulat** (perhatikan bahwa tipe data harus seefisien mungkin → tipe data terkecil yang pas dengan kebutuhan).

- [ ] **Hitung umur kepala keluarga**
	- [ ] Ambil tahun lahir dari tanggal lahir.
	- [ ] Gunakan rumus: **2018 - (tahun lahir)**.
	- [ ] Tipe data akhir hasil perhitungan adalah **bilangan bulat** (perhatikan bahwa tipe data harus seefisien mungkin → tipe data terkecil yang pas dengan kebutuhan).

- [ ] **Mengelompokkan keluarga ke apartemen**
	- [ ] Berikut ini adalah daftar apartemen beserta kriterianya:
		- > Nama: **PPMT**<br>
			> Kabupaten: **Rotunda**<br>
			> RANGE Anggaran Makanan/Tahun: **BEBAS**<br>
			> RANGE Umur Kepala Keluarga: **0** tahun s.d. **18** tahun
		- > Nama: **Teksas**<br>
			> Kabupaten: **Sastra**<br>
			> RANGE Anggaran Makanan/Tahun: Rp **0** s.d. Rp **100.000.000**<br>
			> RANGE Umur Kepala Keluarga: **19** tahun s.d. **1018** tahun
		- > Nama: **Mares**<br>
			> Kabupaten: **Margonda**<br>
			> RANGE Anggaran Makanan/Tahun: Rp **100.000.000** s.d. **TAK HINGGA**<br>
			> RANGE Umur Kepala Keluarga: **19** tahun s.d. **1018** tahun
- [ ] **Cetak rekomendasi sesuai dengan format yang ditentukan**
	<pre>
		REKOMENDASI APARTEMEN
		--------------------
		MENGETAHUI: Identitas keluarga: < Nama Kepala Keluarga > - < number >
		MENIMBANG:  Anggaran makanan tahunan: Rp < Anggaran >
					Umur kepala keluarga: < Umur > tahun
		MEMUTUSKAN: keluarga < Nama Kepala Keluarga > akan ditempatkan di:
		< Nama Tempat >, kabupaten < Nama Kabupaten >
	</pre>

> **Hint**
> - Gunakan fungsi .split() untuk memisahkan tanggal, bulan, dan tahun lahir.
> - Gunakan casting untuk memasukkan ASCII letter dalam rumus.

### **Contoh Input dan Output**
Berikut ini adalah contoh interaksi program yang mungkin terjadi (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>master Shifu</b>
Alamat Rumah                   : <b>Ninja</b>
Panjang Tubuh (cm)             : <b>36</b>
Lebar Tubuh (cm)               : <b>71</b>
Tinggi Tubuh (cm)              : <b>189</b>
Berat Tubuh (kg)               : <b>68.5</b>
Jumlah Anggota Keluarga        : <b>7</b>
Tanggal Lahir                  : <b>12-03-1971</b>
Catatan Tambahan               : <b></b>
Jumlah Cetakan Data            : <b>2</b>

Pencetakan 1 dari 2 untuk: <b>komunitas lingkungan hidup Fasilkom</b>
DATA SIAP DICETAK UNTUK KOMUNITAS LINGKUNGAN HIDUP FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

Pencetakan 2 dari 2 untuk: <b>Arsip pemerintah kabupaten Fasilkom</b>
DATA SIAP DICETAK UNTUK ARSIP PEMERINTAH KABUPATEN FASILKOM
--------------------
master Shifu - Ninja
Lahir pada tanggal 12-03-1971
Rasio Berat Per Volume     = 141 kg/m^3
Tidak ada catatan tambahan

REKOMENDASI APARTEMEN
--------------------
MENGETAHUI: Identitas keluarga: master Shifu - m4279
MENIMBANG:  Anggaran makanan tahunan: Rp 127750000
			Umur kepala keluarga: 47 tahun
MEMUTUSKAN: keluarga master Shifu akan ditempatkan di:
Mares, kabupaten Margonda
</pre>

Berikut ini adalah contoh jika masukan tidak memenuhi validasi (yang dicetak tebal adalah masukan):
<pre>PROGRAM PENCETAK DATA SENSUS
--------------------
Nama Kepala Keluarga           : <b>Esta</b>
Alamat Rumah                   : <b>Parbel</b>
Panjang Tubuh (cm)             : <b>45</b>
Lebar Tubuh (cm)               : <b>64</b>
Tinggi Tubuh (cm)              : <b>288</b>
WARNING: Keluarga ini tidak perlu direlokasi!
</pre>

## Checklist
Fill the brackets with 'x' for checklisting the component.
### Required Components | 100 Points
- [ ] **Ask the user for input**
- [ ] **Count the weight per volume ratio**
- [ ] **Print data according to the format**

### Bonus Components | 10 Points
- [ ] **Input validation**
- [ ] **Generate family identifier number**
- [ ] **Count the budget of food per year**
- [ ] **Count the age of the head of family**
- [ ] **Group families to apartment**
- [ ] **Print recommendation according to the determined format**