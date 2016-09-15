<?php 
	$id = $_GET['id'];
	
	require_once('dbConnect.php');
	
	$sql = "DELETE FROM barang WHERE id=$id;";
	
	if(mysqli_query($con,$sql)){
		echo 'Data Barang Berhasil Dihapus';
	}else{
		echo 'Data Barang Gagal Disimpan';
	}
	
	mysqli_close($con);
