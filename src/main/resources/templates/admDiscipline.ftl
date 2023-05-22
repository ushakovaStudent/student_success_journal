<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row" style="background: #c5d9d0">
    <div class="col-12 col-md-2">
        <#include "leftbarAdmin.ftl">
    </div>

    <div class="col-12 col-md-10">

        <h3 style="text-align: center">Додати нову дисципліну</h3>

        <form action="/addDisc" method="post">
            <table class="table">
                <thead>
                <tr>
                    <th style="text-align: center">Назва</th>
                    <th style="text-align: center">Кількість годин</th>
                    <th></th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td style="text-align: center">
                        <label style="text-align: center">
                            <input style="text-align: center" class="form-control" type="text" name="nameDisc" required>
                        </label>
                    </td>

                    <td style="text-align: center">
                        <label>
                            <input style="text-align: center" class="form-control" type="number" name="numberHours"
                                   required>
                        </label>
                    </td>

                    <td style="text-align: center">
                        <input style="text-align: center" class="form-control" type="submit" placeholder="Зберегти">
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <hr>
        <br>
        <h3 style="text-align: center">Всі дисципліни</h3>
        <hr>
        <br>

        <table class="table">
            <thead>
            <tr>
                <th style="text-align: center">Назва</th>
                <th style="text-align: center">Кількість годин</th>
            </tr>
            </thead>
            <tbody>
            <#if discList??>
                <#list discList as disc>

                    <tr>
                        <td style="text-align: center">${disc.name}</td>
                        <td style="text-align: center">${disc.numberOfHours}</td>
                    </tr>

                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@p.pages>