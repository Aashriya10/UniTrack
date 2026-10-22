# UniTrack — Project Development Report

## 1. Project Information

- **Project Name:** UniTrack
- **Project Type:** Student University Application Planner
- **Programming Language:** Java
- **Development Environment:** IntelliJ IDEA
- **Version:** 1.0
- **Project Status:** Initial setup

## 2. Introduction

Students who plan to pursue higher education abroad often need to manage information about universities, degree programmes, admission requirements, application deadlines, scholarships, and accommodation. Keeping this information in different places can make the application process difficult to organize.

UniTrack aims to provide a centralized application-planning system that helps students organize university information and monitor the progress of their applications.

## 3. Problem Statement

Managing several university applications can be confusing because each university may have different eligibility requirements, deadlines, documents, and application procedures. UniTrack is intended to make this process more organized by storing relevant information in one application.

## 4. Project Objectives

1. Store information about universities and their Master's programmes.
2. Allow users to view and manage university records.
3. Track application statuses, such as Planned, Applied, Accepted, and Rejected.
4. Plan future features for managing deadlines, documents, scholarships, and accommodation.
5. Apply Java programming and object-oriented programming concepts in a practical project.

## 5. Initial Project Scope

The first version will be a Java console application. It will initially allow users to add universities and view their information. Additional features will be developed and tested incrementally.

## 6. Tools and Technologies

- Java
- IntelliJ IDEA
- Git and GitHub (planned)
- File handling and database technologies (planned)

## 7. Development Progress

### Milestone 1: Project Setup

- Created the UniTrack project in IntelliJ IDEA.
- Documentation folder and development report: in progress.
- Java implementation: not started.

### Milestone 2: Feature Planning

- Selected the first feature: Add and View Universities.
- Defined the university record fields: name, programme, and application status.
- Planned a menu-driven console interface.
- Java implementation: not started.

### Milestone 3: University Class

- Created the University class.
- Added fields for university name, programme, and application status.
- Added a constructor to initialize each university record.
- Added a display method to print university information.
- Testing: pending.

### Milestone 4: Console Menu and University Management

- Added a menu using a while loop and switch statement.
- Used Scanner to accept user input.
- Used ArrayList to store multiple University objects.
- Implemented adding and viewing universities.
- Added handling for empty lists and invalid menu choices.
- Tested adding multiple universities and exiting the application.

Status: Completed after successful testing.

### Milestone 5: File Persistence

- Implemented saving university records to universities.txt.
- Implemented loading saved university records at startup.
- Restored university name, programme, and status.
- Handled missing files and file-reading errors.
- Tested persistence across program restarts.

Status: Completed after successful testing.

### Milestone 6: University Management

- Implemented adding and viewing university records.
- Added application status updates.
- Implemented university deletion with confirmation.
- Saved changes to persistent file storage.
- Tested deletion, cancellation, invalid selections, and persistence after restart.

Status: Completed.




## 8. Future Improvements

Potential improvements include persistent data storage, database integration, a graphical or web-based interface, input validation, automated testing, and improved documentation.

## 9. Conclusion

UniTrack will be developed incrementally, with each feature implemented, tested, and documented. The aim is to build a useful application while developing practical programming and software engineering skills.

