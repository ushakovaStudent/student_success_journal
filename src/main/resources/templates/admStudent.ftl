<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarAdmin.ftl">
        </div>

        <div class="col-12 col-md-10">

            <table class="table">
                <thead>
                <tr>
                    <th>Користувацьке ім'я</th>
                    <th>Ім'я</th>
                    <th>Прізвище</th>
                    <th>По батькові</th>
                    <th>Email</th>
                    <th>Телефон</th>
                    <th>Група||Курс</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>

                <#if students??>

                    <#list students as student>
                        <tbody>

                        <tr>
                            <td>${student.user.username}</td>
                            <td>${student.first_name}</td>
                            <td>${student.last_name}</td>
                            <td>${student.middle_name}</td>
                            <td>${student.email}</td>
                            <td>${student.phone}</td>

                            <form action="/updateStudent" method="post">
                                <td>
                                    <label hidden for="UpdatedId"></label>
                                    <select style="width: max-content" class="form-control" name="UpdatedId"
                                            id="UpdatedId">

                                        <#if groups??>
                                            <#list groups as group>
                                                <#if group == student.group>

                                                    <option selected value="${group.id}">
                                                        ${group.numberGroup}||${group.numberCourse}
                                                    </option>

                                                <#else>

                                                    <option value="${group.id}">
                                                        ${group.numberGroup}||${group.numberCourse}
                                                    </option>

                                                </#if>
                                            </#list>
                                        </#if>

                                    </select>
                                </td>
                                <td>
                                    <input type="hidden" name="studentId" value="${student.id}">
                                    <input class="btn btn-light" type="submit" value="Змінити групу">
                                </td>

                            </form>


                            <td>
                                <form action="/deleteStudent" method="post">
                                    <label for="id" hidden></label>
                                    <input type="text" value="${student.id}" hidden name="id" id="id">
                                    <input class="btn btn-light" type="submit" value="Видалити студента">
                                </form>
                            </td>
                        </tr>

                        </tbody>
                    </#list>

                </#if>

            </table>
        </div>
    </div>
</@p.pages>