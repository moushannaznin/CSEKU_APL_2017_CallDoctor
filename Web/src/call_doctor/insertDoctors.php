<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connection.php';
	createDoctors();
}


function createDoctors()
{
	global $connect;
	
	$name = $_POST["name"];	
	$phone = $_POST["phone"];
	$latitude = $_POST["latitude"];
	$longitude = $_POST["longitude"];
	$degree = $_POST["degree"];
	$specialists = $_POST["specialists"];
	$address = $_POST["address"];
	
	$query = " Insert into doctor(name, phone, latitude, longitude, degree, specialists, address) values ('$name','$phone','$latitude','$longitude', '$degree', '$specialists', '$address');";
	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
	mysqli_close($connect);
	
}
?>
