SQL> CREATE TABLESPACE ikhlasul06932
  2  DATAFILE 'E:\praktikumbasdatmdl1\ikhlasul_06932.dbf'
  3  SIZE 30M;
Tablespace created.
SQL> CREATE USER ikhlas_06932
  2  IDENTIFIED BY ikhlas
  3  DEFAULT TABLESPACE ikhlasul06932
  4  QUOTA 30M ON ikhlasul06932;
User created.
SQL> GRANT ALL PRIVILEGES TO ikhlas_06932
  ;
Grant succeeded.

SQL> conn ikhlas_06932/ikhlas
Connected.


SQL> create table karyawan_06932
  2  (
  3  Id_karyawan INTEGER not null,
  4  Nama_karyawan VARCHAR2(30),
  5  Alamat VARCHAR2(100),
  6  No_tlp NUMBER(12),
  7  Gaji INTEGER,
  8  constraint PK_karyawan primary key(Id_karyawan)
  9  );
Table created.

SQL> craete table barang_06932
SP2-0734: unknown command beginning "craete tab..." - rest of line ignored.
SQL> create table barang_06932
  2  (
  3  Id_barang INTEGER not null,
  4  Nama VARCHAR2(30),
  5  constraint PK_barang primary key (Id_barang)
  6  );
Table created.
SQL> alter table barang_06932 add(Harga NUMBER(9));
Table altered.
SQL> alter table barang_06932 add(Stok NUMBER(9));
Table altered.

SQL> create table dagangan_06932
  2  (
  3  Id_dagangan INTEGER not null,
  4  Id_karyawan INTEGER,
  5  Id_barang INTEGER,
  6  Tanggal_dagangan DATE,
  7  Jumlah NUMBER(10),
  8  Total NUMBER(10),
  9  constraint PK_dagangan primary key (Id_dagangan)
 10  );

Table created.
SQL> alter table dagangan_06932
  2  add constraint FK_Id_karyawan FOREIGN KEY (Id_karyawan)
  3  references karyawan_06932(Id_karyawan)
  4  add constraint FK_Id_barang FOREIGN KEY (Id_barang)
  5  references barang_06932(Id_barang);

Table altered.
SQL> create sequence id_barang
  2  minvalue 1
  3  maxvalue 999
  4  start with 1
  5  increment by 1
  6  cache 20;

Sequence created.
SQL> insert into barang_06932
  2  (id_barang, Nama) values
  3  (id_barang.nextval, 'piring');

1 row created.
SQL> select * from barang_06932;

 ID_BARANG NAMA
---------- ------------------------------
         1 piring

SQL> alter table barang_06932 rename column Nama to 06932_Nama;
alter table barang_06932 rename column Nama to 06932_Nama
                                               *
ERROR at line 1:
ORA-00904: : invalid identifier

SQL> ALTER TABLE barang_06932
  2  ADD CONSTRAINT Nama_unique
  3  UNIQUE (Nama);

Table altered.

SQL> alter table karyawan_06932 modify(No_tlp char(12));

Table altered.

SQL> insert into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (1, 'bima', 'sidoarjo', 123456789, '800000');

1 row created.

SQL> insert into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (2, 'daffa', 'surabaya', 234567891, '900000');

1 row created.

SQL> insert all
  2  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (3, 'zen', 'surabaya', 345678912, '1000000')
  3  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (4, 'nicol', 'surabaya', 456789123, '2000000')
  4  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (5, 'adi', 'rungkut', 567891234, '2500000')
  5  select 1 from dual;

3 rows created.
SQL> insert into barang_06932 (id_barang, Nama, Harga, stok) values (1, 'piring', '5000', '45');

1 row created.

SQL> insert into barang_06932 (id_barang, Nama, Harga, stok) values (2, 'baju', '35000', '40');

1 row created.

SQL> insert all
  2  into barang_06932 (id_barang, Nama, Harga, stok) values (3, 'gelas', '3000', '100')
  3  into barang_06932 (id_barang, Nama, Harga, stok) values (4, 'tas', '50000', '20')
  4  into barang_06932 (id_barang, Nama, Harga, stok) values (5, 'celana', '100000', '60')
  5  select 1 from dual;

