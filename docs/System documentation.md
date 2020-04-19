# System Documentation

#### Team 5 
#### April 20, 2020

##### Team Members
- Gjergjaj Albert
- Donisan Ion Cristian
- Quintarelli Federico
- Scardoni Francesco
- Castellano Pietro
___

## Table of Contents
  - [Table of Contents](#table-of-contents)
  - [Revision History](#revision-history)  
  - [Introduction](#introduction)
  - [Access Application Code](#access-application-code)
  - [Import the application](#import-the-application)
  - [System Maintenance](#system-maintenance)
___

### Revision History

| Version | Date | Name | Description |
| --- | --- | --- | --- |
| 1   | 01/02/2019 | Initial Release | Initial Document |
| 2   | 25/02/2020 | Updated Release | Added maintenance information on java code|
___
## Introduction

The Potato Chat Client allows users to chat quickly and in a simple way. This document will provide instructions on how to access the application code and import it into an IDE.
___
## Access Application Code
Internet is required to access the Github repository. 

All the code is found on the Github link below:
https://github.com/albertgj/5Ei_Group5Chat.git

To download the project with the code you have to copy the repository or to download the zip from Github.
___
## Import the application
### Required Components
Access to a computer with Java and JDK installed in order to run the application.
### Import code in IDE
1. Open an IDE (NetBeans is recommended to make the application work properly)
2. Import from repository or from zip
   - To clone the repository from IDE
      1.  Click 'Team' → 'Git' → 'clone'
      2.  Enter Github url and user credentials.
      3.  Press next
      4.  Choose remote branch 'FinalVersion'
      5.  Choose the destination directory and press finish 
   - To import zip downloaded from Github into IDE
     1. Extract zip
     2. Click 'File' → 'Open Project' and choose the project folder.
3. Right click on the name of the project and select 'Clean and Build' to build the application and to make sure that all the dependecies are downloaded.
4. Run the application by right clicking on the name of the project and selecting 'Run'.
5. Program is now running.
___

## System Maintenance
### Java code
The UI consists of a JFrame login screen, general chat and private chat JFrame panels. These three files are implemented in three different java classes that are located in the it.group5.groupchat.gui package.

When the application is launched the login screen will displayed first. Once the user enters the alias and the topic of chat, the window is closed and a new instance of the General chat is created. In this window we have a TextArea which is disabled and this will show the messages that all the users write. Then we have a text field where you can type the message and two buttons, the first one being the send button and the other one is the request user list, which refreshes the JList. In this JList we have all the connected users to the chat and by double clicking on each user(JList item) a new instance of Private chat will be created and placed in a new tab. A double click on the tab will close it. 

All login, user message to general chat and user to user communication logic is written in the service interface, that is implemented by a Java class. 
There is also a thread that listens and sends packets to the server.

