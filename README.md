# Team_6_Crypto_Tutor
Summary of the system: Our team is seeking to design a system that will become the foundation for a question and answer service for students learning about java cryptographic libraries. Using our system students will be able to make searches based on code snippets that are being flagged as unsecure by a complementary eclipse plugin and find questions that have been asked that use similar code snippets. Using this principle our hope is that students will be able to find answers to their questions more reliably and quickly. If they cannot find an answer to the question that they have they can also submit a new question with their code snippet and a description of a problem. From there both students in the same class and the instructors of the course will be able to provide guidance to students who have questions, with the most successful answers being able to be upvoted to highlight them.

Students will be able to enter a question that they have with a relevant code snippet and submit the question for a search. Our UI will then pipe this information to our back-end server which will compare the student's code snippet to other questions' code snippets using a tool called NiCad to determine the similarity of the code. This similarity rating will allow us to rank order the most relevant questions to recommend and return to the student so they can attempt to find answers to their question. If they do not find answers to the specific question they are looking for, they can then submit their original question as a new question for the system, which will then log the information for further searches.

Students and faculty can also go through the list of questions from newest to oldest and respond to them in a forum-like style. They do this by selecting the question and selecting the option to answer the question. From there they can put in a code snippet of their own, as well as a description of the code and a recommendation of action for the user who asked the question.

Update 0.1: During this update we created a basic starting UI for our system that includes fields for a student name and ID, as well as a question field where the code snippet goes and a description fields where a description of the problem can be specified.

Update 0.2: Worked on creating basic NiCad comparison functionality and displaying it to a sample webpage using PHP and Java servlet.

Update 0.3: Refactored the project to work with spring boot as a backend instead of PHP. Created some models for our repositories and added functionality for creating java files when questions are submitted.
