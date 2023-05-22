<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarTeacher.ftl">
        </div>

        <div class="col-12 col-md-10">

            <h3 style="text-align: center">Студент:</h3>
            <hr>
            <br>

            <table class="table">
                <thead>
                <tr>
                    <th>Ім'я</th>
                    <th>Прізвище</th>
                    <th>По батькові</th>
                    <th>Середній бал: дисципліна/оцінка</th>
                </tr>
                </thead>
                <#if student??>
                    <tbody>
                    <tr>

                        <td>${student.first_name}</td>
                        <td>${student.last_name}</td>
                        <td>${student.middle_name}</td>

                        <td>
                            <#list averageMarks as mark>
                                ${mark.discipline.name}/${mark.average}<#sep><br>
                            </#list>
                        </td>

                    </tr>
                    </tbody>

                </#if>
        </div>
    </div>
</@p.pages>