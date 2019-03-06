--- log4j2
Plik konfiguracyjny \src\main\resources. Mozliwosc logowania do konsoli albo
pliku na dysku.

--- Uruchamianie testu
mvn test -DBROWSER=phantomjs
mvn test -DBROWSER=chrome
...
mvn test -DBROWSER=phantomjs -Dcucumber.options="--tags @nazwaScenariusza"
@nazwaScenariusza umieszczamy przed konkrentym Scanario w feature file

-- Testy rownoczesne
plugin: cucumber-jvm-parallel-plugin i maven-surefire-plugin
Wiecej info https://automationrhapsody.com/running-cucumber-tests-in-parallel/
Uzywam 'Forl' zakomentowany kod jest do parallel ktore nie dzialalo.
Mozna nadal uzywac mojego runnera.

-- Raportowanie
Raporty w jednym html -> plugin: maven-cucumber-reporting
//https://www.swtestacademy.com/
