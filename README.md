W celu zbudowania apliacji należy użyć komendy 'mvn clean verify -P container' na głównym pom'ie projektu (news-browser).
Spowoduje to utworzenie obrazu dockera, z którego można uruchomić aplikację komendą:
docker run -p 8080:8080 hw/newsbrowser:1.0.0
