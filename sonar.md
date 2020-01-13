#Sonar Scanner
### Update the code to latest.
1. Update the code to latest
2. Full build code and gen the report
2b. Run test only
```
mvn clean test
```
3. Run the scripts:
```
sonar-scanner -Dproject.settings=sonar.properties -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=admin
```