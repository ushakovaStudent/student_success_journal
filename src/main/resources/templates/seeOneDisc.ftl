<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarTeacher.ftl">
        </div>

        <div class="col-12 col-md-10">
            <h3>Всі оцінки з дисципліни</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Оцінка</th>
                    <th>Назва дисципліни</th>
                    <th>Студент</th>
                    <th>Дата</th>
                </tr>
                </thead>
                <#list marks as m>
                    <tbody>
                    <tr>
                        <td>${m.mark}</td>
                        <td>${m.discipline.name}</td>
                        <td>${m.student.first_name} || ${m.student.last_name}</td>
                        <td>${m.dateOfMarks}</td>
                    </tr>
                    </tbody>
                </#list>
            </table>

        </div>
    </div>
</@p.pages>