<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-12">
        <#include "parts/navbar.ftl">
    </div>
</div>
<h1 style="text-align: center">Хто я?</h1>

<div class="row d-flex align-items-center justify-content-center">
    <div class="col-6 text-center">
        <div class="row">
            <div class="card" style="border: none">
                <div class="row">

                    <a href="/student" class="col-4">
                        <div style="padding-right: 20px; padding-left: 20px; border: none"
                             class="card d-flex flex-column">
                            <img src="/images/student.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="btn btn-outline-success card-title">Я студент</h5>
                            </div>
                        </div>
                    </a>

                    <a href="/teacher" class="col-4">
                        <div style="padding-right: 20px; padding-left: 20px; border: none"
                             class="card d-flex flex-column">
                            <img src="/images/teacher.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="btn btn-outline-success card-title">Я вчитель</h5>
                            </div>
                        </div>
                    </a>

                    <a href="/admin" class="col-4">
                        <div style="padding-right: 20px; padding-left: 20px; border: none"
                             class="card d-flex flex-column">
                            <img src="/images/admin.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="btn btn-outline-success card-title">Я адміністратор</h5>
                            </div>
                        </div>
                    </a>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>