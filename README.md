# VerveBridge_Stipend_Task_01
# Learning Management System (LMS)

## Overview

The Learning Management System (LMS) is a simple command-line application built in Java. It allows users to sign up, log in, and manage courses if they have administrative privileges. The system uses `HashMap` for storing user and course data and `Scanner` for reading user inputs.

## Features

- **Sign Up**: Register a new user with a username, password, and payment status.
- **Login**: Authenticate users with their username and password.
- **Admin Dashboard**: Access available for admins to create and manage courses.
  - **Create Course**: Add new courses to the system.
  - **Manage Courses**: Delete existing courses from the system.
- **Logout**: Log out from the admin dashboard.

## Technologies Used

- **Java**: Programming language used for developing the application.
- **Java Collections**: `HashMap` for storing and managing data.
- **Java I/O**: `Scanner` for handling user input.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later installed on your machine.

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
2. cd <project-directory>
3. javac LMS.java
4. java LMS
