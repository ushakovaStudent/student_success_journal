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
                    <th>Фамілія</th>
                    <th>По батькові</th>
                    <th></th>
                </tr>
                </thead>

                <#if teachers??>
                    <form action="/deleteTeacher" method="post">
                        <#list teachers as teacher>
                            <tbody>

                            <tr>
                                <td>${teacher.users.username}</td>
                                <td>${teacher.first_name}</td>
                                <td>${teacher.last_name}</td>
                                <td>${teacher.middle_name}</td>
                                <td>
                                    <label for="id"></label>
                                    <input type="text" value="${teacher.id}" hidden name="id" id="id">
                                    <input class="btn btn-light" type="submit" value="видалити">
                                </td>
                            </tr>

                            </tbody>
                        </#list>
                    </form>
                </#if>

            </table>
        </div>
    </div>
</@p.pages>