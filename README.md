# Book Manage 📚  

**Book Manage** adalah aplikasi berbasis Java Spring yang dirancang untuk memudahkan admin perpustakaan dalam mengelola proses peminjaman dan pengembalian buku. Aplikasi ini membantu memastikan pengelolaan buku menjadi lebih efisien dan terorganisir, dengan validasi yang ketat untuk memastikan buku dikembalikan tepat waktu.  

## Fitur Utama  
1. **Input Data Buku**:  
   - Menambahkan data buku ke sistem, termasuk:  
     - Judul Buku  
     - Nomor ISBN  (PRIMARY KEY)
     - Stok Buku  

2. **Input Data Peminjam**:  
   - Menyimpan data peminjam dengan informasi:  
     - Nomor KTP  (PRIMARY KEY)
     - Nama  
     - Email  

3. **Validasi Stok Buku**:  
   - Sistem memastikan bahwa peminjaman buku hanya dapat dilakukan jika stok buku mencukupi.  

4. **Validasi Peminjaman Buku**:  
   - Peminjam hanya bisa meminjam **satu buku** per transaksi.  
   - Peminjam tidak boleh meminjam buku jika mereka masih memiliki pinjaman aktif.  
   - Peminjaman dibatasi hingga maksimal **30 hari**.  

5. **Peminjaman dan Pengembalian Buku**:  
   - Admin dapat memonitor apakah buku yang dipinjam dikembalikan tepat waktu atau terlambat.  
   - Sistem menyediakan fitur untuk mencatat pengembalian buku.  

6. **Deadline Pengembalian Buku**:  
   - Peminjam dapat menentukan tenggat waktu pengembalian buku (maksimal 30 hari).  

## Teknologi yang Digunakan  
- **Backend**: Java Spring Framework  
- **Database**: MySQL  
