# sprint-boot-unique-constraint

In this example we will see how to display a specific message when a unique constraint error occurs, allowing user to modify data and complete operation. For this we are going to create a spring-boot project, and a very summarized rest controller, with POST method, to test how it works.

To run application we should execute command
```bash
mvn spring-boot:run
```
To test functionality, we create an entity called Status, add a unique constraint on name column and initialize database with status "CREATED". Once application was started, message that we have a status in database should appear in console
```bash
Status count 1
```
We are going to add a new status by doing a POST with curl command

We try to add status "APPROVED"
```bash
curl -d "@approved.json" -H "Content-Type: application/json" -X POST http://localhost:8080/status
```
`approved.json`
```json
{"name": "APPROVED"}
```
As we see in result, status with id "2" was added
```json
{"id":2,"name":"APPROVED"}
```
Now let's try adding status "CREATED"
```bash
curl -d "@created.json" -H "Content-Type: application/json" -X POST http://localhost:8080/status
```
`created.json`
```json
{"name": "CREATED"}
```
In this case status is not added and we receive a message indicating that it already exists

`A status with entered name already exists`