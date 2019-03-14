------ log4j2 ------
Plik konfiguracyjny \src\main\resources. Mozliwosc logowania do konsoli albo
pliku na dysku.
=====================================================================================
------ Uruchamianie testu ------
mvn test -DBROWSER=phantomjs
mvn test -DBROWSER=chrome
...
mvn test -DBROWSER=phantomjs -Dcucumber.options="--tags @nazwaScenariusza"
@nazwaScenariusza umieszczamy przed konkrentym Scanario w feature file
=====================================================================================
------ Testy rownoczesne ------
plugin: cucumber-jvm-parallel-plugin i maven-surefire-plugin
Wiecej info https://automationrhapsody.com/running-cucumber-tests-in-parallel/
Uzywam 'Forl' zakomentowany kod jest do parallel ktore nie dzialalo.
Jenodczesnie mozna nadal uzywac poprzedniego runnera.
=====================================================================================
------ Raportowanie ------
Raporty w jednym html -> plugin: maven-cucumber-reporting

http://www.seleniumframework.com
https://www.toolsqa.com/cucumber/behavior-driven-development/
https://www.swtestacademy.com/
http://www.automationtestinghub.com/
=====================================================================================
------ json-server ------
instalacja servera -> npm install -g json-server
start servera i dodajemy naszego jsona -> json-server --watch <sciezka do pliku json>
=====================================================================================
------ json-server-auth ------
pieknie opisana autentykacja -> https://www.techiediaries.com/fake-api-jwt-json-server/ i https://github.com/techiediaries/fake-api-jwt-json-server
!!! odkomentowac linie 10 i 11 w server.js
instalacja servera z autentykacja -> npm install -g json-server-auth
instalacja jsonwebtoken -> npm install jsonwebtoken --save
poniewaz nie uzywam skryptow w package.json to do uruchomienia servera uzywam -> node <sciezka>/server.js

przyklad dla standardowych ustawien
post http://localhost:3000/auth/login w body podaje email i haslo uzytkownika z users.json
dostaje token: xxxxxxx
teraz np. get http://localhost:3000/people w Body ustawiam Key: Authorization i Value: Bearer xxxxxxx

=====================================================================================
------ faker.js ------
instalacja fakera -> npm install faker
tworzymy skrypt fakera an podstawie ktorego utworzy nam jsona -> .Resources\faker\fakerGenerateDataScript.js
i generujemy -> node <sciezka>\fakerGenerateDataScript.js <sciazka>\db.json

//rest-assured tutorial
https://www.youtube.com/playlist?list=PL6tu16kXT9PpgqfMbMdzUzDenYgb0gbk0
=====================================================================================
------ mobile testing ------
fajny tutorial -> http://www.automationtestinghub.com/appium-tutorial/ i http://www.automationtestinghub.com i https://www.guru99.com/introduction-to-appium.html
1. instalacja Android Studio, Appium Desktop, ustaw path np. ANDROID_HOME C:\...\AppData\Local\Android\Sdk i do Path ...;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;
2. po ustawieniu zmiennych, w celu weryfikacji -> konsola: sdkmanaged --list albo konsola: uiautomatorviewer
jako administrator -> npm --add-python-to-path='true' --debug install --global windows-build-tools
instalacja appium -> npm install appium -g --save -> nie wiem do konca po co to... -> moga sie pojawic errory ze wzgledu na brak pythona albo zla wersje msbuild
startujemy appium server z Konsoli -> appium
npm install -g appium-doctor -> appium-doctor
startowanie appium servera -> set ADB_TRACE=1 -> adb start-server  ???
