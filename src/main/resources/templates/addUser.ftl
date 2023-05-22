<#import "parts/templ.ftl" as p>
<@p.pages>

    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarAdmin.ftl">
        </div>

        <div class="col-12 col-md-10">
            <div class="row">

                <div class="col-12 col-md-6">
                    <h3 style="text-align: center">Додати студента</h3>
                    <hr>
                    <br>

                    <form action="/addStudent" method="post"
                          onsubmit="return checkExistingUser(document.getElementById('username').value);">
                        <div class="row">
                            <div class="col-12 col-md-6">
                                <label style="align-items: center" for="firstName">Ім'я</label>
                                <input class="form-control cen" type="text" name="firstName" id="firstName"
                                       minlength="2" required>

                                <label for="LastName">Прізвище</label>
                                <input class="form-control cen" type="text" name="LastName" id="LastName" minlength="2"
                                       required>

                                <label for="midl_name">По батькові</label>
                                <input class="form-control cen" type="text" name="midl_name" id="midl_name"
                                       minlength="2" required>

                                <label for="phone">Телефон</label>
                                <input class="form-control cen" type="number" name="phone" id="phone" minlength="2"
                                       required>
                            </div>

                            <div class="col-12 col-md-6">
                                <label for="email">Електронна пошта</label>
                                <input class="form-control cen" type="email" name="email" id="email" minlength="2"
                                       required>

                                <label for="username">Користувацьке ім'я</label>
                                <input class="form-control cen" type="text" name="username" id="username" minlength="2"
                                       required>

                                <label for="password">Пароль</label>
                                <input class="form-control cen" type="text" name="password" id="password" minlength="2"
                                       required>

                                <label for="group">Група||курс</label>
                                <select class="form-select cen" name="group" id="group">
                                    <#list groups as group>
                                        <option style="align-items: center" value="${group.id}">
                                            ${group.numberGroup}||${group.numberCourse}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <br>
                        <input style="margin-top: 40px; background: coral; border-color: black" type="submit"
                               class="form-control btn btn-light" placeholder="Зберегти">
                    </form>
                </div>

                <div class="col-12 col-md-6">
                    <h3 style="text-align: center">Додати вчителя</h3>
                    <hr>
                    <br>

                    <form action="/addTeacher" method="post"
                          onsubmit="return checkExistingUser(document.getElementById('usernameTeacher').value);">

                        <div class="row">
                            <div class="col-12 col-md-6">

                                <label for="firstNameT">Ім'я</label>
                                <input class="form-control cen" type="text" name="firstNameTeacher" id="firstNameT"
                                       required>

                                <label for="LastNameT">Прізвище</label>
                                <input class="form-control cen" type="text" name="LastNameTeacher" id="LastNameT"
                                       required>

                                <label for="midl_name_Teacher">По батькові</label>
                                <input class="form-control cen" type="text" name="midl_name_Teacher"
                                       id="midl_name_Teacher" required>

                            </div>
                            <div class="col-12 col-md-6">
                                <label for="usernameTeacher">Користувацьке ім'я</label>
                                <input class="form-control cen" type="text" name="usernameTeacher" id="usernameTeacher"
                                       required>

                                <label for="passwordTeacher">Пароль</label>
                                <input class="form-control cen" type="text" name="passwordTeacher" id="passwordTeacher"
                                       required>
                            </div>
                        </div>
                        <br>
                        <input style="margin-top: 40px; background: coral; border-color: black" type="submit"
                               class="form-control btn btn-light" placeholder="Зберегти">
                    </form>
                </div>

            </div>
        </div>

    </div>
</@p.pages>
<script>
    function checkExistingUser(username) {
        const usersList = [<#list usersList as user>"${user.username}"</#list>];

        if (usersList.includes(username)) {
            alert("Користувач з таким іменем вже існує");
            return false;
        }

        return true;
    }
</script>
<style>

    label {
        text-align: center;
        display: block;
        margin-bottom: 5px;
    }

    select.form-select {
        text-align-last: center;
    }

    .cen {
        text-align: center;
    }

</style>
