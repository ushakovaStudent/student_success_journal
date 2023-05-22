<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row" style="background: #c5d9d0">
        <div class="col-12 col-md-2">
            <#include "leftbarAdmin.ftl">
        </div>

        <div class="col-12 col-md-10">

            <h3 style="text-align: center">Адміністративне меню</h3>
            <hr>
            <br>

            <p>Тут ви можете:</p>
            <ul>

                <li>Додавати нових студентів та вчителів до бази даних</li>

                <li>Бачити всіх користувачів та повну інформацію про них</li>

                <li>Переводити студентів до інших груп</li>

                <li>Додавати нові дисципліни</li>
            </ul>

        </div>
    </div>
</@p.pages>