3 rows created.
SQL> insert into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (1, 1, 1, to_date('01/05/2019','dd/mm/yyyy'),'2','10000');

1 row created.
SQL> insert into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (2, 2, 2, to_date('01/06/2019','dd/mm/yyyy'),'2','70000');

1 row created.
SQL> insert all
  2  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (3, 3, 3, to_date('01/07/2019','dd/mm/yyyy'),'3','9000')
  3  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (4, 4, 4, to_date('01/04/2019','dd/mm/yyyy'),'1','50000')
  4  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (5, 5, 5, to_date('01/08/2019','dd/mm/yyyy'),'2','200000')
  5  select 1 from dual;

3 rows created.
SQL> insert into karyawan_06932 values (id_karyawan.NEXTVAL, 'cholis','ngagel','678912345','1000000');

1 row created.
SQL> insert into barang_06932 values (id_barang.NEXTVAL, 'sendok','1500','150');

1 row created.
SQL> insert into dagangan_06932 values (id_dagangan.NEXTVAL, 6, 6, to_date('02/04/2019','dd/mm/yyyy'), 1, 1500);
1 row created.

SQL> insert into dagangan_06932 values (id_dagangan.NEXTVAL, 5, 6, to_date('02/05/2019','dd/mm/yyyy'), 2, 3000);
1 row created.

SQL> insert into dagangan_06932 values (id_dagangan.NEXTVAL, 5, 4, to_date('02/07/2019','dd/mm/yyyy'), 2, 100000);
1 row created.

SQL> insert into dagangan_06932 values (id_dagangan.NEXTVAL, 1, 6, to_date('02/11/2019','dd/mm/yyyy'), 5, 7500);
1 row created.

SQL> insert into dagangan_06932 values (id_dagangan.NEXTVAL, 2, 3, to_date('02/12/2019','dd/mm/yyyy'), 3, 9000);
1 row created.
SQL> update karyawan_06932
  2  SET gaji = gaji * 2;

6 rows updated.
SQL> update karyawan_06932 SET gaji = 1200000 WHERE id_karyawan = 1;
1 row updated.

SQL> update karyawan_06932 SET gaji = 1300000 WHERE id_karyawan = 2;
1 row updated.

SQL> update barang_06932 SET harga = 10000 WHERE id_barang = 1;
1 row updated.

SQL> update barang_06932 SET harga = 20000 WHERE id_barang = 2;
1 row updated.

SQL> update karyawan_06932 SET gaji = 1300000 WHERE id_karyawan = 3;

1 row updated.
SQL> UPDATE karyawan_06932 SET nama_karyawan = 'kurnia' WHERE nama_karyawan LIKE 'b%';
1 row updated.

SQL> UPDATE karyawan_06932 SET nama_karyawan = 'rahmatul' WHERE nama_karyawan LIKE 'd%';
1 row updated.

SQL> UPDATE karyawan_06932 SET nama_karyawan = 'mustofa' WHERE nama_karyawan LIKE 'z%';
1 row updated.

SQL> UPDATE karyawan_06932 SET nama_karyawan = 'sumardi' WHERE nama_karyawan LIKE 'n%';
1 row updated.

SQL> UPDATE karyawan_06932 SET nama_karyawan = 'nuril' WHERE nama_karyawan LIKE 'a%';
1 row updated.
SQL> UPDATE dagangan_06932 SET jumlah = 1, total = 5000 WHERE (id_dagangan = 1 OR id_karyawan = 1) AND id_barang = 1;
1 row updated.

SQL> UPDATE dagangan_06932 SET jumlah = 1, total = 35000 WHERE (id_dagangan = 2 OR id_karyawan = 2) AND id_barang = 2;
1 row updated.

SQL> UPDATE dagangan_06932 SET jumlah = 2, total = 3000 WHERE (id_dagangan = 6 OR id_karyawan = 6) AND id_barang = 6;
1 row updated.

SQL> UPDATE dagangan_06932 SET jumlah = 2, total = 100000 WHERE (id_dagangan = 4 OR id_karyawan = 4) AND id_barang = 4;
1 row updated.

