# Programming Quiz 1: Students Information System

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

* * *

This document contains the description and general information required for
completing the **first programming quiz** of Programming Foundations 2 course.
The quiz is about processing data related to students in an university by
implementing OO programming practices.

This quiz covers programming topics as follows:

- File processing
- Interface

This quiz is published on **Monday, 30 April 2018 and due on the same day
at 12:00**. Grading will be conducted by **evaluating latest commit pushed
before the deadline.**

## Description

You are given a CSV file that contains **10000** anonymised records of students
from an university located somewhere at eastern part of Indonesia. It contains
record of student enrollment on courses offered in the university.

Each record in the CSV file describes the following information regarding a
student enrollment in a course:

1. `ID`: student unique ID in the university, akin to your NPM in Universitas
Indonesia
2. `ENROLL_YEAR`: the year when student enrolled into the university
3. `DEGREE`: the diploma/degree a student want to achieve, e.g. **D3** (3-year
diploma), **S1 (4-year bachelor)**
4. `COURSE_CODE`: unique ID for a course offered in the university
5. `COURSE_NAME`: the name of course associated with the unique ID
6. `CREDITS`: number of credits associated with the course

Your task in this programming quiz is to create a Java class that implements
`CsvReader` interface. The interface specifies methods that will be called
by the main program (`PQuiz1`) in order to get information from the CSV file.

Some hints regarding reading the CSV file:

- The first line only contains data descriptors, thus the actual records in the
CSV file start from the second line
- There are several records whose value contains `,` (comma) symbols but enclosed
within doublequotes (`"`), e.g records starting from line 8097 in the CSV file

## Checklists

Please make sure that you:

- [ ] Make at least 1 commit that contains your progress in completing the quiz
- [ ] Push your commits to online Git repository at your GitLab project
- [ ] Create a new class that implements `CsvReader` interface
- [ ] Implement each methods from `CsvReader` correctly
- [ ] Replace null assignment of `CsvReader` instance in the main program (`PQuiz1`)
with actual object of `CsvReader`
- [ ] Invite the lecturer (@addianto) as a Master in your tutorial/quiz GitLab
project
