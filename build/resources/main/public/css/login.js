(function(){

// initialize firebase
  const Config = {
    apiKey: "AIzaSyCPaGnNUTJ7wbW_A9onlSQlpVOqqDKa_9M",
    authDomain: "safe-trans-app.firebaseapp.com",
    databaseURL: "https://safe-trans-app.firebaseio.com",
    projectId: "safe-trans-app",
    storageBucket: "safe-trans-app.appspot.com",
    appId: "1:438334449761:web:578d7d217c22e2825b2220"
    messagingSenderId: "438334449761"
  };
  firebase.initializeApp(config);

  // Get Elements

  const txtEmail = document.getElementById('txtname');
  const txtEmail = document.getElementById('txtEmail');
  const txtPass = document.getElementById('txtPass');
  const btn-signup = document.getElementById('btn-signup');
  const btn-signin = document.getElementById('btn-signin');
  const txtUsername = document.getElementById('txtUsername');
  const checkbox = document.getElementById('checkbox');

  // add a login event
  btn-signin.addEventListener('click', e =>{
  // get Email and pass

  const email = txtEmail.value;
  const pass = txtPass.value;
  const auth = firebase.auth;

  // sign in
  const promise=
  auth.signInWithEmailAndPassword(email, pass);
  promise.catch(e=> console.log(e.message))
  })
}());