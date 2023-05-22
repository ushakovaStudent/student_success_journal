<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarStudent.ftl">
        </div>

        <div class="col-12 col-md-10">

            <form action="/addAbsence" method="post">
                <table>
                    <tbody>
                    <tr>

                        <td>
                            <label for="dateAbsence">Дата відсутності
                                <input class="form-control" style="background: none; border: none" type="date"
                                       id="dateAbsence" name="dateAbsence" value="${.now?string('yyyy-MM-dd')}">
                            </label>
                        </td>

                        <td>
                            <label for="cause">
                                <input class="form-control" type="text" id="cause" name="cause"
                                       placeholder="Причина відсутності">
                            </label>
                        </td>

                        <td>
                            <label for="discipline">
                                <select class="form-control" name="discipline" id="discipline">
                                    <#list discList as disc>
                                        <option value="${disc.id}">${disc.name}</option>
                                    </#list>
                                </select>
                            </label>
                        </td>

                        <td>
                            <input class="form-control" type="submit" value="Відправити">
                        </td>

                    </tr>
                    </tbody>
                </table>
            </form>

            <table class="table">
                <thead>
                <tr>
                    <th>Дисципліна</th>
                    <th>Причина</th>
                    <th>Дата</th>
                </tr>
                </thead>
                <#list absence as abs>
                    <tbody>
                    <tr>
                        <td>${abs.discipline.name}</td>
                        <td>${abs.cause}</td>
                        <td>${abs.dateOfAbsences}</td>
                    </tr>
                    </tbody>
                </#list>
            </table>

        </div>
    </div>
</@p.pages>
<script>
    const now = new Date();
    const dateLessonInput = document.getElementById('dateAbsence');
    const minDate = new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000).toISOString().slice(0, 10);
    const maxDate = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000).toISOString().slice(0, 10);
    dateLessonInput.min = minDate;
    dateLessonInput.max = maxDate;
    dateLessonInput.value = now.toISOString().slice(0, 10);
</script>