﻿use master
go

create database DatVe
go
--drop database DatVe
use DatVe
go

create table NhanVien(
	MaNV nvarchar(20) not null PRIMARY KEY,
	TenNV NVARCHAR(20) NOT NULL,
	MatKhau nvarchar(20) not null,
	NgaySinh DATETIME NOT NULL,
	SDT nvarchar(12) not null,
	CCCD VARCHAR(15) NOT NULL,	
)
go

create table PhongChieu(
	MaPhongChieu nvarchar(20) not null primary key,
	TenPhongChieu nvarchar(20) not null,
	ViTri nvarchar(30) not  null,
	SucChua int not null
)
go

create table LoaiGhe(
	MaLoaiGhe int identity primary key,
	Gia DECIMAL CHECK(Gia >= 0) DEFAULT(0),
	TenLoaiGhe nvarchar(10) not null
)
go

create table LoaiPhim(
	MaLoaiPhim nvarchar(20) not null primary key,
	TenLoaiPhim nvarchar(20) not null,
)
go

create table Phim(
	MaPhim nvarchar(20) not null primary key,
	TenPhim nvarchar(50) not null,
	DaoDien nvarchar(30) not null,
	QuocGia nvarchar(30) not null,
	ThoiLuongPhim int not null,
	LinkPhim nvarchar(100),
	MaLoaiPhim nvarchar(20) not null,
	FOREIGN KEY (MaLoaiPhim) REFERENCES LoaiPhi m(MaLoaiPhim)
)
go

create table SuatChieu(
	MaSuatChieu nvarchar(20) not null primary key,
	NgayChieu date,
	GioChieu datetime,
	MaPhim nvarchar(20) REFERENCES Phim(MaPhim) ON DELETE SET NULL,
	MaPhongChieu nvarchar(20) REFERENCES PhongChieu(MaPhongChieu) ON DELETE SET NULL
)
go

CREATE TABLE HoaDon (
    MaHD NVARCHAR(20) not null PRIMARY KEY,
    MaNV NVARCHAR(20) REFERENCES NhanVien(MaNV) ON DELETE SET NULL,
    -- 0. đã đặt | 1. đã nhận | 2. đã thanh toán
    TrangThai INT,
    CONSTRAINT CK_TrangThai CHECK (TrangThai IN (0, 1, 2)),
    NgayLap DATETIME,
    GiaHoaDon DECIMAL CHECK (GiaHoaDon >= 0) DEFAULT(0)
)
go

CREATE TABLE Ve(
	MaVe nvarchar(20) not null primary key,
	MaSuatChieu nvarchar(20) REFERENCES SuatChieu(MaSuatChieu) ON DELETE SET NULL,
)
go

CREATE TABLE ChiTietVe(
	MaVe NVARCHAR(20),
    MaHD NVARCHAR(20),
    PRIMARY KEY (MaVe, MaHD),
    FOREIGN KEY (MaVe) REFERENCES Ve(MaVe),
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	SoLuongGhe INT,
    NgayGioDat DATETIME
)
go

--CREATE TABLE Ghe (
--    MaGhe NVARCHAR(20) PRIMARY KEY,
--    MaSuatChieu NVARCHAR(20),
--    MaVe NVARCHAR(20),
--    MaLoaiGhe int,
--	--0 chưa đặt
--	--1 đặt rồi
--    trangthai bit default 0,
--    FOREIGN KEY (MaSuatChieu) REFERENCES SuatChieu(MaSuatChieu),
--    FOREIGN KEY (MaVe) REFERENCES Ve(MaVe),
--    FOREIGN KEY (MaLoaiGhe) REFERENCES LoaiGhe(MaLoaiGhe)
--)
CREATE TABLE Ghe (
	MaGhe nvarchar(20) not null primary key,
	MaPhongChieu nvarchar(20),
	MaLoaiGhe int,
	FOREIGN KEY (MaPhongChieu) REFERENCES PhongChieu(MaPhongChieu),
    FOREIGN KEY (MaLoaiGhe) REFERENCES LoaiGhe(MaLoaiGhe)
)
go

