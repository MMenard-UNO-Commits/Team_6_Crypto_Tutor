# Team_6_Crypto_Tutor
Summary of application: This application is a tool that is designed at helping students find suggestions on how to properly implement java cryptographic libraries. The system consists of two applications, a back end that processes student queries against the code repository hosted on the server and saves student questions as persistent data in a MySQL database, and a front end that allows students to compare their functions to functions contained within the code repository in the back end using a tool called NiCad, as well as allowing them to view the previous queries of other students so they can compare their code to others, and even run other's code back through the NiCad form. The NiCad form also allows students to use a diff finding tool to compare variuos code fragments that are returned on to the front end. This application is licensed under the MIT license, so copying and modification of the code is allowed and encouraged for your projects!

Release Notes:

Update 0.1: During this update we created a basic starting UI for our system that includes fields for a student name and ID, as well as a question field where the code snippet goes and a description fields where a description of the problem can be specified.

Update 0.2: Worked on creating basic NiCad comparison functionality and displaying it to a sample webpage using PHP and Java servlet.

Update 0.3: Refactored the project to work with spring boot as a backend instead of PHP. Created some models for our repositories and added functionality for creating java files when questions are submitted.

Update 0.4: Final update before version 1.0. Created remaining models and implemented NiCad search functionality. Also implemented a starter on the dashboard for the front page of our web application. Used JSoup and Java runtime in order to garner NiCad results using the back end.

Update 1.0: Final update of this project. Got a fully functional dashboard form working that allows users to search through the question repository filtering by keywords and usernames. Also fully implemented the Diff finding functionality for the NiCad results page and changed the look and formatting of the tool significantly.

Installation Instructions:

1. Create a Linux server where the application can be installed. Install tomcat9, MySQL, java 11, and the latest version of TXL onto the system. 

2. Download the latest version of NiCad from https://txl.ca/txl-nicaddownload.html and put the NiCad-6.2 directory on your server. Remember where this is installed for later. 

3. Create a MySQL database and create a user that will specifically be used to access data from the back end application. 

4. Download the source code from the GitHub repository. Ensure that you have NPM and Maven installed on your build system or you will not be able to build the application. 

5.Go into the back-end folder in the project and find application.properties. Update the URL, username, and password properties to reflect the URL of your server, the name of the database you created, and the username and password of the user you created for accessing data through the back end. If you have any data that you wish to compare your user inputs to using NiCad, put the code base that you want to compare into the directory “comparisonFiles”, which is found within the “comparisonFilesContainer” directory in the root of the “back-end” directory. This code base must be in its own separate directory, within the comparisonFiles directory. If it is not and the files are just loose in the root of the comparisonFiles directory all of them will be deleted during NiCad cleanup. 

6.Build the project using maven clean and compile, and then build a war file of the project, naming the war what you wish. 

7.On the front-end, in the Dashboard.js and QuestionPage.js files, change the URL of all of the fetch statements to match the URL of your server. Also change the “back-end” after the 8080 to reflect the name of your back end application’s war from the previous step. 

8.Use the command “npm install” in the cypto-tutor directory to install all of the node modules needed for the project. Then use the command “npm run compile”, command derived from Roberto on stack overflow (Awan, A. et al.), to build a war file containing the front end application. Name this war file what you wish. 

9.Go to the tomcat manager for your server and deploy both applications. When you deploy the applications all of the SQL tables should be generated automatically. If they are not, check the information in your application.properties file for errors. 

10.Populate the list of users you wish to have using the MySQL console. user type should be 0 if the user is a student, 1 if they are an instructor, and 2 if they are an admin. 

11.Find the bash scripts folder and open both hello.sh and goodbye.sh. Modify those files in the following ways: 

    A. In hello.sh, on the first line of the script, change the cd command so that the directory being changed to reflects the installation directory of your NiCad-6.2 folder that you put on the server earlier. On the second line modify the directory indicated in the NiCad command to be the installation directory of your back end application. This would take the form of “your/tomcat/install/webapps/yourWarName/comparisonFiles” with comparison files being the place where code fragment files will be saved. This should have been automatically created, but if it wasn’t it will be upon submitting the first question to the system. If it is still not created after attempting a question submission simply add the directory “comparisonFiles” to the root of your back end applications web app directory. This file runs NiCad against the saved code fragments on your system. 

    B.In goodbye.sh change the first line to reflect the installation directory of your back end application, like “your/tomcat/install/webapps/yourWarName”. This application navigates to your back end application install and deletes the results of previous NiCad evaluations, save the log files generated by each run. 

12. Put both of the bash scripts in the root of your tomcat9 installation. These files should be in the same directory as the webapps folder that your front end and back end installation directories are contained in. 

