# Beykent Üniversitesi Mobil

An Android campus app prototype for Beykent University, with separate areas for students, academics, staff and an admin, backed by Firebase.

## Overview

This is the most complete version of a university mobile app built in Java for Android. The app opens on a role picker (Student, Academic, Staff, plus an admin entry). Users sign in with Firebase Authentication, and student records (courses, grades, attendance, exam places, notifications) are stored in Firebase Realtime Database. The UI is in Turkish.

It is the third and final iteration of the same project:

1. [BeykentMobilApp](https://github.com/mertcaneren0/BeykentMobilApp): first UI skeleton (role picker and three empty home screens)
2. [BeykentMobileApp2](https://github.com/mertcaneren0/BeykentMobileApp2): full screen set with static content and hardcoded demo logins
3. **BeykentUniversitesiMobil** (this repo): the same screens wired to Firebase Auth and Realtime Database, plus an admin panel

## Features

**Admin**
- Admin login and panel
- Create student, academic and staff accounts (Firebase Auth) and save their profile data
- Enter a student's courses, grades, attendance and exam information

**Student**
- Grades (`Not Bilgileri`): two grades per course for up to five courses
- Attendance (`Devamsızlık Bilgileri`)
- Course schedule (`Ders Programı`)
- Exam place and time (`Sınav Yeri ve Zamanı`)
- Notifications from academics/staff (`Akademisyen Bildirim`)
- Academic appointment screen (static)
- Library: a searchable list of books
- Link to Beykent Radio (opens the radio website)

**Academic**
- Send a notification to a student
- Appointments screen (static), library search, radio link

**Staff**
- Select a student, then edit grades, course schedule and exam places
- Send a notification to a student

## Tech

- Java, Android SDK (compileSdk / targetSdk 29, minSdk 21, build tools 29.0.2)
- Android Gradle Plugin 3.6.3, Google Services plugin 4.3.3
- AndroidX AppCompat 1.1.0, ConstraintLayout 1.1.3, Material Components 1.1.0
- Firebase Authentication 19.3.1, Firebase Realtime Database 19.3.0
- JUnit / Espresso test stubs (default templates)

## Project structure

```
app/
  build.gradle
  google-services.json           Firebase config
  src/main/java/com/mertcaneren/beykentmobilapp/
    MainActivity.java            role picker
    admin*.java                  admin login, panel, account creation
    ogrenci*.java, notBilgileri  student screens
    akademisyen*.java            academic screens
    personel*.java               staff screens
    kutuphane.java, radyo*.java  library search, radio link
    Post.java                    student record model
  src/main/res/                  layouts, drawables, custom font
BeykentMobileApp/                older copy of the first iteration
```

## Build and run

1. Clone the repo and open the root folder in Android Studio.
2. Let Gradle sync. The project uses an old Gradle/AGP setup (AGP 3.6.x), so a recent Android Studio may ask you to upgrade the Gradle wrapper or plugin.
3. To use your own backend, create a Firebase project with Authentication (email/password) and Realtime Database enabled, and replace `app/google-services.json` with your own file.
4. Run on an emulator or device with Android 5.0 (API 21) or newer.

## Notes

This is a student/learning project and not an official Beykent University app. The admin login uses hardcoded credentials in the source and the data model is kept simple (fixed five courses per student), so it is not meant for production use.

---

Built by [Mertcan Eren](https://github.com/mertcaneren0)
