<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$nama_barang = $_POST['nama_barang'];
		$harga_barang = $_POST['harga_barang'];
		$jenis_barang = $_POST['jenis_barang'];
		
		require_once('dbConnect.php');
		
		$sql = "UPDATE barang SET nama_barang = '$nama_barang', harga_barang = '$harga_barang', jenis_barang = '$jenis_barang' WHERE id = $id;";
		
		if(mysqli_query($con,$sql)){
			echo 'Data Barang Berhasil Diubah';
		}else{
			echo 'Data Barang Gagal Disimpan';
		}
		
		mysqli_close($con);
	}