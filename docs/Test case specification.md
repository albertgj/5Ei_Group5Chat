# Test Case Specification For Team 5

April 17, 2020


# Table of Contents
- [Revision History](#revision-history)
- [1 Introduction](#1-introduction)
- [2 Test Cases: Windows Application](#2-test-cases-windows-application)


# Revision History

| **Version** | **Date** | **Name** | **Description** |
| --- | --- | --- | --- |
| First | 04/03/2020 | Gjergjaj Albert | Initial Document |
| Last | 20/03/2020 | Gjergjaj Albert | Updated test case numbers |

# 1 Introduction

This document provides the test cases made by team 5. Each item to be tested is represented by an individual test case.  Each case details the input and expected outputs.

# 2 Test Cases: Windows Application

| Test ID | 2.0 |
| --- | --- |
| Title | Correct login |
| Feature | Login into the Potato Chat Client with random username and general topic for general chat room |
| Objective | Confirm that with a valid nickname and a valid topic a user can access the Potato Chat Client|
| Setup     | Computer with jdk 1.8 and windows installed.
| Test Data | Login information -> Nickname: general and Chat Topic: general |
| Test Actions | Open NetBeans and Clean and Build the application. Then run the app and insert login information |
| Expected Results | The system displays the general chat room |
___
| Test ID | 2.1 |
| --- | --- |
| Title | Invalid nickname |
| Feature | Login into the Potato Chat Client |
| Objective | Confirm that with a invalid nickname, which means a nickname that has already been taken by someone else, and a valid topic a user can't access the Potato Chat Client|
| Setup     | Computer with jdk 1.8 and windows installed.
| Test Data | Login information -> Already Taken Nickname: test and Chat Topic: general |
| Test Actions | Open NetBeans and Clean and Build the application. Then run the app and insert the invalid nickname |
| Expected Results | The system displays an error message and doesn't enter the general chat room |
___
| Test ID | 3.0 |
| --- | --- |
| Title | General Chat Room |
| Feature | Chat with other users in a general chat room |
| Objective | Confirm that with valid login information users can access and write messages in the general chat room|
| Setup     | Computer with jdk 1.8 and windows installed.
| Test Data |  |
| Test Actions | Open NetBeans and Clean and Build the application. Then run the app and start writing messages |
| Expected Results | The system sends correctly messages to the general chat room and receives them |
___
| Test ID | 3.1 |
| --- | --- |
| Title | Private Chat Room |
| Feature | Chat privately with another user |
| Objective | Confirm that a user, after having logged in the general chat room, can write messages with another user in a private room |
| Setup     | Computer with jdk 1.8 and windows installed.
| Test Data |  |
| Test Actions | Open NetBeans and Clean and Build the application. Then run the app and click on a user that is connected to the general chat room and start writing private messages |
| Expected Results | The system sends and receives correctly private messages |
