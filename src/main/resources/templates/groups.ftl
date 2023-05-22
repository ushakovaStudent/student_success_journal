<#import "parts/templ.ftl" as p>
<@p.pages>

    <div class="row">
    <div class="col-12 col-md-2">
        <#include "leftbarTeacher.ftl">
    </div>

    <div class="col-12 col-md-10">

        <table class="table">

            <thead>
            <tr>
                <th>Курс</th>
                <th>Група</th>
                <th></th>
            </tr>
            </thead>

            <#if group??>
                <tbody>
                <#list group as group>
                    <tr>
                        <td>${group.numberCourse}</td>
                        <td>${group.numberGroup}</td>

                        <td>
                            <form action="/group" method="get">
                                <label>
                                    <input hidden type="text" value="${group.id}" name="id">
                                </label>
                                <input type="submit" placeholder="перейти до групи" class="btn btn-outline-danger"
                                       value="До групи">
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </#if>

        </table>
    </div>
</@p.pages>