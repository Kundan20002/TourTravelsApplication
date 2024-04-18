/**
 * 
 */
function validateForm() {
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var phone = document.getElementById("phone").value;
  var address = document.getElementById("address").value;
  var passport = document.getElementById("passport").value;
  var dob = document.getElementById("dob").value;

  if (name === "" || email === "" || phone === "" || address === "" || passport === "" || dob === "") {
    alert("All fields are required");
    return false;
  }
  return true;
}
