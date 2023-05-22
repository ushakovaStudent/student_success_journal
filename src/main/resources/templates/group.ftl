<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarTeacher.ftl">
        </div>

        <div class="col-12 col-md-10">

            <#if students?? && disciplines??>

                <h3 style="text-align: center">Додати оцінку учню</h3>
                <hr><br>

                <form action="/addMark" method="post">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td>
                                <label>
                                    <input style="min-width: 100px" class="form-control" type="number"
                                           placeholder="Оцінка" name="mark" min="0" max="12" value="0">
                                </label>
                            </td>
                            <td>
                                <label for="dateMark">Дата уроку
                                    <input class="form-control" style="background: none; border: none" type="date"
                                           id="dateMark"
                                           name="dateMark" value="${.now?string('yyyy-MM-dd')}">
                                </label>
                            </td>

                            <td>
                                <label for="typeLesson">
                                    <select class="form-control" name="typeLesson" id="typeLesson">
                                        <#list lessonType as lesson>
                                            <option value="${lesson.id}" selected>${lesson.name}</option>
                                        </#list>
                                    </select>
                                </label>
                            </td>

                            <td>
                                <label for="student">
                                    <select class="form-control" name="student" id="student">
                                        <#list students as stud>
                                            <option value="${stud.id}" selected>
                                                ${stud.first_name}||${stud.last_name}
                                            </option>
                                        </#list>
                                    </select>
                                </label>
                            </td>

                            <td>
                                <label for="discipline">
                                    <select class="form-control" name="discipline" id="discipline">
                                        <#list disciplines as disc>
                                            <option value="${disc.id}">${disc.name}</option>
                                        </#list>
                                    </select>
                                </label>
                            </td>

                            <td>
                                <label for="truancy">
                                    <select class="form-control" name="truancy" id="truancy">
                                        <option selected value="true">Присутній</option>
                                        <option value="false">Відсутній</option>
                                    </select>
                                </label>
                            </td>

                            <td>

                                <input type="submit" class="btn btn-outline-success form-control"
                                       value="Виставити оцінку">

                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </#if>

            <br><br><br>
            <h3 style="text-align: center">Список студентів групи</h3>
            <hr>
            <br>


            <table class="table">
                <thead>
                <tr>
                    <th>Ім'я</th>
                    <th>Прізвище</th>
                    <th>По батькові</th>
                    <th></th>
                </tr>
                </thead>
                <#if students??>
                    <#list students as stud>
                        <tbody>
                        <tr>

                            <td>${stud.first_name}</td>
                            <td>${stud.last_name}</td>
                            <td>${stud.middle_name}</td>

                            <td>
                                <form action="/studentDetail" method="get">
                                    <button class="btn btn-outline-danger form-control" value="${stud.id}" type="submit"
                                            name="studentId">
                                        Детальніше про студента
                                    </button>
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
<script>
    const now = new Date();
    const dateLessonInput = document.getElementById('dateMark');
    const minDate = new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000).toISOString().slice(0, 10);
    const maxDate = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000).toISOString().slice(0, 10);
    dateLessonInput.min = minDate;
    dateLessonInput.max = maxDate;
    dateLessonInput.value = now.toISOString().slice(0, 10);
</script>