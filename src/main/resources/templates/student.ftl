<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarStudent.ftl">
        </div>

        <div class="col-12 col-md-10">

            <h3 style="text-align: center">Студент:</h3>
            <hr>

            <table class="table">
                <thead>
                <tr>
                    <th>Ім'я</th>
                    <th>Прізвище</th>
                    <th>По батькові</th>
                    <th>Середній бал: дисципліна/оцінка</th>
                </tr>
                </thead>
                <#if students??>
                    <tbody>
                    <tr>

                        <td>${students.first_name}</td>
                        <td>${students.last_name}</td>
                        <td>${students.middle_name}</td>

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