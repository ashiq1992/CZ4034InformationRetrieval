# CZ4034InformationRetrieval

This is the Solr used for our CZ4034 - Information Retrieval group assignment. 

## Instruction to Run Solr Server
1. Ensure that Java SE version 8 or above is installed
2. Download this repository
3. From the directory of solr-7.6.0 in the project,run the following command </br> `$ bin/solr start`
4. Solr will be running at port <em>8983</em>
5. To stop run the follwing command </br> `$ bin/solr stop`

Result: The Solr Server is active.



## Instructions to import Airline News Search Engine into Eclipse
1. Download Eclipse Java EE IDE for Web Developers from https://www.eclipse.org/downloads/packages/release/2019-03/r/eclipse-ide-enterprise-java-developers
2. Extract the contents of the downloaded zip file into a local C drive
3. Traverse through the folder to search and run eclipse.exe
4. Right click on the Package Explorer pane on the left side of the screen
5. Select "Import" from the set of options provided
6. From the pop-up screen of import type options, select "Existing Projects into Workspace"
7. Locate and select the download folder of this repository
8. Select "Finish" from the dialog window options

Result: The Project is successfully imported into the development workspace.

## Instructions to Install Tomcat 9.0 in the Eclipse Workspace

1) Ensure the Eclipse development tool is open
2) Select "Window" > "Show View" > "Server
 from the menu panel located at the top of the workspace
3)A "server" panel will be displayed on the bottom of the screen
4) From the panel, select "Create a new server" 
5) A pop-up dialog would appear on the screen
6) Select Tomcat 9.0 as the preferred runtime
5) Select next and download Tomcat 9.0 installation files from https://tomcat.apache.org/download-90.cgi 
6) Set the location of the installation files through the dialog pop-up.
7) Select next and finish to complete the steps

Result: Apache Tomcat 9.0 is installed in the development environment.

## Instructions to run Airline News Search Engine on Eclipse

1) Ensure the Eclipse development tool is open
2) "Right-Click" on the imported project from the repository and select "Run As" > "Run on Server"
3) The web application is activated and can be browsed from eclipse's internal browser

Result: The Airline News Search Engine is ready to be used


