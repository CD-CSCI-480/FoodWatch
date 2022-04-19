import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

const app = firebase.initializeApp({
    apiKey: "AIzaSyDgbohomaj2Xj_3Yto9YzkqaYVJ2DWU9ug",
    authDomain: "completefirebasedemo-666d8.firebaseapp.com",
    databaseURL: "https://completefirebasedemo-666d8.firebaseio.com",
    projectId: "completefirebasedemo-666d8",
    storageBucket: "completefirebasedemo-666d8.appspot.com",
    messagingSenderId: "917354876661",
    appID : "1:917354876661:web:26a9fe444fafc943f43fbc",
    measurementId: "G-35L7TRT0K4",
})

export const auth = app.auth();
export default app 
