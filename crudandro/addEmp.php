<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		error_reporting(0);
		$id = $_POST['id'];
		$nama_barang = $_POST['nama_barang'];
		$harga_barang = $_POST['harga_barang'];
		$jenis_barang = $_POST['jenis_barang'];
		
		//Creating an sql query
		$sql = "INSERT INTO barang(id,nama_barang,harga_barang,jenis_barang) VALUES ('$id','$nama_barang','$harga_barang','$jenis_barang')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'Data Barang Berhasil Disimpan';
		}else{
			echo 'Data Barang Gagal Disimpan';
		}
		
		//Closing the database 
		mysqli_close($con);
	}