SQL> UPDATE dagangan_06932 SET jumlah = 2, total = 6000 WHERE (id_dagangan = 10 OR id_karyawan = 2) AND id_barang = 3;
1 row updated.
SQL> DELETE FROM dagangan_06932 WHERE total = 3000 AND tanggal_dagangan LIKE '%MAY%';
1 row deleted.

SQL> DELETE FROM dagangan_06932 WHERE id_dagangan = 9 OR jumlah = 5;
1 row deleted.

SQL> DELETE FROM dagangan_06932 WHERE id_karyawan = 4 AND  total = 100000;
1 row deleted.
SQL> SAVEPOINT savepoint_1;

Savepoint created.

UPDATE dagangan_06932 SET total = 10000, jumlah = 2 WHERE id_dagangan = 1;

1 row updated.
SQL> COMMIT;

Commit complete.
ROLLBACK TO savepoint_1;
ROLLBACK TO savepoint_1
*
ERROR at line 1:
ORA-01086: savepoint 'SAVEPOINT_1' never established in this session or is
invalid
SQL> SELECT * FROM barang_06932
  2  ORDER BY harga DESC;
SQL> SELECT nama
  2  FROM barang_06932
  3  GROUP BY nama;
SQL> insert all
  2  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (7, 'kevin', 'surabaya', 789123456, '1000000')
  3  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (8, 'zedar', 'pluto', 891234567, '1000000')
  4  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (9, 'sumi', 'jupiter', 912345678, '1000000')
  5  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (10, 'fajar', 'matahari', 912545678, '1000000')
  6  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (11, 'jajang', 'tunjungan', 912545678, '1000000')
  7  select 1 from dual;

5 rows created.
SQL> insert all
  2  into barang_06932 (id_barang, Nama, Harga, stok) values (7, 'kresek', '300', '100')
  3  into barang_06932 (id_barang, Nama, Harga, stok) values (8, 'kertas', '400', '200')
  4  into barang_06932 (id_barang, Nama, Harga, stok) values (9, 'kaleng', '500', '250')
  5  into barang_06932 (id_barang, Nama, Harga, stok) values (10, 'amplop', '150', '450')
  6  into barang_06932 (id_barang, Nama, Harga, stok) values (11, 'sapu', '20000', '50')
  7  select 1 from dual;

5 rows created.
SQL> insert all
  2  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (11, 7, 7, to_date('01/07/2018','dd/mm/yyyy'),'2','600')
  3  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (12, 8, 8, to_date('02/07/2018','dd/mm/yyyy'),'3','1200')
  4  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (13, 9, 9, to_date('02/07/2015','dd/mm/yyyy'),'4','2000')
  5  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (14, 10, 10, to_date('02/08/2015','dd/mm/yyyy'),'3','450')
  6  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (15, 11, 11, to_date('02/09/2015','dd/mm/yyyy'),'5','100000')
  7  select 1 from dual;

5 rows created.
SQL> SELECT nama, MAX(harga) AS harga_tertinggi,
  2  MIN(harga) AS harga_terendah
  3  FROM barang_06932
  4  GROUP BY nama;
SQL> SELECT alamat, count(alamat) AS banyak_alamat
  2  FROM karyawan_06932 WHERE id_karyawan <= 10
  3  GROUP BY alamat;
SQL> select id_karyawan, sum(total) as total_harga
  2  from dagangan_06932 where id_karyawan like '5'
  3  group by id_karyawan;
SQL> select id_karyawan, sum(total) as total_harga, avg(total) as rata2_harga
  2  from dagangan_06932 where id_karyawan like '5'
  3  group by id_karyawan;


SQL> select
  2  id_dagangan, total
  3  from dagangan_06932
  4  where total = (select min(total)
  5  from dagangan_06932)
  6  or total = (select max(total)
  7  from dagangan_06932);

ID_DAGANGAN      TOTAL
----------- ----------
          5     200000
         14        450
SQL> select nama_karyawan as nama_karyawan,
  2  (SELECT COUNT(*) FROM dagangan_06932 WHERE dagangan_06932.id_karyawan = karyawan_06932.id_karyawan AND karyawan_06932.no_tlp IS NOT NULL) AS jumlah_barang
  3  from karyawan_06932;
