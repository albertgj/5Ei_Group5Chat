# Test Plan
___
#### Project Name: Online Chat

#### Team 5

### Focus: Test Plan
___
 Version |  Date               | Author Change             | Description
  :--          | :-:                    |      :-:                               |  --:
 1            |  12/2/2020    |   Castellano Pietro       | Draft 1

___

## TABLE OF CONTENTS
 - [IDENTIFIER](#identifier)
 - [INTRODUCTION](#introduction)
   - [Items and Features Tested](#items-and-features-tested)
   - [Test Specifications](#test-specifications)
   - [Test Reports](#test-reports)
   - [Project Plan](#project-plan)
   - [Quality Assurance Plan](#quality-assurance-plan)
 - [ITEMS AND FEATURES TESTED](#items-and-features-tested)
   - [User Website](#user-website)
   - [Bulletin Board](#bulletin-board)
 - [APPROACH](#approach)
   - [Strategy](#strategy)
   - [Techniques/Tools](#techniquestools)
   - [Test Goals](#test-goals)
 - [TEST DELIVERABLES](#test-deliverables)
 - [TESTING TASKS](#testing-tasks)
 - [SCHEDULE](#schedule)
 - [REQUIRED RESOURCES](#required-resources)
___
### IDENTIFIER

Online Chat Software Test Plan
___
### INTRODUCTION

This exercise essentially discovers faults and failures in the software. Faults lead to failures and
testing is necessary to eliminate these errors in the software development process. The following
document outlines the testing procedures for the Group Five Online Chat software project.

#### Items and Features Tested

The features tested include the user website and the bulletin discussion board.

#### Test Specifications

This section highlights the different levels of testing performed during the software development
process. It includes integrations tests performed by the team tester and system tests performed
by a team of testers to verify that the system fulfills the requirements and performs as expected.
The complete testing procedures are outlined in the test specifications document.

#### Test Reports

Test reports offer feedback about the testing exercise and are informational to project
stakeholders. The reports in this testing exercise track incidents, defects, and changes while
testing the system.

Incident reports track descriptions of incidents, the originator, severity and priority, steps required
to produce the defect, the responder, current status, cause, resolution and date the incident was
addressed. The document will also track in what phase of the development process the incident
was created or detected.


Defect reports reference the unique identifier in the incident report, list affected items, the owner,
required changes, status, phases where the defect was introduced and detected, and general
comments or notes.

Change reports summarize the total number of unit tests, integration tests, and system tests, the
items and features tested, comprehensiveness of the assessment, the total number of incidents
and defects, and unresolved incidents.

#### Project Plan

The project plan reconciles the time schedule and release of candidates with the unit, integration,
and system testing.

#### Quality Assurance Plan

Yet to be defined.
___
### ITEMS AND FEATURES TESTED

#### User Website

User website testing takes place in the integration and system testing phases. During integration,
the tester will test functions of the system and how the system behaves with additional features.
During system testing, the team will test the system as a whole and cross-check the results with
the requirements.

Test items:

- Ability to register and log in
- Correct sending of messages
- Correct reception of messages

#### Bulletin Board

Bulletin board testing takes place in the integration and system testing. The tester will test
functions of the project during integration, will retest them after features are added to make sure
they still function correctly.
System testing will test all aspects of the system and cross-check them with the requirements
document to ensure that the client’s requirements have been fulfilled.

Test items:

- The sender sends a message
- The recipient receives the message
- The user registers on the platform
- The user must be able to access multiple conversations

___
### APPROACH

#### Strategy

The test approach includes that a member of the group interfaces as a user (from a server to
which the client must connect) and sends a message to the recipient (another member of the
group). The activities they perform will be similar to the activities carried out in a normal
conversation. These include sending text messages and viewing the recipient's profile. Team
members will also create unexpected scenarios such as text messages consisting of too many
characters, sending many messages within a short period of time to test how the system will
respond to such scenarios.

System tests will be performed by the team to measure how the system meets the requirements.
Team members will be asked to provide input on the functionality of the system to determine if it
lives up to the expectations of a possible future customer.

#### Techniques/Tools

Developers will perform unit tests to check code functionality and execution of the software, and
perform white-box testing. They will also perform necessary NUnit and regression tests as they
develop the code.

Testers will develop test cases and perform black-box testing. Testers and team members will
also go through the code to find bugs and errors that the developers might not detect.

#### Test Goals

The goals of this testing exercise include finding various situations and testing against these
situations in order to discover any errors that may cause failures. The ultimate goal is to ensure
that the team delivers an error-free functioning system.
___
### TEST DELIVERABLES


- A test plan that delineates the testing phase of the development process
- A test specification document detailing steps in the testing procedures
- Test reports documenting incidents, defects and changes

___
### TESTING TASKS

Testing tasks for integration and system testing are outlined in the test specification document.
___
### SCHEDULE

Testing will occur at each phase of the development process. Test cases are outlined in the test
specification document for the iterations.
___
### REQUIRED RESOURCES

Human resources: 
- Albert Gjergjaj
- Federico Quintarelli
- Ionut Donisan
- Scardoni Francesco

Material: Java for development, Microsoft Word (.doc) and Adobe Acrobat (.pdf) for documentation