CREATE TABLE TrangThaiGhe(
	MaGhe nvarchar(20),
	MaSuatChieu nvarchar(20),
	MaVe nvarchar(20),
	PRIMARY KEY (MaGhe, MaSuatChieu),
    FOREIGN KEY (MaGhe) REFERENCES Ghe(MaGhe),
    FOREIGN KEY (MaSuatChieu) REFERENCES SuatChieu(MaSuatChieu),
	FOREIGN KEY (MaVe) REFERENCES Ve(MaVe),
	trangthai bit default 0,
)

INSERT INTO NhanVien (MaNV, TenNV, MatKhau, NgaySinh, SDT, CCCD)
VALUES 
    ('NV01', N'Nguyễn Văn A', 'NV01', '1990-01-01', '0123456789', '1234567890'),
    ('NV02', N'Trần Thị B', 'NV02', '1995-05-05', '0987654321', '0987654321');
INSERT INTO LoaiPhim (MaLoaiPhim, TenLoaiPhim)
VALUES 
    ('LP01', N'Hoạt Hình'),
    ('LP02', N'Giật Gân'),
	('LP03', N'Hài Kịch');

INSERT INTO Phim (MaPhim, TenPhim, DaoDien, QuocGia, ThoiLuongPhim,LinkPhim,MaLoaiPhim)
VALUES 
    ('P01', 'Poporo', 'Justin Lin', 'USA', 150,'/img/pororo.jpg' ,'LP01'),
    ('P02', 'CaMap', 'Frank Darabont', 'USA', 142,'/img/camap.jpg', 'LP02'),
	('P03', 'DiGimon', 'Frank Gia Huy', 'USA', 142,'/img/digimon.jpg' ,'LP01'),
	('P04', 'Katak', 'Frank Darabont', 'USA', 142, '/img/katak.jpg','LP03'),
	('P05', 'Spyx', 'Frank Darabont', 'USA', 142,'/img/spyx.jpg' ,'LP01');

INSERT INTO PhongChieu (MaPhongChieu, TenPhongChieu, ViTri, SucChua)
VALUES 
    ('PC01', N'Phòng 1', N'Tầng 1', 27),
    ('PC02', N'Phòng 2', N'Tầng 2', 27);

INSERT INTO LoaiGhe (Gia, TenLoaiGhe)
VALUES 
    (10000, N'Ghế Đôi'),
    (5000, N'Ghế Thường');

INSERT INTO SuatChieu (MaSuatChieu, NgayChieu, GioChieu, MaPhim, MaPhongChieu)
VALUES 
    ('SC01', '2024-04-30', '18:00:00', 'P01', 'PC01'),
    ('SC02', '2024-05-01', '20:00:00', 'P02', 'PC02'),
	('SC03', '2024-05-01', '20:00:00', 'P02', 'PC01');

INSERT INTO HoaDon (MaHD, MaNV, TrangThai, NgayLap, GiaHoaDon)
VALUES 
    ('HD01', 'NV01', 0, '2024-04-30', 150000),
    ('HD02', 'NV02', 1, '2024-05-01', 200000);

INSERT INTO Ve (MaVe, MaSuatChieu)
VALUES 
    ('V01', 'SC01'),
    ('V02', 'SC02');

INSERT INTO ChiTietVe (MaVe, MaHD, SoLuongGhe, NgayGioDat)
VALUES 
    ('V01', 'HD01', 2, '2024-04-29 15:00:00'),
    ('V02', 'HD02', 3, '2024-04-30 10:00:00');