SQL> SELECT nama_karyawan as nama_karyawan, (select sum(total)
  2  from dagangan_06932 where dagangan_06932.id_karyawan = karyawan_06932.id_karyawan) as total_harga
  3  from karyawan_06932 where id_karyawan = 5;
SQL> select nama_karyawan as nama_karyawan, (select avg(total)
  2  from dagangan_06932 where dagangan_06932.id_karyawan = karyawan_06932.id_karyawan) as rata2_transaksi
  3  from karyawan_06932 where id_karyawan = 5;
SQL> select nama
  2  from barang_06932
  3  where harga < (select avg(harga) from barang_06932)
  4  group by nama;
SQL> select id_dagangan, (select max(total)
  2  from dagangan_06932) as total_harga
  3  from dagangan_06932 where id_dagangan = (select id_dagangan
  4  from dagangan_06932 where total = (select max(total)
  5  from dagangan_06932));
SQL> select nama_karyawan from (select * from(select * from(select * from karyawan_06932) where gaji = '1000000') where alamat like'surabaya');SQL> insert all
  2  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (12, 'dani', 'matahari', 374657388, '1000000')
  3  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (13, 'rendi', 'kalimantan', 374657338, '2000000')
  4  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (14, 'zizi', 'jawa', 377657338, '1500000')
  5  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (15, 'edo', 'papua', 374657538, '1400000')
  6  into karyawan_06932 (Id_karyawan, Nama_karyawan, alamat, No_tlp, gaji) values (16, 'sukirman', 'rangkah', 377347338, '1600000')
  7  select 1 from dual;

5 rows created.
SQL> insert all
  2  into barang_06932 (id_barang, Nama, Harga, stok) values (12, 'asbes', '4000', '100')
  3  into barang_06932 (id_barang, Nama, Harga, stok) values (13, 'rumah', '1000000', '20')
  4  into barang_06932 (id_barang, Nama, Harga, stok) values (14, 'mobil', '200000', '30')
  5  into barang_06932 (id_barang, Nama, Harga, stok) values (15, 'sepeda', '100000', '45')
  6  into barang_06932 (id_barang, Nama, Harga, stok) values (16, 'laptop', '150000', '15')
  7  select 1 from dual;

5 rows created.
SQL> insert all
  2  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (16, 12, 12, to_date('01/07/1998','dd/mm/yyyy'),'2','8000')
  3  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (17, 13, 13, to_date('01/08/1998','dd/mm/yyyy'),'3','3000000')
  4  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (18, 14, 14, to_date('02/08/1998','dd/mm/yyyy'),'4','800000')
  5  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (19, 15, 15, to_date('02/09/1998','dd/mm/yyyy'),'2','200000')
  6  into dagangan_06932 (Id_dagangan, Id_karyawan, Id_barang, Tanggal_dagangan, Jumlah, Total) values (20, 16, 16, to_date('02/10/1998','dd/mm/yyyy'),'2','300000')
  7  select 1 from dual;
5 rows created.
SQL> select a.id_karyawan,b.id_dagangan
  2  from karyawan_06932 a join
  3  dagangan_06932 b
  4  on a.id_karyawan = b.id_karyawan
  5  where rownum <=20;
SQL> SELECT a.nama_karyawan, b.tanggal_dagangan, c.nama, (select count(*) from karyawan_06932) AS jumlah_pegawai
  2  FROM karyawan_06932 a
  3  join dagangan_06932 b ON a.id_karyawan = b.id_karyawan
  4  left join barang_06932 c ON b.id_barang = c.id_barang
  5  where rownum <=10;
SQL> select a.nama AS nama_barang,
  2  count (b.id_karyawan) AS jumlah_barang, c.nama_karyawan
  3  FROM barang_06932 a
  4  right join dagangan_06932 b
  5  ON a.id_barang = b.id_barang
  6  right join karyawan_06932 c
  7  ON b.id_karyawan = c.id_karyawan
  8  where not c.nama_karyawan like '%a' and not c.nama_karyawan like '%e'
  9  group by a.nama, c.nama_karyawan;
