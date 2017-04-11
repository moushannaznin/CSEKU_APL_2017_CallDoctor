<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
	include 'connection.php';
	createDoctors();
}

function createDoctors()
{
		
	global $connect;
	
	// receiving the post params
	
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

	
	/*
	$Urology = "Urology";
	$Hematology = null;
	$Orthopaedics = null;
	$Gynaecology = null;
	$Respiratory = null;
	$Paediatrics = null;
	$Cardiology = null;
	$ENT = null;
	$Neurology = null;
	$Gastroenterology = null;
	$Eye = null;
	$Psychiatry = null;
	$Skin = null;
	$Hepatology = null;
	$Dental = null;
	$Oncology = null;
	$Rheumatology = null;
	$Nutritionist = null;
	$Dermatology = null;
	$Endocrinology = null;
	*/
	
	
	//echo "Study PHP at " . $sSpecialist . "<br>";
	
	//$query = "SELECT id FROM specialist WHERE $Urology OR $Hematology = 1";
	
	$query = "SELECT id FROM specialist WHERE $Urology OR $Hematology OR $Orthopaedics OR $Gynaecology OR $Respiratory OR $Paediatrics OR $Cardiology OR $ENT OR $Neurology OR $Gastroenterology OR $Eye OR $Psychiatry OR $Skin OR $Hepatology OR $Dental OR $Oncology OR $Rheumatology OR $Nutritionist OR $Dermatology OR $Endocrinology = 1";
	
	$result = mysqli_query($connect, $query);
	$number_of_rows = mysqli_num_rows($result);
	
	$temp_array  = array();
	
	// check for empty result
	if($number_of_rows > 0) {
		while ($row = mysqli_fetch_assoc($result)) {
			// get doctor from doctor table
			$id = $row["id"];
			
			$queryDoctor = "SELECT * FROM doctor WHERE id = '$id'";
			$resultDoctor = mysqli_query($connect, $queryDoctor);
			
			$number_of_doctor_rows = mysqli_num_rows($resultDoctor);
			if($number_of_doctor_rows > 0) {
				while ($row = mysqli_fetch_assoc($resultDoctor)) {
					$temp_array[] = $row;
				}
			}
		}
	}
	
	header('Content-Type: application/json');
	//echo json_encode(array("doctor"=>$temp_array));
	echo json_encode($temp_array);
	mysqli_close($connect);
	
}

?>