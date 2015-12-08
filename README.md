<b>This is sample project that demonstrate the use of spring data with mongodb.</b>

<h4>Follow the below steps to setup the application.</h4>

<ul>
<li>
<b>Install the <a href="https://www.mongodb.org/downloads#production">mongodb </a>. Don't make any change in settings keep default port settings.</b></li>
<li><b>clone git@github.com:mukeshkamboj/spring-data-mongodb-example.git</b></li>
<li><b>go to spring-data-mongodb-example folder</b></li>
<li><b>gradle clean build</b></li>
<li><b>java -jar build\libs\spring-data-mongodb-example-1.0.jar . This will make the server up and running on port localhost:8080</b></li>
</ul>

<h4>You can post the information like</h4>
<code>
curl -H "Accept:application/json" -H "Content-Type:application/json" --data '{"firstName":"Devainder","lastName":"Khera","userName":"dkamboj","primaryAddress":{"id":"5665c707046d7b3148b918e4","street1":"PKL","street2":null,"city":null,"country":null,"state":null,"pinCode":null,"landmark":null,"type":null},"addresses":[{"id":"5665c707046d7b3148b918e4","street1":"PKL","street2":null,"city":null,"country":null,"state":null,"pinCode":null,"landmark":null,"type":null}]}' localhost:8080/user
</code>

<h4>To get the information</h4>
<code>
curl -XGET localhost:8080/user/dkamboj
</code>