SQL> create view list_barang
  2  as select id_barang, nama, harga, stok
  3  from barang_06932;

View created.

SQL> insert into list_barang (id_barang, nama, harga, stok)
  2  values (99, 'asbak', 2500, 50);

1 row created.
SQL> select * from list_barang;
SQL> create view transaksi_karyawan
  2  as select a.id_karyawan,b.id_dagangan
  3  from karyawan_06932 a join
  4  dagangan_06932 b
  5  on a.id_karyawan = b.id_karyawan
  6  where rownum <=20;

View created.
SQL> create view tanggal_transaksi
  2  as SELECT a.nama_karyawan,
  3  b.tanggal_dagangan, c.nama, (select count(*) from karyawan_06932) AS jumlah_pegawai
  4  FROM karyawan_06932 a
  5  join dagangan_06932 b ON a.id_karyawan = b.id_karyawan
  6  left join barang_06932 c ON b.id_barang = c.id_barang
  7  where rownum <=10;

View created.
SQL> create view transaksi_barang
  2  as select a.nama AS nama_barang,
  3  count (b.id_karyawan) AS jumlah_barang, c.nama_karyawan
  4  FROM barang_06932 a
  5  right join dagangan_06932 b
  6  ON a.id_barang = b.id_barang
  7  right join karyawan_06932 c
  8  ON b.id_karyawan = c.id_karyawan
  9  where not c.nama_karyawan like '%a' and not c.nama_karyawan like '%e'
 10  group by a.nama, c.nama_karyawan;

View created.
SQL> insert into transaksi_karyawan(id_karyawan, id_dagangan)
  2  values (101, 102);
SQL> select * from user_updatable_columns;
package oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Koneksi { 
    private Connection connect;
    private Statement db;
      public Koneksi() {
        try {          Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ikhlas_06932",
                        "ikhlas");
            } catch (SQLException se) {
                System.out.println("Koneksi Database Gagal : " + se);}
        } catch (ClassNotFoundException err){
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + err);}
    }
public ResultSet getData(String sql) {
        try {
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }
public int manipulasiData(String sql) {
        try {
            db = connect.createStatement();
            return db.executeUpdate(sql);
        } catch (SQLException e) {
            return 0;
        }
    }

}
public void insert(String nama, int harga, int stok) {
        String sql = "INSERT INTO barang_06932 VALUES (id_barang.NEXTVAL, '" + nama + "', '" + harga
                + "', '" + stok + "')";
        this.koneksi.manipulasiData(sql);
    }
    
String sql = "SELECT * from barang_06932";
        ResultSet rs = this.koneksi.getData("SELECT id_barang, nama, harga, stok FROM barang_06932");
        while (rs.next()) {
            Barang barang = new Barang();            barang.setIdBarang(rs.getInt("id_barang"));          barang.setNama(rs.getString("nama"));
barang.setHarga(rs.getInt("harga"));
barang.setStok(rs.getInt("stok"));

Object[] temp = new Object[4];
temp[0] = barang.getIdBarang();
temp[1] = barang.getNama();
temp[2] = barang.getHarga();
temp[3] = barang.getStok();
dtmBarang.addRow(temp);}
        return dtmBarang; }    
public void update(String nama, int harga, int stok) {
        String sql = "UPDATE barang_06932 SET HARGA = '" + harga + "', STOK = '" + stok 
                + "' WHERE NAMA = '" + nama + "'";
        this.koneksi.manipulasiData(sql);
    }
public void delete(String nama) {
        String sql = "DELETE FROM barang_06932 WHERE nama = '" + nama + "'";
        this.koneksi.manipulasiData(sql);
    }
String sql = "SELECT a.id_dagangan, a.tanggal_dagangan, a.jumlah, a.total, "
+ "b.id_barang, b.nama, b.harga, b.stok, " + "c.id_karyawan, c.nama_karyawan, c.alamat, " + "c.no_tlp, c.gaji " + "FROM dagangan_06932 a "
+ "JOIN barang_06932 b ON a.id_barang = b.id_barang "+ "JOIN karyawan_06932 c ON a.id_karyawan = c.id_karyawan";
String sql = "SELECT * from barang_06932";