INSERT INTO Ghe (MaGhe, MaPhongChieu, MaLoaiGhe)
VALUES 
    ('A1.1', 'PC01', 1),
    ('A1.2', 'PC01', 1),
    ('A1.3', 'PC01', 1),
	('A1.4', 'PC01', 1),
    ('A1.5', 'PC01', 1),
    ('A1.6', 'PC01', 1),
	('A1.7', 'PC01', 1),
    ('B1.1', 'PC01', 1),
    ('B1.2', 'PC01', 1),
    ('B1.3', 'PC01', 1),
	('B1.4', 'PC01', 1),
    ('B1.5', 'PC01', 1),
    ('B1.6', 'PC01', 1),
	('B1.7', 'PC01', 1),
	('C1.1', 'PC01', 1),
    ('C1.2', 'PC01', 1),
    ('C1.3', 'PC01', 1),
	('C1.4', 'PC01', 1),
    ('C1.5', 'PC01', 1),
    ('C1.6', 'PC01', 1),
	('C1.7', 'PC01', 1),
    ('D1.1', 'PC01', 2),
    ('D1.2', 'PC01', 2),
	('D1.3', 'PC01', 2),

	('A2.1', 'PC02', 1),
    ('A2.2', 'PC02', 1),
    ('A2.3', 'PC02', 1),
	('A2.4', 'PC02', 1),
    ('A2.5', 'PC02', 1),
    ('A2.6', 'PC02', 1),
	('A2.7', 'PC02', 1),
    ('B2.1', 'PC02', 1),
    ('B2.2', 'PC02', 1),
    ('B2.3', 'PC02', 1),
	('B2.4', 'PC02', 1),
    ('B2.5', 'PC02', 1),
    ('B2.6', 'PC02', 1),
	('B2.7', 'PC02', 1),
	('C2.1', 'PC02', 1),
    ('C2.2', 'PC02', 1),
    ('C2.3', 'PC02', 1),
	('C2.4', 'PC02', 1),
    ('C2.5', 'PC02', 1),
    ('C2.6', 'PC02', 1),
	('C2.7', 'PC02', 1),
    ('D2.1', 'PC02', 2),
    ('D2.2', 'PC02', 2),
	('D2.3', 'PC02', 2);

INSERT INTO TrangThaiGhe (MaGhe,MaSuatChieu)
values
	('A1.1', 'SC01'),
    ('A1.2', 'SC01'),
    ('A1.3', 'SC01'),
	('A1.4', 'SC01'),
    ('A1.5', 'SC01'),
    ('A1.6', 'SC01'),
	('A1.7', 'SC01'),
    ('B1.1', 'SC01'),
    ('B1.2', 'SC01'),
    ('B1.3', 'SC01'),
	('B1.4', 'SC01'),
    ('B1.5', 'SC01'),
    ('B1.6', 'SC01'),
	('B1.7', 'SC01'),
	('C1.1', 'SC01'),
    ('C1.2', 'SC01'),
    ('C1.3', 'SC01'),
	('C1.4', 'SC01'),
    ('C1.5', 'SC01'),
    ('C1.6', 'SC01'),
	('C1.7', 'SC01'),
    ('D1.1', 'SC01'),
    ('D1.2', 'SC01'),
	('D1.3', 'SC01'),

	('A2.1', 'SC02'),
    ('A2.2', 'SC02'),
    ('A2.3', 'SC02'),
	('A2.4', 'SC02'),
    ('A2.5', 'SC02'),
    ('A2.6', 'SC02'),
	('A2.7', 'SC02'),
    ('B2.1', 'SC02'),
    ('B2.2', 'SC02'),
    ('B2.3', 'SC02'),
	('B2.4', 'SC02'),
    ('B2.5', 'SC02'),
    ('B2.6', 'SC02'),
	('B2.7', 'SC02'),
	('C2.1', 'SC02'),
    ('C2.2', 'SC02'),
    ('C2.3', 'SC02'),
	('C2.4', 'SC02'),
    ('C2.5', 'SC02'),
    ('C2.6', 'SC02'),
	('C2.7', 'SC02'),
    ('D2.1', 'SC02'),
    ('D2.2', 'SC02'),
	('D2.3', 'SC02'),

	('A1.1', 'SC03'),
    ('A1.2', 'SC03'),
    ('A1.3', 'SC03'),
	('A1.4', 'SC03'),
    ('A1.5', 'SC03'),
    ('A1.6', 'SC03'),
	('A1.7', 'SC03'),
    ('B1.1', 'SC03'),
    ('B1.2', 'SC03'),
    ('B1.3', 'SC03'),
	('B1.4', 'SC03'),
    ('B1.5', 'SC03'),
    ('B1.6', 'SC03'),
	('B1.7', 'SC03'),
	('C1.1', 'SC03'),
    ('C1.2', 'SC03'),
    ('C1.3', 'SC03'),
	('C1.4', 'SC03'),
    ('C1.5', 'SC03'),
    ('C1.6', 'SC03'),
	('C1.7', 'SC03'),
    ('D1.1', 'SC03'),
    ('D1.2', 'SC03'),
	('D1.3', 'SC03');


	

