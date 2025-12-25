# Study Target Manager

Aplikasi **Study Target Manager** adalah aplikasi desktop berbasis **Java Swing** yang dibuat untuk memenuhi **Ujian Akhir Praktikum (UAP) Mata Kuliah Pemrograman Lanjut**.

Aplikasi ini digunakan untuk mengelola data target belajar dengan fitur **CRUD**, **GUI**, dan **penyimpanan data menggunakan file CSV**.

---

## Fitur Aplikasi

- Input data target belajar
- Menampilkan data target dalam tabel
- Edit data target
- Hapus data target
- Menandai target sebagai selesai
- Sorting data berdasarkan:
    - Deadline terdekat
    - Deadline terjauh
    - Status
- Pencarian (search) data target
- Penyimpanan data otomatis ke file CSV

---

## Teknologi yang Digunakan

- Java SE
- Java Swing (GUI)
- File I/O
- CSV sebagai media penyimpanan data

---

## Struktur Project

├── App.java
├── model
│ └── StudyTarget.java
├── utils
│ ├── DataStore.java
│ └── FileManager.java
└── view
├── MainFrame.java
├── InputTargetPanel.java
├── ListTargetPanel.java
└── HistoryPanel.java

yaml
Copy code

---

## Cara Menjalankan Program

1. Pastikan Java JDK 8 atau lebih baru sudah terinstal
2. Buka project menggunakan IDE (IntelliJ IDEA / NetBeans / Eclipse)
3. Jalankan file `App.java`
4. Aplikasi akan berjalan dalam bentuk GUI desktop

---

## Format Penyimpanan Data

Data disimpan dalam file `data.csv` dengan format:

Nama Tugas,Mata Kuliah,Deadline,Status

makefile
Copy code

Contoh:

UTS Pemrograman,Java,2025-06-10,Belum

yaml
Copy code

---

## Pengujian Program

- Input data dengan format benar → berhasil disimpan
- Input data tidak valid → ditolak
- Data tersimpan dan dimuat kembali saat aplikasi dijalankan
- Fitur sorting dan pencarian berjalan dengan baik

---

## Keterangan

Aplikasi ini dibuat sesuai dengan ketentuan dan kriteria pada **Modul UAP Pemrograman Lanjut**.