// // Import Axios library (make sure to include Axios in your project)
// const axios = require('axios');


// const apiUrl = 'http://localhost:8080/login/auth'; 

// const loginForm = document.getElementById('loginForm');

// loginForm.addEventListener('submit', function(event) {
//   event.preventDefault(); // Prevent the default form submission

//   // Get the email and password values from the form
//   const email = document.getElementById('email').value;
//   const password = document.getElementById('password').value;

//   // Create an object with the login credentials
//   const loginData = {
//     email: email,
//     password: password
//   };
// const loginData = {
//   email: 'user@example.com',
//   password: 'secretPassword'
// };

// // Make an HTTP POST request to the API endpoint
// axios.post(apiUrl, loginData)
//   .then(response => {
//     // Handle successful response
//     console.log('Response:', response.data);
//     // Assuming the API responds with user details in the JSON format, you can access them using response.data
//     const userDetails = response.data;
//     // Use userDetails as needed (e.g., display user information on the webpage)
//   })
//   .catch(error => {
//     // Handle error
//     console.error('Error:', error.message);
//     // Depending on the error, you can display an error message to the user or perform other actions
//   });
