<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connection.php';
	createSpecialist();
}


function createSpecialist()
{
	global $connect;
	
	$Urology = $_POST["Urology"];	
	$Hematology = $_POST["Hematology"];
	$Orthopaedics = $_POST["Orthopaedics"];
	$Gynaecology = $_POST["Gynaecology"];
	$Respiratory = $_POST["Respiratory"];
	$Paediatrics = $_POST["Paediatrics"];
	$Cardiology = $_POST["Cardiology"];
	$ENT = $_POST["ENT"];
	$Neurology = $_POST["Neurology"];
	$Gastroenterology = $_POST["Gastroenterology"];
	$Eye = $_POST["Eye"];
	$Psychiatry = $_POST["Psychiatry"];
	$Skin = $_POST["Skin"];
	$Hepatology = $_POST["Hepatology"];
	$Dental = $_POST["Dental"];
	$Oncology = $_POST["Oncology"];
	$Rheumatology = $_POST["Rheumatology"];
	$Nutritionist = $_POST["Nutritionist"];
	$Dermatology = $_POST["Dermatology"];
	$Endocrinology = $_POST["Endocrinology"];

	
	$query = " Insert into specialist(Urology,Hematology,Orthopaedics,Gynaecology,Respiratory,Paediatrics,Cardiology,ENT,Neurology,Gastroenterology,Eye,Psychiatry,Skin,Hepatology,Dental,Oncology,Rheumatology,Nutritionist,Dermatology,Endocrinology) values ('$Urology','$Hematology','$Orthopaedics','$Gynaecology','$Respiratory','$Paediatrics','$Cardiology','$ENT','$Neurology','$Gastroenterology','$Eye','$Psychiatry','$Skin','$Hepatology','$Dental','$Oncology','$Rheumatology','$Nutritionist','$Dermatology','$Endocrinology');";
	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
	mysqli_close($connect);
	
}








?>
