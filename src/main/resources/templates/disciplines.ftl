<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row">
        <div class="col-12 col-md-2">
            <#include "leftbarTeacher.ftl">
        </div>

        <div class="col-12 col-md-10">

            <table>
                <thead>
                <tr>
                    <th>Назва дисципліни</th>
                    <th>Кількість годин</th>
                    <th></th>
                </tr>
                </thead>
                <#list discipline as disc>
                    <tbody>
                    <tr>
                        <td>${disc.name}</td>
                        <td>${disc.numberOfHours}</td>
                        <td>
                            <form action="/seeDisc" method="get">
                                <button value="${disc.id}" type="submit" class="form-control" name="id">До дисципліни
                                </button>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </#list>
            </table>

        </div>
    </div>
</@p.pages>