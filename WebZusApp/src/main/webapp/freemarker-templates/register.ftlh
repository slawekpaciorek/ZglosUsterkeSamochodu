<#include "header.ftlh">

<main>

    <div class="pageContent container-fluid">


        <div class="center_box row">


            <div class="col_content col-sm-12">

                <div class="login_form container">

                    <form>

                        <img src="/image/man.png">
                        <label for="userName">Imię</label>
                        <input type="text" placeholder="Wprowadź imię" name="userName" required>
                        <label for="userSurname">Nazwisko</label>
                        <input type="text" placeholder="Wprowadź nazwisko" name="userSurname" required>
                        <label for="password">Hasło użytkownika</label>
                        <input type="password" name="password" placeholder="Wprowadź hasło" required>
                        <label for="password">Potwierdź hasło</label>
                        <input type="password" name="password" placeholder="Powtórz hasło" required>
                        <label for="email">Email</label>
                        <input type="email" name="email" placeholder="Wprowadź email" required>
                        <label for="phoneNumber">Numer telefonu</label>
                        <input type="tel" name="phoneNumber" placeholder="Wprowadź numer teleonu">
                        <label for="dateOfBirth">Data urodzenia</label>
                        <input type="date" name="dateOfBirth" placeholder="Wybierz datę urodzenia" required>
                        <fieldset placeholder="Wybierz kraj">
                            <label for="adressCountry">Polska</label>
                            <input type="radio" name="adressCountry" value="Polska">
                            <label for="adressCountry">USA</label>
                            <input type="radio" name="adressCountry" value="USA">
                            <label for="adressCountry">Niemcy</label>
                            <input type="radio" name="adressCountry" value="Niemcy">
                        </fieldset>
                        <label for="adressCity">Miasto</label>
                        <input type="text" name="adressCity" placeholder="Nazwa miejscowości" required>
                        <label for="adressStreet">Ulica</label>
                        <input type="text" name="adressStreet" placeholder="Nazwa ulicy" required>

                    <button type="button">Zarejestreuj</button>
                    </form>


                </div>

            </div>

        </div>

    </div>

</main>
<#include  "footer.ftlh">