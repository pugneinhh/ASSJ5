<%--
  Created by IntelliJ IDEA.
  User: Phanh
  Date: 23/07/2023
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28//angular-route.min.js"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-sanitize.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
    <title>Home</title>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <title>Document</title>
    <style>

        .container {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            align-items: center;

        }
        .form{
            transform-style: preserve-3d;
            transition: all 1s ease;
        }
        .form form{
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
            background:linear-gradient(215deg, rgb(139, 242, 219), rgb(175, 246, 235), rgb(239, 170, 200), rgb(225, 113, 161));
            border-radius: 15px;
        }

        .form .form_front form{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 35px;
            position: relative;
            backface-visibility: hidden;
            padding: 150px 125px;
            border-radius: 15px;
            box-shadow: inset 2px 2px 10px rgba(0, 0, 0, 1),
            inset -1px -1px 5px rgba(255, 255, 255, 0.6);


        }


        .form_details {
            font-family: Arial, Helvetica, sans-serif;
            -webkit-text-stroke: black 0.2rem;
            color: transparent;
            letter-spacing: 0.2rem;
            font-size: 50px;
            font-weight: 800;
            margin-top: -0.1rem;
            padding-bottom: 10px;
            text-shadow: 0px 0px 16px #CECECE;
        }


        .form .switch {
            font-size: 13px;
        }

        .form .switch .signup_tog {
            font-weight: 700;
            cursor: pointer;
        }

        /* hi */
        /*---------shooting stars-----------*/


        .bg-stars {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -2;
            background-size: cover;
            -webkit-animation: animateBg 50s linear infinite;
            animation: animateBg 50s linear infinite;
        }


        .star {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 4px;
            height: 4px;
            background: #fff;
            border-radius: 50%;
            -webkit-box-shadow: 0 0 0 4px rgba(255,255,255,0.1),0 0 0 8px rgba(255,255,255,0.1),0 0 20px rgba(255,255,255,0.1);
            box-shadow: 0 0 0 4px rgba(255,255,255,0.1),0 0 0 8px rgba(255,255,255,0.1),0 0 20px rgba(255,255,255,0.1);
            -webkit-animation: animate 3s linear infinite;
            animation: animate 3s linear infinite;
        }

        .star::before {
            content: '';
            position: absolute;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
            width: 300px;
            height: 1px;
            background: -webkit-gradient(linear,left top, right top,from(#fff),to(transparent));
            background: linear-gradient(90deg,#fff,transparent);
        }



        .star:nth-child(1) {
            top: 0;
            right: 0;
            left: initial;
            -webkit-animation-delay: 0s;
            animation-delay: 0s;
            -webkit-animation-duration: 1s;
            animation-duration: 1s;
        }

        .star:nth-child(2) {
            top: 0;
            right: 100px;
            left: initial;
            -webkit-animation-delay: 0.2s;
            animation-delay: 0.2s;
            -webkit-animation-duration: 3s;
            animation-duration: 3s;
        }

        .star:nth-child(3) {
            top: 0;
            right: 220px;
            left: initial;
            -webkit-animation-delay: 2.75s;
            animation-delay: 2.75s;
            -webkit-animation-duration: 2.75s;
            animation-duration: 2.75s;
        }

        .star:nth-child(4) {
            top: 0;
            right: -220px;
            left: initial;
            -webkit-animation-delay: 1.6s;
            animation-delay: 1.6s;
            -webkit-animation-duration: 1.6s;
            animation-duration: 1.6s;
        }
        /* Button style */

        .btn {
            margin-top: 10px;
            position: relative;
            padding: 10px 35px;
            background: #11100f;
            font-size: 20px;
            font-weight: 500;
            color: #fffdfd;
            border: 3px solid #c0b7b1;
            border-radius: 8px;
            box-shadow: 0 0 0 #4d48448c;
            transition: all .3s ease-in-out;
        }

        .star-1 {
            position: absolute;
            top: 20%;
            left: 20%;
            width: 25px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all 1s cubic-bezier(0.05, 0.83, 0.43, 0.96);
        }

        .star-2 {
            position: absolute;
            top: 45%;
            left: 45%;
            width: 15px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
        }

        .star-3 {
            position: absolute;
            top: 40%;
            left: 40%;
            width: 5px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
        }

        .star-4 {
            position: absolute;
            top: 20%;
            left: 40%;
            width: 8px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all .8s cubic-bezier(0, 0.4, 0, 1.01);
        }

        .star-5 {
            position: absolute;
            top: 25%;
            left: 45%;
            width: 15px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all .6s cubic-bezier(0, 0.4, 0, 1.01);
        }

        .star-6 {
            position: absolute;
            top: 5%;
            left: 50%;
            width: 5px;
            height: auto;
            filter: drop-shadow(0 0 0 #fffdef);
            z-index: -5;
            transition: all .8s ease;
        }

        .btn:hover {
            background: transparent;
            font-weight: bolder;
            color: #ed1717;
            border: #11100f 1px solid;
            box-shadow: 0 0 25px #ffffff8c;
        }

        button:hover .star-1 {
            position: absolute;
            top: -80%;
            left: -30%;
            width: 25px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        button:hover .star-2 {
            position: absolute;
            top: -25%;
            left: 10%;
            width: 15px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        button:hover .star-3 {
            position: absolute;
            top: 55%;
            left: 25%;
            width: 5px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        button:hover .star-4 {
            position: absolute;
            top: 30%;
            left: 80%;
            width: 8px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        button:hover .star-5 {
            position: absolute;
            top: 25%;
            left: 115%;
            width: 15px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        button:hover .star-6 {
            position: absolute;
            top: 5%;
            left: 60%;
            width: 5px;
            height: auto;
            filter: drop-shadow(0 0 10px #fffdef);
            z-index: 2;
        }

        .fil0 {
            fill: #FFFDEF
        }

        /* Input style */
        .inputbox {
            position: relative;
            width: 350px;
        }
        .inputbox1 {
            position: relative;
            width: 350px;
        }
        .inputbox input {
            position: relative;
            width: 100%;
            padding: 20px 10px 10px;
            background: transparent;
            outline: none;
            box-shadow: none;
            border: none;
            color: #23242a;
            font-size: 22px;
            letter-spacing: 0.05em;
            transition: 0.5s;
            z-index: 10;
        }
        .inputbox1 input {
            position: relative;
            width: 100%;
            padding: 20px 10px 10px;
            background: transparent;
            outline: none;
            box-shadow: none;
            border: none;
            color: #23242a;
            font-size: 22px;
            letter-spacing: 0.05em;
            transition: 0.5s;
            z-index: 10;
        }
        .inputbox span {
            position: absolute;
            left: 0;
            padding: 20px 10px 10px;
            font-size: 20px;
            color: #8f8f8f;
            letter-spacing: 00.05em;
            transition: 0.5s;
            pointer-events: none;
        }
        .inputbox1 span {
            position: absolute;
            left: 0;
            padding: 20px 10px 10px;
            font-size: 20px;
            color: #8f8f8f;
            letter-spacing: 00.05em;
            transition: 0.5s;
            pointer-events: none;
        }
        .inputbox input:valid ~span,
        .inputbox input:focus ~span {
            color: #000000;
            transform: translateX(-10px) translateY(-30px);
            font-size: 20px;

        }
        .inputbox1 input:valid ~span,
        .inputbox1 input:focus ~span {
            color: #000000;
            transform: translateX(-10px) translateY(-30px);
            font-size: 20px;

        }
        .inputbox i {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 2px;
            background: #ffffff;
            border-radius: 4px;
            transition: 0.5s;
            pointer-events: none;
            z-index: 9;
        }
        .inputbox1 i {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 2px;
            background: #ffffff;
            border-radius: 4px;
            transition: 0.5s;
            pointer-events: none;
            z-index: 9;
        }
        .inputbox input:valid ~i,
        .inputbox input:focus ~i {
            height: 44px;
        }
        .inputbox1 input:valid ~i,
        .inputbox1 input:focus ~i {
            height: 44px;
        }
    </style>
</head>

<body>
<div class="container">

    <div class="form">
        <div class="form_front">
            <form action="/trang-chu/trang-chinh" method="post">
                <div class="form_details">Login</div>
                <div class="inputbox">
                    <input required="required" name="user" type="text">
                    <span>Username</span>
                    <i></i>
                </div>
                <div class="inputbox">
                    <input required="required" name="pass" type="text">
                    <span>Password</span>
                    <i></i>
                </div>
                <p style="color: red;">${LOI_LOGIN}</p>
                <button class="btn" type="submit">Login
                    <div class="star-1">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                    <div class="star-2">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                    <div class="star-3">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                    <div class="star-4">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                    <div class="star-5">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                    <div class="star-6">
                        <svg xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 784.11 815.53" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z" class="fil0"></path></g></svg>
                    </div>
                </button>

            </form>
        </div>

        <section class="bg-stars">
            <span class="star"></span>
            <span class="star"></span>
            <span class="star"></span>
            <span class="star"></span>
        </section>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.5.4/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.min.js"></script>
</body>

</html>
