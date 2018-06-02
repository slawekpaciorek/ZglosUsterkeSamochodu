<#include "header.ftlh">

<main>

    <div class="pageContent">


    <div class="center_box row no-gutters">

        <div class="col_content col-sm-6">
            <img src="/image/car_grey.png">
        </div>

            <div class="col_content col-sm-6">

                <div class="login_form container">
                    <img src="/image/man.png">
                    <label for="username">Nazwa użytkownika</label>
                    <input type="text" placeholder="Wprowadź nazwę użytkownia" name="username" required>
                    <label for="password">Hasło użytkownika</label>
                    <input type="text" name="password" placeholder="Wprowadź hasło" required>
                    <button type="button">Logowanie</button>
                    <button type="button">Resetownia hasła</button>

                </div>
            </div>
        </div>

        </div>
    </div>
</main>
<#include  "footer.ftlh">